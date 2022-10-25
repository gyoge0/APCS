// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.dog;

@SuppressWarnings("unused")
public class Dog {

    private final String name;
    private final String breed;
    private final double weight;

    public Dog(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.breed = "Mutt";
    }

    public Dog(String name, String breed, double weight) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Dog{name='%s', breed='%s', weight=%s}", name, breed, weight);
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public double getWeight() {
        return weight;
    }
}
