package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public class Superprime {

    public static final char[] ONE_DIGIT_PRIMES = {'2', '3', '5', '7'};
    private List<String> superPrimes;

    public List<String> getSuperPrimes() {
        return superPrimes;
    }

    public static void main(String[] args) {
        System.out.print("How long? ");
        int num = Integer.parseInt(new Scanner(System.in).nextLine());

        Superprime s = new Superprime();
        s.superPrime("", num);

        for (String str : s.getSuperPrimes()) {
            System.out.println(str);
        }
    }

    public void superPrime(String str, int length) {
        if (superPrimes == null) {
            superPrimes = new ArrayList<>();
        }

        if (str.length() == length) {
            if (isPrime(str)) {
                superPrimes.add(str);
            }
            return;
        }

        for (char c : ONE_DIGIT_PRIMES) {
            superPrime(str + c, length);
        }
    }

    public static boolean isPrime(String str) {
        // no memo because each call has a unique prime
        // no chance for the rucursive calls to generate the same prime
        int intValueOf = Integer.parseInt(str);
        if (intValueOf <= 2) {
            return intValueOf == 2;
        }

        for (int i = 2; i < Math.sqrt(intValueOf) + 1; i++) {
            if (intValueOf % i == 0) {
                return false;
            }
        }
        return true;
    }
}
