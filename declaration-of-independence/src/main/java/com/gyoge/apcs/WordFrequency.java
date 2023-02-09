// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class WordFrequency implements Comparable<WordFrequency> {
    private String word;
    private int frequency;

    @Override
    public String toString() {
        return "WordFrequency{" + "word='" + word + '\'' + ", frequency=" + frequency + '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(WordFrequency o) {
        if (this.frequency > o.frequency) return 1;
        if (this.frequency < o.frequency) return -1;
        return this.word.compareTo(o.word);
    }
}
