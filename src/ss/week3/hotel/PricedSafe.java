package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.Password;

public class PricedSafe extends Safe implements Bill.Item{

    private Password password;
    private Safe Safe;
    public double price;

    public PricedSafe(double price){
        this.price = price;
        this.password = new Password();
    }

    /**
     * activates the safe if received password is correct;
     * @param Password - provided password
     */
    public void activate(String Password){
        if(password.testWord(Password)){
            Safe.activate();
        }
    }

    /**
     * overrides the parent method,
     * gives a warning and does not activate the safe;
     */
    @Override
    public void activate(){
        System.out.println("WARNING!");
    }

    /**
     * closes the safe
     * and deactivates it
     */
    public void deactivate(){
        Safe.close();
        Safe.deactivate();

    }

    /**
     * opens the safe if it's active & password is correct
     * @param Password - given password
     */
    public void open(String Password){
        if (Safe.isActive() && password.testWord(Password)){
            Safe.open();
        }
    }

    /**
     * overrides the parent method and does not change the state of the safe;
     */
    @Override
    public void open(){
        System.out.println("ERROR!");
    }

    /**
     * closes the safe
     * does not change its activation status
     */
    public void close(){
        Safe.close();
    }

    /**
     * return password object on which the method testWord can be called to check password
     * @return password
     */
    public Password getPassword(){
        return password;
    }

    /**
     * @return amount of this Item
     * @ensures: result >=0;
     */
    @Override
    public double getAmount() {
        return price;
    }
}
