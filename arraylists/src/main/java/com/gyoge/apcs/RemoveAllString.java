// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class RemoveAllString {

    public static void removeAll(ArrayList<String> a, String target) {
        System.out.println(target);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals(target)) {
                a.remove(i);
                i--;
            }
        }
    }
}
