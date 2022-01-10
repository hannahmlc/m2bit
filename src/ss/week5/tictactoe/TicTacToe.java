package ss.week5.tictactoe;

import ss.utils.TextIO;
import ss.week4.tictactoe.Mark;

public class TicTacToe {
    public static void main(String[] args) {
        //System.out.print("Please provide your names separated by space:\n");

        Player player1;
        Player player2;

        if (args.length!=0){
            player1 = determineType(args[0],Mark.XX);
            player2 = determineType(args[1], Mark.OO);
        } else{
            System.out.print("Please provide name of first player:\n");
            String input1 = TextIO.getln();
            player1 = determineType(input1,Mark.XX);
            System.out.print("Please provide name of second player:\n");
            String input2 = TextIO.getln();
            player2 = determineType(input2,Mark.OO);
        }

        Game game = new Game (player1, player2);
        game.start();
    }

    static Player determineType(String input, Mark mark){
        Player player;
        if (input.equals("-N")){
            player = new ComputerPlayer(mark);
        }else if (input.equals("-S")){
            player = new ComputerPlayer(mark,new SmartStrategy());
        } else{
            player = new HumanPlayer(input, mark);
        }
        return player;
    }
}