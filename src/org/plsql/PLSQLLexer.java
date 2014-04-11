// $ANTLR 3.5.1 C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g 2014-04-04 18:28:30

package org.plsql;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PLSQLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int A=4;
	public static final int AND=5;
	public static final int ARRAY=6;
	public static final int ARROW=7;
	public static final int AS=8;
	public static final int ASSIGN=9;
	public static final int ASTERISK=10;
	public static final int AT_SIGN=11;
	public static final int AUTHID=12;
	public static final int B=13;
	public static final int BEGIN=14;
	public static final int BETWEEN=15;
	public static final int BODY=16;
	public static final int BULK=17;
	public static final int BULK_ROWCOUNT=18;
	public static final int BY=19;
	public static final int C=20;
	public static final int CASE=21;
	public static final int CLOSE=22;
	public static final int COLLECT=23;
	public static final int COLON=24;
	public static final int COMMA=25;
	public static final int COMMIT=26;
	public static final int CONSTANT=27;
	public static final int CONTINUE=28;
	public static final int CREATE=29;
	public static final int CURRENT_USER=30;
	public static final int CURSOR=31;
	public static final int D=32;
	public static final int DECLARE=33;
	public static final int DEFAULT=34;
	public static final int DEFINER=35;
	public static final int DELETE=36;
	public static final int DELETING=37;
	public static final int DETERMINISTIC=38;
	public static final int DIVIDE=39;
	public static final int DOT=40;
	public static final int DOUBLEDOT=41;
	public static final int DOUBLEQUOTED_STRING=42;
	public static final int DOUBLEVERTBAR=43;
	public static final int E=44;
	public static final int ELSE=45;
	public static final int ELSIF=46;
	public static final int END=47;
	public static final int EQ=48;
	public static final int EXCEPTION=49;
	public static final int EXECUTE=50;
	public static final int EXISTS=51;
	public static final int EXIT=52;
	public static final int EXPONENT=53;
	public static final int EXTERNAL=54;
	public static final int F=55;
	public static final int FALSE=56;
	public static final int FETCH=57;
	public static final int FOR=58;
	public static final int FORALL=59;
	public static final int FUNCTION=60;
	public static final int G=61;
	public static final int GEQ=62;
	public static final int GOTO=63;
	public static final int GTH=64;
	public static final int H=65;
	public static final int I=66;
	public static final int ID=67;
	public static final int IF=68;
	public static final int IMMEDIATE=69;
	public static final int IN=70;
	public static final int INDEX=71;
	public static final int INSERT=72;
	public static final int INSERTING=73;
	public static final int INTEGER=74;
	public static final int INTO=75;
	public static final int IS=76;
	public static final int ISOPEN=77;
	public static final int J=78;
	public static final int K=79;
	public static final int L=80;
	public static final int LANGUAGE=81;
	public static final int LBRACK=82;
	public static final int LEQ=83;
	public static final int LIKE=84;
	public static final int LIMIT=85;
	public static final int LLABEL=86;
	public static final int LOCK=87;
	public static final int LOOP=88;
	public static final int LPAREN=89;
	public static final int LTH=90;
	public static final int M=91;
	public static final int MINUS=92;
	public static final int ML_COMMENT=93;
	public static final int N=94;
	public static final int NF=95;
	public static final int NOCOPY=96;
	public static final int NOT=97;
	public static final int NOTFOUND=98;
	public static final int NOT_EQ=99;
	public static final int NULL=100;
	public static final int NUMBER_VALUE=101;
	public static final int O=102;
	public static final int OPEN=103;
	public static final int OR=104;
	public static final int OTHERS=105;
	public static final int OUT=106;
	public static final int P=107;
	public static final int PACKAGE=108;
	public static final int PARALLEL_ENABLE=109;
	public static final int PERCENT=110;
	public static final int PIPELINED=111;
	public static final int PLUS=112;
	public static final int POINT=113;
	public static final int PRAGMA=114;
	public static final int PROCEDURE=115;
	public static final int Q=116;
	public static final int QUOTED_STRING=117;
	public static final int R=118;
	public static final int RAISE=119;
	public static final int RBRACK=120;
	public static final int REAL_NUMBER=121;
	public static final int RECORD=122;
	public static final int REF=123;
	public static final int RESULT_CACHE=124;
	public static final int RETURN=125;
	public static final int RETURNING=126;
	public static final int RLABEL=127;
	public static final int ROLLBACK=128;
	public static final int ROWTYPE=129;
	public static final int RPAREN=130;
	public static final int S=131;
	public static final int SAVEPOINT=132;
	public static final int SELECT=133;
	public static final int SEMI=134;
	public static final int SET=135;
	public static final int SL_COMMENT=136;
	public static final int SQL=137;
	public static final int SUBTYPE=138;
	public static final int T=139;
	public static final int TABLE=140;
	public static final int THEN=141;
	public static final int TRANSACTION=142;
	public static final int TRUE=143;
	public static final int U=144;
	public static final int UPDATE=145;
	public static final int UPDATING=146;
	public static final int US=147;
	public static final int USING=148;
	public static final int V=149;
	public static final int VARRAY=150;
	public static final int VARYING=151;
	public static final int VERTBAR=152;
	public static final int W=153;
	public static final int WHEN=154;
	public static final int WHILE=155;
	public static final int WS=156;
	public static final int X=157;
	public static final int Y=158;
	public static final int Z=159;

	public String getErrorHeader(RecognitionException e) {
	    return getSourceName()+":"+e.line+":"+(e.charPositionInLine+1)+":";
	}

	// needed for things like BETWEEN 1..2 where 1. would be treated as a literal
	private boolean numberDotValid() {
	    int i = 1;
	    while (input.LA(i) >= '0' && input.LA(i) <= '9') {
	        i++;
	    }
	    return input.LA(i) == '.' && input.LA(i+1) != '.';
	}


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PLSQLLexer() {} 
	public PLSQLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PLSQLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g"; }

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:647:5: ( A N D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:647:7: A N D
			{
			mA(); 

			mN(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "ARRAY"
	public final void mARRAY() throws RecognitionException {
		try {
			int _type = ARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:648:7: ( A R R A Y )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:648:9: A R R A Y
			{
			mA(); 

			mR(); 

			mR(); 

			mA(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARRAY"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:649:4: ( A S )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:649:6: A S
			{
			mA(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "AUTHID"
	public final void mAUTHID() throws RecognitionException {
		try {
			int _type = AUTHID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:650:8: ( A U T H I D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:650:10: A U T H I D
			{
			mA(); 

			mU(); 

			mT(); 

			mH(); 

			mI(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AUTHID"

	// $ANTLR start "BETWEEN"
	public final void mBETWEEN() throws RecognitionException {
		try {
			int _type = BETWEEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:651:9: ( B E T W E E N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:651:11: B E T W E E N
			{
			mB(); 

			mE(); 

			mT(); 

			mW(); 

			mE(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BETWEEN"

	// $ANTLR start "BODY"
	public final void mBODY() throws RecognitionException {
		try {
			int _type = BODY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:652:6: ( B O D Y )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:652:8: B O D Y
			{
			mB(); 

			mO(); 

			mD(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BODY"

	// $ANTLR start "BULK"
	public final void mBULK() throws RecognitionException {
		try {
			int _type = BULK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:653:6: ( B U L K )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:653:8: B U L K
			{
			mB(); 

			mU(); 

			mL(); 

			mK(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BULK"

	// $ANTLR start "BULK_ROWCOUNT"
	public final void mBULK_ROWCOUNT() throws RecognitionException {
		try {
			int _type = BULK_ROWCOUNT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:654:14: ( B U L K US R O W C O U N T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:654:16: B U L K US R O W C O U N T
			{
			mB(); 

			mU(); 

			mL(); 

			mK(); 

			mUS(); 

			mR(); 

			mO(); 

			mW(); 

			mC(); 

			mO(); 

			mU(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BULK_ROWCOUNT"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:655:4: ( B Y )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:655:6: B Y
			{
			mB(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:656:6: ( C A S E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:656:8: C A S E
			{
			mC(); 

			mA(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "CREATE"
	public final void mCREATE() throws RecognitionException {
		try {
			int _type = CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:657:8: ( C R E A T E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:657:10: C R E A T E
			{
			mC(); 

			mR(); 

			mE(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CREATE"

	// $ANTLR start "COLLECT"
	public final void mCOLLECT() throws RecognitionException {
		try {
			int _type = COLLECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:658:9: ( C O L L E C T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:658:11: C O L L E C T
			{
			mC(); 

			mO(); 

			mL(); 

			mL(); 

			mE(); 

			mC(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLLECT"

	// $ANTLR start "COMMIT"
	public final void mCOMMIT() throws RecognitionException {
		try {
			int _type = COMMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:659:8: ( C O M M I T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:659:10: C O M M I T
			{
			mC(); 

			mO(); 

			mM(); 

			mM(); 

			mI(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMIT"

	// $ANTLR start "CURRENT_USER"
	public final void mCURRENT_USER() throws RecognitionException {
		try {
			int _type = CURRENT_USER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:660:14: ( C U R R E N T US U S E R )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:660:16: C U R R E N T US U S E R
			{
			mC(); 

			mU(); 

			mR(); 

			mR(); 

			mE(); 

			mN(); 

			mT(); 

			mUS(); 

			mU(); 

			mS(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT_USER"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:661:9: ( D E F A U L T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:661:11: D E F A U L T
			{
			mD(); 

			mE(); 

			mF(); 

			mA(); 

			mU(); 

			mL(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "DEFINER"
	public final void mDEFINER() throws RecognitionException {
		try {
			int _type = DEFINER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:662:9: ( D E F I N E R )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:662:11: D E F I N E R
			{
			mD(); 

			mE(); 

			mF(); 

			mI(); 

			mN(); 

			mE(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFINER"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:663:8: ( D E L E T E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:663:10: D E L E T E
			{
			mD(); 

			mE(); 

			mL(); 

			mE(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETE"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:664:6: ( E L S E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:664:8: E L S E
			{
			mE(); 

			mL(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "ELSIF"
	public final void mELSIF() throws RecognitionException {
		try {
			int _type = ELSIF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:665:7: ( E L S I F )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:665:9: E L S I F
			{
			mE(); 

			mL(); 

			mS(); 

			mI(); 

			mF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSIF"

	// $ANTLR start "EXTERNAL"
	public final void mEXTERNAL() throws RecognitionException {
		try {
			int _type = EXTERNAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:666:10: ( E X T E R N A L )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:666:12: E X T E R N A L
			{
			mE(); 

			mX(); 

			mT(); 

			mE(); 

			mR(); 

			mN(); 

			mA(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXTERNAL"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:667:7: ( F A L S E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:667:9: F A L S E
			{
			mF(); 

			mA(); 

			mL(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "FETCH"
	public final void mFETCH() throws RecognitionException {
		try {
			int _type = FETCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:668:7: ( F E T C H )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:668:9: F E T C H
			{
			mF(); 

			mE(); 

			mT(); 

			mC(); 

			mH(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FETCH"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:669:5: ( F O R )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:669:7: F O R
			{
			mF(); 

			mO(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "FORALL"
	public final void mFORALL() throws RecognitionException {
		try {
			int _type = FORALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:670:8: ( F O R A L L )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:670:10: F O R A L L
			{
			mF(); 

			mO(); 

			mR(); 

			mA(); 

			mL(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FORALL"

	// $ANTLR start "GOTO"
	public final void mGOTO() throws RecognitionException {
		try {
			int _type = GOTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:671:6: ( G O T O )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:671:8: G O T O
			{
			mG(); 

			mO(); 

			mT(); 

			mO(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GOTO"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:672:4: ( I F )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:672:6: I F
			{
			mI(); 

			mF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:673:4: ( I N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:673:6: I N
			{
			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "INDEX"
	public final void mINDEX() throws RecognitionException {
		try {
			int _type = INDEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:674:7: ( I N D E X )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:674:9: I N D E X
			{
			mI(); 

			mN(); 

			mD(); 

			mE(); 

			mX(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INDEX"

	// $ANTLR start "INSERT"
	public final void mINSERT() throws RecognitionException {
		try {
			int _type = INSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:675:8: ( I N S E R T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:675:10: I N S E R T
			{
			mI(); 

			mN(); 

			mS(); 

			mE(); 

			mR(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INSERT"

	// $ANTLR start "INTO"
	public final void mINTO() throws RecognitionException {
		try {
			int _type = INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:676:6: ( I N T O )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:676:8: I N T O
			{
			mI(); 

			mN(); 

			mT(); 

			mO(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTO"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:677:4: ( I S )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:677:6: I S
			{
			mI(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "LANGUAGE"
	public final void mLANGUAGE() throws RecognitionException {
		try {
			int _type = LANGUAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:678:9: ( L A N G U A G E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:678:11: L A N G U A G E
			{
			mL(); 

			mA(); 

			mN(); 

			mG(); 

			mU(); 

			mA(); 

			mG(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LANGUAGE"

	// $ANTLR start "LIKE"
	public final void mLIKE() throws RecognitionException {
		try {
			int _type = LIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:679:6: ( L I K E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:679:8: L I K E
			{
			mL(); 

			mI(); 

			mK(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIKE"

	// $ANTLR start "LIMIT"
	public final void mLIMIT() throws RecognitionException {
		try {
			int _type = LIMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:680:7: ( L I M I T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:680:9: L I M I T
			{
			mL(); 

			mI(); 

			mM(); 

			mI(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIMIT"

	// $ANTLR start "LOCK"
	public final void mLOCK() throws RecognitionException {
		try {
			int _type = LOCK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:681:6: ( L O C K )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:681:8: L O C K
			{
			mL(); 

			mO(); 

			mC(); 

			mK(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOCK"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:682:5: ( N O T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:682:7: N O T
			{
			mN(); 

			mO(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "NOTFOUND"
	public final void mNOTFOUND() throws RecognitionException {
		try {
			int _type = NOTFOUND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:683:9: ( N O T F O U N D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:683:11: N O T F O U N D
			{
			mN(); 

			mO(); 

			mT(); 

			mF(); 

			mO(); 

			mU(); 

			mN(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOTFOUND"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:684:6: ( N U L L )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:684:8: N U L L
			{
			mN(); 

			mU(); 

			mL(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:685:6: ( O P E N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:685:8: O P E N
			{
			mO(); 

			mP(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:686:4: ( O R )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:686:6: O R
			{
			mO(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "PACKAGE"
	public final void mPACKAGE() throws RecognitionException {
		try {
			int _type = PACKAGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:687:8: ( P A C K A G E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:687:10: P A C K A G E
			{
			mP(); 

			mA(); 

			mC(); 

			mK(); 

			mA(); 

			mG(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PACKAGE"

	// $ANTLR start "RAISE"
	public final void mRAISE() throws RecognitionException {
		try {
			int _type = RAISE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:688:7: ( R A I S E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:688:9: R A I S E
			{
			mR(); 

			mA(); 

			mI(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RAISE"

	// $ANTLR start "ROLLBACK"
	public final void mROLLBACK() throws RecognitionException {
		try {
			int _type = ROLLBACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:689:9: ( R O L L B A C K )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:689:11: R O L L B A C K
			{
			mR(); 

			mO(); 

			mL(); 

			mL(); 

			mB(); 

			mA(); 

			mC(); 

			mK(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROLLBACK"

	// $ANTLR start "SAVEPOINT"
	public final void mSAVEPOINT() throws RecognitionException {
		try {
			int _type = SAVEPOINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:690:11: ( S A V E P O I N T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:690:13: S A V E P O I N T
			{
			mS(); 

			mA(); 

			mV(); 

			mE(); 

			mP(); 

			mO(); 

			mI(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SAVEPOINT"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:691:8: ( S E L E C T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:691:10: S E L E C T
			{
			mS(); 

			mE(); 

			mL(); 

			mE(); 

			mC(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:692:5: ( S E T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:692:7: S E T
			{
			mS(); 

			mE(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "SQL"
	public final void mSQL() throws RecognitionException {
		try {
			int _type = SQL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:693:5: ( S Q L )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:693:7: S Q L
			{
			mS(); 

			mQ(); 

			mL(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SQL"

	// $ANTLR start "TABLE"
	public final void mTABLE() throws RecognitionException {
		try {
			int _type = TABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:694:7: ( T A B L E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:694:9: T A B L E
			{
			mT(); 

			mA(); 

			mB(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLE"

	// $ANTLR start "TRANSACTION"
	public final void mTRANSACTION() throws RecognitionException {
		try {
			int _type = TRANSACTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:695:13: ( T R A N S A C T I O N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:695:15: T R A N S A C T I O N
			{
			mT(); 

			mR(); 

			mA(); 

			mN(); 

			mS(); 

			mA(); 

			mC(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRANSACTION"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:696:6: ( T R U E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:696:8: T R U E
			{
			mT(); 

			mR(); 

			mU(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:697:6: ( T H E N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:697:8: T H E N
			{
			mT(); 

			mH(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:698:8: ( U P D A T E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:698:10: U P D A T E
			{
			mU(); 

			mP(); 

			mD(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:699:7: ( W H I L E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:699:9: W H I L E
			{
			mW(); 

			mH(); 

			mI(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "INSERTING"
	public final void mINSERTING() throws RecognitionException {
		try {
			int _type = INSERTING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:700:11: ( I N S E R T I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:700:13: I N S E R T I N G
			{
			mI(); 

			mN(); 

			mS(); 

			mE(); 

			mR(); 

			mT(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INSERTING"

	// $ANTLR start "UPDATING"
	public final void mUPDATING() throws RecognitionException {
		try {
			int _type = UPDATING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:701:10: ( U P D A T I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:701:12: U P D A T I N G
			{
			mU(); 

			mP(); 

			mD(); 

			mA(); 

			mT(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATING"

	// $ANTLR start "DELETING"
	public final void mDELETING() throws RecognitionException {
		try {
			int _type = DELETING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:702:10: ( D E L E T I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:702:12: D E L E T I N G
			{
			mD(); 

			mE(); 

			mL(); 

			mE(); 

			mT(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETING"

	// $ANTLR start "ISOPEN"
	public final void mISOPEN() throws RecognitionException {
		try {
			int _type = ISOPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:703:8: ( I S O P E N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:703:10: I S O P E N
			{
			mI(); 

			mS(); 

			mO(); 

			mP(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ISOPEN"

	// $ANTLR start "EXISTS"
	public final void mEXISTS() throws RecognitionException {
		try {
			int _type = EXISTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:704:8: ( E X I S T S )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:704:10: E X I S T S
			{
			mE(); 

			mX(); 

			mI(); 

			mS(); 

			mT(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXISTS"

	// $ANTLR start "BEGIN"
	public final void mBEGIN() throws RecognitionException {
		try {
			int _type = BEGIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:706:7: ( B E G I N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:706:9: B E G I N
			{
			mB(); 

			mE(); 

			mG(); 

			mI(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BEGIN"

	// $ANTLR start "CLOSE"
	public final void mCLOSE() throws RecognitionException {
		try {
			int _type = CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:707:7: ( C L O S E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:707:9: C L O S E
			{
			mC(); 

			mL(); 

			mO(); 

			mS(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE"

	// $ANTLR start "CONSTANT"
	public final void mCONSTANT() throws RecognitionException {
		try {
			int _type = CONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:708:10: ( C O N S T A N T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:708:12: C O N S T A N T
			{
			mC(); 

			mO(); 

			mN(); 

			mS(); 

			mT(); 

			mA(); 

			mN(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTANT"

	// $ANTLR start "CONTINUE"
	public final void mCONTINUE() throws RecognitionException {
		try {
			int _type = CONTINUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:709:10: ( C O N T I N U E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:709:12: C O N T I N U E
			{
			mC(); 

			mO(); 

			mN(); 

			mT(); 

			mI(); 

			mN(); 

			mU(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONTINUE"

	// $ANTLR start "CURSOR"
	public final void mCURSOR() throws RecognitionException {
		try {
			int _type = CURSOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:710:8: ( C U R S O R )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:710:10: C U R S O R
			{
			mC(); 

			mU(); 

			mR(); 

			mS(); 

			mO(); 

			mR(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURSOR"

	// $ANTLR start "DECLARE"
	public final void mDECLARE() throws RecognitionException {
		try {
			int _type = DECLARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:711:9: ( D E C L A R E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:711:11: D E C L A R E
			{
			mD(); 

			mE(); 

			mC(); 

			mL(); 

			mA(); 

			mR(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECLARE"

	// $ANTLR start "DETERMINISTIC"
	public final void mDETERMINISTIC() throws RecognitionException {
		try {
			int _type = DETERMINISTIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:712:15: ( D E T E R M I N I S T I C )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:712:17: D E T E R M I N I S T I C
			{
			mD(); 

			mE(); 

			mT(); 

			mE(); 

			mR(); 

			mM(); 

			mI(); 

			mN(); 

			mI(); 

			mS(); 

			mT(); 

			mI(); 

			mC(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DETERMINISTIC"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:713:5: ( E N D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:713:7: E N D
			{
			mE(); 

			mN(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "EXCEPTION"
	public final void mEXCEPTION() throws RecognitionException {
		try {
			int _type = EXCEPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:714:11: ( E X C E P T I O N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:714:13: E X C E P T I O N
			{
			mE(); 

			mX(); 

			mC(); 

			mE(); 

			mP(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCEPTION"

	// $ANTLR start "EXECUTE"
	public final void mEXECUTE() throws RecognitionException {
		try {
			int _type = EXECUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:715:9: ( E X E C U T E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:715:11: E X E C U T E
			{
			mE(); 

			mX(); 

			mE(); 

			mC(); 

			mU(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXECUTE"

	// $ANTLR start "EXIT"
	public final void mEXIT() throws RecognitionException {
		try {
			int _type = EXIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:716:6: ( E X I T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:716:8: E X I T
			{
			mE(); 

			mX(); 

			mI(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXIT"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:717:10: ( F U N C T I O N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:717:12: F U N C T I O N
			{
			mF(); 

			mU(); 

			mN(); 

			mC(); 

			mT(); 

			mI(); 

			mO(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "IMMEDIATE"
	public final void mIMMEDIATE() throws RecognitionException {
		try {
			int _type = IMMEDIATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:718:11: ( I M M E D I A T E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:718:13: I M M E D I A T E
			{
			mI(); 

			mM(); 

			mM(); 

			mE(); 

			mD(); 

			mI(); 

			mA(); 

			mT(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMMEDIATE"

	// $ANTLR start "LOOP"
	public final void mLOOP() throws RecognitionException {
		try {
			int _type = LOOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:719:6: ( L O O P )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:719:8: L O O P
			{
			mL(); 

			mO(); 

			mO(); 

			mP(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOOP"

	// $ANTLR start "NOCOPY"
	public final void mNOCOPY() throws RecognitionException {
		try {
			int _type = NOCOPY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:720:8: ( N O C O P Y )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:720:10: N O C O P Y
			{
			mN(); 

			mO(); 

			mC(); 

			mO(); 

			mP(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOCOPY"

	// $ANTLR start "OTHERS"
	public final void mOTHERS() throws RecognitionException {
		try {
			int _type = OTHERS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:721:8: ( O T H E R S )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:721:10: O T H E R S
			{
			mO(); 

			mT(); 

			mH(); 

			mE(); 

			mR(); 

			mS(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OTHERS"

	// $ANTLR start "OUT"
	public final void mOUT() throws RecognitionException {
		try {
			int _type = OUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:722:5: ( O U T )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:722:7: O U T
			{
			mO(); 

			mU(); 

			mT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUT"

	// $ANTLR start "PARALLEL_ENABLE"
	public final void mPARALLEL_ENABLE() throws RecognitionException {
		try {
			int _type = PARALLEL_ENABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:723:17: ( P A R A L L E L US E N A B L E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:723:19: P A R A L L E L US E N A B L E
			{
			mP(); 

			mA(); 

			mR(); 

			mA(); 

			mL(); 

			mL(); 

			mE(); 

			mL(); 

			mUS(); 

			mE(); 

			mN(); 

			mA(); 

			mB(); 

			mL(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PARALLEL_ENABLE"

	// $ANTLR start "PIPELINED"
	public final void mPIPELINED() throws RecognitionException {
		try {
			int _type = PIPELINED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:724:11: ( P I P E L I N E D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:724:13: P I P E L I N E D
			{
			mP(); 

			mI(); 

			mP(); 

			mE(); 

			mL(); 

			mI(); 

			mN(); 

			mE(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PIPELINED"

	// $ANTLR start "PRAGMA"
	public final void mPRAGMA() throws RecognitionException {
		try {
			int _type = PRAGMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:725:8: ( P R A G M A )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:725:10: P R A G M A
			{
			mP(); 

			mR(); 

			mA(); 

			mG(); 

			mM(); 

			mA(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRAGMA"

	// $ANTLR start "PROCEDURE"
	public final void mPROCEDURE() throws RecognitionException {
		try {
			int _type = PROCEDURE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:726:11: ( P R O C E D U R E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:726:13: P R O C E D U R E
			{
			mP(); 

			mR(); 

			mO(); 

			mC(); 

			mE(); 

			mD(); 

			mU(); 

			mR(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROCEDURE"

	// $ANTLR start "RECORD"
	public final void mRECORD() throws RecognitionException {
		try {
			int _type = RECORD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:727:8: ( R E C O R D )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:727:10: R E C O R D
			{
			mR(); 

			mE(); 

			mC(); 

			mO(); 

			mR(); 

			mD(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RECORD"

	// $ANTLR start "REF"
	public final void mREF() throws RecognitionException {
		try {
			int _type = REF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:728:5: ( R E F )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:728:7: R E F
			{
			mR(); 

			mE(); 

			mF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REF"

	// $ANTLR start "RESULT_CACHE"
	public final void mRESULT_CACHE() throws RecognitionException {
		try {
			int _type = RESULT_CACHE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:729:14: ( R E S U L T US C A C H E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:729:16: R E S U L T US C A C H E
			{
			mR(); 

			mE(); 

			mS(); 

			mU(); 

			mL(); 

			mT(); 

			mUS(); 

			mC(); 

			mA(); 

			mC(); 

			mH(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RESULT_CACHE"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:730:8: ( R E T U R N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:730:10: R E T U R N
			{
			mR(); 

			mE(); 

			mT(); 

			mU(); 

			mR(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "RETURNING"
	public final void mRETURNING() throws RecognitionException {
		try {
			int _type = RETURNING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:731:11: ( R E T U R N I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:731:13: R E T U R N I N G
			{
			mR(); 

			mE(); 

			mT(); 

			mU(); 

			mR(); 

			mN(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNING"

	// $ANTLR start "ROWTYPE"
	public final void mROWTYPE() throws RecognitionException {
		try {
			int _type = ROWTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:732:9: ( R O W T Y P E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:732:11: R O W T Y P E
			{
			mR(); 

			mO(); 

			mW(); 

			mT(); 

			mY(); 

			mP(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROWTYPE"

	// $ANTLR start "SUBTYPE"
	public final void mSUBTYPE() throws RecognitionException {
		try {
			int _type = SUBTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:733:9: ( S U B T Y P E )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:733:11: S U B T Y P E
			{
			mS(); 

			mU(); 

			mB(); 

			mT(); 

			mY(); 

			mP(); 

			mE(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUBTYPE"

	// $ANTLR start "USING"
	public final void mUSING() throws RecognitionException {
		try {
			int _type = USING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:734:7: ( U S I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:734:9: U S I N G
			{
			mU(); 

			mS(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USING"

	// $ANTLR start "VARRAY"
	public final void mVARRAY() throws RecognitionException {
		try {
			int _type = VARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:735:8: ( V A R R A Y )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:735:10: V A R R A Y
			{
			mV(); 

			mA(); 

			mR(); 

			mR(); 

			mA(); 

			mY(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARRAY"

	// $ANTLR start "VARYING"
	public final void mVARYING() throws RecognitionException {
		try {
			int _type = VARYING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:736:9: ( V A R Y I N G )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:736:11: V A R Y I N G
			{
			mV(); 

			mA(); 

			mR(); 

			mY(); 

			mI(); 

			mN(); 

			mG(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VARYING"

	// $ANTLR start "WHEN"
	public final void mWHEN() throws RecognitionException {
		try {
			int _type = WHEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:737:6: ( W H E N )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:737:8: W H E N
			{
			mW(); 

			mH(); 

			mE(); 

			mN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHEN"

	// $ANTLR start "US"
	public final void mUS() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:739:13: ( ( '_' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:739:14: ( '_' )
			{
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:739:14: ( '_' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:739:15: '_'
			{
			match('_'); 
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "US"

	// $ANTLR start "A"
	public final void mA() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:741:11: ( ( 'a' | 'A' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "A"

	// $ANTLR start "B"
	public final void mB() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:742:11: ( ( 'b' | 'B' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "B"

	// $ANTLR start "C"
	public final void mC() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:743:11: ( ( 'c' | 'C' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "C"

	// $ANTLR start "D"
	public final void mD() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:744:11: ( ( 'd' | 'D' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "D"

	// $ANTLR start "E"
	public final void mE() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:745:11: ( ( 'e' | 'E' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "E"

	// $ANTLR start "F"
	public final void mF() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:746:11: ( ( 'f' | 'F' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "F"

	// $ANTLR start "G"
	public final void mG() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:747:11: ( ( 'g' | 'G' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "G"

	// $ANTLR start "H"
	public final void mH() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:748:11: ( ( 'h' | 'H' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "H"

	// $ANTLR start "I"
	public final void mI() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:749:11: ( ( 'i' | 'I' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "I"

	// $ANTLR start "J"
	public final void mJ() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:750:11: ( ( 'j' | 'J' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "J"

	// $ANTLR start "K"
	public final void mK() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:751:11: ( ( 'k' | 'K' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "K"

	// $ANTLR start "L"
	public final void mL() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:752:11: ( ( 'l' | 'L' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "L"

	// $ANTLR start "M"
	public final void mM() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:753:11: ( ( 'm' | 'M' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "M"

	// $ANTLR start "N"
	public final void mN() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:754:11: ( ( 'n' | 'N' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "N"

	// $ANTLR start "O"
	public final void mO() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:755:11: ( ( 'o' | 'O' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "O"

	// $ANTLR start "P"
	public final void mP() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:756:11: ( ( 'p' | 'P' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "P"

	// $ANTLR start "Q"
	public final void mQ() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:757:11: ( ( 'q' | 'Q' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Q"

	// $ANTLR start "R"
	public final void mR() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:758:11: ( ( 'r' | 'R' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "R"

	// $ANTLR start "S"
	public final void mS() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:759:11: ( ( 's' | 'S' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "S"

	// $ANTLR start "T"
	public final void mT() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:760:11: ( ( 't' | 'T' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T"

	// $ANTLR start "U"
	public final void mU() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:761:11: ( ( 'u' | 'U' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "U"

	// $ANTLR start "V"
	public final void mV() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:762:11: ( ( 'v' | 'V' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "V"

	// $ANTLR start "W"
	public final void mW() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:763:11: ( ( 'w' | 'W' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "W"

	// $ANTLR start "X"
	public final void mX() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:764:11: ( ( 'x' | 'X' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "X"

	// $ANTLR start "Y"
	public final void mY() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:765:11: ( ( 'y' | 'Y' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Y"

	// $ANTLR start "Z"
	public final void mZ() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:766:11: ( ( 'z' | 'Z' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Z"

	// $ANTLR start "QUOTED_STRING"
	public final void mQUOTED_STRING() throws RecognitionException {
		try {
			int _type = QUOTED_STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:2: ( ( 'n' )? '\\'' ( '\\'\\'' |~ ( '\\'' ) )* '\\'' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:4: ( 'n' )? '\\'' ( '\\'\\'' |~ ( '\\'' ) )* '\\''
			{
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:4: ( 'n' )?
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='n') ) {
				alt1=1;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:6: 'n'
					{
					match('n'); 
					}
					break;

			}

			match('\''); 
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:18: ( '\\'\\'' |~ ( '\\'' ) )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='\'') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='\'') ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '&')||(LA2_0 >= '(' && LA2_0 <= '\uFFFF')) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:20: '\\'\\''
					{
					match("''"); 

					}
					break;
				case 2 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:769:29: ~ ( '\\'' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTED_STRING"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:773:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' | '#' )* | DOUBLEQUOTED_STRING )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
				alt4=1;
			}
			else if ( (LA4_0=='\"') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:773:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' | '#' )*
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:774:3: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '$' | '#' )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '#' && LA3_0 <= '$')||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
							{
							if ( (input.LA(1) >= '#' && input.LA(1) <= '$')||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop3;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:775:4: DOUBLEQUOTED_STRING
					{
					mDOUBLEQUOTED_STRING(); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:778:2: ( ';' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:778:4: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:781:2: ( ':' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:781:4: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "DOUBLEDOT"
	public final void mDOUBLEDOT() throws RecognitionException {
		try {
			int _type = DOUBLEDOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:784:2: ( POINT POINT )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:784:4: POINT POINT
			{
			mPOINT(); 

			mPOINT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEDOT"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:787:2: ( POINT )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
			{
			if ( input.LA(1)=='.' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "POINT"
	public final void mPOINT() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:792:2: ( '.' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:792:4: '.'
			{
			match('.'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POINT"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:794:2: ( ',' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:794:4: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			int _type = EXPONENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:797:2: ( '**' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:797:4: '**'
			{
			match("**"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "ASTERISK"
	public final void mASTERISK() throws RecognitionException {
		try {
			int _type = ASTERISK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:800:2: ( '*' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:800:4: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASTERISK"

	// $ANTLR start "AT_SIGN"
	public final void mAT_SIGN() throws RecognitionException {
		try {
			int _type = AT_SIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:803:2: ( '@' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:803:4: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT_SIGN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:806:2: ( ')' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:806:4: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:809:2: ( '(' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:809:4: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:812:2: ( ']' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:812:4: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:815:2: ( '[' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:815:4: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:818:2: ( '+' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:818:4: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:821:2: ( '-' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:821:4: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:824:2: ( '/' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:824:4: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:827:2: ( '=' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:827:4: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:830:2: ( '%' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:830:4: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "LLABEL"
	public final void mLLABEL() throws RecognitionException {
		try {
			int _type = LLABEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:833:2: ( '<<' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:833:4: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LLABEL"

	// $ANTLR start "RLABEL"
	public final void mRLABEL() throws RecognitionException {
		try {
			int _type = RLABEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:836:2: ( '>>' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:836:4: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RLABEL"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:839:2: ( ':=' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:839:4: ':='
			{
			match(":="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "ARROW"
	public final void mARROW() throws RecognitionException {
		try {
			int _type = ARROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:842:2: ( '=>' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:842:4: '=>'
			{
			match("=>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARROW"

	// $ANTLR start "VERTBAR"
	public final void mVERTBAR() throws RecognitionException {
		try {
			int _type = VERTBAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:845:2: ( '|' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:845:4: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VERTBAR"

	// $ANTLR start "DOUBLEVERTBAR"
	public final void mDOUBLEVERTBAR() throws RecognitionException {
		try {
			int _type = DOUBLEVERTBAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:848:2: ( '||' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:848:4: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEVERTBAR"

	// $ANTLR start "NOT_EQ"
	public final void mNOT_EQ() throws RecognitionException {
		try {
			int _type = NOT_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:851:2: ( '<>' | '!=' | '~=' | '^=' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case '<':
				{
				alt5=1;
				}
				break;
			case '!':
				{
				alt5=2;
				}
				break;
			case '~':
				{
				alt5=3;
				}
				break;
			case '^':
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:851:4: '<>'
					{
					match("<>"); 

					}
					break;
				case 2 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:851:11: '!='
					{
					match("!="); 

					}
					break;
				case 3 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:851:18: '~='
					{
					match("~="); 

					}
					break;
				case 4 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:851:24: '^='
					{
					match("^="); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_EQ"

	// $ANTLR start "LTH"
	public final void mLTH() throws RecognitionException {
		try {
			int _type = LTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:854:2: ( '<' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:854:4: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LTH"

	// $ANTLR start "LEQ"
	public final void mLEQ() throws RecognitionException {
		try {
			int _type = LEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:857:2: ( '<=' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:857:4: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEQ"

	// $ANTLR start "GTH"
	public final void mGTH() throws RecognitionException {
		try {
			int _type = GTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:860:2: ( '>' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:860:4: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GTH"

	// $ANTLR start "GEQ"
	public final void mGEQ() throws RecognitionException {
		try {
			int _type = GEQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:863:2: ( '>=' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:863:4: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GEQ"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:866:5: ( NF )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:866:9: NF
			{
			mNF(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "REAL_NUMBER"
	public final void mREAL_NUMBER() throws RecognitionException {
		try {
			int _type = REAL_NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:869:2: ( NUMBER_VALUE ( 'e' ( PLUS | MINUS )? NF )? )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:869:4: NUMBER_VALUE ( 'e' ( PLUS | MINUS )? NF )?
			{
			mNUMBER_VALUE(); 

			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:869:17: ( 'e' ( PLUS | MINUS )? NF )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='e') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:869:19: 'e' ( PLUS | MINUS )? NF
					{
					match('e'); 
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:869:23: ( PLUS | MINUS )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='+'||LA6_0=='-') ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
							{
							if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

					}

					mNF(); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REAL_NUMBER"

	// $ANTLR start "NUMBER_VALUE"
	public final void mNUMBER_VALUE() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:874:2: ({...}? => NF POINT ( NF )? | POINT NF | NF )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:874:4: {...}? => NF POINT ( NF )?
					{
					if ( !((numberDotValid())) ) {
						throw new FailedPredicateException(input, "NUMBER_VALUE", "numberDotValid()");
					}
					mNF(); 

					mPOINT(); 

					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:874:35: ( NF )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:874:35: NF
							{
							mNF(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:875:4: POINT NF
					{
					mPOINT(); 

					mNF(); 

					}
					break;
				case 3 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:876:4: NF
					{
					mNF(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER_VALUE"

	// $ANTLR start "NF"
	public final void mNF() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:880:2: ( '0' .. '9' ( '0' .. '9' )* )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:880:4: '0' .. '9' ( '0' .. '9' )*
			{
			matchRange('0','9'); 
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:880:15: ( '0' .. '9' )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NF"

	// $ANTLR start "DOUBLEQUOTED_STRING"
	public final void mDOUBLEQUOTED_STRING() throws RecognitionException {
		try {
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:884:2: ( '\"' (~ ( '\"' ) )* '\"' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:884:4: '\"' (~ ( '\"' ) )* '\"'
			{
			match('\"'); 
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:884:8: (~ ( '\"' ) )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '\uFFFF')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			match('\"'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLEQUOTED_STRING"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:885:4: ( ( ' ' | '\\r' | '\\t' | '\\n' ) )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:885:6: ( ' ' | '\\r' | '\\t' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:888:2: ( '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:888:4: '--' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("--"); 

			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:888:9: (~ ( '\\n' | '\\r' ) )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop12;
				}
			}

			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:888:23: ( '\\r' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='\r') ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:888:23: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:891:2: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:891:4: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:891:9: ( options {greedy=false; } : . )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='*') ) {
					int LA14_1 = input.LA(2);
					if ( (LA14_1=='/') ) {
						alt14=2;
					}
					else if ( ((LA14_1 >= '\u0000' && LA14_1 <= '.')||(LA14_1 >= '0' && LA14_1 <= '\uFFFF')) ) {
						alt14=1;
					}

				}
				else if ( ((LA14_0 >= '\u0000' && LA14_0 <= ')')||(LA14_0 >= '+' && LA14_0 <= '\uFFFF')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:891:37: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop14;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:8: ( AND | ARRAY | AS | AUTHID | BETWEEN | BODY | BULK | BULK_ROWCOUNT | BY | CASE | CREATE | COLLECT | COMMIT | CURRENT_USER | DEFAULT | DEFINER | DELETE | ELSE | ELSIF | EXTERNAL | FALSE | FETCH | FOR | FORALL | GOTO | IF | IN | INDEX | INSERT | INTO | IS | LANGUAGE | LIKE | LIMIT | LOCK | NOT | NOTFOUND | NULL | OPEN | OR | PACKAGE | RAISE | ROLLBACK | SAVEPOINT | SELECT | SET | SQL | TABLE | TRANSACTION | TRUE | THEN | UPDATE | WHILE | INSERTING | UPDATING | DELETING | ISOPEN | EXISTS | BEGIN | CLOSE | CONSTANT | CONTINUE | CURSOR | DECLARE | DETERMINISTIC | END | EXCEPTION | EXECUTE | EXIT | FUNCTION | IMMEDIATE | LOOP | NOCOPY | OTHERS | OUT | PARALLEL_ENABLE | PIPELINED | PRAGMA | PROCEDURE | RECORD | REF | RESULT_CACHE | RETURN | RETURNING | ROWTYPE | SUBTYPE | USING | VARRAY | VARYING | WHEN | QUOTED_STRING | ID | SEMI | COLON | DOUBLEDOT | DOT | COMMA | EXPONENT | ASTERISK | AT_SIGN | RPAREN | LPAREN | RBRACK | LBRACK | PLUS | MINUS | DIVIDE | EQ | PERCENT | LLABEL | RLABEL | ASSIGN | ARROW | VERTBAR | DOUBLEVERTBAR | NOT_EQ | LTH | LEQ | GTH | GEQ | INTEGER | REAL_NUMBER | WS | SL_COMMENT | ML_COMMENT )
		int alt15=125;
		alt15 = dfa15.predict(input);
		switch (alt15) {
			case 1 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:10: AND
				{
				mAND(); 

				}
				break;
			case 2 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:14: ARRAY
				{
				mARRAY(); 

				}
				break;
			case 3 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:20: AS
				{
				mAS(); 

				}
				break;
			case 4 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:23: AUTHID
				{
				mAUTHID(); 

				}
				break;
			case 5 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:30: BETWEEN
				{
				mBETWEEN(); 

				}
				break;
			case 6 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:38: BODY
				{
				mBODY(); 

				}
				break;
			case 7 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:43: BULK
				{
				mBULK(); 

				}
				break;
			case 8 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:48: BULK_ROWCOUNT
				{
				mBULK_ROWCOUNT(); 

				}
				break;
			case 9 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:62: BY
				{
				mBY(); 

				}
				break;
			case 10 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:65: CASE
				{
				mCASE(); 

				}
				break;
			case 11 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:70: CREATE
				{
				mCREATE(); 

				}
				break;
			case 12 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:77: COLLECT
				{
				mCOLLECT(); 

				}
				break;
			case 13 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:85: COMMIT
				{
				mCOMMIT(); 

				}
				break;
			case 14 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:92: CURRENT_USER
				{
				mCURRENT_USER(); 

				}
				break;
			case 15 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:105: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 16 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:113: DEFINER
				{
				mDEFINER(); 

				}
				break;
			case 17 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:121: DELETE
				{
				mDELETE(); 

				}
				break;
			case 18 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:128: ELSE
				{
				mELSE(); 

				}
				break;
			case 19 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:133: ELSIF
				{
				mELSIF(); 

				}
				break;
			case 20 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:139: EXTERNAL
				{
				mEXTERNAL(); 

				}
				break;
			case 21 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:148: FALSE
				{
				mFALSE(); 

				}
				break;
			case 22 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:154: FETCH
				{
				mFETCH(); 

				}
				break;
			case 23 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:160: FOR
				{
				mFOR(); 

				}
				break;
			case 24 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:164: FORALL
				{
				mFORALL(); 

				}
				break;
			case 25 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:171: GOTO
				{
				mGOTO(); 

				}
				break;
			case 26 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:176: IF
				{
				mIF(); 

				}
				break;
			case 27 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:179: IN
				{
				mIN(); 

				}
				break;
			case 28 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:182: INDEX
				{
				mINDEX(); 

				}
				break;
			case 29 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:188: INSERT
				{
				mINSERT(); 

				}
				break;
			case 30 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:195: INTO
				{
				mINTO(); 

				}
				break;
			case 31 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:200: IS
				{
				mIS(); 

				}
				break;
			case 32 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:203: LANGUAGE
				{
				mLANGUAGE(); 

				}
				break;
			case 33 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:212: LIKE
				{
				mLIKE(); 

				}
				break;
			case 34 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:217: LIMIT
				{
				mLIMIT(); 

				}
				break;
			case 35 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:223: LOCK
				{
				mLOCK(); 

				}
				break;
			case 36 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:228: NOT
				{
				mNOT(); 

				}
				break;
			case 37 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:232: NOTFOUND
				{
				mNOTFOUND(); 

				}
				break;
			case 38 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:241: NULL
				{
				mNULL(); 

				}
				break;
			case 39 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:246: OPEN
				{
				mOPEN(); 

				}
				break;
			case 40 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:251: OR
				{
				mOR(); 

				}
				break;
			case 41 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:254: PACKAGE
				{
				mPACKAGE(); 

				}
				break;
			case 42 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:262: RAISE
				{
				mRAISE(); 

				}
				break;
			case 43 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:268: ROLLBACK
				{
				mROLLBACK(); 

				}
				break;
			case 44 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:277: SAVEPOINT
				{
				mSAVEPOINT(); 

				}
				break;
			case 45 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:287: SELECT
				{
				mSELECT(); 

				}
				break;
			case 46 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:294: SET
				{
				mSET(); 

				}
				break;
			case 47 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:298: SQL
				{
				mSQL(); 

				}
				break;
			case 48 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:302: TABLE
				{
				mTABLE(); 

				}
				break;
			case 49 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:308: TRANSACTION
				{
				mTRANSACTION(); 

				}
				break;
			case 50 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:320: TRUE
				{
				mTRUE(); 

				}
				break;
			case 51 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:325: THEN
				{
				mTHEN(); 

				}
				break;
			case 52 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:330: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 53 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:337: WHILE
				{
				mWHILE(); 

				}
				break;
			case 54 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:343: INSERTING
				{
				mINSERTING(); 

				}
				break;
			case 55 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:353: UPDATING
				{
				mUPDATING(); 

				}
				break;
			case 56 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:362: DELETING
				{
				mDELETING(); 

				}
				break;
			case 57 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:371: ISOPEN
				{
				mISOPEN(); 

				}
				break;
			case 58 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:378: EXISTS
				{
				mEXISTS(); 

				}
				break;
			case 59 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:385: BEGIN
				{
				mBEGIN(); 

				}
				break;
			case 60 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:391: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 61 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:397: CONSTANT
				{
				mCONSTANT(); 

				}
				break;
			case 62 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:406: CONTINUE
				{
				mCONTINUE(); 

				}
				break;
			case 63 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:415: CURSOR
				{
				mCURSOR(); 

				}
				break;
			case 64 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:422: DECLARE
				{
				mDECLARE(); 

				}
				break;
			case 65 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:430: DETERMINISTIC
				{
				mDETERMINISTIC(); 

				}
				break;
			case 66 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:444: END
				{
				mEND(); 

				}
				break;
			case 67 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:448: EXCEPTION
				{
				mEXCEPTION(); 

				}
				break;
			case 68 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:458: EXECUTE
				{
				mEXECUTE(); 

				}
				break;
			case 69 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:466: EXIT
				{
				mEXIT(); 

				}
				break;
			case 70 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:471: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 71 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:480: IMMEDIATE
				{
				mIMMEDIATE(); 

				}
				break;
			case 72 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:490: LOOP
				{
				mLOOP(); 

				}
				break;
			case 73 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:495: NOCOPY
				{
				mNOCOPY(); 

				}
				break;
			case 74 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:502: OTHERS
				{
				mOTHERS(); 

				}
				break;
			case 75 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:509: OUT
				{
				mOUT(); 

				}
				break;
			case 76 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:513: PARALLEL_ENABLE
				{
				mPARALLEL_ENABLE(); 

				}
				break;
			case 77 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:529: PIPELINED
				{
				mPIPELINED(); 

				}
				break;
			case 78 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:539: PRAGMA
				{
				mPRAGMA(); 

				}
				break;
			case 79 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:546: PROCEDURE
				{
				mPROCEDURE(); 

				}
				break;
			case 80 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:556: RECORD
				{
				mRECORD(); 

				}
				break;
			case 81 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:563: REF
				{
				mREF(); 

				}
				break;
			case 82 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:567: RESULT_CACHE
				{
				mRESULT_CACHE(); 

				}
				break;
			case 83 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:580: RETURN
				{
				mRETURN(); 

				}
				break;
			case 84 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:587: RETURNING
				{
				mRETURNING(); 

				}
				break;
			case 85 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:597: ROWTYPE
				{
				mROWTYPE(); 

				}
				break;
			case 86 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:605: SUBTYPE
				{
				mSUBTYPE(); 

				}
				break;
			case 87 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:613: USING
				{
				mUSING(); 

				}
				break;
			case 88 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:619: VARRAY
				{
				mVARRAY(); 

				}
				break;
			case 89 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:626: VARYING
				{
				mVARYING(); 

				}
				break;
			case 90 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:634: WHEN
				{
				mWHEN(); 

				}
				break;
			case 91 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:639: QUOTED_STRING
				{
				mQUOTED_STRING(); 

				}
				break;
			case 92 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:653: ID
				{
				mID(); 

				}
				break;
			case 93 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:656: SEMI
				{
				mSEMI(); 

				}
				break;
			case 94 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:661: COLON
				{
				mCOLON(); 

				}
				break;
			case 95 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:667: DOUBLEDOT
				{
				mDOUBLEDOT(); 

				}
				break;
			case 96 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:677: DOT
				{
				mDOT(); 

				}
				break;
			case 97 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:681: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 98 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:687: EXPONENT
				{
				mEXPONENT(); 

				}
				break;
			case 99 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:696: ASTERISK
				{
				mASTERISK(); 

				}
				break;
			case 100 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:705: AT_SIGN
				{
				mAT_SIGN(); 

				}
				break;
			case 101 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:713: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 102 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:720: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 103 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:727: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 104 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:734: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 105 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:741: PLUS
				{
				mPLUS(); 

				}
				break;
			case 106 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:746: MINUS
				{
				mMINUS(); 

				}
				break;
			case 107 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:752: DIVIDE
				{
				mDIVIDE(); 

				}
				break;
			case 108 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:759: EQ
				{
				mEQ(); 

				}
				break;
			case 109 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:762: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 110 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:770: LLABEL
				{
				mLLABEL(); 

				}
				break;
			case 111 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:777: RLABEL
				{
				mRLABEL(); 

				}
				break;
			case 112 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:784: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 113 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:791: ARROW
				{
				mARROW(); 

				}
				break;
			case 114 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:797: VERTBAR
				{
				mVERTBAR(); 

				}
				break;
			case 115 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:805: DOUBLEVERTBAR
				{
				mDOUBLEVERTBAR(); 

				}
				break;
			case 116 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:819: NOT_EQ
				{
				mNOT_EQ(); 

				}
				break;
			case 117 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:826: LTH
				{
				mLTH(); 

				}
				break;
			case 118 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:830: LEQ
				{
				mLEQ(); 

				}
				break;
			case 119 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:834: GTH
				{
				mGTH(); 

				}
				break;
			case 120 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:838: GEQ
				{
				mGEQ(); 

				}
				break;
			case 121 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:842: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 122 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:850: REAL_NUMBER
				{
				mREAL_NUMBER(); 

				}
				break;
			case 123 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:862: WS
				{
				mWS(); 

				}
				break;
			case 124 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:865: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 125 :
				// C:\\Users\\doug\\Documents\\NetBeansProjects\\pl-sql-driver-plugin\\src\\org\\plsql\\PLSQL.g:1:876: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA15 dfa15 = new DFA15(this);
	static final String DFA9_eotS =
		"\1\uffff\1\4\1\uffff\1\4\2\uffff";
	static final String DFA9_eofS =
		"\6\uffff";
	static final String DFA9_minS =
		"\2\56\1\uffff\1\56\2\uffff";
	static final String DFA9_maxS =
		"\2\71\1\uffff\1\71\2\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\2\1\uffff\1\3\1\1";
	static final String DFA9_specialS =
		"\1\uffff\1\1\1\uffff\1\0\2\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\5\1\uffff\12\3",
			"",
			"\1\5\1\uffff\12\3",
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

	protected class DFA9 extends DFA {

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
		@Override
		public String getDescription() {
			return "873:1: fragment NUMBER_VALUE : ({...}? => NF POINT ( NF )? | POINT NF | NF );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA9_3 = input.LA(1);
						 
						int index9_3 = input.index();
						input.rewind();
						s = -1;
						if ( (LA9_3=='.') && ((numberDotValid()))) {s = 5;}
						else if ( ((LA9_3 >= '0' && LA9_3 <= '9')) ) {s = 3;}
						else s = 4;
						 
						input.seek(index9_3);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA9_1 = input.LA(1);
						 
						int index9_1 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA9_1 >= '0' && LA9_1 <= '9')) ) {s = 3;}
						else if ( (LA9_1=='.') && ((numberDotValid()))) {s = 5;}
						else s = 4;
						 
						input.seek(index9_1);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 9, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA15_eotS =
		"\1\uffff\23\25\3\uffff\1\140\1\141\1\uffff\1\145\6\uffff\1\147\1\151\1"+
		"\153\1\uffff\1\156\1\161\1\163\1\uffff\1\165\1\uffff\2\25\1\172\4\25\1"+
		"\u0080\16\25\1\u0097\1\u0098\1\u009c\7\25\1\u00a8\23\25\25\uffff\1\165"+
		"\3\uffff\1\u00c5\1\25\1\uffff\5\25\1\uffff\20\25\1\u00e1\2\25\1\u00e4"+
		"\2\25\2\uffff\3\25\1\uffff\7\25\1\u00f2\3\25\1\uffff\1\25\1\u00f8\11\25"+
		"\1\u0102\4\25\1\u0107\1\u0108\12\25\1\uffff\4\25\1\u0118\1\u0119\1\u011b"+
		"\15\25\1\u0129\3\25\1\u012d\2\25\1\uffff\2\25\1\uffff\2\25\1\u0134\2\25"+
		"\1\u0137\3\25\1\u013b\1\25\1\u013d\1\u013e\1\uffff\2\25\1\u0141\1\u0142"+
		"\1\25\1\uffff\11\25\1\uffff\4\25\2\uffff\3\25\1\u0154\1\u0155\3\25\1\u0159"+
		"\2\25\1\u015c\2\25\1\u015f\2\uffff\1\25\1\uffff\7\25\1\u0168\5\25\1\uffff"+
		"\1\u016f\2\25\1\uffff\2\25\1\u0174\1\u0175\2\25\1\uffff\1\u0178\1\25\1"+
		"\uffff\3\25\1\uffff\1\u017d\2\uffff\2\25\2\uffff\6\25\1\u0186\10\25\1"+
		"\u018f\1\25\2\uffff\1\25\1\u0193\1\u0194\1\uffff\2\25\1\uffff\1\u0197"+
		"\1\25\1\uffff\1\25\1\u019a\1\25\1\u019c\3\25\1\u01a0\1\uffff\2\25\1\u01a3"+
		"\3\25\1\uffff\1\25\1\u01a8\2\25\2\uffff\1\u01ab\1\25\1\uffff\1\u01ad\1"+
		"\u01af\2\25\1\uffff\1\25\1\u01b3\1\u01b4\3\25\1\u01b8\1\25\1\uffff\2\25"+
		"\1\u01bc\1\25\1\u01be\1\25\1\u01c1\1\25\1\uffff\1\25\1\u01c4\1\25\2\uffff"+
		"\1\u01c6\1\25\1\uffff\1\u01c8\1\25\1\uffff\1\u01ca\1\uffff\3\25\1\uffff"+
		"\1\u01ce\1\u01cf\1\uffff\1\25\1\u01d1\2\25\1\uffff\1\25\1\u01d5\1\uffff"+
		"\1\25\1\uffff\1\25\1\uffff\3\25\2\uffff\1\u01db\2\25\1\uffff\2\25\1\u01e0"+
		"\1\uffff\1\25\1\uffff\2\25\1\uffff\1\u01e4\1\25\1\uffff\1\25\1\uffff\1"+
		"\u01e7\1\uffff\1\25\1\uffff\1\u01e9\1\u01ea\1\25\2\uffff\1\u01ec\1\uffff"+
		"\1\25\1\u01ee\1\25\1\uffff\1\u01f0\2\25\1\u01f3\1\u01f4\1\uffff\3\25\1"+
		"\u01f8\1\uffff\3\25\1\uffff\1\25\1\u01fd\1\uffff\1\25\2\uffff\1\25\1\uffff"+
		"\1\25\1\uffff\1\u0201\1\uffff\1\u0202\1\u0203\2\uffff\1\25\1\u0205\1\u0206"+
		"\1\uffff\1\25\1\u0208\1\u0209\1\25\1\uffff\3\25\3\uffff\1\25\2\uffff\1"+
		"\25\2\uffff\6\25\1\u0216\1\25\1\u0218\2\25\1\u021b\1\uffff\1\u021c\1\uffff"+
		"\1\u021d\1\25\3\uffff\1\25\1\u0220\1\uffff";
	static final String DFA15_eofS =
		"\u0221\uffff";
	static final String DFA15_minS =
		"\1\11\1\116\1\105\1\101\1\105\1\114\1\101\1\117\1\106\1\101\1\47\1\120"+
		"\4\101\1\120\1\110\1\101\1\117\3\uffff\1\75\1\56\1\uffff\1\52\6\uffff"+
		"\1\55\1\52\1\76\1\uffff\1\74\1\75\1\174\1\uffff\1\56\1\uffff\1\104\1\122"+
		"\1\43\1\124\1\107\1\104\1\114\1\43\1\123\1\105\1\114\1\122\1\117\1\103"+
		"\1\123\1\103\1\104\1\114\1\124\1\122\1\116\1\124\3\43\1\115\1\116\1\113"+
		"\2\103\1\114\1\105\1\43\1\110\1\124\1\103\1\120\1\101\1\111\1\114\1\103"+
		"\1\126\2\114\2\102\1\101\1\105\1\104\1\111\1\105\1\122\25\uffff\1\56\3"+
		"\uffff\1\43\1\101\1\uffff\1\110\1\127\1\111\1\131\1\113\1\uffff\1\105"+
		"\1\101\1\114\1\115\1\123\1\122\1\123\1\101\1\105\1\114\3\105\1\123\1\105"+
		"\1\103\1\43\1\123\1\103\1\43\1\103\1\117\2\uffff\2\105\1\117\1\uffff\1"+
		"\120\1\105\1\107\1\105\1\111\1\113\1\120\1\43\1\117\1\114\1\116\1\uffff"+
		"\1\105\1\43\1\113\1\101\1\105\1\107\1\103\1\123\1\114\1\124\1\117\1\43"+
		"\2\125\2\105\2\43\1\124\1\114\1\116\1\105\1\116\1\101\1\116\1\114\1\116"+
		"\1\122\1\uffff\1\131\1\111\1\105\1\116\3\43\1\124\1\105\1\111\1\124\1"+
		"\111\1\105\1\117\1\105\1\125\1\116\1\124\1\101\1\122\1\43\1\106\1\122"+
		"\1\124\1\43\1\120\1\125\1\uffff\1\105\1\110\1\uffff\1\114\1\124\1\43\1"+
		"\130\1\122\1\43\1\105\1\104\1\125\1\43\1\124\2\43\1\uffff\1\117\1\120"+
		"\2\43\1\122\1\uffff\1\101\2\114\1\115\2\105\1\102\1\131\1\122\1\uffff"+
		"\1\114\1\122\1\120\1\103\2\uffff\1\131\1\105\1\123\2\43\1\124\1\107\1"+
		"\105\1\43\1\101\1\111\1\43\1\104\1\105\1\43\2\uffff\1\122\1\uffff\1\105"+
		"\1\103\1\124\1\101\2\116\1\122\1\43\1\114\2\105\1\122\1\115\1\uffff\1"+
		"\43\1\116\1\123\1\uffff\2\124\2\43\1\114\1\111\1\uffff\1\43\1\124\1\uffff"+
		"\1\116\1\111\1\101\1\uffff\1\43\2\uffff\1\125\1\131\2\uffff\1\123\1\107"+
		"\1\114\1\111\1\101\1\104\1\43\1\101\1\120\1\104\1\124\1\116\1\117\1\124"+
		"\1\120\1\43\1\101\2\uffff\1\105\2\43\1\uffff\1\131\1\116\1\uffff\1\43"+
		"\1\116\1\uffff\1\117\1\43\1\124\1\43\1\116\1\125\1\124\1\43\1\uffff\1"+
		"\124\1\122\1\43\1\116\1\105\1\111\1\uffff\1\101\1\43\1\111\1\105\2\uffff"+
		"\1\43\1\117\1\uffff\2\43\1\101\1\107\1\uffff\1\116\2\43\2\105\1\116\1"+
		"\43\1\125\1\uffff\1\103\1\105\1\43\1\137\1\43\1\111\1\43\1\105\1\uffff"+
		"\1\103\1\43\1\116\2\uffff\1\43\1\107\1\uffff\1\43\1\127\1\uffff\1\43\1"+
		"\uffff\1\124\1\105\1\137\1\uffff\2\43\1\uffff\1\107\1\43\1\116\1\114\1"+
		"\uffff\1\117\1\43\1\uffff\1\116\1\uffff\1\116\1\uffff\1\124\1\105\1\104"+
		"\2\uffff\1\43\1\114\1\105\1\uffff\1\122\1\113\1\43\1\uffff\1\103\1\uffff"+
		"\2\116\1\uffff\1\43\1\124\1\uffff\1\107\1\uffff\1\43\1\uffff\1\103\1\uffff"+
		"\2\43\1\125\2\uffff\1\43\1\uffff\1\111\1\43\1\116\1\uffff\1\43\1\107\1"+
		"\105\2\43\1\uffff\1\137\1\104\1\105\1\43\1\uffff\1\101\1\107\1\124\1\uffff"+
		"\1\111\1\43\1\uffff\1\117\2\uffff\1\123\1\uffff\1\123\1\uffff\1\43\1\uffff"+
		"\2\43\2\uffff\1\105\2\43\1\uffff\1\103\2\43\1\117\1\uffff\1\125\1\105"+
		"\1\124\3\uffff\1\116\2\uffff\1\110\2\uffff\2\116\1\122\1\111\1\101\1\105"+
		"\1\43\1\124\1\43\1\103\1\102\1\43\1\uffff\1\43\1\uffff\1\43\1\114\3\uffff"+
		"\1\105\1\43\1\uffff";
	static final String DFA15_maxS =
		"\1\176\1\165\1\171\1\165\1\145\1\170\1\165\1\157\1\163\1\157\2\165\1\162"+
		"\1\157\1\165\1\162\1\163\1\150\1\141\1\165\3\uffff\1\75\1\71\1\uffff\1"+
		"\52\6\uffff\1\55\1\52\1\76\1\uffff\2\76\1\174\1\uffff\1\145\1\uffff\1"+
		"\144\1\162\1\172\2\164\1\144\1\154\1\172\1\163\1\145\1\156\1\162\1\157"+
		"\1\164\1\163\1\164\1\144\1\154\1\164\1\162\1\156\1\164\3\172\1\155\1\156"+
		"\1\155\1\157\1\164\1\154\1\145\1\172\1\150\1\164\1\162\1\160\1\157\1\151"+
		"\1\167\1\164\1\166\1\164\1\154\2\142\1\165\1\145\1\144\2\151\1\162\25"+
		"\uffff\1\145\3\uffff\1\172\1\141\1\uffff\1\150\1\167\1\151\1\171\1\153"+
		"\1\uffff\1\145\1\141\1\154\1\155\1\164\2\163\1\151\1\145\1\154\1\145\1"+
		"\151\1\145\1\164\1\145\1\143\1\172\1\163\1\143\1\172\1\143\1\157\2\uffff"+
		"\2\145\1\157\1\uffff\1\160\1\145\1\147\1\145\1\151\1\153\1\160\1\172\1"+
		"\157\1\154\1\156\1\uffff\1\145\1\172\1\153\1\141\1\145\1\147\1\143\1\163"+
		"\1\154\1\164\1\157\1\172\2\165\2\145\2\172\1\164\1\154\1\156\1\145\1\156"+
		"\1\141\1\156\1\154\1\156\1\171\1\uffff\1\171\1\151\1\145\1\156\3\172\1"+
		"\164\1\145\1\151\1\164\1\151\1\145\1\157\1\145\1\165\1\156\1\164\1\141"+
		"\1\162\1\172\1\146\1\162\1\164\1\172\1\160\1\165\1\uffff\1\145\1\150\1"+
		"\uffff\1\154\1\164\1\172\1\170\1\162\1\172\1\145\1\144\1\165\1\172\1\164"+
		"\2\172\1\uffff\1\157\1\160\2\172\1\162\1\uffff\1\141\2\154\1\155\2\145"+
		"\1\142\1\171\1\162\1\uffff\1\154\1\162\1\160\1\143\2\uffff\1\171\1\145"+
		"\1\163\2\172\1\164\1\147\1\145\1\172\1\141\1\151\1\172\1\144\1\145\1\172"+
		"\2\uffff\1\162\1\uffff\1\145\1\143\1\164\1\141\2\156\1\162\1\172\1\154"+
		"\1\145\1\151\1\162\1\155\1\uffff\1\172\1\156\1\163\1\uffff\2\164\2\172"+
		"\1\154\1\151\1\uffff\1\172\1\164\1\uffff\1\156\1\151\1\141\1\uffff\1\172"+
		"\2\uffff\1\165\1\171\2\uffff\1\163\1\147\1\154\1\151\1\141\1\144\1\172"+
		"\1\141\1\160\1\144\1\164\1\156\1\157\1\164\1\160\1\172\1\141\2\uffff\1"+
		"\151\2\172\1\uffff\1\171\1\156\1\uffff\1\172\1\156\1\uffff\1\157\1\172"+
		"\1\164\1\172\1\156\1\165\1\164\1\172\1\uffff\1\164\1\162\1\172\1\156\1"+
		"\145\1\151\1\uffff\1\141\1\172\1\151\1\145\2\uffff\1\172\1\157\1\uffff"+
		"\2\172\1\141\1\147\1\uffff\1\156\2\172\2\145\1\156\1\172\1\165\1\uffff"+
		"\1\143\1\145\1\172\1\137\1\172\1\151\1\172\1\145\1\uffff\1\143\1\172\1"+
		"\156\2\uffff\1\172\1\147\1\uffff\1\172\1\167\1\uffff\1\172\1\uffff\1\164"+
		"\1\145\1\137\1\uffff\2\172\1\uffff\1\147\1\172\1\156\1\154\1\uffff\1\157"+
		"\1\172\1\uffff\1\156\1\uffff\1\156\1\uffff\1\164\1\145\1\144\2\uffff\1"+
		"\172\1\154\1\145\1\uffff\1\162\1\153\1\172\1\uffff\1\143\1\uffff\2\156"+
		"\1\uffff\1\172\1\164\1\uffff\1\147\1\uffff\1\172\1\uffff\1\143\1\uffff"+
		"\2\172\1\165\2\uffff\1\172\1\uffff\1\151\1\172\1\156\1\uffff\1\172\1\147"+
		"\1\145\2\172\1\uffff\1\137\1\144\1\145\1\172\1\uffff\1\141\1\147\1\164"+
		"\1\uffff\1\151\1\172\1\uffff\1\157\2\uffff\1\163\1\uffff\1\163\1\uffff"+
		"\1\172\1\uffff\2\172\2\uffff\1\145\2\172\1\uffff\1\143\2\172\1\157\1\uffff"+
		"\1\165\1\145\1\164\3\uffff\1\156\2\uffff\1\150\2\uffff\2\156\1\162\1\151"+
		"\1\141\1\145\1\172\1\164\1\172\1\143\1\142\1\172\1\uffff\1\172\1\uffff"+
		"\1\172\1\154\3\uffff\1\145\1\172\1\uffff";
	static final String DFA15_acceptS =
		"\24\uffff\1\133\1\134\1\135\2\uffff\1\141\1\uffff\1\144\1\145\1\146\1"+
		"\147\1\150\1\151\3\uffff\1\155\3\uffff\1\164\1\uffff\1\173\64\uffff\1"+
		"\160\1\136\1\140\1\137\1\172\1\142\1\143\1\174\1\152\1\175\1\153\1\161"+
		"\1\154\1\156\1\166\1\165\1\157\1\170\1\167\1\163\1\162\1\uffff\1\171\2"+
		"\172\2\uffff\1\3\5\uffff\1\11\26\uffff\1\32\1\33\3\uffff\1\37\13\uffff"+
		"\1\50\34\uffff\1\1\33\uffff\1\102\2\uffff\1\27\15\uffff\1\44\5\uffff\1"+
		"\113\11\uffff\1\121\4\uffff\1\56\1\57\17\uffff\1\6\1\7\1\uffff\1\12\15"+
		"\uffff\1\22\3\uffff\1\105\6\uffff\1\31\2\uffff\1\36\3\uffff\1\41\1\uffff"+
		"\1\43\1\110\2\uffff\1\46\1\47\21\uffff\1\62\1\63\3\uffff\1\132\2\uffff"+
		"\1\2\2\uffff\1\73\10\uffff\1\74\6\uffff\1\23\4\uffff\1\25\1\26\2\uffff"+
		"\1\34\4\uffff\1\42\10\uffff\1\52\10\uffff\1\60\3\uffff\1\127\1\65\2\uffff"+
		"\1\4\2\uffff\1\13\1\uffff\1\15\3\uffff\1\77\2\uffff\1\21\4\uffff\1\72"+
		"\2\uffff\1\30\1\uffff\1\35\1\uffff\1\71\3\uffff\1\111\1\112\3\uffff\1"+
		"\116\3\uffff\1\120\1\uffff\1\123\2\uffff\1\55\2\uffff\1\64\1\uffff\1\130"+
		"\1\uffff\1\5\1\uffff\1\14\3\uffff\1\17\1\20\1\uffff\1\100\3\uffff\1\104"+
		"\5\uffff\1\51\4\uffff\1\125\3\uffff\1\126\2\uffff\1\131\1\uffff\1\75\1"+
		"\76\1\uffff\1\70\1\uffff\1\24\1\uffff\1\106\2\uffff\1\40\1\45\3\uffff"+
		"\1\53\4\uffff\1\67\3\uffff\1\103\1\66\1\107\1\uffff\1\115\1\117\1\uffff"+
		"\1\124\1\54\14\uffff\1\61\1\uffff\1\16\2\uffff\1\122\1\10\1\101\2\uffff"+
		"\1\114";
	static final String DFA15_specialS =
		"\51\uffff\1\1\112\uffff\1\0\u01ac\uffff}>";
	static final String[] DFA15_transitionS = {
			"\2\52\2\uffff\1\52\22\uffff\1\52\1\50\1\25\2\uffff\1\44\1\uffff\1\24"+
			"\1\35\1\34\1\32\1\40\1\31\1\41\1\30\1\42\12\51\1\27\1\26\1\45\1\43\1"+
			"\46\1\uffff\1\33\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\25\1\10\2\25\1\11\1\25"+
			"\1\23\1\13\1\14\1\25\1\15\1\16\1\17\1\20\1\22\1\21\3\25\1\37\1\uffff"+
			"\1\36\1\50\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\25\1\10\2\25\1\11\1"+
			"\25\1\12\1\13\1\14\1\25\1\15\1\16\1\17\1\20\1\22\1\21\3\25\1\uffff\1"+
			"\47\1\uffff\1\50",
			"\1\53\3\uffff\1\54\1\55\1\uffff\1\56\30\uffff\1\53\3\uffff\1\54\1\55"+
			"\1\uffff\1\56",
			"\1\57\11\uffff\1\60\5\uffff\1\61\3\uffff\1\62\13\uffff\1\57\11\uffff"+
			"\1\60\5\uffff\1\61\3\uffff\1\62",
			"\1\63\12\uffff\1\67\2\uffff\1\65\2\uffff\1\64\2\uffff\1\66\13\uffff"+
			"\1\63\12\uffff\1\67\2\uffff\1\65\2\uffff\1\64\2\uffff\1\66",
			"\1\70\37\uffff\1\70",
			"\1\71\1\uffff\1\73\11\uffff\1\72\23\uffff\1\71\1\uffff\1\73\11\uffff"+
			"\1\72",
			"\1\74\3\uffff\1\75\11\uffff\1\76\5\uffff\1\77\13\uffff\1\74\3\uffff"+
			"\1\75\11\uffff\1\76\5\uffff\1\77",
			"\1\100\37\uffff\1\100",
			"\1\101\6\uffff\1\104\1\102\4\uffff\1\103\22\uffff\1\101\6\uffff\1\104"+
			"\1\102\4\uffff\1\103",
			"\1\105\7\uffff\1\106\5\uffff\1\107\21\uffff\1\105\7\uffff\1\106\5\uffff"+
			"\1\107",
			"\1\24\47\uffff\1\110\5\uffff\1\111\31\uffff\1\110\5\uffff\1\111",
			"\1\112\1\uffff\1\113\1\uffff\1\114\1\115\32\uffff\1\112\1\uffff\1\113"+
			"\1\uffff\1\114\1\115",
			"\1\116\7\uffff\1\117\10\uffff\1\120\16\uffff\1\116\7\uffff\1\117\10"+
			"\uffff\1\120",
			"\1\121\3\uffff\1\123\11\uffff\1\122\21\uffff\1\121\3\uffff\1\123\11"+
			"\uffff\1\122",
			"\1\124\3\uffff\1\125\13\uffff\1\126\3\uffff\1\127\13\uffff\1\124\3\uffff"+
			"\1\125\13\uffff\1\126\3\uffff\1\127",
			"\1\130\6\uffff\1\132\11\uffff\1\131\16\uffff\1\130\6\uffff\1\132\11"+
			"\uffff\1\131",
			"\1\133\2\uffff\1\134\34\uffff\1\133\2\uffff\1\134",
			"\1\135\37\uffff\1\135",
			"\1\136\37\uffff\1\136",
			"\1\110\5\uffff\1\111\31\uffff\1\110\5\uffff\1\111",
			"",
			"",
			"",
			"\1\137",
			"\1\142\1\uffff\12\143",
			"",
			"\1\144",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\146",
			"\1\150",
			"\1\152",
			"",
			"\1\154\1\155\1\50",
			"\1\160\1\157",
			"\1\162",
			"",
			"\1\166\1\uffff\12\164\53\uffff\1\167",
			"",
			"\1\170\37\uffff\1\170",
			"\1\171\37\uffff\1\171",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\173\37\uffff\1\173",
			"\1\175\14\uffff\1\174\22\uffff\1\175\14\uffff\1\174",
			"\1\176\37\uffff\1\176",
			"\1\177\37\uffff\1\177",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0081\37\uffff\1\u0081",
			"\1\u0082\37\uffff\1\u0082",
			"\1\u0083\1\u0084\1\u0085\35\uffff\1\u0083\1\u0084\1\u0085",
			"\1\u0086\37\uffff\1\u0086",
			"\1\u0087\37\uffff\1\u0087",
			"\1\u008a\2\uffff\1\u0088\5\uffff\1\u0089\7\uffff\1\u008b\16\uffff\1"+
			"\u008a\2\uffff\1\u0088\5\uffff\1\u0089\7\uffff\1\u008b",
			"\1\u008c\37\uffff\1\u008c",
			"\1\u008f\1\uffff\1\u0090\3\uffff\1\u008e\12\uffff\1\u008d\16\uffff\1"+
			"\u008f\1\uffff\1\u0090\3\uffff\1\u008e\12\uffff\1\u008d",
			"\1\u0091\37\uffff\1\u0091",
			"\1\u0092\37\uffff\1\u0092",
			"\1\u0093\37\uffff\1\u0093",
			"\1\u0094\37\uffff\1\u0094",
			"\1\u0095\37\uffff\1\u0095",
			"\1\u0096\37\uffff\1\u0096",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\3\25\1\u0099\16\25\1\u009a\1\u009b\6\25"+
			"\4\uffff\1\25\1\uffff\3\25\1\u0099\16\25\1\u009a\1\u009b\6\25",
			"\2\25\13\uffff\12\25\7\uffff\16\25\1\u009d\13\25\4\uffff\1\25\1\uffff"+
			"\16\25\1\u009d\13\25",
			"\1\u009e\37\uffff\1\u009e",
			"\1\u009f\37\uffff\1\u009f",
			"\1\u00a0\1\uffff\1\u00a1\35\uffff\1\u00a0\1\uffff\1\u00a1",
			"\1\u00a2\13\uffff\1\u00a3\23\uffff\1\u00a2\13\uffff\1\u00a3",
			"\1\u00a5\20\uffff\1\u00a4\16\uffff\1\u00a5\20\uffff\1\u00a4",
			"\1\u00a6\37\uffff\1\u00a6",
			"\1\u00a7\37\uffff\1\u00a7",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u00a9\37\uffff\1\u00a9",
			"\1\u00aa\37\uffff\1\u00aa",
			"\1\u00ab\16\uffff\1\u00ac\20\uffff\1\u00ab\16\uffff\1\u00ac",
			"\1\u00ad\37\uffff\1\u00ad",
			"\1\u00ae\15\uffff\1\u00af\21\uffff\1\u00ae\15\uffff\1\u00af",
			"\1\u00b0\37\uffff\1\u00b0",
			"\1\u00b1\12\uffff\1\u00b2\24\uffff\1\u00b1\12\uffff\1\u00b2",
			"\1\u00b3\2\uffff\1\u00b4\14\uffff\1\u00b5\1\u00b6\16\uffff\1\u00b3\2"+
			"\uffff\1\u00b4\14\uffff\1\u00b5\1\u00b6",
			"\1\u00b7\37\uffff\1\u00b7",
			"\1\u00b8\7\uffff\1\u00b9\27\uffff\1\u00b8\7\uffff\1\u00b9",
			"\1\u00ba\37\uffff\1\u00ba",
			"\1\u00bb\37\uffff\1\u00bb",
			"\1\u00bc\37\uffff\1\u00bc",
			"\1\u00bd\23\uffff\1\u00be\13\uffff\1\u00bd\23\uffff\1\u00be",
			"\1\u00bf\37\uffff\1\u00bf",
			"\1\u00c0\37\uffff\1\u00c0",
			"\1\u00c1\37\uffff\1\u00c1",
			"\1\u00c3\3\uffff\1\u00c2\33\uffff\1\u00c3\3\uffff\1\u00c2",
			"\1\u00c4\37\uffff\1\u00c4",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\166\1\uffff\12\164\53\uffff\1\167",
			"",
			"",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u00c6\37\uffff\1\u00c6",
			"",
			"\1\u00c7\37\uffff\1\u00c7",
			"\1\u00c8\37\uffff\1\u00c8",
			"\1\u00c9\37\uffff\1\u00c9",
			"\1\u00ca\37\uffff\1\u00ca",
			"\1\u00cb\37\uffff\1\u00cb",
			"",
			"\1\u00cc\37\uffff\1\u00cc",
			"\1\u00cd\37\uffff\1\u00cd",
			"\1\u00ce\37\uffff\1\u00ce",
			"\1\u00cf\37\uffff\1\u00cf",
			"\1\u00d0\1\u00d1\36\uffff\1\u00d0\1\u00d1",
			"\1\u00d2\1\u00d3\36\uffff\1\u00d2\1\u00d3",
			"\1\u00d4\37\uffff\1\u00d4",
			"\1\u00d5\7\uffff\1\u00d6\27\uffff\1\u00d5\7\uffff\1\u00d6",
			"\1\u00d7\37\uffff\1\u00d7",
			"\1\u00d8\37\uffff\1\u00d8",
			"\1\u00d9\37\uffff\1\u00d9",
			"\1\u00da\3\uffff\1\u00db\33\uffff\1\u00da\3\uffff\1\u00db",
			"\1\u00dc\37\uffff\1\u00dc",
			"\1\u00dd\1\u00de\36\uffff\1\u00dd\1\u00de",
			"\1\u00df\37\uffff\1\u00df",
			"\1\u00e0\37\uffff\1\u00e0",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u00e2\37\uffff\1\u00e2",
			"\1\u00e3\37\uffff\1\u00e3",
			"\2\25\13\uffff\12\25\7\uffff\1\u00e5\31\25\4\uffff\1\25\1\uffff\1\u00e5"+
			"\31\25",
			"\1\u00e6\37\uffff\1\u00e6",
			"\1\u00e7\37\uffff\1\u00e7",
			"",
			"",
			"\1\u00e8\37\uffff\1\u00e8",
			"\1\u00e9\37\uffff\1\u00e9",
			"\1\u00ea\37\uffff\1\u00ea",
			"",
			"\1\u00eb\37\uffff\1\u00eb",
			"\1\u00ec\37\uffff\1\u00ec",
			"\1\u00ed\37\uffff\1\u00ed",
			"\1\u00ee\37\uffff\1\u00ee",
			"\1\u00ef\37\uffff\1\u00ef",
			"\1\u00f0\37\uffff\1\u00f0",
			"\1\u00f1\37\uffff\1\u00f1",
			"\2\25\13\uffff\12\25\7\uffff\5\25\1\u00f3\24\25\4\uffff\1\25\1\uffff"+
			"\5\25\1\u00f3\24\25",
			"\1\u00f4\37\uffff\1\u00f4",
			"\1\u00f5\37\uffff\1\u00f5",
			"\1\u00f6\37\uffff\1\u00f6",
			"",
			"\1\u00f7\37\uffff\1\u00f7",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u00f9\37\uffff\1\u00f9",
			"\1\u00fa\37\uffff\1\u00fa",
			"\1\u00fb\37\uffff\1\u00fb",
			"\1\u00fc\37\uffff\1\u00fc",
			"\1\u00fd\37\uffff\1\u00fd",
			"\1\u00fe\37\uffff\1\u00fe",
			"\1\u00ff\37\uffff\1\u00ff",
			"\1\u0100\37\uffff\1\u0100",
			"\1\u0101\37\uffff\1\u0101",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0103\37\uffff\1\u0103",
			"\1\u0104\37\uffff\1\u0104",
			"\1\u0105\37\uffff\1\u0105",
			"\1\u0106\37\uffff\1\u0106",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0109\37\uffff\1\u0109",
			"\1\u010a\37\uffff\1\u010a",
			"\1\u010b\37\uffff\1\u010b",
			"\1\u010c\37\uffff\1\u010c",
			"\1\u010d\37\uffff\1\u010d",
			"\1\u010e\37\uffff\1\u010e",
			"\1\u010f\37\uffff\1\u010f",
			"\1\u0110\37\uffff\1\u0110",
			"\1\u0111\37\uffff\1\u0111",
			"\1\u0112\6\uffff\1\u0113\30\uffff\1\u0112\6\uffff\1\u0113",
			"",
			"\1\u0114\37\uffff\1\u0114",
			"\1\u0115\37\uffff\1\u0115",
			"\1\u0116\37\uffff\1\u0116",
			"\1\u0117\37\uffff\1\u0117",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\u011a\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u011c\37\uffff\1\u011c",
			"\1\u011d\37\uffff\1\u011d",
			"\1\u011e\37\uffff\1\u011e",
			"\1\u011f\37\uffff\1\u011f",
			"\1\u0120\37\uffff\1\u0120",
			"\1\u0121\37\uffff\1\u0121",
			"\1\u0122\37\uffff\1\u0122",
			"\1\u0123\37\uffff\1\u0123",
			"\1\u0124\37\uffff\1\u0124",
			"\1\u0125\37\uffff\1\u0125",
			"\1\u0126\37\uffff\1\u0126",
			"\1\u0127\37\uffff\1\u0127",
			"\1\u0128\37\uffff\1\u0128",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u012a\37\uffff\1\u012a",
			"\1\u012b\37\uffff\1\u012b",
			"\1\u012c\37\uffff\1\u012c",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u012e\37\uffff\1\u012e",
			"\1\u012f\37\uffff\1\u012f",
			"",
			"\1\u0130\37\uffff\1\u0130",
			"\1\u0131\37\uffff\1\u0131",
			"",
			"\1\u0132\37\uffff\1\u0132",
			"\1\u0133\37\uffff\1\u0133",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0135\37\uffff\1\u0135",
			"\1\u0136\37\uffff\1\u0136",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0138\37\uffff\1\u0138",
			"\1\u0139\37\uffff\1\u0139",
			"\1\u013a\37\uffff\1\u013a",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u013c\37\uffff\1\u013c",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u013f\37\uffff\1\u013f",
			"\1\u0140\37\uffff\1\u0140",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0143\37\uffff\1\u0143",
			"",
			"\1\u0144\37\uffff\1\u0144",
			"\1\u0145\37\uffff\1\u0145",
			"\1\u0146\37\uffff\1\u0146",
			"\1\u0147\37\uffff\1\u0147",
			"\1\u0148\37\uffff\1\u0148",
			"\1\u0149\37\uffff\1\u0149",
			"\1\u014a\37\uffff\1\u014a",
			"\1\u014b\37\uffff\1\u014b",
			"\1\u014c\37\uffff\1\u014c",
			"",
			"\1\u014d\37\uffff\1\u014d",
			"\1\u014e\37\uffff\1\u014e",
			"\1\u014f\37\uffff\1\u014f",
			"\1\u0150\37\uffff\1\u0150",
			"",
			"",
			"\1\u0151\37\uffff\1\u0151",
			"\1\u0152\37\uffff\1\u0152",
			"\1\u0153\37\uffff\1\u0153",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0156\37\uffff\1\u0156",
			"\1\u0157\37\uffff\1\u0157",
			"\1\u0158\37\uffff\1\u0158",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u015a\37\uffff\1\u015a",
			"\1\u015b\37\uffff\1\u015b",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u015d\37\uffff\1\u015d",
			"\1\u015e\37\uffff\1\u015e",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"",
			"\1\u0160\37\uffff\1\u0160",
			"",
			"\1\u0161\37\uffff\1\u0161",
			"\1\u0162\37\uffff\1\u0162",
			"\1\u0163\37\uffff\1\u0163",
			"\1\u0164\37\uffff\1\u0164",
			"\1\u0165\37\uffff\1\u0165",
			"\1\u0166\37\uffff\1\u0166",
			"\1\u0167\37\uffff\1\u0167",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0169\37\uffff\1\u0169",
			"\1\u016a\37\uffff\1\u016a",
			"\1\u016b\3\uffff\1\u016c\33\uffff\1\u016b\3\uffff\1\u016c",
			"\1\u016d\37\uffff\1\u016d",
			"\1\u016e\37\uffff\1\u016e",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0170\37\uffff\1\u0170",
			"\1\u0171\37\uffff\1\u0171",
			"",
			"\1\u0172\37\uffff\1\u0172",
			"\1\u0173\37\uffff\1\u0173",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0176\37\uffff\1\u0176",
			"\1\u0177\37\uffff\1\u0177",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0179\37\uffff\1\u0179",
			"",
			"\1\u017a\37\uffff\1\u017a",
			"\1\u017b\37\uffff\1\u017b",
			"\1\u017c\37\uffff\1\u017c",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"",
			"\1\u017e\37\uffff\1\u017e",
			"\1\u017f\37\uffff\1\u017f",
			"",
			"",
			"\1\u0180\37\uffff\1\u0180",
			"\1\u0181\37\uffff\1\u0181",
			"\1\u0182\37\uffff\1\u0182",
			"\1\u0183\37\uffff\1\u0183",
			"\1\u0184\37\uffff\1\u0184",
			"\1\u0185\37\uffff\1\u0185",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0187\37\uffff\1\u0187",
			"\1\u0188\37\uffff\1\u0188",
			"\1\u0189\37\uffff\1\u0189",
			"\1\u018a\37\uffff\1\u018a",
			"\1\u018b\37\uffff\1\u018b",
			"\1\u018c\37\uffff\1\u018c",
			"\1\u018d\37\uffff\1\u018d",
			"\1\u018e\37\uffff\1\u018e",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0190\37\uffff\1\u0190",
			"",
			"",
			"\1\u0191\3\uffff\1\u0192\33\uffff\1\u0191\3\uffff\1\u0192",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u0195\37\uffff\1\u0195",
			"\1\u0196\37\uffff\1\u0196",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0198\37\uffff\1\u0198",
			"",
			"\1\u0199\37\uffff\1\u0199",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u019b\37\uffff\1\u019b",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u019d\37\uffff\1\u019d",
			"\1\u019e\37\uffff\1\u019e",
			"\1\u019f\37\uffff\1\u019f",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01a1\37\uffff\1\u01a1",
			"\1\u01a2\37\uffff\1\u01a2",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01a4\37\uffff\1\u01a4",
			"\1\u01a5\37\uffff\1\u01a5",
			"\1\u01a6\37\uffff\1\u01a6",
			"",
			"\1\u01a7\37\uffff\1\u01a7",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01a9\37\uffff\1\u01a9",
			"\1\u01aa\37\uffff\1\u01aa",
			"",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01ac\37\uffff\1\u01ac",
			"",
			"\2\25\13\uffff\12\25\7\uffff\10\25\1\u01ae\21\25\4\uffff\1\25\1\uffff"+
			"\10\25\1\u01ae\21\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01b0\37\uffff\1\u01b0",
			"\1\u01b1\37\uffff\1\u01b1",
			"",
			"\1\u01b2\37\uffff\1\u01b2",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01b5\37\uffff\1\u01b5",
			"\1\u01b6\37\uffff\1\u01b6",
			"\1\u01b7\37\uffff\1\u01b7",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01b9\37\uffff\1\u01b9",
			"",
			"\1\u01ba\37\uffff\1\u01ba",
			"\1\u01bb\37\uffff\1\u01bb",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01bd",
			"\2\25\13\uffff\12\25\7\uffff\10\25\1\u01bf\21\25\4\uffff\1\25\1\uffff"+
			"\10\25\1\u01bf\21\25",
			"\1\u01c0\37\uffff\1\u01c0",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01c2\37\uffff\1\u01c2",
			"",
			"\1\u01c3\37\uffff\1\u01c3",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01c5\37\uffff\1\u01c5",
			"",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01c7\37\uffff\1\u01c7",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01c9\37\uffff\1\u01c9",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01cb\37\uffff\1\u01cb",
			"\1\u01cc\37\uffff\1\u01cc",
			"\1\u01cd",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01d0\37\uffff\1\u01d0",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01d2\37\uffff\1\u01d2",
			"\1\u01d3\37\uffff\1\u01d3",
			"",
			"\1\u01d4\37\uffff\1\u01d4",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01d6\37\uffff\1\u01d6",
			"",
			"\1\u01d7\37\uffff\1\u01d7",
			"",
			"\1\u01d8\37\uffff\1\u01d8",
			"\1\u01d9\37\uffff\1\u01d9",
			"\1\u01da\37\uffff\1\u01da",
			"",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01dc\37\uffff\1\u01dc",
			"\1\u01dd\37\uffff\1\u01dd",
			"",
			"\1\u01de\37\uffff\1\u01de",
			"\1\u01df\37\uffff\1\u01df",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01e1\37\uffff\1\u01e1",
			"",
			"\1\u01e2\37\uffff\1\u01e2",
			"\1\u01e3\37\uffff\1\u01e3",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01e5\37\uffff\1\u01e5",
			"",
			"\1\u01e6\37\uffff\1\u01e6",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01e8\37\uffff\1\u01e8",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01eb\37\uffff\1\u01eb",
			"",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01ed\37\uffff\1\u01ed",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01ef\37\uffff\1\u01ef",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u01f1\37\uffff\1\u01f1",
			"\1\u01f2\37\uffff\1\u01f2",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01f5",
			"\1\u01f6\37\uffff\1\u01f6",
			"\1\u01f7\37\uffff\1\u01f7",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01f9\37\uffff\1\u01f9",
			"\1\u01fa\37\uffff\1\u01fa",
			"\1\u01fb\37\uffff\1\u01fb",
			"",
			"\1\u01fc\37\uffff\1\u01fc",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u01fe\37\uffff\1\u01fe",
			"",
			"",
			"\1\u01ff\37\uffff\1\u01ff",
			"",
			"\1\u0200\37\uffff\1\u0200",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"",
			"\1\u0204\37\uffff\1\u0204",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\1\u0207\37\uffff\1\u0207",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u020a\37\uffff\1\u020a",
			"",
			"\1\u020b\37\uffff\1\u020b",
			"\1\u020c\37\uffff\1\u020c",
			"\1\u020d\37\uffff\1\u020d",
			"",
			"",
			"",
			"\1\u020e\37\uffff\1\u020e",
			"",
			"",
			"\1\u020f\37\uffff\1\u020f",
			"",
			"",
			"\1\u0210\37\uffff\1\u0210",
			"\1\u0211\37\uffff\1\u0211",
			"\1\u0212\37\uffff\1\u0212",
			"\1\u0213\37\uffff\1\u0213",
			"\1\u0214\37\uffff\1\u0214",
			"\1\u0215\37\uffff\1\u0215",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0217\37\uffff\1\u0217",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u0219\37\uffff\1\u0219",
			"\1\u021a\37\uffff\1\u021a",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\u021e\37\uffff\1\u021e",
			"",
			"",
			"",
			"\1\u021f\37\uffff\1\u021f",
			"\2\25\13\uffff\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			""
	};

	static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
	static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
	static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
	static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
	static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
	static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
	static final short[][] DFA15_transition;

	static {
		int numStates = DFA15_transitionS.length;
		DFA15_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
		}
	}

	protected class DFA15 extends DFA {

		public DFA15(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 15;
			this.eot = DFA15_eot;
			this.eof = DFA15_eof;
			this.min = DFA15_min;
			this.max = DFA15_max;
			this.accept = DFA15_accept;
			this.special = DFA15_special;
			this.transition = DFA15_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( AND | ARRAY | AS | AUTHID | BETWEEN | BODY | BULK | BULK_ROWCOUNT | BY | CASE | CREATE | COLLECT | COMMIT | CURRENT_USER | DEFAULT | DEFINER | DELETE | ELSE | ELSIF | EXTERNAL | FALSE | FETCH | FOR | FORALL | GOTO | IF | IN | INDEX | INSERT | INTO | IS | LANGUAGE | LIKE | LIMIT | LOCK | NOT | NOTFOUND | NULL | OPEN | OR | PACKAGE | RAISE | ROLLBACK | SAVEPOINT | SELECT | SET | SQL | TABLE | TRANSACTION | TRUE | THEN | UPDATE | WHILE | INSERTING | UPDATING | DELETING | ISOPEN | EXISTS | BEGIN | CLOSE | CONSTANT | CONTINUE | CURSOR | DECLARE | DETERMINISTIC | END | EXCEPTION | EXECUTE | EXIT | FUNCTION | IMMEDIATE | LOOP | NOCOPY | OTHERS | OUT | PARALLEL_ENABLE | PIPELINED | PRAGMA | PROCEDURE | RECORD | REF | RESULT_CACHE | RETURN | RETURNING | ROWTYPE | SUBTYPE | USING | VARRAY | VARYING | WHEN | QUOTED_STRING | ID | SEMI | COLON | DOUBLEDOT | DOT | COMMA | EXPONENT | ASTERISK | AT_SIGN | RPAREN | LPAREN | RBRACK | LBRACK | PLUS | MINUS | DIVIDE | EQ | PERCENT | LLABEL | RLABEL | ASSIGN | ARROW | VERTBAR | DOUBLEVERTBAR | NOT_EQ | LTH | LEQ | GTH | GEQ | INTEGER | REAL_NUMBER | WS | SL_COMMENT | ML_COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA15_116 = input.LA(1);
						 
						int index15_116 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA15_116 >= '0' && LA15_116 <= '9')) ) {s = 116;}
						else if ( (LA15_116=='.') && ((numberDotValid()))) {s = 118;}
						else if ( (LA15_116=='e') ) {s = 119;}
						else s = 117;
						 
						input.seek(index15_116);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA15_41 = input.LA(1);
						 
						int index15_41 = input.index();
						input.rewind();
						s = -1;
						if ( ((LA15_41 >= '0' && LA15_41 <= '9')) ) {s = 116;}
						else if ( (LA15_41=='.') && ((numberDotValid()))) {s = 118;}
						else if ( (LA15_41=='e') ) {s = 119;}
						else s = 117;
						 
						input.seek(index15_41);
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 15, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
