// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.cats;

@SuppressWarnings("unused")
public abstract class Pet {

    private String name;
    private double weight;

    public Pet(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" + "name='" + name + '\'' + ", weight=" + weight + '}';
    }
}
