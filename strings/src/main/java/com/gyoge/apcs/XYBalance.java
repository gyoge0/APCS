// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class XYBalance {

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        System.out.println(xyBalance("aaxbby"));
        System.out.println(xyBalance("aaxbb"));
        System.out.println(xyBalance("yaaxbb"));
        System.out.println(xyBalance("bbxyyxxzzydc"));
    }

    // Your code goes here
    public static boolean xyBalance(String test) {
        boolean balanced = true;
        for (int i = 0; i < test.length(); i++) {
            if (test.charAt(i) == 'x') {
                balanced = false;
            } else if (test.charAt(i) == 'y') {
                balanced = true;
            }
        }
        return balanced;
    }
}
