package me.toddlasley.questions.leetcode.medium.arraysandstrings;

// You have a keypad with 9 buttons, numbered from 1 to 9, each mapped to lowercase English letters. You can
// choose which characters each button is matched to as long as:
// - All 26 lowercase English letters are mapped to.
// - Each character is mapped to by exactly 1 button.
// - Each button maps to at most 3 characters.

// To type the first character matched to a button, you press the button once. To type the second character,
// you press the button twice, and so on.
// Given a string s, return the minimum number of key presses needed to type s using your keypad.

import java.util.Arrays;

public class MinimumKeyPresses {
    private static final int KEY_PRESS_BUTTON_COUNT = 9;
    private static final int LAST_INDEX = 25;

    public static int minimumKeyPresses(String s) {
        final int[] letterCounts = new int[26];

        for (char c : s.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        Arrays.sort(letterCounts);

        int i = LAST_INDEX;
        int result = 0;

        while (i >= 0 && letterCounts[i] > 0) {
            if (i > LAST_INDEX - KEY_PRESS_BUTTON_COUNT) {
                result += letterCounts[i];
            } else if (i > LAST_INDEX - (2 * KEY_PRESS_BUTTON_COUNT)) {
                result += 2 * letterCounts[i];
            } else {
                result += 3 * letterCounts[i];
            }

            i--;
        }

        return result;
    }
}
