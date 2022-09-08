package com.gyoge.apcs;

public class ISBN10 {

    public static String computeISBN10(int num) {
        int sum = 0;
        int tmp = num;
        for (int i = 9; i >= 1; i--) {
            int digit = num % 10;
            sum += i * digit;
            num /= 10;
        }
        int r = sum % 11;
        return tmp + "-" + (r == 10 ? "X" : r);
    }


    public static void testIsbn10(int num) {

        String isbn = computeISBN10(num);
        System.out.println("ISBN-10: " + isbn);

        System.out.println("==========================================");
    }


    public static void main(String[] args) {
        testIsbn10(13601267);
        testIsbn10(13031997);
        testIsbn10(158939758);
    }

}
