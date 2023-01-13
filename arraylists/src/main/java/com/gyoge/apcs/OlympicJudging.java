// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OlympicJudging {

    public static void main(String[] args) {
        String[] judgesArr = {"USA", "East Germany", "Botswana", "Eritrea", "Canada"};

        List<Double> scoreList = getScores(judgesArr);
        System.out.println("Scores before removal: " + scoreList);

        removeHighLow(scoreList);
        System.out.println("Scores after removal: " + scoreList);

        double average = getAverage(scoreList);

        System.out.format("Average score: %.2f%n", average);
    }

    public static List<Double> getScores(String[] judgesArr) {
        ArrayList<Double> s = new ArrayList<>();
        Scanner inp = new Scanner(System.in);
        for (String j : judgesArr) {
            System.out.print("Enter the score for " + j + ": ");
            s.add(inp.nextDouble());
        }

        return s;
    }

    public static void removeHighLow(List<Double> s) {
        double l = s.get(0);
        double h = s.get(0);
        for (double i : s) {
            l = Math.min(l, i);
            h = Math.max(h, i);
        }
        s.remove(l);
        s.remove(h);
    }

    public static double getAverage(List<Double> s) {
        double sum = 0;
        for (double i : s) {
            sum += i;
        }
        return sum / s.size();
    }
}
