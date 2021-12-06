package ss.week1.hotel;

public class SimpleBillPrinter {
    public static void main(String[]args){
        String bill; //String variable that will contain the formatted bill String to be printed out
        String description = "Hotel night 1x";
        double price = 85.50;
        bill = String.format("%1$-25s %2$8.2f",description,price);
        System.out.print(bill);
    }
}