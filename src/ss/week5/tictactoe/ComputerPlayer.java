package ss.week5.tictactoe;

public class ComputerPlayer extends Player{

    private Strategy strategy;

    /**
     * constructs a computer player using the given mark and strategy
     * @param mark - mark of the player
     * @param strategy - player's strategy
     */
    public ComputerPlayer (Mark mark, Strategy strategy){
        super(strategy.getName() + "-" + mark.toString(), mark);
        this.strategy = strategy;
    }

    /**
     * constructs a computer player using the given mark and naive strategy.
     * @param mark
     */
    public ComputerPlayer (Mark mark) {
        this(mark, new NaiveStrategy());}

        /**
         * Determines the field for the next move.
         *
         * @param board the current game board
         * @return the player's choice
         * @requires board is not null and not full
         * @ensures the returned in is a valid field index and that field is empty
         */
    @Override
    public int determineMove(Board board) {
        int move = strategy.determineMove(board,super.getMark());
        return move;
    }


    public Strategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
