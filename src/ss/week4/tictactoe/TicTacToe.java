package ss.week4.tictactoe;
import ss.utils.TextIO;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.print("Please provide your names separated by space:\n");
        String[] players = TextIO.getlnString().split(" ", 2);
        HumanPlayer player1 = new HumanPlayer(players[0], Mark.OO);
        HumanPlayer player2 = new HumanPlayer(players[1], Mark.XX);
        new Game(player1, player2).start();
    }

}
