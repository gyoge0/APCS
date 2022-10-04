// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings(value = {"SpellCheckingInspection"})
public class PigLatin {

    public static void main(String[] args) {
        part_1_using_pig();
        // part_2_using_piglatenizeFile();
    }

    public static void part_1_using_pig() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nWhat word? ");
            String s = sc.next();
            if (s.equals("-1")) System.exit(0);
            String p = pig(s);
            System.out.println(p);
        }
    }

    private static final List<Character> VOWELS = Arrays.asList('a', 'e', 'i', 'o', 'u');

    @SuppressWarnings("SpellCheckingInspection")
    private static final List<Character> VOWELSY = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');

    private static final List<Character> PUNCTUATION = Arrays.asList('.', '!', '?', '"');

    public static String pig(String str) {
        char last = str.charAt(str.length() - 1);
        char first = str.charAt(0);

        // I was so proud of myself for this one
        if (PUNCTUATION.contains(last)) {
            return pig(str.substring(0, str.length() - 1)) + last;
        }
        if (PUNCTUATION.contains(first)) {
            return first + pig(str.substring(1));
        }

        String lower = str.toLowerCase();
        char firstLower = lower.charAt(0);

        // start capitalization
        boolean startIsCaps = Character.isUpperCase(first);
        if (startIsCaps) str = firstLower + str.substring(1);

        StringBuilder sb = new StringBuilder(str.length());

        // str[0] will always be lower at this point
        // starting with vowel case
        if (VOWELS.contains(firstLower)) {
            // keep caps even if it starts with caps
            if (startIsCaps) {
                sb.append(Character.toUpperCase(first));
                sb.append(str.substring(1));
            } else sb.append(str);
            sb.append("way");
            return sb.toString();
        }

        // i = 1 because str[0] already checked
        for (int i = 1; i < str.length(); i++) {
            if (VOWELSY.contains(lower.charAt(i))) {
                if (lower.charAt(i) == 'u' && lower.charAt(i - 1) == 'q') {
                    // qu case
                    i++;
                }

                // keep caps
                if (startIsCaps) {
                    sb.append(Character.toUpperCase(str.charAt(i)));
                    sb.append(str.substring(i + 1));
                } else sb.append(str.substring(i));
                sb.append(str, 0, i);
                sb.append("ay");

                return sb.toString();
            }
        }

        return "**** INVALID ****";
    }

    public static void part_2_using_piglatenizeFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
        String filename = sc.next();
        Scanner infile;

        //noinspection DataFlowIssue
        infile = new Scanner(PigLatin.class.getResourceAsStream(filename)); // PigLatin.txt

        System.out.print("Output Filename (Including .txt)? Example: PigLatinOut.txt:");
        String filenameOut = sc.next();
        piglatenizeFile(infile, filenameOut);
        System.out.println("Piglatin done!");
        sc.close();
    }

    /******************************
     *  precondition:  filename has .txt
     *  postcondition:  output a piglatinized .txt file
     *.
     ******************************/
    public static void piglatenizeFile(Scanner infile, String filename) {
        StringBuilder sb = new StringBuilder();
        while (infile.hasNext()) {
            String line = infile.nextLine();
            if (line.isBlank()) sb.append(line);
            else sb.append(pig(line));
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            bufferedWriter.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
