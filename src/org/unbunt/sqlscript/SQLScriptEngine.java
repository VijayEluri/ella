package org.unbunt.sqlscript;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.unbunt.sqlscript.continuations.*;
import org.unbunt.sqlscript.engine.DefaultContext;
import org.unbunt.sqlscript.engine.Env;
import org.unbunt.sqlscript.engine.Obj;
import org.unbunt.sqlscript.exception.*;
import org.unbunt.sqlscript.lang.*;
import org.unbunt.sqlscript.lang.sql.ConnMgr;
import org.unbunt.sqlscript.lang.sql.RawSQL;
import org.unbunt.sqlscript.statement.*;
import org.unbunt.sqlscript.support.*;
import org.unbunt.sqlscript.utils.Consts;
import org.unbunt.sqlscript.utils.ObjUtils;
import org.unbunt.sqlscript.utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class SQLScriptEngine implements ExpressionVisitor, ContinuationVisitor {
    @SuppressWarnings({"UnusedDeclaration"})
    private static final boolean STEP = false;

    protected final Log logger = LogFactory.getLog(getClass());
    protected final boolean trace = logger.isTraceEnabled();

    protected DefaultContext context;
    protected boolean finished = false;

    public static final Obj SLOT_PARENT = Consts.SLOT_PARENT;
    public static final Obj SLOT_INIT = Consts.SLOT_INIT;

    public SQLScriptEngine(DefaultContext context) {
        this.context = context;
        this.env = context.getEnv();
    }

    public static SQLScriptEngine create(DefaultContext context) {
        return new SQLScriptEngine(context);
    }

    protected Statement stmt;
    protected Obj val;
    protected Env env;

    // TODO: dynamically increase cont stack size to allow non-tail-recursion to occur up until the heap runs out
    protected int MAX_CONT_STACK = 4096;
    protected Continuation[] cont = new Continuation[MAX_CONT_STACK];
    protected int pc;

    public Object process(Block block) throws SQLScriptException {
        next = EVAL;
        stmt = block;
        val = null;
        pc = 0;
        cont[pc] = new EndCont();

        try {
            process();
        } catch (ArrayIndexOutOfBoundsException e) {
            if (pc >= MAX_CONT_STACK) {
                throw new SQLScriptRuntimeException("Continuation stack overflow", e);
            }
            else {
                throw e;
            }
        } catch (SQLScriptRuntimeException e) {
            throw new SQLScriptException(e);
        }

        return val == null ? null : val.toJavaObject();
    }

    protected final static boolean CONT = true;
    protected final static boolean EVAL = false;

    protected boolean next;

    @SuppressWarnings({"PointlessBooleanExpression"})
    protected void process() throws SQLScriptRuntimeException {
        while (true) {
            if (next == CONT) {
                if (pc == 0) {
                    return;
                }
                cont();
            }
            else {
                eval();
            }
        }
    }

    @SuppressWarnings({"PointlessBooleanExpression"})
    protected boolean step() throws SQLScriptRuntimeException {
        if (next == CONT) {
            if (pc == 0) {
                return false;
            }
            cont();
        }
        else {
            eval();
        }

        return true;
    }

    protected void eval() {
        stmt.accept(this);
    }

    public void processExpression(Block blockExpression) {
        if (blockExpression.isScoped()) {
            Env savedEnv = env;
            env = new StaticEnv(env);
            cont[++pc] = new BlockCont(blockExpression, savedEnv);
        }
        else {
            cont[++pc] = new BlockCont(blockExpression);
        }
        next = CONT;
    }

    public void processExpression(IdentifierExpression identifierExpression) {
        val = identifierExpression.getValue();
        next = CONT;
    }

    public void processExpression(IntegerLiteralExpression integerLiteralExpression) {
        val = integerLiteralExpression.getValue();
        next = CONT;
    }

    public void processExpression(FloatingPointLiteralExpression floatingPointLiteralExpression) {
        val = floatingPointLiteralExpression.getValue();
        next = CONT;
    }

    public void processExpression(BooleanLiteralExpression booleanLiteralExpression) {
        val = booleanLiteralExpression.getValue() ? getObjTrue() : getObjFalse();
        next = CONT;
    }

    public void processExpression(StringLiteralExpression stringLiteralExpression) {
        StringLiteral stringLiteral = stringLiteralExpression.getStringLiteral();

        StringBuilder buf = new StringBuilder();
        String delim = stringLiteral.getDelim();
        for (Object part : stringLiteral.getParts()) {
            String str = part instanceof Variable
                         ? env.get((Variable) part).toString()
                         : StringUtils.unescapeSQLString(part.toString(), delim);
            buf.append(str);
        }

        val = new Str(buf.toString());
        next = CONT;
    }

    public void processExpression(SQLLiteralExpression sqlLiteralExpression) {
        if (trace) {
            logger.trace("Got SQL-Literal: " + sqlLiteralExpression);
        }

        SQLParseMode parseMode = sqlLiteralExpression.getParseMode();
        SQLStringType stringType = parseMode.getStringType();

        StringBuilder buf = new StringBuilder();
        for (Object part : sqlLiteralExpression.getParts()) {
            if (part instanceof StringLiteral) {
                StringLiteral string = (StringLiteral) part;
                String strStartDelim = string.getStartDelim();
                String strEndDelim = string.getEndDelim();
                buf.append(strStartDelim);
                for (Object strPart : ((StringLiteral) part).getParts()) {
                    if (strPart instanceof Variable) {
                        String strValue = env.get((Variable)strPart).toString();
                        buf.append(stringType.escape(strValue, strStartDelim));
                    }
                    else {
                        buf.append(strPart.toString());
                    }
                }
                buf.append(strEndDelim);
            }
            else if (part instanceof Variable) {
                // TODO: For non-string values (Str) we should possibly evaluate the object's toString() slot
                buf.append(env.get((Variable)part).toString());
            }
            else {
                buf.append(part.toString());
            }
        }

        val = new RawSQL(buf.toString(), parseMode);
        next = CONT;
    }

    public void processExpression(ObjectLiteralExpression objectLiteralExpression) {
        cont[++pc] = new ObjLitCont(objectLiteralExpression.getObjectLiteral());
        next = CONT;
    }

    public void processExpression(ArrayLiteralExpression arrayLiteralExpression) {
        cont[++pc] = new ArrLitCont(arrayLiteralExpression.getComponents());
        next = CONT;
    }

    public void processExpression(DeclareVariableExpression declareVariableExpression) {
        env.extend(declareVariableExpression.getVariable());
        next = CONT;
    }

    public void processExpression(AssignExpression assignExpression) {
        cont[++pc] = new AssignCont(assignExpression.getVariable());
        stmt = assignExpression.getRvalue();
        next = EVAL;
    }

    public void processExpression(DeclareAndAssignExpression declareAndAssignExpression) {
        stmt = declareAndAssignExpression.getDeclareExpr();
        cont[++pc] = new AssignExprCont(declareAndAssignExpression.getAssignExpr());
        next = EVAL;
    }

    public void processExpression(SlotSetExpression slotSetExpression) {
        SlotExpression slotExpression = slotSetExpression.getSlotExpression();
        stmt = slotExpression.getReceiver();
        cont[++pc] = new SlotSetReceiverCont(slotExpression.getSlot(), slotSetExpression.getValueExpression());
        next = EVAL;
    }

    public void processExpression(SlotExpression slotExpression) {
        stmt = slotExpression.getReceiver();
        cont[++pc] = new SlotGetReceiverCont(slotExpression.getSlot());
        next = EVAL;
    }

    public void processExpression(VariableExpression variableExpression) {
        val = env.get(variableExpression.getVariable());
        next = CONT;
    }

    public void processExpression(FunctionDefinitionExpression functionDefinitionExpression) {
        Function func = functionDefinitionExpression.getFunction();
        String funcName = func.getName();
        val = new Func(func);
        if (funcName != null) {
            if (functionDefinitionExpression.isDeclareVariable()) {
                env.add(functionDefinitionExpression.getVariable(), val);
            }
            else {
                env.set(functionDefinitionExpression.getVariable(), val);
            }
        }
        // FIXME: Should env be assiociated with newly created Func-Object instead? What if the definition is called
        // FIXME: multiple times while references to a previous definition are still floating around?
        func.setEnv(env);
        next = CONT;
    }

    public void processExpression(BlockClosureExpression blockClosureExpression) {
        BlockClosure clos = blockClosureExpression.getBlockClosure();

        // FIXME: is this nessassary? Env is already saved at last...
        clos.setHomeOffset(env.getClosureHomeOffset());
        clos.setHomeCont(env.getClosureHomeCont());

        val = new Clos(clos);
        clos.setEnv(env);

        next = CONT;
    }

    public void processExpression(FunctionCallExpression functionCallExpression) {
        stmt = functionCallExpression.getExpression();
        cont[++pc] = new CallCont(functionCallExpression.getArguments(), functionCallExpression.getCallFlags());
        next = EVAL;
    }

    public void processExpression(SlotCallExpression slotCallExpression) {
        SlotExpression slotExpression = slotCallExpression.getSlotExpression();
        stmt = slotExpression.getReceiver();
        cont[++pc] = new SlotCallReceiverCont(slotCallExpression);
        next = EVAL;
    }

    public void processExpression(ReturnStatement returnStatement) {
        // tail-call optimization
        if (returnStatement.isOptimizeForTailCall()) {
            // XXX: use env.getClosureHomeOffset() ???
            for (int i = pc; i >= 0; i--) {
                Continuation c = cont[i];
                if (c instanceof FunRetCont) {
                    pc = i;
                }
            }

            // assumes optimziation is performed only on return statements having function calls as expression
            // which implies there must be an expression - therefore not calling hasExpression() in this case
            stmt = returnStatement.getExpression();
            next = EVAL;
        }
        else {
            cont[++pc] = new ReturnCont();

            if (returnStatement.hasExpression()) {
                stmt = returnStatement.getExpression();
                next = EVAL;
            }
            else {
                // NOTE: change in semantics
                // return statement without expression make the associated function return the value of the
                // last evaluated expression
                // TODO: is this feasible? what about functions containing only a return statement without an expression?
                // TODO: should possibly make function initialize current value with null...
                //val = Null.instance;
                next = CONT;
            }
        }
    }

    public void processExpression(ThisExpression thisExpression) {
        val = env.getContext();
        next = CONT;
    }

    public void processExpression(SuperExpression superExpression) {
        Obj ctx = env.getReceiver();
        if (ctx == null) {
            ctx = env.getContext();
        }

        if (ctx == null) {
            val = getObjNull();
        }
        else {
            Obj parentCtx = ObjUtils.getParent(context, ctx);
            if (parentCtx == null) {
                parentCtx = getObjNull();
            }
            val = parentCtx;
        }
        next = CONT;
    }

    public void processExpression(NewExpression newExpression) {
        stmt = newExpression.getExpression();
        cont[++pc] = new NewCont(newExpression.getArguments());
        next = EVAL;
    }

    protected void cont() {
        cont[pc].accept(this);
    }

    public void processContinuation(EndCont endCont) {
        pc--;
        next = CONT;
    }

    public void processContinuation(BlockCont blockCont) {
        if (!blockCont.hasNextStatement()) {
            // aleady processed last statement of block, leaving
            if (blockCont.isScoped()) {
                env = blockCont.getSavedEnv();
            }
            pc--;
            next = CONT;
        }
        else {
            stmt = blockCont.nextStatement();
            // tail-call optimization
            if (!blockCont.hasNextStatement() && blockCont.isOptimizeForTailCall()) {
                pc--;
            }
            next = EVAL;
        }
    }

    public void processContinuation(ObjLitCont objLitCont) {
        if (objLitCont.hasNextSlot()) {
            ObjectLiteral.SlotEntry slot = objLitCont.getNextSlot();
            stmt = slot.key;
            cont[++pc] = new ObjLitSlotCont(objLitCont.getObj(), slot.value);
            next = EVAL;
        }
        else {
            pc--;
            val = objLitCont.getObj();
            next = CONT;
        }
    }

    public void processContinuation(ObjLitSlotCont objLitSlotCont) {
        stmt = objLitSlotCont.getSlotValue();
        cont[pc] = new ObjLitSlotValueCont(objLitSlotCont.getObj(), val);
        next = EVAL;
    }

    public void processContinuation(ObjLitSlotValueCont objLitSlotValueCont) {
        pc--;
        objLitSlotValueCont.getObj().setSlot(context, objLitSlotValueCont.getSlot(), val);
        next = CONT;
    }

    public void processContinuation(ArrLitCont arrLitCont) {
        // Unconditionally add current value to the array. The first value will be a the value of the last expression
        // previously evaluated and is therefore not the value of a component of the to be created array. ArrLitCont
        // knows about this and takes care of this.
        arrLitCont.addComponentValue(val);

        Expression componentExpr = arrLitCont.getNextComponent();
        if (componentExpr == null) {
            val = new Lst(arrLitCont.getComponentValues());
            pc--;
            next = CONT;
        }
        else {
            stmt = componentExpr;
            next = EVAL;
        }
    }

    public void processContinuation(AssignExprCont assignExprCont) {
        stmt = assignExprCont.getAssign();
        pc--;
        next = EVAL;
    }

    public void processContinuation(AssignCont assignCont) {
        env.set(assignCont.getVariable(), val);
        pc--;
        next = CONT;
    }

    public void processContinuation(SlotSetReceiverCont slotSetReceiverCont) {
        stmt = slotSetReceiverCont.getSlotExpression();
        Obj receiver = val;
        cont[pc] = new SlotSetSlotCont(receiver, slotSetReceiverCont.getValueExpression());
        next = EVAL;
    }

    public void processContinuation(SlotSetSlotCont slotSetSlotCont) {
        Obj receiver = slotSetSlotCont.getReceiver();
        Obj slot = val;

        stmt = slotSetSlotCont.getValueExpression();
        cont[pc] = new SlotSetValueCont(receiver, slot);
        next = EVAL;
    }

    public void processContinuation(SlotSetValueCont slotSetValueCont) {
        pc--;

        Obj receiver = slotSetValueCont.getReceiver();
        Obj slot = slotSetValueCont.getSlot();
        Obj value = val;

        receiver.setSlot(context, slot, value);
        next = CONT;
    }

    public void processContinuation(SlotGetReceiverCont slotGetReceiverCont) {
        Obj receiver = val;
        stmt = slotGetReceiverCont.getSlotExpression();

        cont[pc] = new SlotGetSlotCont(receiver);
        next = EVAL;
    }

    public void processContinuation(SlotGetSlotCont slotGetSlotCont) {
        pc--;
        Obj receiver = slotGetSlotCont.getReceiver();
        Obj slot = val;
        Obj obj = receiver;
        while (true) {
            val = obj.getSlot(context, slot);
            if (val != null) {
                break;
            }
            Obj parent = ObjUtils.getParent(context, obj);
            if (parent == null) {
                break;
            }
            obj = parent;
        }
        if (val == null) {
            val = getObjNull();
        }
        next = CONT;
    }

    public void processContinuation(SlotCallReceiverCont slotCallReceiverCont) {
        Obj receiver = val;
        stmt = slotCallReceiverCont.getSlotExpression();
        cont[pc] = new SlotCallSlotCont(receiver, slotCallReceiverCont.getCallExpression());

        next = EVAL;
    }

    public void processContinuation(SlotCallSlotCont slotCallSlotCont) {
        Obj ctx = slotCallSlotCont.getReceiver();
        Obj slot = val;

        Obj receiver = ctx;
        while (true) {
            val = receiver.getSlot(context, slot);
            if (val != null) {
                break;
            }

            Obj parent = ObjUtils.getParent(context, receiver);
            if (parent == null) {
                break;
            }

            receiver = parent;
        }

        if (val == null) {
            val = getObjNull();
        }

        cont[pc] = new CallCont(ctx, receiver, slotCallSlotCont.getArguments(), slotCallSlotCont.getCallFlags());
        next = CONT;
    }

    public void processContinuation(CallCont callCont) {
        // TODO: merge if-branches as far as possible
        // TODO: replace if-else by switch by introducing class ids (if possible enum-based)
        if (val instanceof PrimitiveCall) {
            cont[pc] = new PrimitiveCont((PrimitiveCall) val, callCont.getContext());
        }
        else if (val instanceof NativeCall) {
            cont[pc] = new NativeCont((NativeCall) val, callCont.getContext());
        }
        else if (val instanceof Func) {
            Function func = ((Func) val).getFunction();
            List<Expression> args = callCont.getArguments();
            checkFunArgs(func, args);
            // FIXME: should environment be saved _after_ evaluating arguments???
            Env savedEnv = env;
            Env funcEnv = new StaticEnv(func.getEnv());
            funcEnv.setContext(callCont.isSuperCall() ? env.getContext() : callCont.getContext());
            funcEnv.setReceiver(callCont.getReceiver());
            cont[pc] = new CallArgCont(func, funcEnv, savedEnv, callCont.isTailCall());
        }
        else if (val instanceof Clos) {
            Clos closObj = (Clos) val;
            BlockClosure clos = closObj.getClosure();
            List<Expression> args = callCont.getArguments();
            checkFunArgs(clos, args);
            Env savedEnv = env;
            Env lexEnv = clos.getEnv();
            Env closEnv = new StaticEnv(lexEnv);
            closEnv.setContext(lexEnv.getContext());
            closEnv.setReceiver(lexEnv.getReceiver());
            cont[pc] = new CallArgCont(clos, closEnv, savedEnv);
        }
        else {
            throw new SQLScriptRuntimeException("Invalid call: Neither block nor function");
        }

        next = evalArgs(callCont.getArguments());
    }

    protected boolean evalArgs(List<Expression> args) {
        if (args.isEmpty()) {
            val = Args.emptyArgs;
            return CONT;
        }

        stmt = args.get(0);
        cont[++pc] = new ArgsCont(args);
        return EVAL;
    }

    public void processContinuation(ArgsCont argsCont) {
        argsCont.addArgsValue(val);
        if (argsCont.hasNext()) {
            stmt = argsCont.next();
            next = EVAL;
        }
        else {
            pc--;
            val = argsCont.getArgsValues();
            next = CONT;
        }
    }

    public void processContinuation(CallArgCont callArgCont) {
        stmt = callArgCont.getBody();
        env = callArgCont.getCallEnv();

        Callable callable = callArgCont.getCallable();

        // NOTE: matching length of both containers is ensured by previous call to checkFunArgs()
        List<Variable> argVars = callable.getArguments();
        Obj[] args = ((Args) val).args;
        int nargs = args.length;
        for (int i = 0; i < nargs; i++) {
            Variable variable = argVars.get(i);
            env.add(variable, args[i]);
        }

        if (callable instanceof Function) {
            // tail-call optimization
            if (callArgCont.isTailCall()) {
                pc--;
            }
            else {
                cont[pc] = new FunRetCont(callArgCont.getSavedEnv());
            }
            env.setClosureHome(pc, cont[pc]);
        }
        else if (callable instanceof BlockClosure) {
            BlockClosure clos = (BlockClosure) callable;
            cont[pc] = new ClosRetCont(clos, callArgCont.getSavedEnv());
        }
        else {
            throw new SQLScriptRuntimeException("Internal error: Unhandled callable");
        }

        next = EVAL;
    }

    protected boolean closureReturnInProgress = false;

    public boolean isClosureReturnInProgress() {
        return closureReturnInProgress;
    }

    public void processContinuation(NativeCont nativeCont) {
        // NOTE: The next flag has to be set _before_ invoking the call to allow the invoked method to modify it
        //       without getting overridden.
        next = CONT;
        pc--;

        Obj context = nativeCont.getContext();
        Obj[] args = ((Args) val).args;
        try {
            Obj result = nativeCont.getNative().call(this, context, args);
            if (result != null) {
                val = result;
            }
        } catch (ClosureTerminatedException ignored) {
            // XXX: is this correct??? - it is ReturnCont has already cleaned up the cont stack
            closureReturnInProgress = false;
        } catch (ControlFlowException e) {
            throw e;
        } catch (SQLScriptRuntimeException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new SQLScriptNativeRuntimeException(e);
        }
    }

    public void processContinuation(TriggeredNativeCont triggeredNativeCont) {
        pc--;
        NativeCall nat = triggeredNativeCont.getNative();
        Obj context = triggeredNativeCont.getContext();
        Obj[] args = triggeredNativeCont.getArgs();
        // XXX: Should ClosureTerminatedException be handled here?
        try {
            Obj result = nat.call(this, context, args);
            if (result != null) {
                val = result;
            }
        } catch (ControlFlowException e) {
            throw e;
        } catch (SQLScriptRuntimeException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new SQLScriptNativeRuntimeException(e);
        }
        next = CONT;
    }

    public void processContinuation(PrimitiveCont primitiveCont) {
        pc--;
        Obj[] args = ((Args) val).args;
        processPrimitive(primitiveCont.getPrimitive().type, primitiveCont.getContext(), args);
        next = CONT;
    }

    public void processContinuation(TriggeredPrimitiveCont triggeredPrimitiveCont) {
        pc--;
        PrimitiveCall prim = triggeredPrimitiveCont.getPrimitive();
        Obj context = triggeredPrimitiveCont.getContext();
        Obj[] args = triggeredPrimitiveCont.getArgs();
        processPrimitive(prim.type, context, args);
        next = CONT;
    }

    protected void processPrimitive(PrimitiveCall.Type primitive, Obj context, Obj... args) {
        switch (primitive) {
            case ID: {
                Obj o2 = args[0];
                val = context == o2 ? getObjTrue() : getObjFalse();
                break;
            }
            case NI: {
                Obj o2 = args[0];
                val = context != o2 ? getObjTrue() : getObjFalse();
                break;
            }
            case LOOP:
                cont[++pc] = new LoopCont();
                break;
            case LOOP_BREAK:
                cont[++pc] = new LoopBreakCont();
                break;
            case LOOP_CONTINUE:
                cont[++pc] = new LoopContinueCont();
                break;
            case EXIT:
//                System.out.println("Computation finished. Exiting...");
                if (args.length > 0) {
                    val = args[0];
                }
                pc = 0;
                finished = true;
                break;
            default:
                throw new SQLScriptRuntimeException("Unhandled primitive: " + primitive);
        }
    }

    public void processContinuation(FunRetCont funRetCont) {
        env = funRetCont.getSavedEnv();
        pc--;
        next = CONT;
    }

    public void processContinuation(ClosRetCont closRetCont) {
        env = closRetCont.getSavedEnv();
        pc--;
        next = CONT;
    }

    public void processContinuation(ReturnCont returnCont) {
        pc--;
        for (int i = pc; i >= 0; i--) {
            Continuation c = cont[i];
            if (c instanceof ClosRetCont) {
                BlockClosure closure = ((ClosRetCont) c).getClosure();
                int homeOffset = closure.getHomeOffset();
                Continuation homeCont = closure.getHomeCont();
                if (homeOffset < 0 || homeOffset >= i || cont[homeOffset] != homeCont) {
                    // NOTE: This exact message is checked for in some unit tests (due to the lack of a proper
                    //       exception handling scheme)
                    throw new SQLScriptNonLocalReturnException("Non-local return");
                }
                pc = homeOffset;
                if (returnCont.hasSavedValue()) {
                    val = returnCont.getSavedValue();
                }
                next = CONT;
                return;
            }
            else if (c instanceof FunRetCont) {
                pc = i;
                if (returnCont.hasSavedValue()) {
                    val = returnCont.getSavedValue();
                }
                next = CONT;
                return;
            }
        }
        throw new SQLScriptRuntimeException("Found return statement outside of function block");
    }

    public void processContinuation(NewCont newCont) {
        if (val instanceof NativeObj) {
            NativeObj context = (NativeObj) val;
            Call nativeConstructor = context.getNativeConstructor();
            cont[pc] = new CallCont(context, context, newCont.getArguments());
            val = nativeConstructor;
        }
        else {
            Obj parent = val;
            Obj newObj = new PlainObj();
            newObj.setSlot(context, SLOT_PARENT, parent);

            Obj initSlot = parent.getSlot(context, SLOT_INIT);
            while (initSlot == null) {
                Obj nextParent = ObjUtils.getParent(context, parent);
                if (nextParent == null) {
                    break;
                }
                initSlot = nextParent.getSlot(context, SLOT_INIT);
                parent = nextParent;
            }

            if (initSlot == null) {
                pc--;
                val = newObj;
            }
            else {
                val = initSlot;
                cont[pc] = new NewResultCont(newObj);
                cont[++pc] = new CallCont(newObj, parent, newCont.getArguments());
            }
        }
        next = CONT;
    }

    public void processContinuation(NewResultCont newResultCont) {
        pc--;
        val = newResultCont.getNewObject();
        next = CONT;
    }

    public void processContinuation(LoopCont loopCont) {
        // LoopCont is used as marker only -> just remove it
        pc--;
    }

    public void processContinuation(LoopBreakCont loopBreakCont) {
        for (int i = pc - 1; i >= 0; i--) {
            Continuation c = cont[i];
            if (c instanceof ClosRetCont) {
                ClosRetCont closRetCont = (ClosRetCont) c;
                env = closRetCont.getSavedEnv();
            }
            else if (c instanceof LoopCont) {
                pc = i - 1;
                next = CONT;
                throw new LoopBreakException();
            }
        }
        throw new SQLScriptRuntimeException("Found break statement outside of loop");
    }

    public void processContinuation(LoopContinueCont loopContinueCont) {
        for (int i = pc - 1; i >= 0; i--) {
            Continuation c = cont[i];
            if (c instanceof ClosRetCont) {
                ClosRetCont closRetCont = (ClosRetCont) c;
                env = closRetCont.getSavedEnv();
            }
            else if (c instanceof LoopCont) {
                pc = i;
                next = CONT;
                throw new LoopContinueException();
            }
        }
        throw new SQLScriptRuntimeException("Found continue statement outside of loop");
    }

    protected void checkFunArgs(Callable callable, List args) {
        if (callable.getArgCount() != args.size()) {
            throw new SQLScriptRuntimeException("Arguments do not match function");
        }
    }

    public Obj toBool(Obj value) {
        if (value == null) {
            return getObjFalse();
        }
        if (value instanceof Bool) {
            return value.equals(getObjTrue()) ? getObjTrue() : getObjFalse();
        }
        if (value instanceof Null) {
            return getObjFalse();
        }
        return getObjTrue();
//        return value != null && (!(value instanceof Bool) || value.equals(Bool.TRUE)) ? Bool.TRUE : Bool.FALSE;
    }

    public boolean toBoolean(Obj value) {
        return context.getObjTrue().equals(value) || (!(value instanceof Bool) && !(value instanceof Null));
    }

    protected void finish() throws SQLScriptRuntimeException {
        logger.debug("Finishing");

        // TODO: close connections in ConnMgr
    }

    public boolean isFinished() {
        return finished;
    }

    // native interface

    // TODO: adjust trigger-scheme to support trigger of multiple calls in turn
    public void trigger(Obj obj, Obj context, Obj... args) {
        Call call;
        try {
            call = (Call) obj;
        } catch (ClassCastException e) {
            throw new SQLScriptRuntimeException(e);
        }

        call.trigger(this, context, args);
    }

    public void trigger(PrimitiveCall prim, Obj context, Obj... args) {
        cont[++pc] = new TriggeredPrimitiveCont(prim, context, args);
        next = CONT;
    }

    public void trigger(NativeCall nat, Obj context, Obj... args) {
        cont[++pc] = new TriggeredNativeCont(nat, context, args);
        next = CONT;
    }

    public void trigger(Clos clos, Obj... args) {
        BlockClosure closure = clos.getClosure();
        List<Obj> argsList = Arrays.asList(args);
        checkFunArgs(closure, argsList);
        Env savedEnv = env;
        Env lexEnv = closure.getEnv();
        env = new StaticEnv(lexEnv);
        env.setContext(lexEnv.getContext());

        List<Variable> argVars = clos.getClosure().getArguments();
        int nargs = args.length;
        for (int i = 0; i < nargs; i++) {
            Variable variable =  argVars.get(i);
            env.add(variable, args[i]);
        }

        stmt = closure.getBody();
        cont[++pc] = new ClosRetCont(closure, savedEnv);
        next = EVAL;
    }

    public void trigger(Func func, Obj context, Obj receiver, Obj... args) {
        Function function = func.getFunction();
        List<Obj> argsList = Arrays.asList(args);
        checkFunArgs(function, argsList);
        Env savedEnv = env;
        env = new StaticEnv(function.getEnv());
        env.setContext(context);
        env.setReceiver(receiver);

        List<Variable> argVars = func.getFunction().getArguments();
        int nargs = args.length;
        for (int i = 0; i < nargs; i++) {
            Variable variable =  argVars.get(i);
            env.add(variable, args[i]);
        }

        stmt = function.getBody();
        cont[++pc] = new FunRetCont(savedEnv);
        next = EVAL;
    }

    /**
     * Calls the given callable object so that "this" is set to the given context and "super" lookups start at
     * the given receiver.
     * Does have an effect only on calls to Func objects.
     *
     * @param call the callable
     * @param context "this" context
     * @param receiver "super"
     * @param args arguments passed to callable
     * @return result of the invocation
     */
    public Obj invokeOnReceiver(Obj call, Obj context, Obj receiver, Obj... args) {
        Call c = ObjUtils.ensureType(Call.class, call);
        return c.call(this, context, receiver, args);
    }

    public Obj invoke(Obj call, Obj context, Obj... args) throws ClosureTerminatedException {
        Call c = ObjUtils.ensureType(Call.class, call);
        return c.call(this, context, args);
    }

    public Obj invoke(PrimitiveCall prim, Obj context, Obj... args) {
        processPrimitive(prim.type, context, args);
        return val;
    }

    public Obj invoke(NativeCall nat, Obj context, Obj... args) {
        Obj result = nat.call(this, context, args);
        if (result == null) {
            return val; // XXX: better return getObjNull()?
        }
        return result;
    }

    public Obj invoke(Clos clos, Obj... args) throws ClosureTerminatedException {
        int callFrame = pc;

        trigger(clos, args);

        while (step() && pc > callFrame) {
        }

        if (pc < callFrame) {
            closureReturnInProgress = true;
            throw new ClosureTerminatedException();
        }

        return val;
    }

    public Obj invoke(Func func, Obj context, Obj receiver, Obj... args) throws ClosureTerminatedException {
        int callFrame = pc;

        trigger(func, context, receiver, args);

        while (step() && pc > callFrame) {
        }

        if (pc < callFrame) {
            closureReturnInProgress = true;
            throw new ClosureTerminatedException();
        }

        return val;
    }

    public Obj invokeSlot(Obj obj, Obj slot, Obj... args) throws ClosureTerminatedException {
        Obj receiver = obj;
        Obj slotValue;
        while ((slotValue = receiver.getSlot(context, slot)) == null) {
            receiver = ObjUtils.getParent(context, obj);
            if (receiver == null) {
                break;
            }
        }

        if (slotValue == null) {
            slotValue = getObjNull();
        }

        return invokeOnReceiver(slotValue, obj, receiver, args);
    }

    /**
     * Tries to invoke the value associated with the given slot on the given object.
     *
     * @param obj receiver if the slot invocation
     * @param slot slot whose value is to be invoked
     * @param args arguments passed to the invoked method
     * @return the result of the invocation or null if the given slot was not set
     */
    public Obj invokeSlotIfPresent(Obj obj, Obj slot, Obj... args) {
        Obj receiver = obj;
        Obj slotValue;
        while ((slotValue = receiver.getSlot(context, slot)) == null) {
            receiver = ObjUtils.getParent(context, receiver);
            if (receiver == null) {
                break;
            }
        }

        if (slotValue == null) {
            return null;
        }

        return invokeOnReceiver(slotValue, obj, receiver, args);
    }

    public Obj invokeBlock(Block block) throws ClosureTerminatedException {
        int callFrame = pc;

        stmt = block;
        next = EVAL;

        while (step() && pc > callFrame) {
        }

        if (pc < callFrame) {
            closureReturnInProgress = true;
            throw new ClosureTerminatedException();
        }

        return val;
    }

    protected static final Continuation LOOP_CONT = new LoopCont();

    public Obj invokeInLoop(Obj obj, Obj context, Obj... args)
            throws ClosureTerminatedException, LoopBreakException, LoopContinueException {
        cont[++pc] = LOOP_CONT;
        Obj result = invoke(obj, context, args);
        pc--;
        return result;
    }

    public Obj getVal() {
        return val;
    }

    public void setVal(Obj val) {
        this.val = val;
    }

    public EngineState getState() {
        return new EngineState(env, pc);
    }

    public void setState(EngineState state) {
        env = state.env;
        pc = state.pc;
    }

    public Env getEnv() {
        return env;
    }

    public void setEnv(Env env) {
        this.env = env;
    }

    public static class EngineState {
        protected Env env;
        protected int pc;

        public EngineState(Env env, int pc) {
            this.env = env;
            this.pc = pc;
        }
    }

    public DefaultContext getContext() {
        return context;
    }

    public Sys getObjSys() {
        return context.getObjSys();
    }

    public ConnMgr getObjConnMgr() {
        return context.getObjConnMgr();
    }

    public Null getObjNull() {
        return context.getObjNull();
    }

    public Bool getObjTrue() {
        return context.getObjTrue();
    }

    public Bool getObjFalse() {
        return context.getObjFalse();
    }
}
