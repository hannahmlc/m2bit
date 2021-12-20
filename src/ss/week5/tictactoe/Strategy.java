package ss.week5.tictactoe;
import ss.week4.tictactoe.*;

public interface Strategy {

    /**
     * @return the name of the strategy;
     */
    public String getName() ;

    /**
     * @param board the current game board
     * @param mark - mark of the player
     * @return next legal move
     */
    public int determineMove(Board board, Mark mark);

}
