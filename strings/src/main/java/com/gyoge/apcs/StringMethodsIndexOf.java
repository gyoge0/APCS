// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class StringMethodsIndexOf {

    public static void main(String[] args) {
        String str = "abracadabra alakazam";
        String target1 = "dab";
        String target2 = "ABRA";
        System.out.println(str.indexOf("c"));
        System.out.println(str.indexOf(" "));
        System.out.println(str.indexOf(target1));
        //noinspection MismatchedStringCase
        System.out.println(str.indexOf(target2));
    }
}
