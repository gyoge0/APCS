// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("EnhancedSwitchMigration")
public class HawaiianPhonetics {

    /* Returns true if the word is a valid Hawaiian word
     * false otherwise
     * Print out a message listing the invalid character(s)
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean validateWord(String word) {
        Set<Character> chars = Set.of('p', 'h', 'k', 'l', 'm', 'n', 'a', 'e', 'i', 'o', 'u', 'w');
        //noinspection SuspiciousMethodCalls
        return word.chars().boxed().allMatch(chars::contains);
    }

    // create and return the phonetic representation of the input Hawaiian word
    public static String generatePhonetic(String word) {
        StringBuilder phonetic = new StringBuilder();
        char[] chars = word.toCharArray();

        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            char next;
            if (i + 1 < chars.length) {
                next = chars[i + 1];
            } else {
                next = ' ';
            }
            char next2;
            if (i + 2 < chars.length) {
                next2 = chars[i + 2];
            } else {
                next2 = ' ';
            }

            switch (Character.toLowerCase(c)) {
                case 'a':
                    switch (Character.toLowerCase(next)) {
                        case 'i':
                        case 'e':
                            phonetic.append("eye");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'o':
                        case 'u':
                            phonetic.append("ow");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'w':
                            phonetic.append("ah-w");
                            i++;
                            break;
                        default:
                            phonetic.append("ah");
                            // no i++ here because we still need to handle next
                            if (Character.isLetter(next)) phonetic.append("-");
                            break;
                    }
                    break;
                case 'e':
                    switch (Character.toLowerCase(next)) {
                        case 'i':
                            phonetic.append("ay");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'u':
                            phonetic.append("eh-oh");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'w':
                            phonetic.append("eh-v");
                            i++;
                            break;
                        default:
                            phonetic.append("eh");
                            if (Character.isLetter(next)) phonetic.append("-");
                            break;
                    }
                    break;
                case 'i':
                    switch (Character.toLowerCase(next)) {
                        case 'u':
                            phonetic.append("ew");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'w':
                            phonetic.append("ee-v");
                            i++;
                            break;
                        default:
                            phonetic.append("ee");
                            if (Character.isLetter(next)) phonetic.append("-");
                            break;
                    }
                    break;
                case 'o':
                    switch (Character.toLowerCase(next)) {
                        case 'i':
                            phonetic.append("oy");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'u':
                            phonetic.append("ow");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'w':
                            phonetic.append("oh-w");
                            i++;
                            break;
                        default:
                            phonetic.append("oh");
                            if (Character.isLetter(next)) phonetic.append("-");
                            break;
                    }
                    break;
                case 'u':
                    switch (Character.toLowerCase(next)) {
                        case 'i':
                            phonetic.append("oo-ee");
                            if (Character.isLetter(next2)) {
                                phonetic.append("-");
                            }
                            i++;
                            break;
                        case 'w':
                            phonetic.append("oo-w");
                            i++;
                            break;
                        default:
                            phonetic.append("oo");
                            if (Character.isLetter(next)) phonetic.append("-");
                            break;
                    }
                    break;
                default:
                    phonetic.append(c);
                    break;
            }
            i++;
        }
        phonetic.replace(0, 1, phonetic.substring(0, 1).toUpperCase());
        return phonetic.toString();
    }

    // gather user input
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word;

        // super janky while loop setup!
        while (true) {
            // get input
            System.out.println("Please enter a Hawaiian word to pronounce.");
            word = s.nextLine();
            // check if input is valid
            if (!validateWord(word)) {
                System.out.println("Please enter a valid Hawaiian word!");
                continue;
            }

            // generate and print phonetic
            System.out.println("The phonetic for " + word + " is " + generatePhonetic(word));

            // ask if they want to go again
            System.out.println("Would you like to enter another word? (Enter YES (Y) or NO (N)");
            word = s.nextLine();
            word = word.toUpperCase();
            if (!word.equals("Y") && !word.equals("YES")) {
                break;
            }
        }
    }
}
