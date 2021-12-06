package ss.week1.hotel;

import ss.utils.TextIO;

class Room{
    boolean availability; //is the room taken
    String guest; //guest name
    String hotelname; //name of hotel
    String name; // room name
}

public class HotelTUI {
    private static final String MENU = "Commands :\n" +
        "i name ........... check in guest with name\n" +
        "o name ........... check out guest with name\n" +
        "r name ........... request room of guest\n" +
        "h ................ help ( this menu )\n" +
        "p ................ print state\n" +
        "x ................ exit\n";

    static final String IN = "i";
    static final String OUT = "o";
    static final String ROOM = "r";
    static final String HELP = "h";
    static final String PRINT = "p";
    static final String EXIT = "x";

        public static void main(String[] args){

            Room room = new Room();
            room.availability = true;
            room.name = "101";
            room.hotelname = "U Parkhotel";

            //System.out.print("Welcome to the Hotel booking system of the " + room.hotelname + "\n" + MENU);

            boolean exit = false;
            while(!exit){
                //System.out.printf("Command: ");
                String input = TextIO.getln();
                String [] split = input.split("\\s+");
                String command = split[0];
                String param = null;
                if (split.length>1){
                    param = split[1]; }

                if (command.length()==1){ //if command had one letter
                    switch (command){
                        case IN:
                            if(param == null)
                                System.out.println("ERROR, incorrect input");
                            else if (room.availability ){
                                room.guest = param;
                                room.availability = false;
                                System.out.println("Guest " + room.guest + " is checked into room " + room.name);
                            }else
                                System.out.println("Room is taken ");
                            break;

                        case OUT:
                            if(param == null)
                                System.out.println("ERROR, incorrect input");
                            else if (room.availability)
                                System.out.println("ERROR, room not taken by any guest");
                            else{
                                System.out.println("Guest " + room.guest + " successfully checked out.");
                                room.availability = true;
                                room.guest = null;
                            }
                            break;

                        case ROOM:
                            if (param == null)
                                System.out.println("ERROR, incorrect input");
                            else if(!(room.guest.equals(param)))
                                System.out.println("guest not found");
                            else
                                System.out.println("Guest " + room.guest + " has room " + room.name);
                            break;

                        case PRINT:
                            //print hotel ifo
                            if (room.availability){
                                System.out.println("Hotel " + room.hotelname + ":\n" +
                                    "> Room " + room.name + ": empty");
                            }else {
                                System.out.println("Hotel " + room.hotelname + ":\n" +
                                    "> Room " + room.name + ": taken by " + room.guest);}
                            break;

                        case HELP:
                            System.out.print(MENU);
                            break;

                        case EXIT:
                            exit = true;
                            //System.out.println("You have left the hotel system");
                            break;

                        default:
                            System.out.println("ERROR, incorrect input");

                    }
                }
            }
        }


}
