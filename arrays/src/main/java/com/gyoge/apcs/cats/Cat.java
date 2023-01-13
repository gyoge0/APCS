// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.cats;

@SuppressWarnings("unused")
public class Cat extends Pet {

    private String type;

    public Cat(String name, double weight) {
        super(name, weight);
        this.type = "mixed";
    }

    public Cat(String name, double weight, String type) {
        super(name, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cat{" + "type='" + type + '\'' + "} " + super.toString();
    }
}
