package ss.week2;
import ss.utils.TextIO;


public class ThreeWayLampTUI {

    public static void main(String [] args){

        boolean exit = false;
        ThreeWayLamp lamp = new ThreeWayLamp();

        States input; // user input from keyboard

        while (!exit){
            printMenu();
            input = States.valueOf(TextIO.getln());

            switch (input) {
                case OFF:
                    lamp.setState(States.OFF);
                    System.out.println("Set light to off");
                    break;
                case LOW:
                    lamp.setState(States.LOW);
                    System.out.println("Set light to low");
                    break;
                case MEDIUM:
                    lamp.setState(States.MEDIUM);
                    System.out.println("Set light to medium");
                    break;
                case HIGH:
                    lamp.setState(States.HIGH);
                    System.out.println("Set light to high");
                    break;
                case STATE:
                    System.out.println(lamp.getState());
                    break;
                case NEXT:
                    lamp.nextState();
                    System.out.println("State changed to:" + lamp.getState() );
                    break;
                case HELP:
                    printMenu();
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

    private static void printMenu() {
        System.out.println ("OFF: Set the lamp to OFF (default value)\n" +
        "• LOW: Set the lamp to LOW\n" +
        "• MEDIUM: Set the lamp to MEDIUM\n" +
        "• HIGH: Set the lamp to HIGH\n" +
        "• STATE: Print the current setting of the lamp\n" +
        "• NEXT: Change to the next setting, observing the order OFF → LOW → MEDIUM → HIGH →\n" +
        "OFF\n" +
        "• HELP: Show a help menu, explaining how the user should interact with the program\n" +
        "• EXIT: Quit the program");
    }




}
