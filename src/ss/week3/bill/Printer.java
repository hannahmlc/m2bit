package ss.week3.bill;

public interface Printer{

    /**
     * format and return the line listing the item and price, ending on a newline
     * @returns a formatted line
     */
    default String format(String text, double price) {
        return String.format("%1$-25s %2$8.2f\n", text, price);
    }

    /**
     * uses format to send the combination of text and price to the printer
     */
    void printLine (String text, double price);

}
