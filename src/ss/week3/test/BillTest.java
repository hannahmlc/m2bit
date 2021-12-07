package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

public class BillTest {
    private Bill bill;
    private Item item;
    private Item item2;
    private  StringPrinter printer;

    class Item implements Bill.Item{
        double amount;
        String text;

        public Item(String Text, double Amount){
            this.text = Text;
            this.amount = Amount;
        }

        /**
         * @return amount of this Item
         * @ensures: result >=0;
         */
        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public String toString(){
            return this.text;
        }
    }

    @BeforeEach
    void setUp() {
        printer = new StringPrinter();
        bill = new Bill(printer);
        item = new Item("Apple", 11);
        item2 = new Item("Orange",11);
    }

    @Test
    void testAddItem() {
        assertEquals(item.getAmount(), 11); // item basic state
        bill.addItem(item);
        assertEquals(bill.getSum(), 11);
        bill.addItem(item2);
        assertEquals(bill.getSum(), 22);

    }

    @Test
    void testClose() {
        bill.addItem(item);
        assertEquals("Total sum: 11.0", "Total sum: " + bill.getSum() );
    }

    @Test
    void testGetSum() {
        assertEquals(bill.getSum(), 0); // basic state
        bill.addItem(item);
        assertEquals(bill.getSum(), 11);
    }

    @Test
    public void testNewItem() {
        bill.addItem(item);
        assertEquals("Apple",item.text);
        assertEquals(11,bill.getSum());
        assertTrue(printer.getResult().contains(String.valueOf(item.amount)));
        bill.addItem(item2);
        assertTrue(printer.getResult().contains(item.toString()));
        assertTrue(printer.getResult().contains(item2.toString()));
        assertEquals(bill.getSum(), item.amount+item2.amount);

    }
}