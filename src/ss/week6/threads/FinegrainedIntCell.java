package ss.week6.threads;

import java.util.concurrent.locks.*;

public class FinegrainedIntCell implements IntCell {
    private int value = 0;
    private boolean buffer = false;
    private ReentrantLock intCellLock = new ReentrantLock();
    private final Condition consumerBuffer = intCellLock.newCondition();
    private final Condition producerBuffer = intCellLock.newCondition();

    public void setValue(int valueArg) {
        intCellLock.lock();
        try {
            while (buffer) {
                consumerBuffer.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = valueArg;
        buffer = true;
        producerBuffer.signal();
        intCellLock.unlock();
    }

    public int getValue() {
        intCellLock.lock();
        try {
            while (!buffer) {
                producerBuffer.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumerBuffer.signal();
        buffer = false;
        intCellLock.unlock();
        return value;
    }
}