// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.string;

public class FindMinVowels {

    public static void main(String[] args) {
        String[] arr = {"hey", "yolo", "hi", "this is long"};
        System.out.println(minVowels(arr));
        // should print "hi"
    }

    public static String minVowels(String[] words) {
        String most = words[0];
        int vowels = countVowels(most);
        for (String str : words) {
            int strVowels = countVowels(str);
            if (strVowels < vowels) most = str;
            else if (strVowels == vowels && str.length() < most.length()) most = str;
        }
        return most;
    }

    public static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) count++;
        }
        return count;
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
