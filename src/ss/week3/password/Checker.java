package ss.week3.password;

public interface Checker {

    /**
     * Check whatever given word is acceptable (at least 6 words, no spaces)
     * @ensures: password is at least 6 characters long
     * @ensures: password doesnot contain spaces
     * @return true if the parameter is an acceptable
     */
    default boolean acceptable(String password){
        return (password.length() >= 6 && !password.contains(" "));
    }

    /**
     * @return an acceptable String
     */
   String generatePassword();
}
