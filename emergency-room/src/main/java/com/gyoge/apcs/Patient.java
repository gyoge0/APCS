// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
public class Patient implements Comparable<Patient> {
    private final String name;
    private final int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return name + ": Priority " + priority;
    }

    @Override
    public int compareTo(Patient o) {
        return Integer.compare(this.priority, o.priority);
    }
}
