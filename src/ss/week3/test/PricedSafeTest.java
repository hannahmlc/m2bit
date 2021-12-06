package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";
    
    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    

    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getFactoryPassword();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getAmount(), 0.001,
        		"GetAmount should return the price of the safe.");
    }

    //Test if method getAmount works properly;
    @Test
    public void testGetAmount(){
        assertEquals(PRICE,safe.getAmount(),0.001);
    }

    //Test if method toString works properly;
    @Test
    public void testToString(){
        assertEquals("Safe's price: 6.36", safe.toString());
    }

    //Assert that a deactivated safe can be activated with the correct password and is activated and closed after that;
    @Test
    public void testActivate(){
        assertFalse(safe.isActive());//test initial state
        assertFalse(safe.isOpen()); //test initial state
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    //Assert that a deactivated safe cannot be activated with an incorrect password (remains deactivated and closed);
    @Test
    public void testActivate2(){
        safe.activate(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    // Test if after trying to open a deactivated safe with the correct password the safe is indeed deactivated and closed;
    // Test if after trying to open a deactivated safe with an incorrect password the safe is indeed deactivated and closed;
    @Test
    public void testDeactivated(){
        safe.open(CORRECT_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }

    // Assert that after activating a safe with the correct password
    // it cannot be opened with an incorrect password,
    // but after being opened with the correct password it is activated and open;
   @Test
   public void testOpen(){
        safe.activate(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        safe.open(WRONG_PASSWORD);
        assertFalse(safe.isOpen());
        safe.open(CORRECT_PASSWORD);
        assertTrue(safe.isActive());
        assertTrue(safe.isOpen());
    }

    // Test if after activating and opening a safe with the correct password, and closing it, the safe is closed and activated;
    @Test
    public void testClose1(){
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);
        safe.close();
        assertTrue(safe.isActive());
        assertFalse(safe.isOpen());
    }

    //Test if after closing a deactivated safe, it is closed and deactivated
    @Test
    public void testClose2(){
        assertFalse(safe.isActive());
        safe.close();
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
}
