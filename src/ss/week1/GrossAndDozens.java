package ss.week1;
import ss.utils.TextIO;

public class GrossAndDozens {
    static int n; // number of eggs

    public static void main(String[] args) {
        System.out.println("How manny eggs: ");
        n = TextIO.getlnInt();
        /*
        gross = 144
        dozen = 12
         */

        int gross = n/144;
        int dozen = n%144/12;
        int left = n%144%12;//n-(gross*144+dozen*12);
        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + left);
    }
}
