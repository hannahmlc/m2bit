package ss.week5.tictactoe;

import java.util.ArrayList;

public class NaiveStrategy implements Strategy{
    /**
     * @return the name of the strategy;
     */
    @Override
    public String getName() {
        return "Naive";
    }

    /**
     * @param board the current game board
     * @param mark  - mark of the player
     * @return next legal move
     */
    public int determineMove(Board board, Mark mark) {
        ArrayList<Integer> emptyFields = new ArrayList();
        for (int i=0; i<Board.DIM*Board.DIM;i++){
            if (board.isEmptyField(i)){
                emptyFields.add(i);
            }
        }
        return emptyFields.get((int)(Math.random()*(emptyFields.size()-1)));
    }
}
