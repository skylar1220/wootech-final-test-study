package mission.util.validatorFixErrorMessage;

import java.util.List;
import java.util.Set;

public class GeneralValidator {
    private GeneralValidator() {
    }

    public static void validateSingleSeparator(String separator, String value, String message) {
        if (containsDuplicateSubstring(separator, value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateStartsWith(String separator, String value, String message) {
        if (value.startsWith(separator)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateEndsWith(String separator, String value, String message) {
        if (value.endsWith(separator)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotStartsWith(String subString, String value, String message) {
        if (value.startsWith(subString)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotEndsWith(String subString, String value, String message) {
        if (value.endsWith(subString)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateListForDuplicates(List<String> values, String message) {
        if (hasDuplicates(values)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateMinimumSplitCount(String seperator, String value, int minSplittedCount, String message) {
        List<String> values = Converter.splitToList(seperator, value);
        if (!hasOverMinCount(values, minSplittedCount)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateSplitCount(String seperator, String value, int requiredCount, String message) {
        List<String> values = Converter.splitToList(seperator, value);
        if (!hasValidCount(values, requiredCount)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateCount(List<String> values, int requiredCount, String message) {
        if (hasValidCount(values, requiredCount)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean containsDuplicateSubstring(String substring, String value) {
        String doubleSubstring = substring.repeat(2);
        return value.contains(doubleSubstring);
    }

    private static boolean hasDuplicates(List<String> values) {
        return Set.copyOf(values).size() != values.size();
    }

    private static boolean hasOverMinCount(List<String> values, int minSplittedCount) {
        return values.size() >= minSplittedCount;
    }

    private static boolean hasValidCount(List<String> values, int requiredCount) {
        return values.size() == requiredCount;
    }
}
