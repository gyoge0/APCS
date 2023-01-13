// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class RepeatValue {

    public static List<Integer> twoTimes(List<Integer> a) {
        List<Integer> r = new ArrayList<>();
        for (Integer i : a) {
            r.add(i);
            r.add(i);
        }
        return r;
    }
}
