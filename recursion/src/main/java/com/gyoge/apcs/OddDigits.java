// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;

public class OddDigits {

    private static final String[] ODD_DIGITS = {"1", "3", "5", "7", "9"};

    public static void main(String[] args) {
        ArrayList<String> combo = new ArrayList<>();
        oddDigits("", 3, combo);
        for (String temp : combo) {
            System.out.println(temp);
        }
    }

    public static void oddDigits(String s, int maxDigits, ArrayList<String> inList) {
        if (maxDigits == 1) {
            for (String digit : ODD_DIGITS) {
                inList.add(s + digit);
            }
        } else {
            for (String digit : ODD_DIGITS) {
                oddDigits(s + digit, maxDigits - 1, inList);
            }
        }
    }
}
