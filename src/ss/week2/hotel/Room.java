package ss.week2.hotel;

public class Room {
    private int number;
    private Guest Guest;
    private Room room;
    private Safe safe;

    /**
     * Creates a <code>Room</code> with the given number, without a guest.
     * @param number number of the new <code>Room</code>
     */
    public Room(int number, Safe safe) {
        this.number = number;
        this.safe = safe;
    }

    /**
     * creates a safe for the Room with given number
     * @param number number of the Room
     */
    public Room(int number){
        this(number, new Safe());
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
