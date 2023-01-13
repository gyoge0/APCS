// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;

public class LeftRight {

    public static void main(String[] args) {
        ArrayList<String> combo = new ArrayList<>();
        lr("", 3, combo);
        for (String temp : combo) {
            System.out.println(temp);
        }
    }

    public static void lr(String str, int n, List<String> combos) {
        if (str.length() == n) {
            combos.add(str);
            return;
        }

        lr(str + 'L', n, combos);
        lr(str + 'R', n, combos);
    }
}
