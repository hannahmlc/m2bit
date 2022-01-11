package ss.week6.threads;

import java.util.concurrent.locks.*;

public class TestSyncConsoleLock implements Runnable{

    private ReentrantLock lock;

    public static void main(String[] args) {
        new Thread(new TestSyncConsole(), "Thread A").start();
        new Thread(new TestSyncConsole(), "Thread B").start();
    }

    @Override
    public void run() {
        lock.lock();
        this.sum();
        lock.unlock();
    }

    private void sum() {
        int number1 = SyncConsole.readInt(Thread.currentThread().getName() + ": get number 1? ");
        int number2 = SyncConsole.readInt(Thread.currentThread().getName() + ": get number 2? ");
        int sum = number1 + number2;
        SyncConsole.println(Thread.currentThread().getName() + ": " + number1 + " + " + number2 + " = " + sum);
    }


}