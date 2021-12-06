package ss.week3.bill;

public class Bill {

    //Constructor

    private Bill bill;
    private double Sum;
    private StringPrinter Printer;
    /**
     *  Constructs a Bill sending the output to a given Printer.
     * @param printer -the printer to send the bill to
     * @require: printer != null
     * @ensure: getSum()=0;
     */
    public Bill(Printer printer){
        this.Sum = 0;
        Printer = (StringPrinter) printer;

    }

    /**
     * Abstraction of the items on the bill.
     * Every item has an amount and description;
     * Description is available with toString().
     */
    public static interface Item{
        /**
         * @return amount of this Item
         * @ensures: result >=0;
         */
        double getAmount();
        String toString();
    }

    /**
     * Adds an item to this Bill.
     * The item is sent to the printer
     * Amount is added to the sum of the Bill
     * @param Item - new item
     * @requires: item != null
     * @ensures: this.getSum() == old(getSum()) + item.getAmount();
     */
    public void addItem(Item Item){
        this.Sum = this.Sum + Item.getAmount();
        Printer.printLine(Item.toString(), Item.getAmount());
    }

    /**
     * Sends the sum total of the bill to the printer.
     */
    public void close(){
        Printer.printLine("Total sum: ",this.Sum);
    }

    /**
     * Returns the current sum total of the Bill.
     * @return: the current sum total of the Bill
     * @ensures: result >= 0;
     */
    public double getSum(){
       return this.Sum;
    }






}
