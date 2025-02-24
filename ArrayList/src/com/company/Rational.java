//22C
//Lab1 - Assignment

package com.company;

/**
 * A class that represents a rational number. 
 * @author Pranav Munjal
 * @version 4.0
*/

public class Rational {
    // PUT PRIVATE DATA FIELDS HERE
    private int numerator1;
    private int denominator1;

    /**
     * The default constructor for objects of class Rational.  Creates the rational number 1.
     */
    public Rational() {
        // ADD CODE TO THE CONSTRUCTOR
        numerator1 = 1;
        denominator1 = 1;
    }

    /**
     * The alternate constructor for objects of class Rational.  Creates a rational number equivalent to n/d.
     *
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    // create and initialize a new Rational object.
    public Rational(int n, int d) {
        if (d == 0) {
            throw new ZeroDenominatorException("denominator is zero.");
        }
        numerator1 = n;
        denominator1 = d;
        normalize();
    }

    /**
     * Get the value of the Numerator
     *
     * @return the value of the numerator
     */
    public int getNumerator() {
        return numerator1;
    }

    /**
     * Get the value of the Denominator
     *
     * @return the value of the denominator
     */
    public int getDenominator() {
        return denominator1;
    }

    /**
     * Negate a rational number r
     *
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate() {
        return new Rational(-1 * numerator1, denominator1);
    }

    /**
     * Invert a rational number r
     *
     * @return a new rational number that is 1/r.
     */
    public Rational invert() {
        return new Rational(denominator1, numerator1);
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */
    public Rational add(Rational other) {
        Rational a = this;

        // find gcd of numerators and denominators
        int f = gcd(Math.abs(a.numerator1), Math.abs(other.numerator1));
        int g = gcd(Math.abs(a.denominator1), Math.abs(other.denominator1));
        Rational sum = new Rational((a.numerator1 / f) * (other.denominator1 / g) +
                (other.numerator1 / f) * (a.denominator1 / g),
                (a.denominator1 * other.denominator1) / g);

        // multiply back in
        sum.numerator1 *= f;
        return sum;
    }

    /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other) {
        Rational a = this;
        return a.add(other.negate());
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the sum of this object and the other rational.
     */
    public Rational multiply(Rational other) {
        Rational a = this;

        // simplify this 2 Rational
        Rational c = new Rational(a.numerator1, other.denominator1);
        Rational d = new Rational(other.numerator1, a.denominator1);
        return new Rational(c.numerator1 * d.numerator1, c.denominator1 * d.denominator1);
    }

    /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other) {
        Rational a = this;
        // CHANGE THE RETURN TO SOMETHING APPROPRIATE
        return a.multiply(other.invert());
    }
    /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors.  Guarantee that only the numerator
     * is negative.
     */
    private void normalize() {
        // reduce fraction
        int g = gcd(Math.abs(numerator1), Math.abs(denominator1));
        numerator1 = numerator1/ g;
        denominator1 = denominator1 / g;

        // needed only for negative number
        if (denominator1 < 0) {
            denominator1 = denominator1 * -1;
            numerator1 = numerator1 * -1;
        }
    }
    
    
    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b) {
        int result = 0;
        if (a < b) {
            result = gcd(b, a);
        }
        else if (b == 0) {
            result = a;
        }
        else {
            int remainder = a % b;
            result = gcd(b, remainder);
        }
        return result;
    }
}