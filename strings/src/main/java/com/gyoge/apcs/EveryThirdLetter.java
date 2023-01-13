// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class EveryThirdLetter {

    // test case below (dont change):
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        System.out.println(thirdLetter("hello there")); // "hltr"
        System.out.println(thirdLetter("technology")); // "thly"
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public static String thirdLetter(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); i += 3) {
            ret += s.charAt(i);
        }
        return ret;
    }
}
