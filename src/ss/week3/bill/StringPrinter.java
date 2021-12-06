package ss.week3.bill;

public class StringPrinter implements Printer{

    private String result = null; // all lines collected

    /**
     * uses format to send the combination of text and price to the printer
     */
    @Override
    public void printLine(String text, double price) {
        result += format(text, price);
    }

    public String getResult () {
        return result;
    }
}
