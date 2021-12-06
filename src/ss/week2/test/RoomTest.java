package ss.week2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week2.hotel.Safe;
import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe safe;

    @BeforeEach
    public void setUp() {
        safe = new Safe();
        guest = new Guest("Jip");
        room = new Room(101,safe);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
        assertEquals(false, room.getSafe().isActive());
        assertEquals(false, room.getSafe().isOpen());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    
}
