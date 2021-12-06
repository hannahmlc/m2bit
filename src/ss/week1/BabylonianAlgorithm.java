package ss.week1;

import ss.utils.TextIO;

public class BabylonianAlgorithm {


    public static void main (String []args){
       System.out.println("give a number: ");
       double n = TextIO.getDouble();
       double guess = n/2;
       double oldguess = guess; // previous guess
        System.out.println(guess);
       double difference = 1;
       double r;
       while (Math.abs(difference)>=0.01){
           r = n/guess;
           guess = (guess + r) / 2;
           difference = (guess-oldguess)/oldguess;
           oldguess = guess;
           System.out.printf("%.2f%n",guess);
       }





    }


}
