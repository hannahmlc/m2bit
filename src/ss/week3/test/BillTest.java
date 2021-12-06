package ss.week3.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

class BillTest {
    private Bill bill;
    private Item item;

    private class Item implements Bill.Item{
        double amount;
        String text;

        public Item(String Text, double Amount){
            text = Text;
            amount = Amount;
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
            return text;
        }
    }

    @BeforeEach
    void setUp() {
        bill = new Bill(new StringPrinter());
        item = new Item("Apple", 11);
    }

    @Test
    void addItem() {
        assertEquals(item.getAmount(), 11); // item basic state
        bill.addItem(item);
        assertEquals(bill.getSum(), 11);
        Item item2 = new Item("orange", 11);
        bill.addItem(item2);
        assertEquals(bill.getSum(), 22);

    }

    @Test
    void close() {
        //TODO: finish this test
        // the test class in general
        //assertEquals(Printer.get);
    }

    @Test
    void getSum() {
        assertEquals(bill.getSum(), 0); // basic state
        bill.addItem(item);
        assertEquals(bill.getSum(), 11);
    }
}