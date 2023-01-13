// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs.cats;

public class CatKennel {

    @SuppressWarnings("unused")
    public static void removeHighestWeight(Cat[] cats) {
        int idx = 0;
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getWeight() > cats[idx].getWeight()) {
                idx = i;
            }
        }
        cats[idx] = null;
    }

    public static void main(String[] args) {
        String[] nameArray = {"KittyAmazing", "Snowball", "Muffin"};
        String[] typeArr = {"Tabby", "Black", "Mutt"};
        double[] weightArray = {30.0, 40.0, 50.2};

        Cat[] catKennel = fillCatKennel(nameArray, typeArr, weightArray, 10);

        for (Cat tempCat : catKennel) {
            System.out.println(tempCat);
        }
    }

    public static Cat[] fillCatKennel(
            String[] names, String[] types, double[] weights, int numCats) {
        Cat[] kennel = new Cat[numCats];
        for (int i = 0; i < types.length; i++) {
            kennel[i] = new Cat(names[i], weights[i], types[i]);
        }
        return kennel;
    }
}
