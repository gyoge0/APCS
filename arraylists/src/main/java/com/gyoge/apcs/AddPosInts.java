// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class AddPosInts {

    public static List<Integer> appendPosSum(List<Integer> in) {
        List<Integer> out = new ArrayList<>();
        int sum = 0;
        for (Integer i : in) {
            if (i > 0) {
                out.add(i);
                sum += i;
            }
        }
        out.add(sum);
        return out;
    }
}
