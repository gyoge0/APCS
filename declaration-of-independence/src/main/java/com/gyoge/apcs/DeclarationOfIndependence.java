// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class DeclarationOfIndependence {

    public List<WordFrequency> getWordFrequencies(String text) {
        return Arrays.stream(text.split(" "))
            .map(String::toLowerCase)
            .map(word -> word.replaceAll("[^a-zA-Z]", ""))
            .filter(word -> !word.isEmpty())
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
            .entrySet()
            .stream()
            .map(entry -> new WordFrequency(entry.getKey(), entry.getValue().intValue()))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
