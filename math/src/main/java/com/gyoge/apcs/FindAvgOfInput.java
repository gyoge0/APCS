// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;

public class FindAvgOfInput {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        // DO NOT CHANGE ABOVE CODE!  Write your code below
        // You can use the code below to get you started
        // use System.out.print("Enter a number or 9999 to quit: "); to prompt user
        // use inp.nextInt() to get a number from the user
        long count = 0;
        double num = 0;
        double sum = 0;
        while (true) {
            System.out.print("Enter a number or 9999 to quit: ");
            num = inp.nextDouble();
            if (num == 9999) break;
            count++;
            sum += num;
        }
        if (count == 0 || sum == 0) System.out.print("The average is 0.0");
        else System.out.print("The average is " + sum / count);
    }
}
