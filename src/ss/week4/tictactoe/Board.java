package ss.week4.tictactoe;

/**
 * Board for the Tic Tac Toe game. Module 2 lab assignment.
 *
 * @author Theo Ruys en Arend Rensink
 * @version $Revision: 1.4 $
 */
public class Board {
    public static final int DIM = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * The DIM by DIM fields of the Tic Tac Toe board. See NUMBERING for the
     * coding of the fields.
     * @invariant there are always DIM*DIM fields
     * @invariant all fields are either Mark.EMPTY, Mark.XX or Mark.OO
     */
    private final Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     * @ensures all fields are EMPTY
     */
    public Board() {
        fields = new Mark[DIM*DIM];
        reset();
    }

    /**
     * Creates a deep copy of this field.
     * @ensures the result is a new object, so not this object
     * @ensures the values of all fields of the copy match the ones of this Board
     */
    public Board deepCopy() {
        Board deepCopy = new Board();
        for(int i = 0; i<9;i++){
            deepCopy.fields[i] = fields[i];
        }
        return deepCopy;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @requires row to be between 0 and DIM
     * @requires col to be between 0 and DIM
     * @return the index belonging to the (row,col)-field
     */
    public int index(int row, int col) {
        int index = (row * Board.DIM) + col;
        return index;
    }

    /**
     * Returns true if index is a valid index of a field on the board.
     * @ensures a positive result when the index is between 0 and DIM*DIM
     * @return true if 0 <= index < DIM*DIM
     */
    public boolean isField(int index) {
        return (index < (Board.DIM * Board.DIM) && index>=0);
    }

    /**
     * Returns true of the (row,col) pair refers to a valid field on the board.
     * @ensures true when both row and col are within the board's bounds
     * @return true if 0 <= row < DIM && 0 <= col < DIM
     */
    public boolean isField(int row, int col) {
        return ( row >=0 && row < Board.DIM && col >=0 && col < Board.DIM);
    }
    
    /**
     * Returns the content of the field i.
     * @requires i to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param i the number of the field (see NUMBERING)
     * @return the mark on the field
     */
    public Mark getField(int i) {
        return fields[i];
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     * @requires (row, col) to be a valid field
     * @ensures the result to be either EMPTY, XX or OO
     * @param row the row of the field
     * @param col the column of the field
     * @return the mark on the field
     */
    public Mark getField(int row, int col) {
    	int index = index(row,col);
        return fields[index];
    }

    /**
     * Returns true if the field i is empty.
     * @requires i to be a valid field index
     * @ensures true when the Mark at index i is EMPTY
     * @param i the index of the field (see NUMBERING)
     * @return true if the field is empty
     */
    public boolean isEmptyField(int i) {
        if (isField(i)){
            return getField(i)==Mark.EMPTY;
        } else return false;
    }

    /**
     * Returns true if the field referred to by the (row,col) pair it empty.
     * @requires (row, col) to be a valid field
     * @ensures true when the Mark at (row, col) is EMPTY
     * @param row the row of the field
     * @param col the column of the field
     * @return true if the field is empty
     */
    public boolean isEmptyField(int row, int col) {
    	int index = index(row,col);
        if (isField(index)) {
            return getField(index)==Mark.EMPTY;
        } else return false;
    }

    /**
     * Tests if the whole board is full.
     * @ensures true if all fields are occupied
     * @return true if all fields are occupied
     */
    public boolean isFull() {
    	for (int i = 0; i< Board.DIM * Board.DIM; i++){
            if (getField(i) ==Mark.EMPTY) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     * @ensures true if the board is full or when there is a winner
     * @return true if the game is over
     */
    public boolean gameOver() {
        return (hasWinner() || isFull() );
    }

    /**
     * Checks whether there is a row which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a row controlled by m
     */
    public boolean hasRow(Mark m) {
        boolean hasRow = false;

        for (int row = 0; row < DIM; row++) {
            boolean sameMark = true;
            for (int col = 0; col < DIM; col++) {
                if (getField(row,col) != m) {
                    sameMark = false;
                }
            }
            if (sameMark) {
                hasRow = true;
                break;
            }
        }
        return hasRow;
    }

    /**
     * Checks whether there is a column which is full and only contains the mark
     * m.
     * @param m the Mark of interest
     * @return true if there is a column controlled by m
     */
    public boolean hasColumn(Mark m) {
        boolean hasColumn = false;

        for (int row = 0; row < DIM; row++) {
            boolean sameMark = true;
            for (int col = 0; col < DIM; col++) {
                if (getField(col,row) != m) {
                    sameMark = false;
                }
            }
            if (sameMark) {
                hasColumn = true;
                break;
            }
        }
        return hasColumn;
    }

    /**
     * Checks whether there is a diagonal which is full and only contains the
     * mark m.
     * @param m the Mark of interest
     * @return true if there is a diagonal controlled by m
     */
    public boolean hasDiagonal(Mark m) {
        boolean hasDiagonal = false;
        boolean left = true; // for the line starting from top left
        boolean right = true; //// for the line starting from top right
        for (int i = 0; i < Board.DIM; i++) {
            //check for line from top left
            if (!getField(i, i).equals(m)) {
                left = false;
            }
            //check for lien from top right
            if (!getField(Board.DIM - i - 1, i).equals(m)) {
                right = false;
            }
            hasDiagonal = left || right;
        }
        return hasDiagonal;
    }

    /**
     * Checks if the mark m has won. A mark wins if it controls at
     * least one row, column or diagonal.
     * @requires m to be either XX or OO
     * @ensures true when m has a row, column or diagonal 
     * @param m the mark of interest
     * @return true if the mark has won
     */
    public boolean isWinner(Mark m) {
        return (hasColumn(m) || hasRow(m) || hasDiagonal(m));
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     * @ensures true when either XX or OO has won
     * @return true if the student has a winner.
     */
    public boolean hasWinner() {
        return (isWinner(Mark.XX) || isWinner(Mark.OO));
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     *
     * @return the game situation as String
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < DIM; i++) {
            String row = "";
            for (int j = 0; j < DIM; j++) {
                row = row + " " + getField(i, j).toString() + " ";
                if (j < DIM - 1) {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < DIM - 1) {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Mark.EMPTY).
     * @ensures all fields are EMPTY
     */
    public void reset() {
    	for (int i=0;i< DIM*DIM;i++){
            setField(i, Mark.EMPTY);
        }
    }

    /**
     * Sets the content of field i to the mark m.
     * @requires i to be a valid field
     * @ensures field i to be set to Mark m
     * @param i the field number (see NUMBERING)
     * @param m the mark to be placed
     */
    public void setField(int i, Mark m) {
    	fields[i]=m;
    }

    /**
     * Sets the content of the field represented by the (row,col) pair to the
     * mark m.
     * @requires (row, col) to be a valid field
     * @ensures field (row, col) to be set to Mark m
     * @param row the field's row
     * @param col the field's column
     * @param m the mark to be placed
     */
    public void setField(int row, int col, Mark m) {
        int index = index(row,col);
        setField(index, m);
    }
}
