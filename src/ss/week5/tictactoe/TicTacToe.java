package ss.week5.tictactoe;

import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.HumanPlayer;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

public class TicTacToe {
        public static void main(String[] args) {
            //System.out.print("Please provide your names separated by space:\n");

            ss.week4.tictactoe.Player player1 = new HumanPlayer(args[0], Mark.XX);
            Player player2 = new HumanPlayer(args[1], Mark.OO);

            Game game = new Game (player1, player2);
            game.start();
        }

}


