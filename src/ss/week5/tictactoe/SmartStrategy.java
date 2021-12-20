package ss.week5.tictactoe;

import java.util.ArrayList;

public class SmartStrategy implements Strategy {
    /**
     * @return the name of the strategy;
     */
    @Override
    public String getName() {
        return "Smart";
    }


    /**
     * @param board the current game board
     * @param mark  - mark of the player
     * @return next legal move
     */
    @Override
    public int determineMove(Board board, Mark mark) {
        Board deepCopy = board.deepCopy();
        Mark otherMark; // mark of the opponent
        ArrayList<Integer> emptyFields = new ArrayList();
        if (mark == Mark.XX) {
            otherMark = Mark.OO;
        } else{
            otherMark = Mark.XX;
        }

        //If the middle field is empty, this field is selected;
        int middle = (board.DIM*board.DIM)/2;
        if (board.isEmptyField(middle)) {
            return middle;
        }

        for (int i=0; i<Board.DIM*Board.DIM;i++){
            if (board.isEmptyField(i)){
                emptyFields.add(i);
            }

            //If there is a field that guarantees a direct win, this field is selected.
            deepCopy.setField(i, mark);
            if (deepCopy.isWinner(mark)) {
                return i;
            }

            //If there is a field with which the opponent could win, this field is selected.
            deepCopy.setField(i, otherMark);
            if (deepCopy.isWinner(otherMark)) {
                return i;
            }
            deepCopy.setField(i, Mark.EMPTY);
        }

            // If none of the cases above applies, a random field is selected.
            return emptyFields.get((int)(Math.random()*(emptyFields.size()-1)));
        }
}
