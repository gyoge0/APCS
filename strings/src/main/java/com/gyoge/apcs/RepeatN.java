// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("StringConcatenationInLoop")
public class RepeatN {

    public static void main(String[] args) {
        System.out.println(repeatN("Chocolate", 4));
    }

    public static String repeatN(String str, int n) {
        String ret = "";
        for (int i = n; i > 0; i--) {
            ret += str.substring(0, i);
        }
        return ret;
    }
}
