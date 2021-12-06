package ss.week1;

import ss.utils.TextIO;


enum state{
    OFF,//state 1
    LOW, //state 2
    MEDIUM,  //state 3
    HIGH, //state 4
    NEXT,
    HELP,
    EXIT,
    STATE
}

public class ThreeWayLamp {
    public static void main (String []args){

        //System.out.println("Enter the input, enter help for the list of possible inputs");
        boolean exit = false;
        int LampState = 0; //current state of the lamp
        state input;
        while(!exit) {

            input = ss.week1.state.valueOf(TextIO.getln());

            switch (input) {
                case OFF:
                    LampState = 1;
                    System.out.println("Set light to off");
                    break;
                case LOW:
                    LampState = 2;
                    System.out.println("Set light to low");
                    break;
                case MEDIUM:
                    LampState = 3;
                    System.out.println("Set light to medium");
                    break;
                case HIGH:
                    LampState = 4;
                    System.out.println("Set light to high");
                    break;
                case STATE:
                    System.out.println("Current state: " + state.values()[LampState-1]);
                    break;
                case NEXT:
                    LampState += 1;
                    if (LampState > 4) {
                        LampState = 1;
                    }
                    System.out.println("State changed to:" + state.values()[LampState-1]);
                    break;
                case HELP:
                    System.out.println("Possible inputs:");
                    System.out.println("OFF: Set the lamp to OFF (default value)");
                    System.out.println("LOW: Set the lamp to LOW)");
                    System.out.println("MEDIUM: Set the lamp to MEDIUM");
                    System.out.println("HIGH: Set the lamp to HIGH");
                    System.out.println("STATE: Print the current setting of the lamp");
                    System.out.println("NEXT: Change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH → OFF");
                    System.out.println("HELP: Show a help menu");
                    System.out.println("EXIT: Quit the program");
                    break;
                case EXIT:
                    System.out.println("You have exited the program");
                    exit = true;
                    break;
                default:
                    System.out.println("Given input is incorrect");
                    break;

            }

        }

    }
}
