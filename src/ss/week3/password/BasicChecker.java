package ss.week3.password;

public class BasicChecker implements Checker{

    private static final String passwordExample = "Initial123";
    /**
     * @return an acceptable String
     */
    @Override
    public String generatePassword() {return passwordExample;}

}
