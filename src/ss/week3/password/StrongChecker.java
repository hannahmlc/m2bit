package ss.week3.password;

public class StrongChecker extends BasicChecker{
    /**
     * additionally check whether the String starts with a letter and ends with digit.
     * @param password - given password
     * @return true is given password is acceptable
     */
    @Override
    public boolean acceptable(String password) {
        boolean startLetter = Character.isLetter(password.charAt(0));
        boolean endNumber = Character.isDigit(password.charAt(password.length()-1));
        return (super.acceptable(password) && startLetter && endNumber);
    }
}