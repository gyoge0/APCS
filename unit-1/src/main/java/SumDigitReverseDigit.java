import java.util.Arrays;

public class SumDigitReverseDigit {

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static int sumDigits(int digit) {
        return Arrays.stream(Integer.toString(digit)
                .split(""))
            .map(Integer::parseInt)
            .reduce(Integer::sum)
            .get();
    }

    public static int reverseDigits(int digit) {
        return Integer.parseInt(new StringBuilder(Integer.toString(digit)).reverse().toString());
    }

}
