package ss.week3.password;

public class Password {




    private String password;
    private Checker checker;
    private String INITIAL ="";
    public String factoryPassword;


    public Password (Checker Checker) {
        this.checker = Checker;
        INITIAL = checker.generatePassword();
        factoryPassword = INITIAL;

        //factoryPassword = checker.generatePassword();
    }

    public Password() {
        this(new BasicChecker());
        this.password = checker.generatePassword();
    }

    /**
     * Test if a given string is an acceptable password
     * @param suggestion- Word that should be tested
     * @return true If suggestion is acceptable
     * @requires: uggestion != null
     * @ensures: returns true If the suggestion has at least 6 characters and no spaces
     */
    public boolean acceptable(String suggestion){
        return checker.acceptable(suggestion);
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
        if (testWord(oldPass) && acceptable(newPass)) {
            password = newPass;
            return true;
        }
        else {
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public Checker getChecker() {
        return checker;
    }

    public String getFactoryPassword() {
        return factoryPassword;
    }

}
