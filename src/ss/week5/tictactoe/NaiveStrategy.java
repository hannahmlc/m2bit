package ss.week5.tictactoe;

import java.util.ArrayList;
import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public class NaiveStrategy implements Strategy{
    /**
     * @return the name of the strategy;
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * @param board the current game board
     * @param mark  - mark of the player
     * @return next legal move
     */
    @Override
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
