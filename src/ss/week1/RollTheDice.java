package ss.week1;

public class RollTheDice {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 3; i++) {
            int number = (int) (Math.random() * 6) + 1;
            sum += number;
            System.out.println("The " + i + " dice: " + number);
        }
        System.out.println("Final result:" + sum);

    }
}
