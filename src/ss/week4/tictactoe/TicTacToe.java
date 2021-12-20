package ss.week4.tictactoe;

import ss.utils.TextIO;

public class TicTacToe {
    public static void main(String[] args) {
        //System.out.print("Please provide your names separated by space:\n");

        Player player1;
        Player player2;

        if (args.length!=0){
            player1 = new HumanPlayer(args[0], Mark.XX);
            player2 = new HumanPlayer(args[1], Mark.OO);
        } else{
            System.out.print("Please provide name of first player:\n");
            String input1 = TextIO.getln();
            player1 = new HumanPlayer(input1, Mark.XX);
            System.out.print("Please provide name of second player:\n");
            String input2 = TextIO.getln();
            player2 = new HumanPlayer(input2, Mark.OO);
        }

        Game game = new Game (player1, player2);
        game.start();
    }

}
