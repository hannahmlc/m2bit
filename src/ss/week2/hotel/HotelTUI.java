package ss.week2.hotel;

import ss.utils.TextIO;

public class HotelTUI {

    private Hotel hotel;

    //constructor with the name of the hotel as argument
    public HotelTUI(String hotelName) {
        this.hotel = new Hotel(hotelName);
    }

    public static void main(String[] args) {
        (new HotelTUI("U Parkhotel")).start();
    }

    public void start(){

        boolean exit = false;
        printHelpMenu();


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
                    case "i":
                        if(param == null)
                            System.out.println("ERROR, incorrect input");
                        else if (hotel.getFreeRoom() != null ){
                            hotel.checkIn(param);
                            System.out.println("Guest " + param + " is checked into room " + hotel.getRoom(param));
                        }else
                            System.out.println("Hotel is full ");
                        break;

                    case "o":
                        if(param == null)
                            System.out.println("ERROR, incorrect input");
                        //else if (room.availability)
                           // System.out.println("ERROR, room not taken by any guest");
                        else{
                            System.out.println("Guest " + param + " successfully checked out from room " +  hotel.getRoom(param));
                            hotel.checkOut(param);
                        }
                        break;

                    case "r":
                        if (param == null)
                            System.out.println("ERROR, incorrect input");
                        else if(hotel.getRoom(param) == null)
                            System.out.println("Guest not found");
                        else
                            System.out.println("Guest " + param + " has room " + hotel.getRoom(param));
                        break;

                    case "p":
                        //print hotel ifo
                        System.out.println(hotel.toString());
                        break;

                    case "h":
                        printHelpMenu();
                        break;

                    case "x":
                        exit = true;
                        System.out.println("You have left the hotel system");
                        break;

                    default:
                        System.out.println("ERROR, incorrect input");

                }
            }
        }
    }


    public void printHelpMenu(){
        System.out.println("Welcome to the Hotel booking system of the U Parkhotel\n" +
            "Commands :\n" +
            "i name ........... checkin guest with name\n" +
            "o name ........... checkout guest with name\n" +
            "r name ........... request room of guest\n" +
            "a name ........... activate safe\n" +
            "h ................ help ( this menu )\n" +
            "p ................ print state\n" +
            "x ................ exit\n");
    }

}


