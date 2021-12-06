package ss.week3.hotel;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Safe;

public class Room {
    private int number;
    private ss.week2.hotel.Guest Guest;
    private ss.week2.hotel.Room room;
    private ss.week2.hotel.Safe safe;

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param number number of the new <code>Room</code>
     */
    public Room(int number, ss.week2.hotel.Safe safe) {
        this.number = number;
        this.safe = safe;
    }

    /**
     * creates a safe for the Room with given number
     * @param number number of the Room
     */
    public Room(int number){
        this(number, new ss.week2.hotel.Safe());
    }

    /**
     * Returns the number of this Room
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the current guest living in this Room
     * @return the guest of this Room, null if not rented
     */
    public Guest getGuest() {
        return Guest;
    }


    public Safe getSafe(){return safe;}

    /**
     * Assigns a Guest to this Room.
     * @param guest the new guest renting this Room, if null is given, Room is empty afterwards
     */
    public void setGuest(Guest guest) {

        this.Guest = guest;
    }

    /**
     *
     */
    public String toString() {
        return "Room " + getNumber();
    }
}
