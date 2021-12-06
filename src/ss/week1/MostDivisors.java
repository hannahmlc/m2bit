package ss.week1;

public class MostDivisors {
    static int many; // how many divisors
    static int numbermost; // number with most divisors
    static int numberleast;  // number with least divisors
    static int most = 0; // how many divisors does number with most divisors have
    static int least =1000;

    public static void main(String[] args){
        for(int i = 1; i<=10000; i++){
            many = CountDivisors(i);
            if (many > most) {
                most = many;
                numbermost = i; }
            else if (many <least) {
                least = many;
                numberleast = i;
            }
    }

        System.out.println(numbermost + " divisors count: " + most);
    }

    public static int CountDivisors(int n) {

            int testDivisor;
            int divisorCount = 0;
            int numberTested = 0;
            for (testDivisor = 1; testDivisor <= n; testDivisor++) {
            if ( n % testDivisor == 0 )
                divisorCount++;
            numberTested++;
            }
            return divisorCount;
    }

}
