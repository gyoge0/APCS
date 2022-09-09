// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

public class DogKennel {

    public static void main(String[] args) {
        String[] nameArray = {"WolfieWolfie", "Sledder", "Eclipse"};
        String[] breedArr = {"Huskie", "Part-Huskie", "Mutt"};
        double[] weightArray = {30.0, 40.0, 50.2};

        Dog[][] dogKennel = fillDogKennel(nameArray, breedArr, weightArray, 3, 2);

        for (Dog[] dogRow : dogKennel) {
            for (Dog tempDog : dogRow) {
                System.out.println(tempDog);
            }
        }
    }

    public static Dog[][] fillDogKennel(
            String[] nameArray,
            String[] breedArray,
            double[] weightArray,
            int rowLength,
            int colLength) {

        int i = 0;
        Dog[][] returnKennel = new Dog[rowLength][colLength];
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (i < nameArray.length) {
                    returnKennel[r][c] = new Dog(nameArray[i], breedArray[i], weightArray[i]);
                    i++;
                }
            }
        }
        return returnKennel;
    }
}
