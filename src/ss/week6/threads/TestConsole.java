package ss.week6.threads;

public class TestConsole implements Runnable{

    public static void main(String[] args) {
        new Thread(new TestConsole(), "Thread A").start();
        new Thread(new TestConsole(), "Thread B").start();
    }

    @Override
    public void run() {
        sum();
    }

    private void sum() {
        int number1 = Console.readInt(Thread.currentThread().getName() + ": get number 1? ");
        int number2 = Console.readInt(Thread.currentThread().getName() + ": get number 2? ");
        int sum = number1 + number2;
        Console.println(Thread.currentThread().getName() + ": " + number1 + " + " + number2 + " = " + sum);
    }


}

