// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class SumAll {

    public static int sumAll(ArrayList<Integer> a) {
        int sum = 0;
        for (Integer integer : a) {
            sum += integer;
        }
        return sum;
    }
}
