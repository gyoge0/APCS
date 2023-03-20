// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class ReplacePatterns {

    @SuppressWarnings("StringConcatenationInLoop")
    public static String replacePattern(String str, String findStr, String replaceStr) {
        int count = 0;

        String ret = "";
        int strLength = str.length();
        int findStrLength = findStr.length();

        for (int i = 0; i < strLength; i++) {
            if (str.charAt(i) == findStr.charAt(count)) {
                count++;
                if (count == findStrLength) {
                    ret += replaceStr;
                    count = 0;
                }
            } else {
                ret += str.substring(i - count, i + 1);
                count = 0;
            }
        }
        if (count != findStrLength) {
            ret += str.substring(strLength - count, strLength);
        }
        return ret;
    }

    public static void verify_replacePattern(
        String str, String findStr, String replaceStr, String expectedStr
    ) {
        String retStr = replacePattern(str, findStr, replaceStr);
        String result = "fail";
        if (retStr.equals(expectedStr)) result = "pass";

        System.out.printf(
            "%s: replacePattern(%s, %s, %s) => %s\n",
            result, str, findStr, replaceStr, expectedStr
        );
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        verify_replacePattern("kitty_dog_kitty", "kitty", "dog", "dog_dog_dog");
        verify_replacePattern("dog_kitty_dog", "dog", "kitty", "kitty_kitty_kitty");
        verify_replacePattern("Mississippi", "iss", "us", "Mususippi");
        verify_replacePattern("Mississippi", "i", "ae", "Maessaessaeppae");
        verify_replacePattern(
            "the effervescence in the teleconference was electrogeneses",
            "e",
            "a",
            "tha affarvascanca in tha talaconfaranca was alactroganasas"
        );
    }
}
