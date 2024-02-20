// Given a string containing digits from 2-9 inclusive, return all possible letter
// combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Note that 1 does not map to any letters.

//    1 ""     2 "abc"  3 "def"
//    4 "ghi"  5 "jkl"  6 "mno"
//    7 "pqrs" 8 "tuv"  9 "wxyz"

package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import java.util.List;
import java.util.ArrayList;

public class PhoneNumberLetterCombinations {
    private static final String[] LETTERS =  { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if ( digits != null && digits.length() > 0 ) {
            letterCombinationsHelper(0, digits, result, new StringBuilder());
        }

        return result;
    }

    private static void letterCombinationsHelper(int digitIndex, String digits, List<String> result, StringBuilder sb) {
        if ( digitIndex == digits.length() ) {
            result.add(sb.toString());
            return;
        }

        int letterIndex = Character.getNumericValue(digits.charAt(digitIndex)) - 2;
        String letters = LETTERS[letterIndex];

        for ( char c : letters.toCharArray() ) {
            StringBuilder newStringBuilder = new StringBuilder(sb);
            newStringBuilder.append(c);

            letterCombinationsHelper(digitIndex + 1, digits, result, newStringBuilder);
        }
    }
}
