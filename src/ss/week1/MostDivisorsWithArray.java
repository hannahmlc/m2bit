package ss.week1;


import java.util.ArrayList;

public class MostDivisorsWithArray {
    static int many; // how many divisors
    static int numbermost;  // number with most divisors
    static int most = 0; // how many is the most divisot
     static ArrayList<Integer> array = new ArrayList<Integer>();// array with numbers with most divisors

    public static void main(String[] args){
        for(int i = 1; i<=10000; i++){
            many = CountDivisors(i);

            if ( many > most) {
                most = many;
                numbermost = i;
                array.clear();
                array.add(i);

            }else if(many==most){
                array.add(i);
            }
        }

        System.out.println("Among integers between 1 and 10000 ,\n" + "The maximum number of divisors was: " + most);
        System.out.println("Numbers with that many divisors include :");
        for (int j=0; j<array.size(); j++){
            System.out.println(array.get(j));
        }
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

