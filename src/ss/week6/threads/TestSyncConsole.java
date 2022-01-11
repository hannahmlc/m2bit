package ss.week6.threads;

public class TestSyncConsole implements Runnable{


    public static void main(String[] args) {
        new Thread(new TestSyncConsole(), "Thread A").start();
        new Thread(new TestSyncConsole(), "Thread B").start();
    }

    @Override
    public synchronized void run() {
        sum();
    }

    private synchronized void sum() {
        int number1 = SyncConsole.readInt(Thread.currentThread().getName() + ": get number 1? ");
        int number2 = SyncConsole.readInt(Thread.currentThread().getName() + ": get number 2? ");
        int sum = number1 + number2;
        SyncConsole.println(Thread.currentThread().getName() + ": " + number1 + " + " + number2 + " = " + sum);
    }


}
