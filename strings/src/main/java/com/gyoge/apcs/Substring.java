// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("In:");
        String str = inp.nextLine();
        // Don't change the code above! Write your code below
        System.out.printf("The first 3 letters of %s is %s%n", str, str.substring(0, 3));
    }
}
