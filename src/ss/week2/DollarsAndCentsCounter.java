package ss.week2;

public class DollarsAndCentsCounter {
    int dollars_;
    int cents_;

    public DollarsAndCentsCounter() {
        dollars_ = 0;
        cents_ = 0;
    }

    /**
     * @ensures a return value that is bigger or equal to 0
     * @return dollars
     */
    public int dollars() {
        return dollars_;
    }

    /**
     * @ensures a return value in the range of 0 to 99
     * @return cents
     */
    public int cents() {
        return cents_;
    }

    /**
     * Adds the specified dollars and cents to this Counter.
     */
    public void add(int dollars, int cents) {
        dollars_ += dollars;
        cents_ += cents;
        if (cents_ >= 100) {
            dollars_++;
            cents_ -= 100;
        }
    }

    /**
     * Reset this Counter to 0.
     * @ensures this Counter is set to 0 dollars and 0 cents
     */
    public void reset() {
        dollars_ = 0;
        cents_ = 0;
    }
}
