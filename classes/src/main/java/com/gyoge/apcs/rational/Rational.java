// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.rational;

import java.util.Objects;

@SuppressWarnings("unused")
public class Rational {
    private int numerator;
    private int denominator;

    /**
     * Constructs an object representing a rational number in the form of numer / denom. The
     * rational number will be simplified.
     *
     * @param numerator   the numerator of a rational number
     * @param denominator the denominator of a rational number
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        reduce();
    }

    /**
     * Constructs an object representing a rational number in the form of numer / denom. The
     * rational number will be simplified. The denominator is set to 1.
     *
     * @param numerator the numerator of a rational number
     */
    public Rational(int numerator) {
        this(numerator, 1);
    }

    @Override
    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        else return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator == rational.numerator && denominator == rational.denominator;
    }

    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    }

    /**
     * Find the sum of the two Rational numbers
     *
     * @param r a Rational number
     * @return a new Rational that is the sum of two Rational numbers
     */
    public Rational add(Rational r) {
        return new Rational(
            numerator * r.denominator + denominator * r.numerator, denominator * r.denominator);
    }

    public Rational subtract(Rational r) {
        return new Rational(
            numerator * r.denominator - denominator * r.numerator, denominator * r.denominator);
    }

    public Rational multiply(Rational r) {
        return new Rational(numerator * r.numerator, denominator * r.denominator);
    }

    public Rational divide(Rational r) {
        return multiply(r.reciprocal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     * Reduces the fraction
     */
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (denominator < 0) {
            numerator = -numerator;
            denominator = Math.abs(denominator);
        }
    }

    /**
     * Find the greatest common divisor between integers a and b
     *
     * @param a an integer
     * @param b an integer
     * @return the GCD
     */
    private int gcd(int a, int b) {
        int n = Math.min(Math.abs(a), Math.abs(b));
        while (!(a % n == 0 && b % n == 0)) {
            n = n - 1;
        }
        return n;
    }
}
