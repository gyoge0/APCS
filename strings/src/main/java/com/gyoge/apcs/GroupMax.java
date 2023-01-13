// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class GroupMax {

    public static void main(String[] args) {
        System.out.println(groupMax("hoopla"));
        System.out.println(groupMax("abbCCCddBBBxx"));
        System.out.println(groupMax(""));
    }

    public static int groupMax(String s) {
        int current = 0;
        int longest = 0;
        char c = '=';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                current++;
            } else {
                if (current > longest) {
                    longest = current;
                }
                current = 1;
                c = s.charAt(i);
            }
        }
        return longest;
    }
}
