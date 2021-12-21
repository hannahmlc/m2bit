package ss.week5;

public class WrongArgumentException extends Exception{

    public WrongArgumentException(){
        super("Wrong argument");
    }

    public WrongArgumentException(String message){
        super(message);
    }



}
