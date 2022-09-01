// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.stream.IntStream;

public class SumOddsInRange {

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static int sumOddsInRange(int num1, int num2) {
        return IntStream.range(num1, num2 + 1)
            .boxed()
            .filter(i -> i % 2 != 0)
            .reduce(Integer::sum)
            .get();
    }
}
