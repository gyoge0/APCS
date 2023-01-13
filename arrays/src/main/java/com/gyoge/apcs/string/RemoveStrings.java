// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.string;

@SuppressWarnings("unused")
public class RemoveStrings {

    @SuppressWarnings("ManualArrayCopy")
    public static String[] removeWords(String[] a, int l) {
        String[] tmp = new String[a.length];
        int count = 0;
        for (String s : a) {
            if (s.length() != l) {
                tmp[count] = s;
                count++;
            }
        }
        String[] ret = new String[count];
        for (int i = 0; i < count; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }
}
