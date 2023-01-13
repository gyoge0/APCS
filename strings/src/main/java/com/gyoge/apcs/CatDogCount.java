// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class CatDogCount {

    public static boolean catDog(String str) {
        // kabi messed up and didn't know how .replace() worked,
        // but that inspired this genius solution
        return str.replace("cat", "").length() == str.replace("dog", "").length();
    }
}
