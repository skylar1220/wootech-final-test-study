package mission.util.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private Converter() {
    }

    public static List<String> splitToList(String separator, String value) {
        return Arrays.asList(value.split(separator));
    }

    public static List<String> splitToTrimedList(String separator, String value) {
        return Arrays.stream(value.split(separator))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertToInteger(List<String> values) {
        return values.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<Integer> splitToIntegerList(String separator, String value) {
        return convertToInteger(splitToList(separator, value));
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String splitValue(String separator, int index, String value) {
        return splitToList(separator, value).get(index);
    }

    private static double roundToDecimalPlaces(double number, int decimalPlaces) {
        int placeValue = 1;
        for (int currentPlace = 0; currentPlace < decimalPlaces; currentPlace++) {
            placeValue *= 10;
        }
        return Math.round(number * placeValue) / (double) placeValue;
    }
}
