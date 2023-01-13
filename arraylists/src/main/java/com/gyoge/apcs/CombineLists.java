// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class CombineLists {

    @SuppressWarnings("UseBulkOperation")
    public static ArrayList<String> combineAL(ArrayList<String> a, ArrayList<String> b) {
        ArrayList<String> r = new ArrayList<>(a.size() + b.size());
        for (String s : a) {
            r.add(s);
        }
        for (String s : b) {
            r.add(s);
        }
        return r;
    }
}
