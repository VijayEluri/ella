// $ANTLR 3.1 /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g 2009-07-14 08:23:00

	package org.unbunt.sqlscript;

	import org.antlr.runtime.tree.CommonTree;
	import org.unbunt.sqlscript.antlr.TreeHolderToken;	
	import org.unbunt.sqlscript.exception.RuntimeRecognitionException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SQLScriptLexer extends Lexer {
    public static final int ELSE_BLOCK=52;
    public static final int EXPONENT=153;
    public static final int OP_LE=121;
    public static final int LSQUARE=127;
    public static final int OP_AND=113;
    public static final int PARAM_NAME=38;
    public static final int WORD_CHAR=27;
    public static final int QQUOT_START=15;
    public static final int COND_AND=60;
    public static final int CHAR=17;
    public static final int NEW=79;
    public static final int EQUALS=87;
    public static final int NOT=63;
    public static final int OP_GE=119;
    public static final int EOF=-1;
    public static final int FUNC_CALL=44;
    public static final int KW_VAR=85;
    public static final int VARNAME=18;
    public static final int WORD=134;
    public static final int OP_MOD=123;
    public static final int RPAREN=91;
    public static final int SQL=31;
    public static final int OP_EQ=114;
    public static final int KW_NEW=133;
    public static final int SQUOT=12;
    public static final int KW_BREAK=103;
    public static final int IDX_GET=72;
    public static final int THIS=77;
    public static final int RETURN=57;
    public static final int ARGS=46;
    public static final int STR_QQUOT=146;
    public static final int IDX_CALL=71;
    public static final int SUPER=78;
    public static final int ATSIGN=20;
    public static final int EMBEDDED_VAR=11;
    public static final int OP_LT=120;
    public static final int NL=136;
    public static final int DOLQUOT_TAG=24;
    public static final int COMMENT=148;
    public static final int PARAM_VALUE=39;
    public static final int KW_EXIT=106;
    public static final int ARRAY=67;
    public static final int EXIT=58;
    public static final int OP_NE=115;
    public static final int CALL_UNARY=76;
    public static final int STRING_START=8;
    public static final int ARG_EXPR=47;
    public static final int LINE_COMMENT=149;
    public static final int EMB_VAR_START=140;
    public static final int EVAL_CMD=29;
    public static final int OP_ADD=124;
    public static final int OP_NI=117;
    public static final int NUMBER=154;
    public static final int KW_CATCH=97;
    public static final int LCURLY=21;
    public static final int INT=129;
    public static final int OP_DIV=122;
    public static final int FUNC_DEF=43;
    public static final int KW_IMPORT=107;
    public static final int DOLQUOT_TAG_START=25;
    public static final int SIMPLE_IDENTIFIER=155;
    public static final int SLOT_CALL=69;
    public static final int STR_BTICK=145;
    public static final int TRY=53;
    public static final int IF_BLOCK=51;
    public static final int KW_FINALLY=98;
    public static final int WS=135;
    public static final int KW_INCLUDE=110;
    public static final int KW_THROW=99;
    public static final int IMPORT_PACKAGE=80;
    public static final int SLOT=68;
    public static final int QQUOT_DELIM=23;
    public static final int STRING_END=10;
    public static final int COND_EXPR=59;
    public static final int STR_SQUOT=143;
    public static final int CHARS=7;
    public static final int CALL=74;
    public static final int CATCH=54;
    public static final int FALSE=65;
    public static final int SQL_MODE=32;
    public static final int KW_SUPER=132;
    public static final int THROW=56;
    public static final int KW_SQL=84;
    public static final int OP_DEFINE=86;
    public static final int BACKSLASH=138;
    public static final int KW_ELSE=95;
    public static final int IMPORT_CLASS=81;
    public static final int DOLLAR=151;
    public static final int OP_OR=112;
    public static final int KW_FUN=89;
    public static final int DQUOT=13;
    public static final int STRING_CONTENT=9;
    public static final int OP_MUL=108;
    public static final int OP_GT=118;
    public static final int FLOAT=130;
    public static final int KW_TRUE=141;
    public static final int ANNOT=36;
    public static final int DOUBLE_ARROW=92;
    public static final int ARG_FALSE=49;
    public static final int LPAREN=90;
    public static final int IF=50;
    public static final int QQUOT=6;
    public static final int AS=82;
    public static final int INDEX=73;
    public static final int DECLARE_ASSIGN=40;
    public static final int OP_ID=116;
    public static final int OP_SUB=125;
    public static final int SEP=83;
    public static final int COMMA=88;
    public static final int OBJ=66;
    public static final int KW_FOR=100;
    public static final int KW_WHILE=102;
    public static final int COND_OR=61;
    public static final int IDENTIFIER=139;
    public static final int KW_RETURN=105;
    public static final int DOLQUOT=16;
    public static final int ARG_TRUE=48;
    public static final int KW_TRY=96;
    public static final int DIGIT=152;
    public static final int COMP_EQ=62;
    public static final int QQUOT_END=19;
    public static final int DOT=93;
    public static final int KW_IF=94;
    public static final int KW_THIS=131;
    public static final int ANNOT_ARG=37;
    public static final int SQL_STMT=33;
    public static final int STR_DQUOT=144;
    public static final int KW_FALSE=142;
    public static final int EVAL_ARG=30;
    public static final int QUOTTED_IDENFITIER=5;
    public static final int KW_CONTINUE=104;
    public static final int STR_DOLQUOT=147;
    public static final int RSQUARE=128;
    public static final int TRUE=64;
    public static final int COLON=101;
    public static final int DOLQUOT_TAG_END=26;
    public static final int DDOLLAR=150;
    public static final int SQL_PARAM=35;
    public static final int QUESTION=111;
    public static final int FINALLY=55;
    public static final int EXCLAM=126;
    public static final int BLOCK=28;
    public static final int RCURLY=22;
    public static final int ASSIGN=42;
    public static final int KW_AS=109;
    public static final int DECLARE=41;
    public static final int SLOT_GET=70;
    public static final int SQL_SPECIAL_CHAR=137;
    public static final int CALL_BINARY=75;
    public static final int SQL_EXPR=34;
    public static final int BTICK=14;
    public static final int BLOCK_CLOSURE=45;
    public static final int IDENTIFIER_SPECIAL=156;
    public static final int STRING=4;

    	protected CommonTree currentStringTree = null;
    	
    	protected int lastStringStartMarker = -1;
    	
    	protected boolean allowQQuote = false;
    	protected boolean allowDollarQuote = false;
    	
    	protected boolean allowSpecialSQLSep = false;
    	
    	protected boolean escapeSeparators = false;
    	
    	/**
    	 * At signs in identifier clash with embedded variable syntax in sql literals.
    	 * This flag allows to disable at signs in identifiers when parsing sql literals.
    	 */
    	protected boolean allowAtSignInIdentifier = true;
    	
    	protected boolean allowEmbeddedVariables = true;
    	
    	protected int whitespaceChannel = HIDDEN;

    	@Override
    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		throw new RuntimeRecognitionException(e);
    	}
    	
    	protected int getLastStringStartMarker() {
    		return lastStringStartMarker;
    	}
    	
    	protected void setLastStringStartMarker(int lastStringStartMarker) {
    		this.lastStringStartMarker = lastStringStartMarker;
    	}
    	
    	protected void setAllowQQuote(boolean allowQQuote) {
    		this.allowQQuote = allowQQuote;
    	}
    	
    	protected boolean isAllowQQuote() {
    		return allowQQuote;
    	}
    	
    	protected void setAllowDollarQuote(boolean allowDollarQuote) {
    		this.allowDollarQuote = allowDollarQuote;
    	}
    	
    	protected boolean isAllowDollarQuote() {
    		return allowDollarQuote;
    	}
    	
    	protected void setAllowAtSignInIdentifier(boolean allow) {
    		this.allowAtSignInIdentifier = allow;
    	}
    	
    	protected boolean isAllowAtSignInIdentifier() {
    		return allowAtSignInIdentifier;
    	}
    	
    	protected void setAllowEmbeddedVariables(boolean allow) {
    		this.allowEmbeddedVariables = allow;
    	}
    	
    	protected boolean isAllowEmbeddedVariables() {
    		return allowEmbeddedVariables;
    	}
    	
    	protected void setIgnoreWhitespace(boolean ignore) {
    		whitespaceChannel = ignore ? HIDDEN : DEFAULT_TOKEN_CHANNEL;
    	}
    	
    	protected void setEscapeSeparators(boolean escape) {
    		escapeSeparators = escape;
    	}
    	
    	protected boolean isEscapeSeparators() {
    		return escapeSeparators;
    	}
    	
    	protected void setAllowSpecialSQLSep(boolean allow) {
    		this.allowSpecialSQLSep = allow;
    	}
    	
    	protected boolean isAllowSpecialSQLSep() {
    		return allowSpecialSQLSep;
    	}


    // delegates
    // delegators

    public SQLScriptLexer() {;} 
    public SQLScriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SQLScriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g"; }

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1125:9: ( '/*' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1125:11: '/*'
            {
            match("/*"); if (state.failed) return ;

            if ( state.backtracking==0 ) {

              			int level = 1;
              			while (true) {
              				if (input.LA(1) == EOF) {
              					break;
              				}
              				if (input.LA(1) == '*' && input.LA(2) == '/') {
              					input.consume();
              					input.consume();
              					if (--level == 0) {
              						break;
              					}
              				}
              				else if (input.LA(1) == '/' && input.LA(2) == '*') {
              					input.consume();
              					input.consume();
              					level++;
              				}
              				else {
              					input.consume();
              				}
              			}
              			_channel = HIDDEN;
              		
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:2: ( ( '--' ) (~ ( '\\n' | '\\r' ) )* )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:4: ( '--' ) (~ ( '\\n' | '\\r' ) )*
            {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:4: ( '--' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:5: '--'
            {
            match("--"); if (state.failed) return ;


            }

            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:11: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1155:11: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = HIDDEN; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "STR_SQUOT"
    public final void mSTR_SQUOT() throws RecognitionException {
        try {
            int _type = STR_SQUOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             lastStringStartMarker = input.mark(); 
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1160:2: ( '\\'' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1160:4: '\\''
            {
            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR_SQUOT"

    // $ANTLR start "STR_DQUOT"
    public final void mSTR_DQUOT() throws RecognitionException {
        try {
            int _type = STR_DQUOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             lastStringStartMarker = input.mark(); 
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1165:2: ( '\"' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1165:4: '\"'
            {
            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR_DQUOT"

    // $ANTLR start "STR_BTICK"
    public final void mSTR_BTICK() throws RecognitionException {
        try {
            int _type = STR_BTICK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             lastStringStartMarker = input.mark(); 
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1170:2: ( '`' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1170:4: '`'
            {
            match('`'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR_BTICK"

    // $ANTLR start "STR_QQUOT"
    public final void mSTR_QQUOT() throws RecognitionException {
        try {
            int _type = STR_QQUOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             lastStringStartMarker = input.mark(); 
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1175:2: ({...}? => ( 'N' | 'n' )? ( 'Q' | 'q' ) '\\'' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1175:4: {...}? => ( 'N' | 'n' )? ( 'Q' | 'q' ) '\\''
            {
            if ( !((allowQQuote)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "STR_QQUOT", "allowQQuote");
            }
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1175:21: ( 'N' | 'n' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='N'||LA2_0=='n') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:
                    {
                    if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR_QQUOT"

    // $ANTLR start "STR_DOLQUOT"
    public final void mSTR_DOLQUOT() throws RecognitionException {
        try {
            int _type = STR_DOLQUOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
             lastStringStartMarker = input.mark(); 
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1184:2: ({...}? => ( DDOLLAR | DOLLAR DOLQUOT_TAG DOLLAR ) )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1184:4: {...}? => ( DDOLLAR | DOLLAR DOLQUOT_TAG DOLLAR )
            {
            if ( !((allowDollarQuote)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "STR_DOLQUOT", "allowDollarQuote");
            }
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1184:26: ( DDOLLAR | DOLLAR DOLQUOT_TAG DOLLAR )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='$') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='$') ) {
                    alt3=1;
                }
                else if ( ((LA3_1>='A' && LA3_1<='Z')||LA3_1=='_'||(LA3_1>='a' && LA3_1<='z')||(LA3_1>='\u0080' && LA3_1<='\uFFFD')) ) {
                    alt3=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1184:27: DDOLLAR
                    {
                    mDDOLLAR(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1184:37: DOLLAR DOLQUOT_TAG DOLLAR
                    {
                    mDOLLAR(); if (state.failed) return ;
                    mDOLQUOT_TAG(); if (state.failed) return ;
                    mDOLLAR(); if (state.failed) return ;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STR_DOLQUOT"

    // $ANTLR start "DDOLLAR"
    public final void mDDOLLAR() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1188:9: ( '$$' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1188:11: '$$'
            {
            match("$$"); if (state.failed) return ;


            }

        }
        finally {
        }
    }
    // $ANTLR end "DDOLLAR"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1192:8: ( '$' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1192:10: '$'
            {
            match('$'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "DOLQUOT_TAG"
    public final void mDOLQUOT_TAG() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1197:2: ( DOLQUOT_TAG_START ( DOLQUOT_TAG_END )* )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1197:4: DOLQUOT_TAG_START ( DOLQUOT_TAG_END )*
            {
            mDOLQUOT_TAG_START(); if (state.failed) return ;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1197:22: ( DOLQUOT_TAG_END )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')||(LA4_0>='\u0080' && LA4_0<='\uFFFD')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1197:22: DOLQUOT_TAG_END
            	    {
            	    mDOLQUOT_TAG_END(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "DOLQUOT_TAG"

    // $ANTLR start "DOLQUOT_TAG_START"
    public final void mDOLQUOT_TAG_START() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1202:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '\\u0080' .. '\\ufffd' | '_' ) )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1202:4: ( 'A' .. 'Z' | 'a' .. 'z' | '\\u0080' .. '\\ufffd' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u0080' && input.LA(1)<='\uFFFD') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DOLQUOT_TAG_START"

    // $ANTLR start "DOLQUOT_TAG_END"
    public final void mDOLQUOT_TAG_END() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1207:2: ( DOLQUOT_TAG_START | DIGIT )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u0080' && input.LA(1)<='\uFFFD') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DOLQUOT_TAG_END"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:8: ( ( ( DIGIT )+ '.' DIGIT )=> ( DIGIT )+ '.' ( ( DIGIT )+ | EXPONENT ) | ( DIGIT )+ )
            int alt9=2;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:10: ( ( DIGIT )+ '.' DIGIT )=> ( DIGIT )+ '.' ( ( DIGIT )+ | EXPONENT )
                    {
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:31: ( DIGIT )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:31: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);

                    match('.'); if (state.failed) return ;
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:42: ( ( DIGIT )+ | EXPONENT )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0=='E'||LA7_0=='e') ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:43: ( DIGIT )+
                            {
                            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:43: ( DIGIT )+
                            int cnt6=0;
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:43: DIGIT
                            	    {
                            	    mDIGIT(); if (state.failed) return ;

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt6 >= 1 ) break loop6;
                            	    if (state.backtracking>0) {state.failed=true; return ;}
                                        EarlyExitException eee =
                                            new EarlyExitException(6, input);
                                        throw eee;
                                }
                                cnt6++;
                            } while (true);


                            }
                            break;
                        case 2 :
                            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:52: EXPONENT
                            {
                            mEXPONENT(); if (state.failed) return ;

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       _type = FLOAT; 
                    }

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1212:4: ( DIGIT )+
                    {
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1212:4: ( DIGIT )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1212:4: DIGIT
                    	    {
                    	    mDIGIT(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);

                    if ( state.backtracking==0 ) {
                       _type = INT; 
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1215:5: ({...}? => 'just to disable warning about no lexer rule corresponding to INT' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1215:7: {...}? => 'just to disable warning about no lexer rule corresponding to INT'
            {
            if ( !((false)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "INT", "false");
            }
            match("just to disable warning about no lexer rule corresponding to INT"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1216:7: ({...}? => 'just to disable warning about no lexer rule corresponding to FLOAT' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1216:9: {...}? => 'just to disable warning about no lexer rule corresponding to FLOAT'
            {
            if ( !((false)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "FLOAT", "false");
            }
            match("just to disable warning about no lexer rule corresponding to FLOAT"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1227:9: ( ( 'e' | 'E' ) ( '-' | '+' )? ( DIGIT )+ )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1227:11: ( 'e' | 'E' ) ( '-' | '+' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1227:21: ( '-' | '+' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='+'||LA10_0=='-') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1227:32: ( DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1227:32: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1231:7: ( '0' .. '9' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1231:9: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "KW_SQL"
    public final void mKW_SQL() throws RecognitionException {
        try {
            int _type = KW_SQL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1234:8: ( ( 'S' | 's' ) ( 'Q' | 'q' ) ( 'L' | 'l' ) )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1234:10: ( 'S' | 's' ) ( 'Q' | 'q' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_SQL"

    // $ANTLR start "KW_VAR"
    public final void mKW_VAR() throws RecognitionException {
        try {
            int _type = KW_VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1237:8: ( 'var' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1237:10: 'var'
            {
            match("var"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_VAR"

    // $ANTLR start "KW_IF"
    public final void mKW_IF() throws RecognitionException {
        try {
            int _type = KW_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1240:7: ( 'if' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1240:9: 'if'
            {
            match("if"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_IF"

    // $ANTLR start "KW_ELSE"
    public final void mKW_ELSE() throws RecognitionException {
        try {
            int _type = KW_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1243:9: ( 'else' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1243:11: 'else'
            {
            match("else"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_ELSE"

    // $ANTLR start "KW_TRY"
    public final void mKW_TRY() throws RecognitionException {
        try {
            int _type = KW_TRY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1246:8: ( 'try' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1246:10: 'try'
            {
            match("try"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_TRY"

    // $ANTLR start "KW_CATCH"
    public final void mKW_CATCH() throws RecognitionException {
        try {
            int _type = KW_CATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1249:9: ( 'catch' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1249:11: 'catch'
            {
            match("catch"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_CATCH"

    // $ANTLR start "KW_FINALLY"
    public final void mKW_FINALLY() throws RecognitionException {
        try {
            int _type = KW_FINALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1253:2: ( 'finally' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1253:4: 'finally'
            {
            match("finally"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_FINALLY"

    // $ANTLR start "KW_THROW"
    public final void mKW_THROW() throws RecognitionException {
        try {
            int _type = KW_THROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1256:9: ( 'throw' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1256:11: 'throw'
            {
            match("throw"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_THROW"

    // $ANTLR start "KW_FOR"
    public final void mKW_FOR() throws RecognitionException {
        try {
            int _type = KW_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1259:8: ( 'for' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1259:10: 'for'
            {
            match("for"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_FOR"

    // $ANTLR start "KW_WHILE"
    public final void mKW_WHILE() throws RecognitionException {
        try {
            int _type = KW_WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1262:9: ( 'while' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1262:11: 'while'
            {
            match("while"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_WHILE"

    // $ANTLR start "KW_BREAK"
    public final void mKW_BREAK() throws RecognitionException {
        try {
            int _type = KW_BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1265:9: ( 'break' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1265:11: 'break'
            {
            match("break"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_BREAK"

    // $ANTLR start "KW_CONTINUE"
    public final void mKW_CONTINUE() throws RecognitionException {
        try {
            int _type = KW_CONTINUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1269:2: ( 'continue' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1269:4: 'continue'
            {
            match("continue"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_CONTINUE"

    // $ANTLR start "KW_RETURN"
    public final void mKW_RETURN() throws RecognitionException {
        try {
            int _type = KW_RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1273:2: ( 'return' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1273:4: 'return'
            {
            match("return"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_RETURN"

    // $ANTLR start "KW_EXIT"
    public final void mKW_EXIT() throws RecognitionException {
        try {
            int _type = KW_EXIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1276:9: ( 'exit' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1276:11: 'exit'
            {
            match("exit"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_EXIT"

    // $ANTLR start "KW_TRUE"
    public final void mKW_TRUE() throws RecognitionException {
        try {
            int _type = KW_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1279:9: ( 'true' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1279:11: 'true'
            {
            match("true"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_TRUE"

    // $ANTLR start "KW_FALSE"
    public final void mKW_FALSE() throws RecognitionException {
        try {
            int _type = KW_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1282:9: ( 'false' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1282:11: 'false'
            {
            match("false"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_FALSE"

    // $ANTLR start "KW_FUN"
    public final void mKW_FUN() throws RecognitionException {
        try {
            int _type = KW_FUN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1285:8: ( 'fun' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1285:10: 'fun'
            {
            match("fun"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_FUN"

    // $ANTLR start "KW_THIS"
    public final void mKW_THIS() throws RecognitionException {
        try {
            int _type = KW_THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1288:9: ( 'this' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1288:11: 'this'
            {
            match("this"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_THIS"

    // $ANTLR start "KW_SUPER"
    public final void mKW_SUPER() throws RecognitionException {
        try {
            int _type = KW_SUPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1291:9: ( 'super' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1291:11: 'super'
            {
            match("super"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_SUPER"

    // $ANTLR start "KW_NEW"
    public final void mKW_NEW() throws RecognitionException {
        try {
            int _type = KW_NEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1294:8: ( 'new' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1294:10: 'new'
            {
            match("new"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_NEW"

    // $ANTLR start "KW_IMPORT"
    public final void mKW_IMPORT() throws RecognitionException {
        try {
            int _type = KW_IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1298:2: ( 'import' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1298:4: 'import'
            {
            match("import"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_IMPORT"

    // $ANTLR start "KW_INCLUDE"
    public final void mKW_INCLUDE() throws RecognitionException {
        try {
            int _type = KW_INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1302:2: ( 'include' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1302:4: 'include'
            {
            match("include"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_INCLUDE"

    // $ANTLR start "KW_AS"
    public final void mKW_AS() throws RecognitionException {
        try {
            int _type = KW_AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1305:7: ( 'as' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1305:9: 'as'
            {
            match("as"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "KW_AS"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1308:6: ( ( WORD_CHAR )+ )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1308:8: ( WORD_CHAR )+
            {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1308:8: ( WORD_CHAR )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='A' && LA12_0<='Z')||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1308:8: WORD_CHAR
            	    {
            	    mWORD_CHAR(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "WORD_CHAR"
    public final void mWORD_CHAR() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1313:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1313:4: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "WORD_CHAR"

    // $ANTLR start "EMB_VAR_START"
    public final void mEMB_VAR_START() throws RecognitionException {
        try {
            int _type = EMB_VAR_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1317:2: ({...}? => '@{' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1317:4: {...}? => '@{'
            {
            if ( !((allowEmbeddedVariables)) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "EMB_VAR_START", "allowEmbeddedVariables");
            }
            match("@{"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EMB_VAR_START"

    // $ANTLR start "BACKSLASH"
    public final void mBACKSLASH() throws RecognitionException {
        try {
            int _type = BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1321:2: ( '\\\\' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1321:4: '\\\\'
            {
            match('\\'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BACKSLASH"

    // $ANTLR start "DOUBLE_ARROW"
    public final void mDOUBLE_ARROW() throws RecognitionException {
        try {
            int _type = DOUBLE_ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1331:2: ( '=>' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1331:4: '=>'
            {
            match("=>"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLE_ARROW"

    // $ANTLR start "OP_DEFINE"
    public final void mOP_DEFINE() throws RecognitionException {
        try {
            int _type = OP_DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1335:2: ( ':=' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1335:4: ':='
            {
            match(":="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_DEFINE"

    // $ANTLR start "OP_AND"
    public final void mOP_AND() throws RecognitionException {
        try {
            int _type = OP_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1338:8: ( '&&' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1338:10: '&&'
            {
            match("&&"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_AND"

    // $ANTLR start "OP_OR"
    public final void mOP_OR() throws RecognitionException {
        try {
            int _type = OP_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1341:7: ( '||' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1341:9: '||'
            {
            match("||"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_OR"

    // $ANTLR start "OP_EQ"
    public final void mOP_EQ() throws RecognitionException {
        try {
            int _type = OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1344:7: ( '==' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1344:9: '=='
            {
            match("=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_EQ"

    // $ANTLR start "OP_NE"
    public final void mOP_NE() throws RecognitionException {
        try {
            int _type = OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1347:7: ( '!=' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1347:9: '!='
            {
            match("!="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_NE"

    // $ANTLR start "OP_ID"
    public final void mOP_ID() throws RecognitionException {
        try {
            int _type = OP_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1350:7: ( '===' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1350:9: '==='
            {
            match("==="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_ID"

    // $ANTLR start "OP_NI"
    public final void mOP_NI() throws RecognitionException {
        try {
            int _type = OP_NI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1353:7: ( '!==' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1353:9: '!=='
            {
            match("!=="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_NI"

    // $ANTLR start "OP_GT"
    public final void mOP_GT() throws RecognitionException {
        try {
            int _type = OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1356:7: ( '>' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1356:9: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_GT"

    // $ANTLR start "OP_GE"
    public final void mOP_GE() throws RecognitionException {
        try {
            int _type = OP_GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1359:7: ( '>=' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1359:9: '>='
            {
            match(">="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_GE"

    // $ANTLR start "OP_LT"
    public final void mOP_LT() throws RecognitionException {
        try {
            int _type = OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1362:7: ( '<' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1362:9: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_LT"

    // $ANTLR start "OP_LE"
    public final void mOP_LE() throws RecognitionException {
        try {
            int _type = OP_LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1365:7: ( '<=' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1365:9: '<='
            {
            match("<="); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_LE"

    // $ANTLR start "OP_MUL"
    public final void mOP_MUL() throws RecognitionException {
        try {
            int _type = OP_MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1368:8: ( '*' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1368:10: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_MUL"

    // $ANTLR start "OP_DIV"
    public final void mOP_DIV() throws RecognitionException {
        try {
            int _type = OP_DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1371:8: ( '/' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1371:10: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_DIV"

    // $ANTLR start "OP_MOD"
    public final void mOP_MOD() throws RecognitionException {
        try {
            int _type = OP_MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1374:8: ( '%' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1374:10: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_MOD"

    // $ANTLR start "OP_ADD"
    public final void mOP_ADD() throws RecognitionException {
        try {
            int _type = OP_ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1377:8: ( '+' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1377:10: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_ADD"

    // $ANTLR start "OP_SUB"
    public final void mOP_SUB() throws RecognitionException {
        try {
            int _type = OP_SUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1380:8: ( '-' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1380:10: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OP_SUB"

    // $ANTLR start "SIMPLE_IDENTIFIER"
    public final void mSIMPLE_IDENTIFIER() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1391:2: ( ( WORD_CHAR | '_' ) ( WORD_CHAR | '_' | DIGIT )* )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1391:4: ( WORD_CHAR | '_' ) ( WORD_CHAR | '_' | DIGIT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1391:22: ( WORD_CHAR | '_' | DIGIT )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "SIMPLE_IDENTIFIER"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:2: ( ( WORD_CHAR | IDENTIFIER_SPECIAL ) ( WORD_CHAR | IDENTIFIER_SPECIAL | '!' | '?' | DIGIT )* )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:4: ( WORD_CHAR | IDENTIFIER_SPECIAL ) ( WORD_CHAR | IDENTIFIER_SPECIAL | '!' | '?' | DIGIT )*
            {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:4: ( WORD_CHAR | IDENTIFIER_SPECIAL )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>='A' && LA14_0<='Z')||(LA14_0>='a' && LA14_0<='z')) ) {
                alt14=1;
            }
            else if ( (LA14_0=='+'||LA14_0=='-'||LA14_0=='~') ) {
                alt14=2;
            }
            else if ( (LA14_0=='@') && ((allowAtSignInIdentifier))) {
                alt14=2;
            }
            else if ( ((LA14_0>='$' && LA14_0<='&')||LA14_0=='*'||LA14_0=='/'||(LA14_0>='^' && LA14_0<='_')||LA14_0=='|') ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:5: WORD_CHAR
                    {
                    mWORD_CHAR(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:17: IDENTIFIER_SPECIAL
                    {
                    mIDENTIFIER_SPECIAL(); if (state.failed) return ;

                    }
                    break;

            }

            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:37: ( WORD_CHAR | IDENTIFIER_SPECIAL | '!' | '?' | DIGIT )*
            loop15:
            do {
                int alt15=6;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='A' && LA15_0<='Z')||(LA15_0>='a' && LA15_0<='z')) ) {
                    alt15=1;
                }
                else if ( (LA15_0=='+'||LA15_0=='-'||LA15_0=='~') ) {
                    alt15=2;
                }
                else if ( (LA15_0=='@') && ((allowAtSignInIdentifier))) {
                    alt15=2;
                }
                else if ( ((LA15_0>='$' && LA15_0<='&')||LA15_0=='*'||LA15_0=='/'||(LA15_0>='^' && LA15_0<='_')||LA15_0=='|') ) {
                    alt15=2;
                }
                else if ( (LA15_0=='!') ) {
                    alt15=3;
                }
                else if ( (LA15_0=='?') ) {
                    alt15=4;
                }
                else if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=5;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:38: WORD_CHAR
            	    {
            	    mWORD_CHAR(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:50: IDENTIFIER_SPECIAL
            	    {
            	    mIDENTIFIER_SPECIAL(); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:71: '!'
            	    {
            	    match('!'); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:77: '?'
            	    {
            	    match('?'); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1395:83: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "IDENTIFIER_SPECIAL"
    public final void mIDENTIFIER_SPECIAL() throws RecognitionException {
        try {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1400:2: ( '+' | '-' | '~' | {...}? => '@' | '%' | '^' | '&' | '*' | '/' | '_' | '|' | DOLLAR )
            int alt16=12;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1400:4: '+'
                    {
                    match('+'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1400:8: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1400:12: '~'
                    {
                    match('~'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1405:3: {...}? => '@'
                    {
                    if ( !((allowAtSignInIdentifier)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "IDENTIFIER_SPECIAL", "allowAtSignInIdentifier");
                    }
                    match('@'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:4: '%'
                    {
                    match('%'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:8: '^'
                    {
                    match('^'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:12: '&'
                    {
                    match('&'); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:16: '*'
                    {
                    match('*'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:20: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:24: '_'
                    {
                    match('_'); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:28: '|'
                    {
                    match('|'); if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1406:32: DOLLAR
                    {
                    mDOLLAR(); if (state.failed) return ;

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER_SPECIAL"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1410:8: ( '=' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1410:10: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1413:8: ( '(' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1413:10: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1416:8: ( ')' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1416:10: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1419:8: ( '{' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1419:10: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1422:8: ( '}' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1422:10: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "LSQUARE"
    public final void mLSQUARE() throws RecognitionException {
        try {
            int _type = LSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1425:9: ( '[' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1425:11: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LSQUARE"

    // $ANTLR start "RSQUARE"
    public final void mRSQUARE() throws RecognitionException {
        try {
            int _type = RSQUARE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1428:9: ( ']' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1428:11: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RSQUARE"

    // $ANTLR start "EXCLAM"
    public final void mEXCLAM() throws RecognitionException {
        try {
            int _type = EXCLAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1431:8: ( '!' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1431:10: '!'
            {
            match('!'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLAM"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1434:9: ( '?' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1434:11: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1437:7: ( ':' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1437:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1440:5: ( '.' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1440:7: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1443:7: ( ',' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1443:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SQL_SPECIAL_CHAR"
    public final void mSQL_SPECIAL_CHAR() throws RecognitionException {
        try {
            int _type = SQL_SPECIAL_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:2: ( '*' | '/' | '-' | '=' | '%' | '#' | '&' | '|' | DIGIT | {...}? => '@' )
            int alt17=10;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:4: '*'
                    {
                    match('*'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:8: '/'
                    {
                    match('/'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:12: '-'
                    {
                    match('-'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:16: '='
                    {
                    match('='); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:20: '%'
                    {
                    match('%'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:24: '#'
                    {
                    match('#'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:28: '&'
                    {
                    match('&'); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:32: '|'
                    {
                    match('|'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1447:36: DIGIT
                    {
                    mDIGIT(); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1448:4: {...}? => '@'
                    {
                    if ( !((!allowAtSignInIdentifier)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "SQL_SPECIAL_CHAR", "!allowAtSignInIdentifier");
                    }
                    match('@'); if (state.failed) return ;

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQL_SPECIAL_CHAR"

    // $ANTLR start "SEP"
    public final void mSEP() throws RecognitionException {
        try {
            int _type = SEP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1451:5: ( ';' | {...}? => '\\n' '/' ( '\\r' )? '\\n' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==';') ) {
                alt19=1;
            }
            else if ( (LA19_0=='\n') && ((allowSpecialSQLSep))) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1451:7: ';'
                    {
                    match(';'); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			if (escapeSeparators) {
                      				_type = WS;
                      			}
                      		
                    }

                    }
                    break;
                case 2 :
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1456:4: {...}? => '\\n' '/' ( '\\r' )? '\\n'
                    {
                    if ( !((allowSpecialSQLSep)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "SEP", "allowSpecialSQLSep");
                    }
                    match('\n'); if (state.failed) return ;
                    match('/'); if (state.failed) return ;
                    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1456:37: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1456:37: '\\r'
                            {
                            match('\r'); if (state.failed) return ;

                            }
                            break;

                    }

                    match('\n'); if (state.failed) return ;
                    if ( state.backtracking==0 ) {

                      			// Disable the flag again. We do this to restore the standard
                      			// separator after having parsed a complete sql literal to
                      			// get the desired behaviour of having script statements always
                      			// be terminated by semicolon and only sql literals by possibly
                      			// some other sequence.
                      			// This is safe for now since there is only one possible separator
                      			// active at one time so that this rule will always be triggered
                      			// after an sql literal if the special separator is activated.
                      			allowSpecialSQLSep = false;
                      		
                    }

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEP"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1469:4: ( ( ' ' | '\\r' | '\\t' | '\\u000C' )+ )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1469:6: ( ' ' | '\\r' | '\\t' | '\\u000C' )+
            {
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1469:6: ( ' ' | '\\r' | '\\t' | '\\u000C' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\t'||(LA20_0>='\f' && LA20_0<='\r')||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:
            	    {
            	    if ( input.LA(1)=='\t'||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);

            if ( state.backtracking==0 ) {
               _channel = whitespaceChannel; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1472:4: ( '\\n' )
            // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1472:6: '\\n'
            {
            match('\n'); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               _channel = whitespaceChannel; 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    public void mTokens() throws RecognitionException {
        // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:8: ( COMMENT | LINE_COMMENT | STR_SQUOT | STR_DQUOT | STR_BTICK | STR_QQUOT | STR_DOLQUOT | NUMBER | INT | FLOAT | KW_SQL | KW_VAR | KW_IF | KW_ELSE | KW_TRY | KW_CATCH | KW_FINALLY | KW_THROW | KW_FOR | KW_WHILE | KW_BREAK | KW_CONTINUE | KW_RETURN | KW_EXIT | KW_TRUE | KW_FALSE | KW_FUN | KW_THIS | KW_SUPER | KW_NEW | KW_IMPORT | KW_INCLUDE | KW_AS | WORD | EMB_VAR_START | BACKSLASH | DOUBLE_ARROW | OP_DEFINE | OP_AND | OP_OR | OP_EQ | OP_NE | OP_ID | OP_NI | OP_GT | OP_GE | OP_LT | OP_LE | OP_MUL | OP_DIV | OP_MOD | OP_ADD | OP_SUB | IDENTIFIER | EQUALS | LPAREN | RPAREN | LCURLY | RCURLY | LSQUARE | RSQUARE | EXCLAM | QUESTION | COLON | DOT | COMMA | SQL_SPECIAL_CHAR | SEP | WS | NL )
        int alt21=70;
        alt21 = dfa21.predict(input);
        switch (alt21) {
            case 1 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:10: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:18: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:31: STR_SQUOT
                {
                mSTR_SQUOT(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:41: STR_DQUOT
                {
                mSTR_DQUOT(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:51: STR_BTICK
                {
                mSTR_BTICK(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:61: STR_QQUOT
                {
                mSTR_QQUOT(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:71: STR_DOLQUOT
                {
                mSTR_DOLQUOT(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:83: NUMBER
                {
                mNUMBER(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:90: INT
                {
                mINT(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:94: FLOAT
                {
                mFLOAT(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:100: KW_SQL
                {
                mKW_SQL(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:107: KW_VAR
                {
                mKW_VAR(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:114: KW_IF
                {
                mKW_IF(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:120: KW_ELSE
                {
                mKW_ELSE(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:128: KW_TRY
                {
                mKW_TRY(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:135: KW_CATCH
                {
                mKW_CATCH(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:144: KW_FINALLY
                {
                mKW_FINALLY(); if (state.failed) return ;

                }
                break;
            case 18 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:155: KW_THROW
                {
                mKW_THROW(); if (state.failed) return ;

                }
                break;
            case 19 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:164: KW_FOR
                {
                mKW_FOR(); if (state.failed) return ;

                }
                break;
            case 20 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:171: KW_WHILE
                {
                mKW_WHILE(); if (state.failed) return ;

                }
                break;
            case 21 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:180: KW_BREAK
                {
                mKW_BREAK(); if (state.failed) return ;

                }
                break;
            case 22 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:189: KW_CONTINUE
                {
                mKW_CONTINUE(); if (state.failed) return ;

                }
                break;
            case 23 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:201: KW_RETURN
                {
                mKW_RETURN(); if (state.failed) return ;

                }
                break;
            case 24 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:211: KW_EXIT
                {
                mKW_EXIT(); if (state.failed) return ;

                }
                break;
            case 25 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:219: KW_TRUE
                {
                mKW_TRUE(); if (state.failed) return ;

                }
                break;
            case 26 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:227: KW_FALSE
                {
                mKW_FALSE(); if (state.failed) return ;

                }
                break;
            case 27 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:236: KW_FUN
                {
                mKW_FUN(); if (state.failed) return ;

                }
                break;
            case 28 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:243: KW_THIS
                {
                mKW_THIS(); if (state.failed) return ;

                }
                break;
            case 29 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:251: KW_SUPER
                {
                mKW_SUPER(); if (state.failed) return ;

                }
                break;
            case 30 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:260: KW_NEW
                {
                mKW_NEW(); if (state.failed) return ;

                }
                break;
            case 31 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:267: KW_IMPORT
                {
                mKW_IMPORT(); if (state.failed) return ;

                }
                break;
            case 32 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:277: KW_INCLUDE
                {
                mKW_INCLUDE(); if (state.failed) return ;

                }
                break;
            case 33 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:288: KW_AS
                {
                mKW_AS(); if (state.failed) return ;

                }
                break;
            case 34 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:294: WORD
                {
                mWORD(); if (state.failed) return ;

                }
                break;
            case 35 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:299: EMB_VAR_START
                {
                mEMB_VAR_START(); if (state.failed) return ;

                }
                break;
            case 36 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:313: BACKSLASH
                {
                mBACKSLASH(); if (state.failed) return ;

                }
                break;
            case 37 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:323: DOUBLE_ARROW
                {
                mDOUBLE_ARROW(); if (state.failed) return ;

                }
                break;
            case 38 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:336: OP_DEFINE
                {
                mOP_DEFINE(); if (state.failed) return ;

                }
                break;
            case 39 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:346: OP_AND
                {
                mOP_AND(); if (state.failed) return ;

                }
                break;
            case 40 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:353: OP_OR
                {
                mOP_OR(); if (state.failed) return ;

                }
                break;
            case 41 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:359: OP_EQ
                {
                mOP_EQ(); if (state.failed) return ;

                }
                break;
            case 42 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:365: OP_NE
                {
                mOP_NE(); if (state.failed) return ;

                }
                break;
            case 43 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:371: OP_ID
                {
                mOP_ID(); if (state.failed) return ;

                }
                break;
            case 44 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:377: OP_NI
                {
                mOP_NI(); if (state.failed) return ;

                }
                break;
            case 45 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:383: OP_GT
                {
                mOP_GT(); if (state.failed) return ;

                }
                break;
            case 46 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:389: OP_GE
                {
                mOP_GE(); if (state.failed) return ;

                }
                break;
            case 47 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:395: OP_LT
                {
                mOP_LT(); if (state.failed) return ;

                }
                break;
            case 48 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:401: OP_LE
                {
                mOP_LE(); if (state.failed) return ;

                }
                break;
            case 49 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:407: OP_MUL
                {
                mOP_MUL(); if (state.failed) return ;

                }
                break;
            case 50 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:414: OP_DIV
                {
                mOP_DIV(); if (state.failed) return ;

                }
                break;
            case 51 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:421: OP_MOD
                {
                mOP_MOD(); if (state.failed) return ;

                }
                break;
            case 52 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:428: OP_ADD
                {
                mOP_ADD(); if (state.failed) return ;

                }
                break;
            case 53 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:435: OP_SUB
                {
                mOP_SUB(); if (state.failed) return ;

                }
                break;
            case 54 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:442: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;
            case 55 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:453: EQUALS
                {
                mEQUALS(); if (state.failed) return ;

                }
                break;
            case 56 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:460: LPAREN
                {
                mLPAREN(); if (state.failed) return ;

                }
                break;
            case 57 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:467: RPAREN
                {
                mRPAREN(); if (state.failed) return ;

                }
                break;
            case 58 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:474: LCURLY
                {
                mLCURLY(); if (state.failed) return ;

                }
                break;
            case 59 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:481: RCURLY
                {
                mRCURLY(); if (state.failed) return ;

                }
                break;
            case 60 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:488: LSQUARE
                {
                mLSQUARE(); if (state.failed) return ;

                }
                break;
            case 61 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:496: RSQUARE
                {
                mRSQUARE(); if (state.failed) return ;

                }
                break;
            case 62 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:504: EXCLAM
                {
                mEXCLAM(); if (state.failed) return ;

                }
                break;
            case 63 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:511: QUESTION
                {
                mQUESTION(); if (state.failed) return ;

                }
                break;
            case 64 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:520: COLON
                {
                mCOLON(); if (state.failed) return ;

                }
                break;
            case 65 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:526: DOT
                {
                mDOT(); if (state.failed) return ;

                }
                break;
            case 66 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:530: COMMA
                {
                mCOMMA(); if (state.failed) return ;

                }
                break;
            case 67 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:536: SQL_SPECIAL_CHAR
                {
                mSQL_SPECIAL_CHAR(); if (state.failed) return ;

                }
                break;
            case 68 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:553: SEP
                {
                mSEP(); if (state.failed) return ;

                }
                break;
            case 69 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:557: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 70 :
                // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1:560: NL
                {
                mNL(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_SQLScript
    public final void synpred1_SQLScript_fragment() throws RecognitionException {   
        // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:10: ( ( DIGIT )+ '.' DIGIT )
        // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:11: ( DIGIT )+ '.' DIGIT
        {
        // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:11: ( DIGIT )+
        int cnt22=0;
        loop22:
        do {
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>='0' && LA22_0<='9')) ) {
                alt22=1;
            }


            switch (alt22) {
        	case 1 :
        	    // /home/tweiss/IdeaProjects/SQLScript/src/org/unbunt/sqlscript/SQLScript.g:1211:11: DIGIT
        	    {
        	    mDIGIT(); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt22 >= 1 ) break loop22;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(22, input);
                    throw eee;
            }
            cnt22++;
        } while (true);

        match('.'); if (state.failed) return ;
        mDIGIT(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_SQLScript

    public final boolean synpred1_SQLScript() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_SQLScript_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA21 dfa21 = new DFA21(this);
    static final String DFA9_eotS =
        "\1\uffff\1\2\2\uffff";
    static final String DFA9_eofS =
        "\4\uffff";
    static final String DFA9_minS =
        "\1\60\1\56\2\uffff";
    static final String DFA9_maxS =
        "\2\71\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA9_specialS =
        "\1\uffff\1\0\2\uffff}>";
    static final String[] DFA9_transitionS = {
            "\12\1",
            "\1\3\1\uffff\12\1",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1211:1: NUMBER : ( ( ( DIGIT )+ '.' DIGIT )=> ( DIGIT )+ '.' ( ( DIGIT )+ | EXPONENT ) | ( DIGIT )+ );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA9_1 = input.LA(1);

                         
                        int index9_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA9_1>='0' && LA9_1<='9')) ) {s = 1;}

                        else if ( (LA9_1=='.') && (synpred1_SQLScript())) {s = 3;}

                        else s = 2;

                         
                        input.seek(index9_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 9, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA16_eotS =
        "\15\uffff";
    static final String DFA16_eofS =
        "\15\uffff";
    static final String DFA16_minS =
        "\1\44\14\uffff";
    static final String DFA16_maxS =
        "\1\176\14\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String DFA16_specialS =
        "\1\0\14\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\14\1\5\1\7\3\uffff\1\10\1\1\1\uffff\1\2\1\uffff\1\11\20\uffff"+
            "\1\4\35\uffff\1\6\1\12\34\uffff\1\13\1\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "1398:1: fragment IDENTIFIER_SPECIAL : ( '+' | '-' | '~' | {...}? => '@' | '%' | '^' | '&' | '*' | '/' | '_' | '|' | DOLLAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0=='+') ) {s = 1;}

                        else if ( (LA16_0=='-') ) {s = 2;}

                        else if ( (LA16_0=='~') ) {s = 3;}

                        else if ( (LA16_0=='@') && ((allowAtSignInIdentifier))) {s = 4;}

                        else if ( (LA16_0=='%') ) {s = 5;}

                        else if ( (LA16_0=='^') ) {s = 6;}

                        else if ( (LA16_0=='&') ) {s = 7;}

                        else if ( (LA16_0=='*') ) {s = 8;}

                        else if ( (LA16_0=='/') ) {s = 9;}

                        else if ( (LA16_0=='_') ) {s = 10;}

                        else if ( (LA16_0=='|') ) {s = 11;}

                        else if ( (LA16_0=='$') ) {s = 12;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\13\uffff";
    static final String DFA17_eofS =
        "\13\uffff";
    static final String DFA17_minS =
        "\1\43\12\uffff";
    static final String DFA17_maxS =
        "\1\174\12\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String DFA17_specialS =
        "\1\0\12\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\6\1\uffff\1\5\1\7\3\uffff\1\1\2\uffff\1\3\1\uffff\1\2\12"+
            "\11\3\uffff\1\4\2\uffff\1\12\73\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1446:1: SQL_SPECIAL_CHAR : ( '*' | '/' | '-' | '=' | '%' | '#' | '&' | '|' | DIGIT | {...}? => '@' );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_0 = input.LA(1);

                         
                        int index17_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA17_0=='*') ) {s = 1;}

                        else if ( (LA17_0=='/') ) {s = 2;}

                        else if ( (LA17_0=='-') ) {s = 3;}

                        else if ( (LA17_0=='=') ) {s = 4;}

                        else if ( (LA17_0=='%') ) {s = 5;}

                        else if ( (LA17_0=='#') ) {s = 6;}

                        else if ( (LA17_0=='&') ) {s = 7;}

                        else if ( (LA17_0=='|') ) {s = 8;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 9;}

                        else if ( (LA17_0=='@') && ((!allowAtSignInIdentifier))) {s = 10;}

                         
                        input.seek(index17_0);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA21_eotS =
        "\1\uffff\1\64\1\66\3\uffff\2\70\1\45\1\uffff\17\70\1\127\1\uffff"+
        "\1\133\1\135\2\137\1\142\1\144\1\146\1\147\1\150\1\151\14\uffff"+
        "\1\153\1\uffff\1\154\1\uffff\1\155\1\uffff\1\70\1\uffff\2\70\1\uffff"+
        "\1\177\2\137\2\uffff\4\70\1\u0088\17\70\1\u009a\4\uffff\1\u009c"+
        "\3\uffff\1\u009d\1\uffff\1\u009e\1\u00a0\14\uffff\20\155\1\u00a1"+
        "\1\uffff\2\137\1\177\1\137\1\70\1\u00a3\1\70\1\u00a5\1\uffff\4\70"+
        "\1\u00aa\6\70\1\u00b1\1\70\1\u00b3\3\70\10\uffff\1\70\1\uffff\1"+
        "\70\1\uffff\2\70\1\u00bb\1\u00bc\1\uffff\1\u00bd\1\70\1\u00bf\3"+
        "\70\1\uffff\1\70\1\uffff\3\70\1\uffff\1\u00c8\2\70\3\uffff\1\u00cb"+
        "\1\uffff\1\u00cc\2\70\1\u00cf\1\u00d0\1\u00d1\1\70\2\uffff\1\u00d4"+
        "\1\70\2\uffff\2\70\3\uffff\1\u00d8\2\uffff\1\u00da\1\70\1\u00dc"+
        "\3\uffff\1\u00de\71\uffff";
    static final String DFA21_eofS =
        "\u0115\uffff";
    static final String DFA21_minS =
        "\1\11\2\41\3\uffff\2\41\1\44\1\uffff\20\41\1\uffff\2\75\1\46\1\174"+
        "\3\75\3\41\14\uffff\1\57\1\uffff\1\41\1\uffff\1\41\1\uffff\1\41"+
        "\1\uffff\2\41\1\uffff\1\41\2\44\2\uffff\25\41\1\uffff\1\0\2\uffff"+
        "\1\75\3\uffff\1\41\1\uffff\1\41\1\75\14\uffff\21\41\1\0\2\44\1\41"+
        "\1\44\4\41\1\uffff\21\41\10\uffff\1\40\1\uffff\1\41\1\uffff\4\41"+
        "\1\uffff\6\41\1\uffff\1\41\1\uffff\3\41\1\164\3\41\3\uffff\1\41"+
        "\1\uffff\7\41\1\157\1\uffff\2\41\2\uffff\2\41\3\uffff\1\41\1\40"+
        "\1\uffff\3\41\1\uffff\1\144\1\uffff\1\41\1\uffff\1\151\1\uffff\1"+
        "\163\1\141\1\142\1\154\1\145\1\40\1\167\1\141\1\162\1\156\1\151"+
        "\1\156\1\147\1\40\1\141\1\142\1\157\1\165\1\164\1\40\1\156\1\157"+
        "\1\40\1\154\1\145\1\170\1\145\1\162\1\40\1\162\1\165\1\154\1\145"+
        "\1\40\1\143\1\157\2\162\1\145\1\163\1\160\1\157\1\156\1\144\1\151"+
        "\1\156\1\147\1\40\1\164\1\157\1\40\1\106\2\uffff";
    static final String DFA21_maxS =
        "\3\176\3\uffff\2\176\1\ufffd\1\uffff\20\176\1\uffff\1\76\1\75\1"+
        "\46\1\174\3\75\3\176\14\uffff\1\57\1\uffff\1\176\1\uffff\1\176\1"+
        "\uffff\1\176\1\uffff\2\176\1\uffff\1\176\2\ufffd\2\uffff\25\176"+
        "\1\uffff\1\0\2\uffff\1\75\3\uffff\1\176\1\uffff\1\176\1\75\14\uffff"+
        "\21\176\1\0\2\ufffd\1\176\1\ufffd\4\176\1\uffff\21\176\10\uffff"+
        "\1\176\1\uffff\1\176\1\uffff\4\176\1\uffff\6\176\1\uffff\1\176\1"+
        "\uffff\3\176\1\164\3\176\3\uffff\1\176\1\uffff\7\176\1\157\1\uffff"+
        "\2\176\2\uffff\2\176\3\uffff\1\176\1\40\1\uffff\3\176\1\uffff\1"+
        "\144\1\uffff\1\176\1\uffff\1\151\1\uffff\1\163\1\141\1\142\1\154"+
        "\1\145\1\40\1\167\1\141\1\162\1\156\1\151\1\156\1\147\1\40\1\141"+
        "\1\142\1\157\1\165\1\164\1\40\1\156\1\157\1\40\1\154\1\145\1\170"+
        "\1\145\1\162\1\40\1\162\1\165\1\154\1\145\1\40\1\143\1\157\2\162"+
        "\1\145\1\163\1\160\1\157\1\156\1\144\1\151\1\156\1\147\1\40\1\164"+
        "\1\157\1\40\1\111\2\uffff";
    static final String DFA21_acceptS =
        "\3\uffff\1\3\1\4\1\5\3\uffff\1\10\20\uffff\1\44\12\uffff\1\66\1"+
        "\70\1\71\1\72\1\73\1\74\1\75\1\77\1\101\1\102\1\103\1\104\1\uffff"+
        "\1\105\1\uffff\1\62\1\uffff\1\65\1\uffff\1\42\2\uffff\1\6\3\uffff"+
        "\1\7\1\10\25\uffff\1\43\1\uffff\1\66\1\45\1\uffff\1\67\1\46\1\100"+
        "\1\uffff\1\66\2\uffff\1\76\1\56\1\55\1\60\1\57\1\61\1\63\1\64\1"+
        "\104\1\106\1\1\1\2\32\uffff\1\15\21\uffff\1\41\1\53\1\51\1\47\1"+
        "\50\1\54\1\52\1\36\1\uffff\1\13\1\uffff\1\14\4\uffff\1\17\6\uffff"+
        "\1\23\1\uffff\1\33\7\uffff\1\16\1\30\1\31\1\uffff\1\34\10\uffff"+
        "\1\35\2\uffff\1\22\1\20\2\uffff\1\32\1\24\1\25\2\uffff\1\37\3\uffff"+
        "\1\27\1\uffff\1\40\1\uffff\1\21\1\uffff\1\26\64\uffff\1\11\1\12";
    static final String DFA21_specialS =
        "\1\26\6\uffff\1\102\1\6\20\uffff\1\1\27\uffff\1\106\7\uffff\1\101"+
        "\3\uffff\1\0\1\36\30\uffff\1\105\47\uffff\1\103\1\61\1\73\1\uffff"+
        "\1\104\36\uffff\1\43\24\uffff\1\25\17\uffff\1\23\13\uffff\1\24\5"+
        "\uffff\1\35\3\uffff\1\37\1\uffff\1\33\1\34\1\31\1\32\1\27\1\30\1"+
        "\12\1\11\1\10\1\7\1\5\1\4\1\3\1\2\1\22\1\21\1\20\1\17\1\16\1\15"+
        "\1\14\1\13\1\64\1\65\1\66\1\67\1\57\1\60\1\62\1\63\1\75\1\76\1\77"+
        "\1\100\1\70\1\71\1\72\1\74\1\46\1\45\1\50\1\47\1\41\1\40\1\44\1"+
        "\42\1\54\1\53\1\56\1\55\1\52\1\51\2\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\62\1\61\1\uffff\2\62\22\uffff\1\62\1\37\1\4\1\57\1\10\1\43"+
            "\1\35\1\3\1\46\1\47\1\42\1\44\1\56\1\2\1\55\1\1\12\11\1\34\1"+
            "\60\1\41\1\33\1\40\1\54\1\31\15\30\1\26\2\30\1\7\1\30\1\25\7"+
            "\30\1\52\1\32\1\53\2\45\1\5\1\27\1\23\1\20\1\30\1\16\1\21\2"+
            "\30\1\15\1\12\3\30\1\6\2\30\1\7\1\24\1\13\1\17\1\30\1\14\1\22"+
            "\3\30\1\50\1\36\1\51\1\45",
            "\1\45\2\uffff\3\45\3\uffff\1\63\1\45\1\uffff\1\45\1\uffff\13"+
            "\45\5\uffff\34\45\3\uffff\2\45\1\uffff\32\45\1\uffff\1\45\1"+
            "\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\65\1\uffff\13\45"+
            "\5\uffff\34\45\3\uffff\2\45\1\uffff\32\45\1\uffff\1\45\1\uffff"+
            "\1\45",
            "",
            "",
            "",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\20\72\1\71\11\72\3\uffff\2\45\1\uffff\4\72\1\67"+
            "\13\72\1\71\11\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\1\73\2\uffff\2\45\1\uffff\1\45\1\uffff\13"+
            "\45\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\32\72\1\uffff\1"+
            "\45\1\uffff\1\45",
            "\1\74\34\uffff\32\75\4\uffff\1\76\1\uffff\32\75\5\uffff\uff7e"+
            "\77",
            "",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\24\72\1\101\5\72\1"+
            "\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\20\72\1\102\11\72\3\uffff\2\45\1\uffff\20\72\1"+
            "\102\3\72\1\103\5\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\1\104\31\72\1\uffff"+
            "\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\5\72\1\105\6\72\1\106"+
            "\1\107\14\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\13\72\1\110\13\72\1"+
            "\111\2\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\7\72\1\113\11\72\1"+
            "\112\10\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\1\114\15\72\1\115\13"+
            "\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\1\120\7\72\1\116\5"+
            "\72\1\117\5\72\1\121\5\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\7\72\1\122\22\72\1"+
            "\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\21\72\1\123\10\72\1"+
            "\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\4\72\1\124\25\72\1"+
            "\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\20\72\1\102\11\72\3\uffff\2\45\1\uffff\20\72\1"+
            "\102\11\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\20\72\1\71\11\72\3\uffff\2\45\1\uffff\20\72\1"+
            "\71\11\72\1\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\22\72\1\125\7\72\1"+
            "\uffff\1\45\1\uffff\1\45",
            "\1\45\2\uffff\3\45\3\uffff\2\45\1\uffff\1\45\1\uffff\13\45"+
            "\5\uffff\2\45\32\72\3\uffff\2\45\1\uffff\32\72\1\uffff\1\45"+
            "\1\uffff\1\45",
            "\1\130\2\uffff\3\130\3\uffff\2\130\1\uffff\1\130\1\uffff\13"+
            "\130\5\uffff\34\130\3\uffff\2\130\1\uffff\32\130\1\126\1\130"+
            "\1\uffff\1\130",
            "",
            "\1\132\1\131",
            "\1\134",
            "\1\136",
            "\1\140",
            "\1\141",
            "\1\143",
            "\1\145",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\152",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\26\72\1\176\3"+
            "\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\1\73\2\uffff\2\137\1\uffff\1\137\1\uffff"+
            "\13\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "\1\u0082\13\uffff\12\u0083\7\uffff\32\u0080\4\uffff\1\u0081"+
            "\1\uffff\32\u0080\5\uffff\uff7e\77",
            "\1\u0082\13\uffff\12\u0083\7\uffff\32\u0080\4\uffff\1\u0081"+
            "\1\uffff\32\u0080\5\uffff\uff7e\77",
            "",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\22\72\1\u0084"+
            "\7\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\13\72\1\u0085\16\72\3\uffff\2\137\1\uffff"+
            "\13\72\1\u0085\16\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\17\72\1\u0086"+
            "\12\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\21\72\1\u0087"+
            "\10\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\17\72\1\u0089"+
            "\12\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\2\72\1\u008a"+
            "\27\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\22\72\1\u008b"+
            "\7\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\10\72\1\u008c"+
            "\21\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\24\72\1\u008e"+
            "\3\72\1\u008d\1\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\10\72\1\u0090"+
            "\10\72\1\u008f\10\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u0091"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\15\72\1\u0092"+
            "\14\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\15\72\1\u0093"+
            "\14\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\21\72\1\u0094"+
            "\10\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\13\72\1\u0095"+
            "\16\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\15\72\1\u0096"+
            "\14\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\10\72\1\u0097"+
            "\21\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u0098"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u0099"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\uffff",
            "",
            "",
            "\1\u009b",
            "",
            "",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "\1\u009f",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\173\2\uffff\1\172\1\163\1\165\3\uffff\1\166\1\157\1\uffff"+
            "\1\160\1\uffff\1\167\12\175\5\uffff\1\174\1\162\32\156\3\uffff"+
            "\1\164\1\170\1\uffff\32\156\1\uffff\1\171\1\uffff\1\161",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\uffff",
            "\1\u0082\13\uffff\12\u0083\7\uffff\32\u0080\4\uffff\1\u0081"+
            "\1\uffff\32\u0080\5\uffff\uff7e\77",
            "\1\u0082\13\uffff\12\u0083\7\uffff\32\u0080\4\uffff\1\u0081"+
            "\1\uffff\32\u0080\5\uffff\uff7e\77",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\34\137\3\uffff\2\137\1\uffff\32\137\1\uffff\1\137"+
            "\1\uffff\1\137",
            "\1\u0082\13\uffff\12\u0083\7\uffff\32\u0080\4\uffff\1\u0081"+
            "\1\uffff\32\u0080\5\uffff\uff7e\77",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u00a2"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00a4"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\16\72\1\u00a6"+
            "\13\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\13\72\1\u00a7"+
            "\16\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00a8"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u00a9"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00ab"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\16\72\1\u00ac"+
            "\13\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\22\72\1\u00ad"+
            "\7\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\2\72\1\u00ae"+
            "\27\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u00af"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\1\u00b0\31\72"+
            "\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\22\72\1\u00b2"+
            "\7\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\13\72\1\u00b4"+
            "\16\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\1\u00b5\31\72"+
            "\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\24\72\1\u00b6"+
            "\5\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00b7\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1"+
            "\uffff\13\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72"+
            "\1\uffff\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\21\72\1\u00b8"+
            "\10\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\21\72\1\u00b9"+
            "\10\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\24\72\1\u00ba"+
            "\5\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\26\72\1\u00be"+
            "\3\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\7\72\1\u00c0"+
            "\22\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\10\72\1\u00c1"+
            "\21\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\13\72\1\u00c2"+
            "\16\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00c3"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00c4"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\12\72\1\u00c5"+
            "\17\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\21\72\1\u00c6"+
            "\10\72\1\uffff\1\137\1\uffff\1\137",
            "\1\u00c7",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\23\72\1\u00c9"+
            "\6\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\3\72\1\u00ca"+
            "\26\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\15\72\1\u00cd"+
            "\14\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\13\72\1\u00ce"+
            "\16\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\15\72\1\u00d2"+
            "\14\72\1\uffff\1\137\1\uffff\1\137",
            "\1\u00d3",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00d5"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\24\72\1\u00d6"+
            "\5\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\30\72\1\u00d7"+
            "\1\72\1\uffff\1\137\1\uffff\1\137",
            "",
            "",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\u00d9",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\4\72\1\u00db"+
            "\25\72\1\uffff\1\137\1\uffff\1\137",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\u00dd",
            "",
            "\1\137\2\uffff\3\137\3\uffff\2\137\1\uffff\1\137\1\uffff\13"+
            "\137\5\uffff\2\137\32\72\3\uffff\2\137\1\uffff\32\72\1\uffff"+
            "\1\137\1\uffff\1\137",
            "",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0114\2\uffff\1\u0113",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( COMMENT | LINE_COMMENT | STR_SQUOT | STR_DQUOT | STR_BTICK | STR_QQUOT | STR_DOLQUOT | NUMBER | INT | FLOAT | KW_SQL | KW_VAR | KW_IF | KW_ELSE | KW_TRY | KW_CATCH | KW_FINALLY | KW_THROW | KW_FOR | KW_WHILE | KW_BREAK | KW_CONTINUE | KW_RETURN | KW_EXIT | KW_TRUE | KW_FALSE | KW_FUN | KW_THIS | KW_SUPER | KW_NEW | KW_IMPORT | KW_INCLUDE | KW_AS | WORD | EMB_VAR_START | BACKSLASH | DOUBLE_ARROW | OP_DEFINE | OP_AND | OP_OR | OP_EQ | OP_NE | OP_ID | OP_NI | OP_GT | OP_GE | OP_LT | OP_LE | OP_MUL | OP_DIV | OP_MOD | OP_ADD | OP_SUB | IDENTIFIER | EQUALS | LPAREN | RPAREN | LCURLY | RCURLY | LSQUARE | RSQUARE | EXCLAM | QUESTION | COLON | DOT | COMMA | SQL_SPECIAL_CHAR | SEP | WS | NL );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA21_61 = input.LA(1);

                         
                        int index21_61 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_61>='A' && LA21_61<='Z')||(LA21_61>='a' && LA21_61<='z')) ) {s = 128;}

                        else if ( (LA21_61=='_') ) {s = 129;}

                        else if ( (LA21_61=='$') ) {s = 130;}

                        else if ( ((LA21_61>='0' && LA21_61<='9')) ) {s = 131;}

                        else if ( ((LA21_61>='\u0080' && LA21_61<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 95;

                         
                        input.seek(index21_61);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA21_25 = input.LA(1);

                         
                        int index21_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_25=='{') && ((allowEmbeddedVariables))) {s = 86;}

                        else if ( (LA21_25=='!'||(LA21_25>='$' && LA21_25<='&')||(LA21_25>='*' && LA21_25<='+')||LA21_25=='-'||(LA21_25>='/' && LA21_25<='9')||(LA21_25>='?' && LA21_25<='Z')||(LA21_25>='^' && LA21_25<='_')||(LA21_25>='a' && LA21_25<='z')||LA21_25=='|'||LA21_25=='~') && ((allowAtSignInIdentifier))) {s = 88;}

                        else s = 87;

                         
                        input.seek(index21_25);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA21_236 = input.LA(1);

                         
                        int index21_236 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_236==' ') && ((false))) {s = 237;}

                         
                        input.seek(index21_236);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA21_235 = input.LA(1);

                         
                        int index21_235 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_235=='g') && ((false))) {s = 236;}

                         
                        input.seek(index21_235);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA21_234 = input.LA(1);

                         
                        int index21_234 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_234=='n') && ((false))) {s = 235;}

                         
                        input.seek(index21_234);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA21_233 = input.LA(1);

                         
                        int index21_233 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_233=='i') && ((false))) {s = 234;}

                         
                        input.seek(index21_233);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA21_8 = input.LA(1);

                         
                        int index21_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_8=='$') ) {s = 60;}

                        else if ( ((LA21_8>='A' && LA21_8<='Z')||(LA21_8>='a' && LA21_8<='z')) ) {s = 61;}

                        else if ( (LA21_8=='_') ) {s = 62;}

                        else if ( ((LA21_8>='\u0080' && LA21_8<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 37;

                         
                        input.seek(index21_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA21_232 = input.LA(1);

                         
                        int index21_232 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_232=='n') && ((false))) {s = 233;}

                         
                        input.seek(index21_232);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA21_231 = input.LA(1);

                         
                        int index21_231 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_231=='r') && ((false))) {s = 232;}

                         
                        input.seek(index21_231);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA21_230 = input.LA(1);

                         
                        int index21_230 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_230=='a') && ((false))) {s = 231;}

                         
                        input.seek(index21_230);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA21_229 = input.LA(1);

                         
                        int index21_229 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_229=='w') && ((false))) {s = 230;}

                         
                        input.seek(index21_229);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA21_244 = input.LA(1);

                         
                        int index21_244 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_244=='o') && ((false))) {s = 245;}

                         
                        input.seek(index21_244);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA21_243 = input.LA(1);

                         
                        int index21_243 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_243=='n') && ((false))) {s = 244;}

                         
                        input.seek(index21_243);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA21_242 = input.LA(1);

                         
                        int index21_242 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_242==' ') && ((false))) {s = 243;}

                         
                        input.seek(index21_242);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA21_241 = input.LA(1);

                         
                        int index21_241 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_241=='t') && ((false))) {s = 242;}

                         
                        input.seek(index21_241);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA21_240 = input.LA(1);

                         
                        int index21_240 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_240=='u') && ((false))) {s = 241;}

                         
                        input.seek(index21_240);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA21_239 = input.LA(1);

                         
                        int index21_239 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_239=='o') && ((false))) {s = 240;}

                         
                        input.seek(index21_239);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA21_238 = input.LA(1);

                         
                        int index21_238 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_238=='b') && ((false))) {s = 239;}

                         
                        input.seek(index21_238);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA21_237 = input.LA(1);

                         
                        int index21_237 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_237=='a') && ((false))) {s = 238;}

                         
                        input.seek(index21_237);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA21_199 = input.LA(1);

                         
                        int index21_199 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_199=='o') && ((false))) {s = 211;}

                         
                        input.seek(index21_199);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA21_211 = input.LA(1);

                         
                        int index21_211 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_211==' ') && ((false))) {s = 217;}

                         
                        input.seek(index21_211);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA21_183 = input.LA(1);

                         
                        int index21_183 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_183=='t') && ((false))) {s = 199;}

                         
                        input.seek(index21_183);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA21_0 = input.LA(1);

                         
                        int index21_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_0=='/') ) {s = 1;}

                        else if ( (LA21_0=='-') ) {s = 2;}

                        else if ( (LA21_0=='\'') ) {s = 3;}

                        else if ( (LA21_0=='\"') ) {s = 4;}

                        else if ( (LA21_0=='`') ) {s = 5;}

                        else if ( (LA21_0=='n') ) {s = 6;}

                        else if ( (LA21_0=='Q'||LA21_0=='q') ) {s = 7;}

                        else if ( (LA21_0=='$') ) {s = 8;}

                        else if ( ((LA21_0>='0' && LA21_0<='9')) ) {s = 9;}

                        else if ( (LA21_0=='j') ) {s = 10;}

                        else if ( (LA21_0=='s') ) {s = 11;}

                        else if ( (LA21_0=='v') ) {s = 12;}

                        else if ( (LA21_0=='i') ) {s = 13;}

                        else if ( (LA21_0=='e') ) {s = 14;}

                        else if ( (LA21_0=='t') ) {s = 15;}

                        else if ( (LA21_0=='c') ) {s = 16;}

                        else if ( (LA21_0=='f') ) {s = 17;}

                        else if ( (LA21_0=='w') ) {s = 18;}

                        else if ( (LA21_0=='b') ) {s = 19;}

                        else if ( (LA21_0=='r') ) {s = 20;}

                        else if ( (LA21_0=='S') ) {s = 21;}

                        else if ( (LA21_0=='N') ) {s = 22;}

                        else if ( (LA21_0=='a') ) {s = 23;}

                        else if ( ((LA21_0>='A' && LA21_0<='M')||(LA21_0>='O' && LA21_0<='P')||LA21_0=='R'||(LA21_0>='T' && LA21_0<='Z')||LA21_0=='d'||(LA21_0>='g' && LA21_0<='h')||(LA21_0>='k' && LA21_0<='m')||(LA21_0>='o' && LA21_0<='p')||LA21_0=='u'||(LA21_0>='x' && LA21_0<='z')) ) {s = 24;}

                        else if ( (LA21_0=='@') && (((!allowAtSignInIdentifier)||(allowAtSignInIdentifier)||(allowEmbeddedVariables)))) {s = 25;}

                        else if ( (LA21_0=='\\') ) {s = 26;}

                        else if ( (LA21_0=='=') ) {s = 27;}

                        else if ( (LA21_0==':') ) {s = 28;}

                        else if ( (LA21_0=='&') ) {s = 29;}

                        else if ( (LA21_0=='|') ) {s = 30;}

                        else if ( (LA21_0=='!') ) {s = 31;}

                        else if ( (LA21_0=='>') ) {s = 32;}

                        else if ( (LA21_0=='<') ) {s = 33;}

                        else if ( (LA21_0=='*') ) {s = 34;}

                        else if ( (LA21_0=='%') ) {s = 35;}

                        else if ( (LA21_0=='+') ) {s = 36;}

                        else if ( ((LA21_0>='^' && LA21_0<='_')||LA21_0=='~') ) {s = 37;}

                        else if ( (LA21_0=='(') ) {s = 38;}

                        else if ( (LA21_0==')') ) {s = 39;}

                        else if ( (LA21_0=='{') ) {s = 40;}

                        else if ( (LA21_0=='}') ) {s = 41;}

                        else if ( (LA21_0=='[') ) {s = 42;}

                        else if ( (LA21_0==']') ) {s = 43;}

                        else if ( (LA21_0=='?') ) {s = 44;}

                        else if ( (LA21_0=='.') ) {s = 45;}

                        else if ( (LA21_0==',') ) {s = 46;}

                        else if ( (LA21_0=='#') ) {s = 47;}

                        else if ( (LA21_0==';') ) {s = 48;}

                        else if ( (LA21_0=='\n') ) {s = 49;}

                        else if ( (LA21_0=='\t'||(LA21_0>='\f' && LA21_0<='\r')||LA21_0==' ') ) {s = 50;}

                         
                        input.seek(index21_0);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA21_227 = input.LA(1);

                         
                        int index21_227 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_227=='e') && ((false))) {s = 228;}

                         
                        input.seek(index21_227);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA21_228 = input.LA(1);

                         
                        int index21_228 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_228==' ') && ((false))) {s = 229;}

                         
                        input.seek(index21_228);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA21_225 = input.LA(1);

                         
                        int index21_225 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_225=='b') && ((false))) {s = 226;}

                         
                        input.seek(index21_225);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA21_226 = input.LA(1);

                         
                        int index21_226 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_226=='l') && ((false))) {s = 227;}

                         
                        input.seek(index21_226);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA21_223 = input.LA(1);

                         
                        int index21_223 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_223=='s') && ((false))) {s = 224;}

                         
                        input.seek(index21_223);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA21_224 = input.LA(1);

                         
                        int index21_224 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_224=='a') && ((false))) {s = 225;}

                         
                        input.seek(index21_224);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA21_217 = input.LA(1);

                         
                        int index21_217 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_217=='d') && ((false))) {s = 221;}

                         
                        input.seek(index21_217);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA21_62 = input.LA(1);

                         
                        int index21_62 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_62>='A' && LA21_62<='Z')||(LA21_62>='a' && LA21_62<='z')) ) {s = 128;}

                        else if ( (LA21_62=='_') ) {s = 129;}

                        else if ( (LA21_62=='$') ) {s = 130;}

                        else if ( ((LA21_62>='0' && LA21_62<='9')) ) {s = 131;}

                        else if ( ((LA21_62>='\u0080' && LA21_62<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 95;

                         
                        input.seek(index21_62);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA21_221 = input.LA(1);

                         
                        int index21_221 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_221=='i') && ((false))) {s = 223;}

                         
                        input.seek(index21_221);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA21_266 = input.LA(1);

                         
                        int index21_266 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_266=='d') && ((false))) {s = 267;}

                         
                        input.seek(index21_266);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA21_265 = input.LA(1);

                         
                        int index21_265 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_265=='n') && ((false))) {s = 266;}

                         
                        input.seek(index21_265);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA21_268 = input.LA(1);

                         
                        int index21_268 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_268=='n') && ((false))) {s = 269;}

                         
                        input.seek(index21_268);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA21_162 = input.LA(1);

                         
                        int index21_162 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_162==' ') && ((false))) {s = 183;}

                        else if ( ((LA21_162>='A' && LA21_162<='Z')||(LA21_162>='a' && LA21_162<='z')) ) {s = 58;}

                        else if ( (LA21_162=='!'||(LA21_162>='$' && LA21_162<='&')||(LA21_162>='*' && LA21_162<='+')||LA21_162=='-'||(LA21_162>='/' && LA21_162<='9')||(LA21_162>='?' && LA21_162<='@')||(LA21_162>='^' && LA21_162<='_')||LA21_162=='|'||LA21_162=='~') ) {s = 95;}

                        else s = 56;

                         
                        input.seek(index21_162);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA21_267 = input.LA(1);

                         
                        int index21_267 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_267=='i') && ((false))) {s = 268;}

                         
                        input.seek(index21_267);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA21_262 = input.LA(1);

                         
                        int index21_262 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_262=='s') && ((false))) {s = 263;}

                         
                        input.seek(index21_262);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA21_261 = input.LA(1);

                         
                        int index21_261 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_261=='e') && ((false))) {s = 262;}

                         
                        input.seek(index21_261);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA21_264 = input.LA(1);

                         
                        int index21_264 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_264=='o') && ((false))) {s = 265;}

                         
                        input.seek(index21_264);
                        if ( s>=0 ) return s;
                        break;
                    case 40 : 
                        int LA21_263 = input.LA(1);

                         
                        int index21_263 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_263=='p') && ((false))) {s = 264;}

                         
                        input.seek(index21_263);
                        if ( s>=0 ) return s;
                        break;
                    case 41 : 
                        int LA21_274 = input.LA(1);

                         
                        int index21_274 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_274=='I') && ((false))) {s = 275;}

                        else if ( (LA21_274=='F') && ((false))) {s = 276;}

                         
                        input.seek(index21_274);
                        if ( s>=0 ) return s;
                        break;
                    case 42 : 
                        int LA21_273 = input.LA(1);

                         
                        int index21_273 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_273==' ') && ((false))) {s = 274;}

                         
                        input.seek(index21_273);
                        if ( s>=0 ) return s;
                        break;
                    case 43 : 
                        int LA21_270 = input.LA(1);

                         
                        int index21_270 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_270==' ') && ((false))) {s = 271;}

                         
                        input.seek(index21_270);
                        if ( s>=0 ) return s;
                        break;
                    case 44 : 
                        int LA21_269 = input.LA(1);

                         
                        int index21_269 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_269=='g') && ((false))) {s = 270;}

                         
                        input.seek(index21_269);
                        if ( s>=0 ) return s;
                        break;
                    case 45 : 
                        int LA21_272 = input.LA(1);

                         
                        int index21_272 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_272=='o') && ((false))) {s = 273;}

                         
                        input.seek(index21_272);
                        if ( s>=0 ) return s;
                        break;
                    case 46 : 
                        int LA21_271 = input.LA(1);

                         
                        int index21_271 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_271=='t') && ((false))) {s = 272;}

                         
                        input.seek(index21_271);
                        if ( s>=0 ) return s;
                        break;
                    case 47 : 
                        int LA21_249 = input.LA(1);

                         
                        int index21_249 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_249=='e') && ((false))) {s = 250;}

                         
                        input.seek(index21_249);
                        if ( s>=0 ) return s;
                        break;
                    case 48 : 
                        int LA21_250 = input.LA(1);

                         
                        int index21_250 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_250=='r') && ((false))) {s = 251;}

                         
                        input.seek(index21_250);
                        if ( s>=0 ) return s;
                        break;
                    case 49 : 
                        int LA21_128 = input.LA(1);

                         
                        int index21_128 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_128>='A' && LA21_128<='Z')||(LA21_128>='a' && LA21_128<='z')) ) {s = 128;}

                        else if ( (LA21_128=='_') ) {s = 129;}

                        else if ( (LA21_128=='$') ) {s = 130;}

                        else if ( ((LA21_128>='0' && LA21_128<='9')) ) {s = 131;}

                        else if ( ((LA21_128>='\u0080' && LA21_128<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 95;

                         
                        input.seek(index21_128);
                        if ( s>=0 ) return s;
                        break;
                    case 50 : 
                        int LA21_251 = input.LA(1);

                         
                        int index21_251 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_251==' ') && ((false))) {s = 252;}

                         
                        input.seek(index21_251);
                        if ( s>=0 ) return s;
                        break;
                    case 51 : 
                        int LA21_252 = input.LA(1);

                         
                        int index21_252 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_252=='r') && ((false))) {s = 253;}

                         
                        input.seek(index21_252);
                        if ( s>=0 ) return s;
                        break;
                    case 52 : 
                        int LA21_245 = input.LA(1);

                         
                        int index21_245 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_245==' ') && ((false))) {s = 246;}

                         
                        input.seek(index21_245);
                        if ( s>=0 ) return s;
                        break;
                    case 53 : 
                        int LA21_246 = input.LA(1);

                         
                        int index21_246 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_246=='l') && ((false))) {s = 247;}

                         
                        input.seek(index21_246);
                        if ( s>=0 ) return s;
                        break;
                    case 54 : 
                        int LA21_247 = input.LA(1);

                         
                        int index21_247 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_247=='e') && ((false))) {s = 248;}

                         
                        input.seek(index21_247);
                        if ( s>=0 ) return s;
                        break;
                    case 55 : 
                        int LA21_248 = input.LA(1);

                         
                        int index21_248 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_248=='x') && ((false))) {s = 249;}

                         
                        input.seek(index21_248);
                        if ( s>=0 ) return s;
                        break;
                    case 56 : 
                        int LA21_257 = input.LA(1);

                         
                        int index21_257 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_257=='c') && ((false))) {s = 258;}

                         
                        input.seek(index21_257);
                        if ( s>=0 ) return s;
                        break;
                    case 57 : 
                        int LA21_258 = input.LA(1);

                         
                        int index21_258 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_258=='o') && ((false))) {s = 259;}

                         
                        input.seek(index21_258);
                        if ( s>=0 ) return s;
                        break;
                    case 58 : 
                        int LA21_259 = input.LA(1);

                         
                        int index21_259 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_259=='r') && ((false))) {s = 260;}

                         
                        input.seek(index21_259);
                        if ( s>=0 ) return s;
                        break;
                    case 59 : 
                        int LA21_129 = input.LA(1);

                         
                        int index21_129 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_129>='A' && LA21_129<='Z')||(LA21_129>='a' && LA21_129<='z')) ) {s = 128;}

                        else if ( (LA21_129=='_') ) {s = 129;}

                        else if ( (LA21_129=='$') ) {s = 130;}

                        else if ( ((LA21_129>='0' && LA21_129<='9')) ) {s = 131;}

                        else if ( ((LA21_129>='\u0080' && LA21_129<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 95;

                         
                        input.seek(index21_129);
                        if ( s>=0 ) return s;
                        break;
                    case 60 : 
                        int LA21_260 = input.LA(1);

                         
                        int index21_260 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_260=='r') && ((false))) {s = 261;}

                         
                        input.seek(index21_260);
                        if ( s>=0 ) return s;
                        break;
                    case 61 : 
                        int LA21_253 = input.LA(1);

                         
                        int index21_253 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_253=='u') && ((false))) {s = 254;}

                         
                        input.seek(index21_253);
                        if ( s>=0 ) return s;
                        break;
                    case 62 : 
                        int LA21_254 = input.LA(1);

                         
                        int index21_254 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_254=='l') && ((false))) {s = 255;}

                         
                        input.seek(index21_254);
                        if ( s>=0 ) return s;
                        break;
                    case 63 : 
                        int LA21_255 = input.LA(1);

                         
                        int index21_255 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_255=='e') && ((false))) {s = 256;}

                         
                        input.seek(index21_255);
                        if ( s>=0 ) return s;
                        break;
                    case 64 : 
                        int LA21_256 = input.LA(1);

                         
                        int index21_256 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_256==' ') && ((false))) {s = 257;}

                         
                        input.seek(index21_256);
                        if ( s>=0 ) return s;
                        break;
                    case 65 : 
                        int LA21_57 = input.LA(1);

                         
                        int index21_57 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_57=='\'') && ((allowQQuote))) {s = 59;}

                        else if ( ((LA21_57>='A' && LA21_57<='Z')||(LA21_57>='a' && LA21_57<='z')) ) {s = 58;}

                        else if ( (LA21_57=='!'||(LA21_57>='$' && LA21_57<='&')||(LA21_57>='*' && LA21_57<='+')||LA21_57=='-'||(LA21_57>='/' && LA21_57<='9')||(LA21_57>='?' && LA21_57<='@')||(LA21_57>='^' && LA21_57<='_')||LA21_57=='|'||LA21_57=='~') ) {s = 95;}

                        else s = 56;

                         
                        input.seek(index21_57);
                        if ( s>=0 ) return s;
                        break;
                    case 66 : 
                        int LA21_7 = input.LA(1);

                         
                        int index21_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_7=='\'') && ((allowQQuote))) {s = 59;}

                        else if ( ((LA21_7>='A' && LA21_7<='Z')||(LA21_7>='a' && LA21_7<='z')) ) {s = 58;}

                        else if ( (LA21_7=='!'||(LA21_7>='$' && LA21_7<='&')||(LA21_7>='*' && LA21_7<='+')||LA21_7=='-'||(LA21_7>='/' && LA21_7<='9')||(LA21_7>='?' && LA21_7<='@')||(LA21_7>='^' && LA21_7<='_')||LA21_7=='|'||LA21_7=='~') ) {s = 37;}

                        else s = 56;

                         
                        input.seek(index21_7);
                        if ( s>=0 ) return s;
                        break;
                    case 67 : 
                        int LA21_127 = input.LA(1);

                         
                        int index21_127 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((allowDollarQuote)) ) {s = 63;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index21_127);
                        if ( s>=0 ) return s;
                        break;
                    case 68 : 
                        int LA21_131 = input.LA(1);

                         
                        int index21_131 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((LA21_131>='A' && LA21_131<='Z')||(LA21_131>='a' && LA21_131<='z')) ) {s = 128;}

                        else if ( (LA21_131=='_') ) {s = 129;}

                        else if ( (LA21_131=='$') ) {s = 130;}

                        else if ( ((LA21_131>='0' && LA21_131<='9')) ) {s = 131;}

                        else if ( ((LA21_131>='\u0080' && LA21_131<='\uFFFD')) && ((allowDollarQuote))) {s = 63;}

                        else s = 95;

                         
                        input.seek(index21_131);
                        if ( s>=0 ) return s;
                        break;
                    case 69 : 
                        int LA21_87 = input.LA(1);

                         
                        int index21_87 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((allowAtSignInIdentifier)) ) {s = 95;}

                        else if ( ((!allowAtSignInIdentifier)) ) {s = 47;}

                         
                        input.seek(index21_87);
                        if ( s>=0 ) return s;
                        break;
                    case 70 : 
                        int LA21_49 = input.LA(1);

                         
                        int index21_49 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA21_49=='/') && ((allowSpecialSQLSep))) {s = 106;}

                        else s = 107;

                         
                        input.seek(index21_49);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 21, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}