package ss.week5;

public class ArgumentLengthsDifferException extends WrongArgumentException {

    public ArgumentLengthsDifferException(int s1Length, int s2Length){
        super("error: length of command line arguments "
            + "differ (" + s1Length + ", " + s2Length + ")");
    }


}
