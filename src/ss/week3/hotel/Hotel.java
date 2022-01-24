package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.bill.Printer;

public class Hotel {
    private Guest guest;
    public static int ROOM_PRICE =11;
    public static int SAFE_PRICE =11;
    private PricedRoom room101 = new PricedRoom(101, ROOM_PRICE, SAFE_PRICE);
    private Room room102 = new Room(102);
    private String hotelName;
    private Bill bill;

    public Hotel(String hname) {
        this.hotelName = hname;
    }

    /**
     * receives one String object as parameter, indicating the name of the guest
     *
     * @param name guest name
     * @return Room with a (new) Guest of the given name checked in, or null in case there is already a guest with this name or the hotel is full.
     */
    public Room checkIn(String name){
        guest = new Guest(name);
        Room room = null;
        room = getFreeRoom();
        if (guest.getRoom() == null && room!=null && room.getGuest()==null){
            guest.checkin(getFreeRoom());
        }
        return room;
    }

    /**
     * upon receiving guest name, the guest is checked out,
     * safe in the room is deactivates
     * nothing happens if there is no guest with this name
     *
     * @param name nme of a guest
     * @ensures Room is set to null
     */
    public void checkOut(String name) {
        Room room = this.getRoom(name);
        if (room != null) {
            room.getSafe().deactivate();
            room.setGuest(null);
            guest.checkout();
        }
    }

    /**
     * returns the Room into which the guest can check in, otherwise returns null
     *
     * @return room that is free or null
     */
    public Room getFreeRoom(){
        if (room101.getGuest() == null){
            return room101;
        } else if ( room102.getGuest() == null){
            return room102;
        } return null;

    }

    /**
     * upon receiving guest name, returns the Room  into which the guest is checked in
     * if the guest cannot be found in any room returns null
     * @param name guest name
     * @return room occupied by guest
     */
    public Room getRoom(String name) {
        if (room101.getGuest() != null && room101.getGuest().getName().equals(name)) {
            return room101;
        } else if (room102.getGuest() != null && room102.getGuest().getName().equals(name)) {
            return room102;
        }return null;
    }

    /**
     * gives a textual description of all rooms in the hotel,
     * including name of the guest and the status of the safe in that room
     *
     * @return textual description of all rooms in hotel
     */
    public String toString() {
        return "Hotel Name : " + hotelName + " " + room101.getGuest() + " " + room102.getGuest();
    }


    /**
     * If there is no guest with the given name,
     * or if the guest stays in an ’standard’ room (i.e., not a PricedRoom)
     * return null
     *
     * @param guestName - name of guest
     * @param noNights  - mumber of nights
     * @param printer   - bill printer
     */
    public Bill getBill(String guestName, int noNights, Printer printer) {
        if (guestName.equals(room101.getGuest().getName())) {
            Bill bill = new Bill(printer);
            Room room = getRoom(guestName);
            Item item = new Item(guestName + " " + noNights, noNights * ROOM_PRICE + SAFE_PRICE);
            bill.addItem(item);
            return bill;
        } else return null;
    }

    public String getName() {
        return this.hotelName;
    }


    private class Item implements Bill.Item {
        private final double _amount;
        private final String _name;

        public Item(String name, double amount) {
            _name = name;
            _amount = amount;
        }

        @Override
        public double getAmount() {
            return _amount;
        }

        public String toString() {
            return _name;
        }
    }
}
