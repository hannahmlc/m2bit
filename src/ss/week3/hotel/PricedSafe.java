package ss.week3.hotel;

import ss.week3.password.Password;

public class PricedSafe extends Safe {

    private Password password;
    private Safe Safe;
    //activate: receives a String with a password text as a parameter, ------
    // activates the safe if password is correct; -----
    //• activate: without parameters, overrides the parent method, gives a warning and does not activate
    //the safe;
    public void activate(String Password){
        String actualPassword = password.getPassword(); // password of the safe
        if(Password.equals(actualPassword)){
            Safe.activate();
        }
    }

    //• deactivate: without parameters, closes the safe and deactivates it;



    //• open: receives a String with a password text as a parameter,
    // opens the safe if it is active, and password is correct;
    //• open: without parameters, overrides the parent method and does not change the state of the safe;


    //• close: without parameters, c
    // loses the safe (but does not change its activation status).


    //getPassword:
    // returns the password object on which the method testWord can be called to check password

}
