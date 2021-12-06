package ss.week3.hotel;

import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item{

private double pricePerNigth;

    //constructor
    public PricedRoom(int roomNumber, double roomPrice, double safePrice) {
        super(roomNumber, new PricedSafe(safePrice));
        pricePerNigth = roomPrice;
    }


    /**
     * @return amount of this Item
     * @ensures: result >=0;
     */
    @Override
    public double getAmount() {
        return this.pricePerNigth;
    }

    @Override
    public String toString(){
        return "Rooom" + getNumber() + " " + getAmount();
    }
}
