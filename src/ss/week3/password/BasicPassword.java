package ss.week3.password;

public class BasicPassword {

    public static final String INITIAL = "inital";
    private String password;
    
    /**
     * Constructs a Password with the initial word provided in INITIAL
     * @ensures: sestWord(INITIAL) is true for each newly created BasicPassword object
     */
    public BasicPassword(){
        password = INITIAL;
    }

    /**
     * Test if a given string is an acceptable password
     * Not acceptable: A word with less than 6 characters or a space
     * @param suggestion- Word that should be tested
     * @return true If suggestion is acceptable
     * @requires: uggestion != null
     * @ensures: returns true If the suggestion has at least 6 characters and no spaces
     */
    public boolean acceptable(String suggestion){
        return (suggestion.length() >= 6 && !suggestion.contains(" "));
    }

    /**
     * Tests if a given word is equal to the current password.
     * @requires: test != null;
     * @param test - Word that should be tested
     * @return true If test is equal to the current password
     */
    public boolean testWord(String test){
        return (test.equals(password));
    }


    /**
     * Changes this password.
     * @param oldPass - old password
     * @param newPass - current password
     * @return true If oldPass is equal to the current password and newpass is an acceptable password
     * @requires: oldpass != null, newpass != null
     * @ensures: returns true if the old password is correct and the new one is accepta
     */
    public boolean setWord(String oldPass, String newPass){
        boolean oldCheck = testWord(oldPass);//Check if the old password is correct; ;
        boolean newCheck = acceptable(newPass); // Check if the new password is acceptable;
         //if checks are correct update the password.
        if (oldCheck && newCheck){
            this.password = newPass;
            return true;
        } else {
            return false;
        }
    }


}
