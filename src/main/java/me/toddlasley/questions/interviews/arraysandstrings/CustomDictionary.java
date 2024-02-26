package me.toddlasley.questions.interviews.arraysandstrings;

import java.util.HashMap;
import java.util.Map;

public class CustomDictionary {
    public static boolean isSorted(final String[] words, final char[] sort) {
        final Map<Character, Integer> key = new HashMap<>();

        for (int i = 0; i < sort.length; i++) {
            key.put(sort[i], i);
        }

        for (int i = 1; i < words.length; i++) {
            final String x = words[i - 1];
            final String y = words[i];

            final int shortestLength = Math.min(x.length(), y.length());

            for (int j = 0; j < shortestLength; j++) {
                final char xLetter = x.charAt(j);
                final char yLetter = y.charAt(j);

                if (key.get(xLetter) > key.get(yLetter) || (key.get(xLetter) == key.get(yLetter) && j == shortestLength - 1 && x.length() > y.length())) {
                    return false;
                } else if (key.get(xLetter) < key.get(yLetter)) {
                    break;
                }
            }
        }

        return true;
    }
}
