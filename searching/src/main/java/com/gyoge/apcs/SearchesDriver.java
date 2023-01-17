// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SearchesDriver {

    private static final int amount = 1325;

    public static void main(String[] args) {
        String[] apple = input("declaration.txt");
        Arrays.sort(apple);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");

        // Liberty
        String target = sc.next();
        int found = Searches.linear(apple, target);
        if (found == -1) {
            System.out.println(target + " was not found by the linear search.");
        } else {
            System.out.printf(
                "Linear Search found it at location %d in %d comparisons.%n",
                found, Searches.getLinearCount());
        }

        int found2 = Searches.binary(apple, target);
        if (found2 == -1) {
            System.out.println(target + " was not found by the binary search.");
        } else {
            System.out.printf(
                "Binary Search found it at location %d in %d comparisons.%n",
                found2, Searches.getBinaryCount());
        }
    }

    public static String[] input(String filename) {
        Scanner infile =
            new Scanner(
                Objects.requireNonNull(
                    SearchesDriver.class.getResourceAsStream("/" + filename)));
        String[] array = new String[amount];
        for (int k = 0; k < amount; k++) {
            array[k] = infile.next();
        }
        infile.close();
        return array;
    }
}
