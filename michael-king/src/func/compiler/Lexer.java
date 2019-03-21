/* The following code was generated by JFlex 1.6.1 */

package func.compiler;

import java.io.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>func.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\2\36\1\36\1\37\1\36\1\36\22\0\1\36\7\0\1\32"+
    "\1\33\2\0\1\4\3\0\12\1\1\5\1\3\1\0\1\6\3\0"+
    "\4\2\1\34\25\2\6\0\1\30\1\20\1\2\1\17\1\13\1\10"+
    "\1\21\1\12\1\7\2\2\1\15\1\22\1\14\1\23\1\27\1\35"+
    "\1\24\1\16\1\11\1\25\1\31\1\26\3\2\12\0\1\37\u1fa2\0"+
    "\1\37\1\37\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\13\3"+
    "\1\6\1\7\1\10\1\11\1\12\4\3\1\13\15\3"+
    "\1\14\12\3\1\15\3\3\1\16\1\17\3\3\1\20"+
    "\3\3\1\21\1\22\1\23\3\3\1\24\2\3\1\25"+
    "\1\26\1\27\2\3\1\30\1\31\1\32\3\3\1\33"+
    "\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[87];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\40\0\100\0\140\0\40\0\40\0\200\0\240"+
    "\0\300\0\340\0\u0100\0\u0120\0\u0140\0\u0160\0\u0180\0\u01a0"+
    "\0\u01c0\0\u01e0\0\40\0\40\0\u0200\0\40\0\140\0\u0220"+
    "\0\u0240\0\u0260\0\u0280\0\140\0\u02a0\0\u02c0\0\u02e0\0\u0300"+
    "\0\u0320\0\u0340\0\u0360\0\u0380\0\u03a0\0\u03c0\0\u03e0\0\u0400"+
    "\0\u0420\0\140\0\u0440\0\u0460\0\u0480\0\u04a0\0\u04c0\0\u04e0"+
    "\0\u0500\0\u0520\0\u0540\0\u0560\0\140\0\u0580\0\u05a0\0\u05c0"+
    "\0\140\0\u05e0\0\u0600\0\u0620\0\u0640\0\140\0\u0660\0\u0680"+
    "\0\u06a0\0\140\0\140\0\140\0\u06c0\0\u06e0\0\u0700\0\140"+
    "\0\u0720\0\u0740\0\140\0\140\0\140\0\u0760\0\u0780\0\140"+
    "\0\140\0\140\0\u07a0\0\u07c0\0\u07e0\0\140\0\140";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[87];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\2\1\10"+
    "\1\4\1\11\1\4\1\12\1\13\1\14\2\4\1\15"+
    "\1\4\1\16\1\4\1\17\1\4\1\20\1\21\1\4"+
    "\1\22\1\23\1\24\2\4\1\25\42\0\1\3\37\0"+
    "\2\4\4\0\23\4\2\0\2\4\10\0\1\26\32\0"+
    "\2\4\4\0\1\4\1\27\3\4\1\30\15\4\2\0"+
    "\2\4\3\0\2\4\4\0\3\4\1\31\17\4\2\0"+
    "\2\4\3\0\2\4\4\0\5\4\1\32\1\33\14\4"+
    "\2\0\1\4\1\34\3\0\2\4\4\0\23\4\2\0"+
    "\1\35\1\4\3\0\2\4\4\0\4\4\1\36\16\4"+
    "\2\0\2\4\3\0\2\4\4\0\4\4\1\37\16\4"+
    "\2\0\2\4\3\0\2\4\4\0\4\4\1\40\16\4"+
    "\2\0\2\4\3\0\2\4\4\0\4\4\1\41\16\4"+
    "\2\0\2\4\3\0\2\4\4\0\3\4\1\42\11\4"+
    "\1\43\5\4\2\0\2\4\3\0\2\4\4\0\15\4"+
    "\1\44\5\4\2\0\2\4\3\0\2\4\4\0\21\4"+
    "\1\45\1\4\2\0\2\4\40\0\1\25\2\0\2\4"+
    "\4\0\20\4\1\46\2\4\2\0\2\4\3\0\2\4"+
    "\4\0\4\4\1\47\16\4\2\0\2\4\3\0\2\4"+
    "\4\0\10\4\1\50\12\4\2\0\2\4\3\0\2\4"+
    "\4\0\7\4\1\51\13\4\2\0\2\4\3\0\2\4"+
    "\4\0\23\4\2\0\1\4\1\52\3\0\2\4\4\0"+
    "\7\4\1\53\13\4\2\0\2\4\3\0\2\4\4\0"+
    "\12\4\1\54\10\4\2\0\2\4\3\0\2\4\4\0"+
    "\2\4\1\55\20\4\2\0\2\4\3\0\2\4\4\0"+
    "\2\4\1\56\16\4\1\57\1\4\2\0\2\4\3\0"+
    "\2\4\4\0\1\60\22\4\2\0\2\4\3\0\2\4"+
    "\4\0\1\61\22\4\2\0\2\4\3\0\2\4\4\0"+
    "\1\62\22\4\2\0\2\4\3\0\2\4\4\0\15\4"+
    "\1\63\5\4\2\0\2\4\3\0\2\4\4\0\16\4"+
    "\1\64\4\4\2\0\2\4\3\0\2\4\4\0\5\4"+
    "\1\65\15\4\2\0\2\4\3\0\2\4\4\0\1\66"+
    "\12\4\1\67\3\4\1\70\3\4\2\0\2\4\3\0"+
    "\2\4\4\0\4\4\1\71\16\4\2\0\2\4\3\0"+
    "\2\4\4\0\7\4\1\72\13\4\2\0\2\4\3\0"+
    "\2\4\4\0\1\73\22\4\2\0\2\4\3\0\2\4"+
    "\4\0\3\4\1\74\17\4\2\0\2\4\3\0\2\4"+
    "\4\0\16\4\1\75\4\4\2\0\2\4\3\0\2\4"+
    "\4\0\10\4\1\76\12\4\2\0\2\4\3\0\2\4"+
    "\4\0\6\4\1\77\14\4\2\0\2\4\3\0\2\4"+
    "\4\0\2\4\1\100\20\4\2\0\2\4\3\0\2\4"+
    "\4\0\5\4\1\101\15\4\2\0\2\4\3\0\2\4"+
    "\4\0\7\4\1\102\13\4\2\0\2\4\3\0\2\4"+
    "\4\0\2\4\1\103\20\4\2\0\2\4\3\0\2\4"+
    "\4\0\1\4\1\104\21\4\2\0\2\4\3\0\2\4"+
    "\4\0\4\4\1\105\16\4\2\0\2\4\3\0\2\4"+
    "\4\0\3\4\1\106\17\4\2\0\2\4\3\0\2\4"+
    "\4\0\23\4\2\0\1\107\1\4\3\0\2\4\4\0"+
    "\5\4\1\110\15\4\2\0\2\4\3\0\2\4\4\0"+
    "\14\4\1\111\6\4\2\0\2\4\3\0\2\4\4\0"+
    "\15\4\1\112\5\4\2\0\2\4\3\0\2\4\4\0"+
    "\4\4\1\113\16\4\2\0\2\4\3\0\2\4\4\0"+
    "\4\4\1\114\16\4\2\0\2\4\3\0\2\4\4\0"+
    "\2\4\1\115\20\4\2\0\2\4\3\0\2\4\4\0"+
    "\2\4\1\116\20\4\2\0\2\4\3\0\2\4\4\0"+
    "\1\117\22\4\2\0\2\4\3\0\2\4\4\0\23\4"+
    "\2\0\1\4\1\120\3\0\2\4\4\0\10\4\1\121"+
    "\12\4\2\0\2\4\3\0\2\4\4\0\5\4\1\122"+
    "\15\4\2\0\2\4\3\0\2\4\4\0\3\4\1\123"+
    "\17\4\2\0\2\4\3\0\2\4\4\0\6\4\1\124"+
    "\14\4\2\0\2\4\3\0\2\4\4\0\14\4\1\125"+
    "\6\4\2\0\2\4\3\0\2\4\4\0\4\4\1\126"+
    "\16\4\2\0\2\4\3\0\2\4\4\0\10\4\1\127"+
    "\12\4\2\0\2\4\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2048];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\2\11\14\1\2\11\1\1\1\11"+
    "\101\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[87];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
  enum Yytoken{
    SEMI, COMMA, ASSIGN, IF, THEN, ELSE, ENDIF, BEGIN, METHOD, RETURN, ENDWHILE, ENDMETHOD, WHILE, INPUT, READ, WRITE, 
    PRINT, VARS, LBRA, RBRA, LT, LTE, EQ, NEQ, INT, ID, EOF
  }



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 138) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Yytoken yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
              {
                return Yytoken.EOF;
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Unexpected character ["+yytext()+"]");
            }
          case 29: break;
          case 2: 
            { return Yytoken.INT;
            }
          case 30: break;
          case 3: 
            { return Yytoken.ID;
            }
          case 31: break;
          case 4: 
            { return Yytoken.SEMI;
            }
          case 32: break;
          case 5: 
            { return Yytoken.COMMA;
            }
          case 33: break;
          case 6: 
            { return Yytoken.LBRA;
            }
          case 34: break;
          case 7: 
            { return Yytoken.RBRA;
            }
          case 35: break;
          case 8: 
            { /* eat whitespace */
            }
          case 36: break;
          case 9: 
            { return Yytoken.ASSIGN;
            }
          case 37: break;
          case 10: 
            { return Yytoken.IF;
            }
          case 38: break;
          case 11: 
            { return Yytoken.EQ;
            }
          case 39: break;
          case 12: 
            { return Yytoken.NEQ;
            }
          case 40: break;
          case 13: 
            { return Yytoken.THEN;
            }
          case 41: break;
          case 14: 
            { return Yytoken.ELSE;
            }
          case 42: break;
          case 15: 
            { return Yytoken.LT;
            }
          case 43: break;
          case 16: 
            { return Yytoken.READ;
            }
          case 44: break;
          case 17: 
            { return Yytoken.VARS;
            }
          case 45: break;
          case 18: 
            { return Yytoken.INPUT;
            }
          case 46: break;
          case 19: 
            { return Yytoken.ENDIF;
            }
          case 47: break;
          case 20: 
            { return Yytoken.BEGIN;
            }
          case 48: break;
          case 21: 
            { return Yytoken.WHILE;
            }
          case 49: break;
          case 22: 
            { return Yytoken.WRITE;
            }
          case 50: break;
          case 23: 
            { return Yytoken.PRINT;
            }
          case 51: break;
          case 24: 
            { return Yytoken.LTE;
            }
          case 52: break;
          case 25: 
            { return Yytoken.METHOD;
            }
          case 53: break;
          case 26: 
            { return Yytoken.RETURN;
            }
          case 54: break;
          case 27: 
            { return Yytoken.ENDWHILE;
            }
          case 55: break;
          case 28: 
            { return Yytoken.ENDMETHOD;
            }
          case 56: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}