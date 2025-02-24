package com.company;

/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * @author Pranav Munjal
 * @version 4.0
 */
public class Counter {
    // PUT PRIVATE DATA FIELDS HERE
    private int minimum1;
    private int maximum2;
    private int counter;
    private boolean rollover;

    /**
     * The default constructor for objects of class Counter.  Minimum is 0 and the maximum
     * is the largest possible integer.
     */
    public Counter() {
        // ADD CODE FOR THE CONSTRUCTOR
        minimum1 = 0;
        maximum2 = 1000000000;
    }

    /**
     * The alternate constructor for objects of class Counter.  The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     * */
    public Counter(int min, int max) {
        // ADD CODE FOR THE ALTERNATE CONSTRUCTOR
        if (min > max) {
            throw new CounterInitializationException("min1 is greater than max1");
        }

        if (min == max) {
            throw new CounterInitializationException("min1 is equal to max1");
        }
        minimum1 = min;
        maximum2 = max;
        counter = min;
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param otherObject   the object to test against for equality
     * @return true if the objects are in the same state
     */
    public boolean equals(Counter otherObject) {
        boolean result = true;
        if (otherObject instanceof Counter) {
            if (this.counter == otherObject.counter &&
                    this.maximum2 == otherObject.maximum2 &&
                    this.minimum1 == otherObject.minimum1 &&
                    this.rollover == otherObject.rollover) {
                result = true;
            }
            else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Increases the counter by one
     */
    public void increase() {
        if (counter == maximum2) {
            counter = minimum1;
            rollover = true;
        }
        else {
            counter++;
            rollover = false;
        }
    }

     /**
     * Decreases the counter by one
     */
    public void decrease() {
        if (counter == minimum1) {
            counter = maximum2;
            rollover = true;
        }
        else {
            counter--;
            rollover = false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return the current value of the counter
     */
    public int value() {
        // CHANGE THE RETURN TO GIVE THE CURRENT VALUE OF THE COUNTER
        return counter;
    }

    /**
     * Accessor that allows the client to determine if the counter
     *             rolled over on the last count
     *
     * @return true if the counter rolled over
     */
    public boolean rolledOver() {
        // CHANGE THE RETURN TO THE ROLLOVER STATUS OF THE COUNTER
        return rollover;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return a descriptive string about the object
     */
    public String toString() {
        if (rolledOver()) {
            return "[ Counter Minimum is " + minimum1 + ", Maximum is " + maximum2 +
                    "\n counter has the value " + value() +
                    "it has rolled over " + "]";
        }
        else {
            return "[ Counter Minimum is " + minimum1 + ", Maximum is " + maximum2 +
                    "\n  counter has the value " + value() +
                    "\n  it has not rolled over " + "]";
        }
    }
}