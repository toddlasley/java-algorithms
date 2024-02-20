// Curly braces can be used in programming to provide scope-limit.
// Write a function to print all valid( properly opened and closed) combinations of n-pairs of curly braces.
// Example:
// input: 1 output: {}
// input: 2 output: {}{}, {{}}
// input: 3 output: {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}

package me.toddlasley.questions.interviews.arraysandstrings;

import java.util.ArrayList;
import java.util.List;

public class CurlyBraceCombinations {

    public static List<String> getCurlyBraceCombinations(int n) {
        final List<String> result = new ArrayList<>();

        curlyCombinationsHelper("", n, n, result);

        return result;
    }

    private static void curlyCombinationsHelper(String current, int left, int right, final List<String> combinations) {
        if (left == 0 && right == 0) {
            combinations.add(current);
        } else {
            if (left > 0) {
                curlyCombinationsHelper(current + "{", left - 1, right, combinations);
            }

            if (right > left) {
                curlyCombinationsHelper(current + "}", left, right - 1, combinations);
            }
        }
    }
}
