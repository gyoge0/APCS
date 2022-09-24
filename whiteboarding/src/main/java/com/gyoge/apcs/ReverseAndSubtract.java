// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class ReverseAndSubtract {

    private static int reverse(int n) {
        int ret = 0;

        while (n > 0) {
            ret *= 10;
            ret += n % 10;
            n /= 10;
        }

        return ret;
    }

    public static int reverseAndSubtract(int n1, int n2) {
        return reverse(n1) - reverse(n2);
    }
}
