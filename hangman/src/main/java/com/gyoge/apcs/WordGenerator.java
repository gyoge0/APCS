// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;

@SuppressWarnings("all")
public class WordGenerator {

    public static String getWord() {
        Scanner file;
        String filename = "/hangmanWords.txt";
        file = new Scanner(WordGenerator.class.getResourceAsStream(filename));
        int nWords = file.nextInt();
        int cnt = (int) (Math.random() * nWords);

        System.out.println("picking from: " + filename + " nWords: " + nWords + " offset: " + cnt);
        for (int k = 0; k < cnt; k++) {
            file.next();
        }

        String word = file.next();
        return word;
    }
}
