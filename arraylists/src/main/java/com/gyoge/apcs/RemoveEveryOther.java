// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveEveryOther {

    public static void main(String[] args) {
        @SuppressWarnings("SpellCheckingInspection")
        ArrayList<String> testList =
                new ArrayList<>(Arrays.asList("hi", "yo", "sup", "yolo", "boop"));

        removeEveryOther(testList);

        for (String tempS : testList) {
            System.out.print(tempS + "  ");
        }
    }

    public static void removeEveryOther(ArrayList<String> a) {
        for (int i = a.size() % 2 == 1 ? a.size() - 1 : a.size() - 2; i >= 0; i -= 2) {
            a.remove(i);
        }
    }
}
