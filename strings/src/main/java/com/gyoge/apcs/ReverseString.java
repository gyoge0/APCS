// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;

public class ReverseString {

    @SuppressWarnings("StringConcatenationInLoop")
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("In:");
        String s = inp.nextLine();
        // write your code below
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        System.out.println(r);
    }
}
