// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class HashMapApplication {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Objects.requireNonNull(HashMapApplication.class.getResourceAsStream(
            "/dictionary.txt")));

        java.util.List<String> wordsList = new java.util.LinkedList<>();
        while (scanner.hasNext()) {
            wordsList.add(scanner.nextLine());
        }


        long hashTotalTime = 0;
        long binaryTotalTime = 0;
        int numLookups = 0;
        int errBinary = 0;
        int errHash = 0;
        int numIterations = 5000000;
        String[] words = wordsList.toArray(new String[0]);

        HashMap<String, String> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, word);
        }

        for (int i = 0; i < numIterations; i++) {
            numLookups++;
            String word = words[random.nextInt(words.length)];
            long start = System.nanoTime();
            try {
                Searches.binary(words, word);
            } catch (Exception e){
                errBinary++;
            } finally {
                binaryTotalTime += System.nanoTime() - start;
            }

            start = System.nanoTime();
            try {
                wordsMap.get(word);
            } catch (Exception e) {
                errHash++;
            } finally {
                hashTotalTime += System.nanoTime() - start;
            }
        }

        System.out.println("binaryTotalTime = " + binaryTotalTime);
        System.out.println("errBinary = " + errBinary);
        System.out.println("hashTotalTime = " + hashTotalTime);
        System.out.println("errHash = " + errHash);
    }
}
