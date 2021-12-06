package ss.week3.bill;

public class SysoutPrinter implements Printer{

    public static void main(String[] args) {
        SysoutPrinter p = new SysoutPrinter();
        p.printLine("Text1", 1.00);
        p.printLine("Other text", -12.12);
        p.printLine("Something", 0.20);
    }

    /**
     * uses format to send the combination of text and price to the printer
     */
    @Override
    public void printLine(String text, double price) {
        System.out.print(format(text, price));
    }
}
