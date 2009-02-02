// TODO:
// - Handle variable references in parameter values

tree grammar SQLScriptWalker;

options {
	tokenVocab = SQLScript;
	ASTLabelType = CommonTree;
}

scope Scope {
	Scope scope;
}

scope Block {
	StatementContainer block;
}

@header {
	package org.unbunt.sqlscript;

	import java.util.Observer;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.HashMap;

	import org.unbunt.sqlscript.lang.*;
	import org.unbunt.sqlscript.statement.*;
	import org.unbunt.sqlscript.support.*;
	import org.unbunt.sqlscript.exception.*;
}

@members {
	protected static int POS_RHS = 1;
	protected static int POS_LHS = 2;

	protected Observer[] observers = new Observer[] {};

	public void run(Observer... observers) throws RecognitionException, SQLScriptRuntimeException, RuntimeException {
		this.observers = observers;

		boolean success = false;
		try {
			script();
			success = true;
		}
		finally {
			if (success) {
				finish();
			}
			else {
				try { finish(); }
				catch (Exception ignored) {}
			}
		}
	}

	protected SQLScriptContext scriptContext = null;
	
	public SQLScriptContext getScriptContext() {
		return scriptContext;
	}
	
	public void setScriptContext(SQLScriptContext scriptContext) {
		this.scriptContext = scriptContext;
	}
	
	protected SQLScriptEngine scriptEngine = null;
	
	protected SQLScriptEngine engine() {
		if (scriptEngine == null) {
			if (scriptContext == null) {
				throw new RuntimeException("No script context provided");
			}
			
			scriptEngine = new SQLScriptEngine(scriptContext);
			
			for (Observer o : observers) {
				scriptEngine.addObserver(o);
			}
		}
		return scriptEngine;
	}
	
	protected void finish() {
		if (scriptEngine != null) {
			scriptEngine.finish();
		}
	}
	
	protected boolean verbose = false;

	private void print(String msg) {
		if (!verbose) {
			return;
		}
		System.out.println(msg);
	}
	
	public static String extractString(String s) {
		return s.substring(1, s.length() - 1).replace("''", "'");
	}
	
	protected List<Token> getOffchannelTokensBefore(int channel, int index) {
		TokenStream tokens = input.getTokenStream();

		List<Token> result = new LinkedList<Token>();
		while (--index >= 0) {
			Token token;
			try {
				token = tokens.get(index);
			} catch (IndexOutOfBoundsException e) {
				break;
			}

			if (channel != Token.HIDDEN_CHANNEL && token.getChannel() == Token.HIDDEN_CHANNEL) {
				continue;
			}

			if (token.getChannel() == channel) {
				result.add(0, token);
			}
			else {
				break;
			}
		}

		return result;
	}

	protected List<Token> getOffchannelTokensBefore(int channel, Object tree) {
		if (tree == null) {
			return getOffchannelTokensBefore(channel, -1);
		}

		int index = ((CommonTree)tree).getTokenStartIndex();
		return getOffchannelTokensBefore(channel, index);
	}
}

script
scope Block, Scope;
@init {
	$Scope::scope = new Scope();
	$Block::block = new Block($Scope::scope);
}
@after{
	engine().process((Block)$Block::block);
	engine().finish();
}
	:	statement*
	;

statement
	:	sqlStmt
	|	evalStmt
	|	scriptStmt
	|	block
	;

block returns [ Statement value ]
	:	blk=blockStmt { $Block::block.addStatement($blk.value); }
	;

// NOTE: ANTLRWorks currently has problems with the "scope ScopeA, ScopeB;" syntax.
// NOTE: Therefore we just split the block rule in two separate rules. (a form of currying)
blockStmt returns [ Statement value ]
scope Scope;
@init { $Scope::scope = new Scope($Scope[-1]::scope); }
	:	blk=blockStmt_ { $value = $blk.value; }
	;

blockStmt_ returns [ Statement value ]
scope Block;
@init {
	$Block::block = new Block($Scope::scope);
	$value = $Block::block;
}
	:	^(BLOCK statement*)
	;

evalStmt
@init { EvalCommand cmd = new EvalCommand(); }
@after { $Block::block.addStatement(cmd); }
	:	^(EVAL_CMD
			evcmd=evalCommand { cmd.setName($evcmd.value); }
			(param=evalParam { cmd.addParam($param.value); })*
			(annot=annotation { $annot.value.setSubject(cmd); })*
		)
	;

evalCommand returns [ String value ]
	:	cmd=identifier { $value = $cmd.value; }
	;

evalParam returns [ Parameter value ]
	:	^(EVAL_ARG param=parameter) { $value = $param.value; }
	;

sqlStmt
@init { SQLStatement stmt = new SQLStatement(); }
@after { $Block::block.addStatement(stmt); }
	:	^(SQL_CMD
			name=sqlStmtName  { stmt.addPart($name.value); }
			(param=sqlParam   {
				if ($param.whitespace.length() > 0) {
					stmt.addPart($param.whitespace);
				}
				stmt.addPart($param.value);
			})*
			(annot=annotation { $annot.value.setSubject(stmt); })*
		)
	;

sqlStmtName returns [ Object value ]
	:	name=WORD { $value = $name.text; }
	|	var=(VARIABLE | EMBEDDED_VARIABLE) { $value = $Scope::scope.getVariable($var.text); }
	;

sqlParam returns [ String whitespace, Object value ]
	:	token=sqlToken {
			$value = $token.value;

			$whitespace = "";
			List<Token> wsBefore = getOffchannelTokensBefore(SQLScriptParser.WHITESPACE_CHANNEL, $sqlToken.start);
			for (Token ws : wsBefore) {
				$whitespace += ws.getText();
			}
		}
	;

sqlToken returns [ Object value ]
	:	str=stringLiteral     { $value = $str.value; }
	|	id=identifier         { $value = $id.value; }
	|	chr=sqlSpecialChars   { $value = $chr.text; }
	|	kw=keyword            { $value = $kw.text; }
	|	var=VARIABLE          { $value = $Scope::scope.getVariable($var.text); }
	;

annotation returns [ AnnotationCommand value ] // generated command returned so that annotation subject can be set in calling context
@init { $value = new AnnotationCommand(); }
@after { $Block::block.addStatement($value); }
	:	^(ANNOT
			cmd=annotationCommand { $value.setName($cmd.value); }
			(param=annotationParam { $value.addParam($param.value); })*)
	;

annotationCommand returns [ String value ]
	:	cmd=identifier { $value = $cmd.value; }
	;

annotationParam returns [ Parameter value ]
	:	^(ANNOT_ARG param=parameter) { $value = $param.value; }
	;

scriptStmt
	:	scriptIfElse
	|	scriptTry
	|	scriptThrow
	|	scriptReturn
	|	scriptExit
	|	expressionStmt
	;

//scriptFuncDefStmt
//	:	func=scriptFuncDef {
//			$Block::block.addStatement($func.value);
//		}
//	;

//scriptFuncCallStmt
//	:	func=scriptFuncCall { $Block::block.addStatement($func.value); }
//	;

scriptIfElse returns [ Statement value ]
scope Block;
@init { $Block::block = new IfStatement(); $value = $Block::block; }
@after { $Block[-1]::block.addStatement($value); }
	:	^(IF scriptIf scriptElse?)
	;

scriptIf returns [ Statement value ]
scope Scope;
@init { $Scope::scope = new Scope($Scope[-1]::scope); }
	:	expr=expression block { $Block::block.addStatement($expr.value); }
	;

scriptElse returns [ Statement value ]
	:	elseIf=scriptIfElse { $value = $elseIf.value; }
	|	elseBlock=block { $value = $elseBlock.value; }
	;

scriptTry returns [ TryStatement value ]
@after { $Block::block.addStatement($value); }
	:	^(TRY blk=blockStmt { $value = new TryStatement($blk.value); } (
			cat=scriptCatch { $value.setCatchClause($cat.value); }
			(fin=scriptFinally { $value.setFinallyClause($fin.value); })?
			| fin=scriptFinally { $value.setFinallyClause($fin.value); }
		))
	;

scriptCatch returns [ CatchStatement value ]
	:	^(CATCH var=identifier blk=blockStmt) {
			$value = new CatchStatement($var.value, $blk.value);
		}
	;

scriptFinally returns [ FinallyStatement value ]
	:	^(FINALLY blk=blockStmt) { $value = new FinallyStatement($blk.value); }
	;

scriptThrow returns [ ThrowStatement value ]
@after { $Block::block.addStatement($value); }
	:	^(THROW expr=expression) { $value = new ThrowStatement($expr.value); }
	;

scriptReturn returns [ ReturnStatement value ]
	:	^(RETURN { $value = new ReturnStatement(); } (expr=expression { $value.setExpression($expr.value); })?) {
			$Block::block.addStatement($value);
		}
	;
	
scriptExit returns [ ExitStatement value ]
	:	^(EXIT { $value = new ExitStatement(); } (expr=expression { $value.setExpression($expr.value); })?) {
			$Block::block.addStatement($value);
		}
	;

expressionStmt
	:	expr=expression { $Block::block.addStatement($expr.value); }
	;

expression returns [ Expression value ]
	:	ex=expressionNoSlotExp { $value = $ex.value; }
	|	st=slotExpressionRHS { $value = $st.value; } // separated out to avoid ambigouity in callExpression
	;

expressionNoSlotExp returns [ Expression value ]
	:	fd=scriptFuncDef { $value = $fd.value; }
	|	fc=scriptFuncCall { $value = $fc.value; }
	|	da=scriptDeclareAndAssign { $value = $da.value; }
	|	de=scriptDeclare { $value = $de.value; }
	|	ae=scriptAssign { $value = $ae.value; }
	|	ix=indexExpressionRHS { $value = $ix.value; }
	|	cl=callExpression { $value = $cl.value; }
	|	tc=ternaryConditional { $value = $tc.value; }
	|	oc=orCondition { $value = $oc.value; }
	|	ac=andCondition { $value = $ac.value; }
	|	ec=eqCondition { $value = $ec.value; }
	|	nexp=notExpression { $value = $nexp.value; }
	|	newx=newExpression { $value = $newx.value; }
	|	sexp=simpleExpression { $value = $sexp.value; }
	;

scriptFuncDef returns [ FunctionDefinitionExpression value ]
//scope Scope;
scope Block;
@init {
//	$Scope::scope = new Scope($Scope[-1]::scope);
	Function function = new Function();
	$value = new FunctionDefinitionExpression(function);
	$Block::block = $value;
}
	:	^(FUNC_DEF (name=identifier { function.setName($name.value); })?
	                   (args=argumentsDef { function.setArguments($args.value); })?
	                   block)
	;

// TODO: Forbid duplicate arguments
argumentsDef returns [ List<String> value ]
@init { $value = new ArrayList<String>(); }
	:	^(ARGS (name=identifier { $value.add($name.value); })+)
	;

// NOTE: Obsoleted - should no longer be generated by parser
// TODO: Remove
scriptFuncCall returns [ AbstractFunctionCallExpression value ]
	:	^(FUNC_CALL (name=identifier { $value = new NamedFunctionCallExpression($name.value); }
			    |expr=expression { $value = new FunctionCallExpression($expr.value); }
			    )
			    (args=argumentsList { $value.setArguments($args.value); })?
		)
	;

// TODO: Forbid duplicate arguments
argumentsList returns [ Map<String, Expression> value ]
@init { $value = new HashMap<String, Expression>(); }
	:	^(ARGS ((^(ARG_EXPR name=identifier expr=expression { $value.put($name.value, $expr.value); })
	                |^(ARG_TRUE name=identifier { $value.put($name.value, new BooleanLiteralExpression(Bool.TRUE)); })
	                |^(ARG_FALSE name=identifier { $value.put($name.value, new BooleanLiteralExpression(Bool.FALSE)); })
	                )
	               )+)
	;

//scriptDeclareStmt
//	:	declare=scriptDeclare { $Block::block.addStatement($declare.value); }
//	;

scriptDeclareAndAssign returns [ Expression value ]
@init { Expression decl = null; }
	:	^(DECLARE_ASSIGN
			declare=scriptDeclare { decl = $declare.value; }
			assign=scriptAssign {
				if (decl != null) {
					$value = new DeclareAndAssignExpression($declare.value, (AssignExpression)$assign.value);
				}
				else {
					$value = $assign.value;
				}
			}
		)
	;

// TODO: Warning, if already declared
scriptDeclare returns [ DeclareVariableExpression value ]
	:	^(DECLARE var=VARIABLE {
			$Scope::scope.setVariable(new Variable($var.text));
			$value = new DeclareVariableExpression($var.text);
		})
	;

//scriptAssignStmt
//	:	assign=scriptAssign { $Block::block.addStatement($assign.value); }
//	;

scriptAssign returns [ Expression value ]
	:	^(ASSIGN
			( varExp=assignVariable { $value = $varExp.value; }
			| idxExp=assignIndex { $value = $idxExp.value; }
			| slotExp=assignSlot { $value = $slotExp.value; }
			)
		)
	;

assignVariable returns [ Expression value ]
	:	lval=VARIABLE rval=expression {
			Variable variable = $Scope::scope.getVariable($lval.text);
			if (variable == null) {
				// TODO: Warning, if not yet declared
				variable = new Variable($lval.text);
				$Scope::scope.setVariable(variable);
				$value = new DeclareAndAssignExpression(
						new DeclareVariableExpression($lval.text),
						new AssignExpression($lval.text, $rval.value)
				);
			}
			else {
				$value = new AssignExpression($lval.text, $rval.value);
				//$Block::block.addStatement($value);
			}
		}
	;

assignIndex returns [ Expression value ]
	:	lval=indexExpressionLHS rval=expression
	;

assignSlot returns [ Expression value ]
	:	lval=slotExpressionLHS rval=expression
		{ $value = new SlotSetExpression($lval.value, $rval.value); }
	;

indexExpressionLHS returns [ Expression value ]
	:	exp=indexExpression_[POS_LHS] { $value = $exp.value; }
	;

indexExpressionRHS returns [ Expression value ]
	:	exp=indexExpression_[POS_RHS] { $value = $exp.value; }
	;

indexExpression_ [ int pos ] returns [ Expression value ]
	:	^(INDEX receiver=expression index=expression)
		{ $value = pos == POS_RHS ? /* gen "get" */ new NullExpression() : /* gen "set" */ new NullExpression(); }
	;

slotExpressionLHS returns [ SlotExpression value ]
	:	exp=slotExpression_[POS_LHS] { $value = $exp.value; }
	;

slotExpressionRHS returns [ SlotExpression value ]
	:	exp=slotExpression_[POS_RHS] { $value = $exp.value; }
	;

slotExpression_ [ int pos ] returns [ SlotExpression value ]
	:	^(SLOT receiver=expression
			( slotName=identifierExpression	{ $value = new SlotExpression($receiver.value, $slotName.value); }
			| slotExpr=expression		{ $value = new SlotExpression($receiver.value, $slotExpr.value); }
			)
		)
	;

callExpression returns [ Expression value ]
	:	^(CALL
			( slotCall=slotCallExpression { $value = $slotCall.value; }
			| funcCall=funcCallExpression { $value = $funcCall.value; }
			)
		)
	;

slotCallExpression returns [ SlotCallExpression value ]
	:	slotExpr=slotExpressionRHS { $value = new SlotCallExpression($slotExpr.value); }
		(callArgs=argumentsList { $value.setArguments($callArgs.value); })?
	;

funcCallExpression returns [ AbstractFunctionCallExpression value ]
	:	( name=identifier          { $value = new NamedFunctionCallExpression($name.value); }
		| expr=expressionNoSlotExp { $value = new FunctionCallExpression($expr.value); }
		)
		(callArgs=argumentsList { $value.setArguments($callArgs.value); })?
	;

ternaryConditional returns [ Expression value ]
	:	^(COND_EXPR cond=expression trueExp=expression falseExp=expression) {
			$value = new TernaryCondExpression($cond.value, $trueExp.value, $falseExp.value);
		}
	;

orCondition returns [ Condition value ]
@init { List<Expression> expressions = new ArrayList<Expression>(); }
	:	^(COND_OR (expr=expression { expressions.add($expr.value); })+) {
			$value = new ConditionOr(expressions);
		}
	;

andCondition returns [ Condition value ]
@init { List<Expression> expressions = new ArrayList<Expression>(); }
	:	^(COND_AND (expr=expression { expressions.add($expr.value); })+) {
			$value = new ConditionAnd(expressions);
		}
	;

eqCondition returns [ Condition value ]
	:	^(COMP_EQ exp1=expression exp2=expression) {
			$value = new ConditionEq($exp1.value, $exp2.value);
		}
	;

notExpression returns [ Expression value ]
	:	^(NOT exp=expression) {
			$value = new NotExpression($exp.value);
		}
	;

newExpression returns [ Expression value ]
	:	^(NEW exp=expression (args=argumentsList)?) {
			$value = new NewExpression($exp.value, $args.value);
		}
	;

simpleExpression returns [ Expression value ]
	:	var=VARIABLE { // TODO: factor out into separate rule
			//Variable v = $Scope::scope.getVariable($var.text);
			//if (v == null) {
			//	// TODO: throw warning (variable not set)
			//	v = new Variable($var.text);
			//	$Scope::scope.setVariable($var.text, v);
			//}
			$value = new VariableExpression($var.text);
		}
	|	THIS {
			$value = new VariableExpression("this");
		}
	|	str=stringLiteral {
			$value = new StringLiteralExpression($str.value);
			//Scope::block.addStatement(new CreateString($str.value, $value));
		}
	|	bool=booleanLiteral {
			//Variable boolVar = new Variable();
			//boolVar.setValue($bool.value);
			//$value = new VariableExpression(boolVar);
			$value = new BooleanLiteralExpression($bool.value);
		}
	|	obj=objectLiteral {
			$value = new ObjectLiteralExpression($obj.value);
		}
	;

objectLiteral returns [ ObjectLiteral value ]
@init { $value = new ObjectLiteral(); }
	:	^(OBJ (slot=objectSlot { $value.putSlot($slot.key, $slot.value); })*)
	;

objectSlot returns [ Expression key, Expression value ]
	:	^(SLOT
			( id=identifierStringLiteral { $key = new StringLiteralExpression($id.value); }
			| str=stringLiteral { $key = new StringLiteralExpression($str.value); }
			)
			expr=expression { $value = $expr.value; }
		)
	;

parameter returns [ Parameter value ]
@init { Expression paramValue = null; }
	:	PARAM_NAME pname=paramName (PARAM_VALUE pval=paramValue { paramValue = $pval.value; })? {
			$value = new Parameter();
			$value.setName($pname.value);
			$Block::block.addStatement(new InitParameter($value, paramValue));
		}
	;

paramName returns [ String value ]
	:	id=identifier { $value = $id.value; }
	;

paramValue returns [ Expression value ]
	:	expr=expression { $value = $expr.value; }
	;

identifierExpression returns [ Expression value ]
	:	id=identifier { $value = new IdentifierExpression($id.value); }
	;

identifier returns [ String value ]
	:	id=(WORD | IDENTIFIER) { $value = $id.text; }
	;

sqlSpecialChars
	:	SQL_SPECIAL_CHAR | LPAREN | RPAREN | EQUALS | BACKSLASH | ATSIGN
	|	OP_DEFINE | OP_AND | OP_OR | OP_EQ
	|	EXCLAM | QUESTION | COLON
	;

keyword	:	KW_SQL | KW_VAR | KW_IF | KW_ELSE | KW_TRUE | KW_FALSE
	;

stringLiteral returns [ StringLiteral value ]
@init { List<Object> parts = new ArrayList<Object>(); }
	:	^(STRING start=(SQUOT | DQUOT | BTICK)
			( str=STRING_CONTENT    { parts.add($str.text); }
			| var=EMBEDDED_VARIABLE { parts.add(new Variable($var.text)); /*System.out.println("embedded str var: " + $var.text);*/ }
			)*
			(SQUOT | DQUOT | BTICK))
		{ $value = new StringLiteral($start.text, parts); }
	;

identifierStringLiteral returns [ StringLiteral value ]
@init { List<Object> parts = new ArrayList<Object>(); }
	:	id=identifier { parts.add($id.value); $value = new StringLiteral("'", parts); }
	;

booleanLiteral returns [ Bool value ]
	:	TRUE  { $value = Bool.TRUE; }
	|	FALSE { $value = Bool.FALSE; }
	;