package ss.week2.hotel;

public class Hotel {

    private Guest guest;
    private Room room101 = new Room(101);
    private Room room102 = new Room(102);
    private String hotelName;


    public Hotel(String hname){
        this.hotelName = hname;
    }
    /**
     * receives one String object as parameter, indicating the name of the guest
     * @param name guest name
     * @return  Room with a (new) Guest of the given name checked in, or null in case there is already a guest with this name or the hotel is full.
     */
    public Room checkIn(String name){
        assert name != null;
        guest = new Guest(name);
        Room room = getFreeRoom();
        if (guest.getRoom() == null && room!=null){
            guest.checkin(room);
        }
        return room;
    }



    /**
     * upon receiving guest name, the guest is checked out,
     * safe in the room is deactivates
     * nothing happens if there is no guest with this name
     * @param name nme of a guest
     * @ensures Room is set to null
     */
        public void checkOut(String name){
                Room room = this.getRoom(name);
                if(room != null){
                    room.getSafe().deactivate();
                    room.setGuest(null);
                    guest.checkout();
                }
        }


    /**
     *returns the Room into which the guest can check in, otherwise returns null
     * @return room that is free or null
     */
    public Room getFreeRoom(){
        if (room101.getGuest() == null){
            return room101;
        } else if (room102.getGuest() == null){
            return room102;
        } else return null;

    }

    //• A query getRoom that

    /**
     * upon receiving guest name, returns the Room  into which the guest is checked in
     * if the guest cannot be found in any room returns null
     * @param name guest name
     * @return room occupied by guest
     */
    public Room getRoom(String name){
            if (guest != null && ( room101.getGuest() != null || room102.getGuest()!= null )) {
                return guest.getRoom();
            } else {
                return null;
            }
    }

    /**
     * gives a textual description of all rooms in the hotel,
     * including name of the guest and the status of the safe in that room
     * @return textual description of all rooms in hotel
     */
    public String toString(){
        return "Hotel Name : " + hotelName + " " + room101.getGuest() + " " + room102.getGuest();
    }


}
