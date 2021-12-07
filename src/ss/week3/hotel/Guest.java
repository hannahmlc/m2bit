package ss.week3.hotel;

public class Guest {

    private String guest; //Creates a Guest with the given name and without Room.
    private Room Room_;

    /**
     * Creates a Guest with the given name and without Room.
     * @param name - name of the new Guest
     */
    public Guest(String name) {
        this.guest = name;
    }

    /**
     * Returns the name of this Guest.
     * @return name of this Guest
     *
     */
    public String getName(){
        return guest;
    }

    /**
     * Returns the Room that is rented by this Guest.
     * @return Room rented by this Guest; null if this Guest does not rent a room
     */
    public Room getRoom() {
        return Room_;
    }

    /**
     * Rents a Room to this Guest if this Guest does not already have a Room and room is not rented.
     * adapts the Guest-reference of the Room.
     * @param room - Room to be rented to this Guest;
     * @requires: room != null;
     * @return true if checkin succeeded; false if this Guest already had a Room, or room already had a Guest
     */
    public boolean checkin(Room room) {
        if (room.getGuest() == null) {
            Room_ = room;
            room.setGuest(this);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the Room of this Guest to null
     * Resets the Guest-reference of the (current) Room.
     * @return true if this action succeeded; false if Guest does not have a Room when this method is called
     */
    public boolean checkout() {
        if (getRoom() != null ) {
            Room_.setGuest(null);
            Room_ = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * provide a description for each guest
     * @override toString in class java.lang.Object
     */
    public String toString(){
        return "Guest : " + this.getName() + " Room :" + Room_.getNumber();
    }

}
