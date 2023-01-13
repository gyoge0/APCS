// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.basics;

import java.util.Arrays;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Strings {

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {

        // Search
        String[] srch = {
            "Lorem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "incidunt", "dolor"
        };
        System.out.println(Strings.search(srch, "dolor")); // should be 7
        System.out.println(Strings.search(srch, "fish")); // should be -1

        // AnyStartCaps
        String[] anyStrtCp = {
            "Lorem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "incidunt", "Dolor"
        };
        String[] anyStrtCpNo = {
            "orem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "incidunt", "dolor"
        };
        System.out.println(Strings.anyStartCaps(anyStrtCp)); // should be true
        System.out.println(Strings.anyStartCaps(anyStrtCpNo)); // should be false

        // AllStartCaps
        String[] allStrtCp = {
            "Lorem", "Ipsum", "Dolor", "Sit", "Amet.", "Et itaque", "Incidunt", "Dolor"
        };
        String[] allStrtCpNo = {
            "orem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "incidunt", "dolor"
        };
        System.out.println(Strings.allStartCaps(allStrtCp)); // should be true
        System.out.println(Strings.allStartCaps(allStrtCpNo)); // should be false

        // CountStartCaps
        String[] cntStrtCp = {
            "Lorem", "Ipsum", "Dolor", "Sit", "Amet.", "Et itaque", "Incidunt", "Dolor"
        };
        String[] cntStrtCpNo = {
            "orem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "Incidunt", "dolor"
        };
        System.out.println(Strings.countStartCaps(cntStrtCp)); // should be 8
        System.out.println(Strings.countStartCaps(cntStrtCpNo)); // should be 1

        // CountPairs
        String[] cntPairCp = {
            "Lorem",
            "Lorem",
            "Ipsum",
            "Ipsum",
            "Ipsum",
            "Dolor",
            "Sit",
            "Amet.",
            "Et itaque",
            "Incidunt",
            "Dolor",
            "Lorem",
            "Ipsum",
            "Dolor",
            "Sit",
            "Amet.",
            "Et itaque",
            "Incidunt",
            "Dolor"
        };
        String[] cntPairCpOne = {"orem", "dolor", "dolor", "dolor", "dolor", "dolor", "dolor"};
        String[] cntPairCpNo = {
            "orem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "Incidunt", "dolor"
        };
        System.out.println(Strings.countPairs(cntPairCp)); // should be 3
        System.out.println(Strings.countPairs(cntPairCpOne)); // should be 5
        System.out.println(Strings.countPairs(cntPairCpNo)); // should be 0

        // hasNoDuplicates
        String[] hasNDup1 = {
            "Lorem",
            "Lorem",
            "Ipsum",
            "Ipsum",
            "Ipsum",
            "Dolor",
            "Sit",
            "Amet.",
            "Et itaque",
            "Incidunt",
            "Dolor",
            "Lorem"
        };
        String[] hasNDup2 = {"orem", "dolor", "dolor", "dolor", "dolor", "dolor", "dolor"};
        String[] hasNDup3 = {"orem", "ipsum", "dolor", "sit", "amet.", " Et itaque", "Incidunt"};
        System.out.println(Strings.hasNoDuplicates(hasNDup1)); // should be false
        System.out.println(Strings.hasNoDuplicates(hasNDup2)); // should be false
        System.out.println(Strings.hasNoDuplicates(hasNDup3)); // should be true
    }

    /**
     * check if any array value is equal to a given value
     *
     * @param ss     an array of Strings with positive length
     * @param target : a string
     * @return an integer representing any index k such that ss[k] is equal to target, or -1 if
     * there is no such index
     */
    public static int search(String[] ss, String target) {
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * check if any String in the array starts with an upper case letter
     *
     * @param ss an array of Strings with positive length
     * @return true if any String in ss begins with an upper case letter, and false otherwise
     */
    public static boolean anyStartCaps(String[] ss) {
        for (String s : ss) {
            if (Character.isUpperCase(s.charAt(0))) {
                return true;
            }
        }
        return false;
    }

    /**
     * check if all Strings in the array start with an upper case letter
     *
     * @param ss an array of Strings with positive length
     * @return true, if all Strings in ss begin with an upper case letter, and false otherwise
     */
    public static boolean allStartCaps(String[] ss) {
        for (String s : ss) {
            if (!Character.isUpperCase(s.charAt(0))) {
                return false;
            }
        }
        return true;
    }

    /**
     * count Strings in the array start with an upper case letter
     *
     * @param ss an array of Strings with positive length
     * @return int representing the number of Strings in ss that begin with an upper case letter
     */
    public static int countStartCaps(String[] ss) {
        int count = 0;
        for (String s : ss) {
            if (Character.isUpperCase(s.charAt(0))) {
                count++;
            }
        }
        return count;
    }

    /**
     * count the number of consecutive equal elements, i.e. the number of values that are equal to
     * the previous value. Note: the 0th element has no previous element
     *
     * @param ss an array of Strings with positive length
     * @return int representing the number of pairs as described above
     */
    public static int countPairs(String[] ss) {
        int count = 0;
        for (int i = 1; i < ss.length; i++) {
            if (ss[i].equals(ss[i - 1])) {
                count++;
            }
        }
        return count;
    }

    /**
     * determine there are duplicate elements in the array
     *
     * @param ss an array of Strings with positive length
     * @return true, if no two Strings in the array are equal, false otherwise
     */
    public static boolean hasNoDuplicates(String[] ss) {
        return Arrays.stream(ss).collect(Collectors.toSet()).size() == ss.length;
    }
}
