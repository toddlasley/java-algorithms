package me.toddlasley.questions.leetcode.medium.arraysandstrings;

// Given two integer arrays pushed and popped each with distinct values, return true if this could have been the
// result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;

        while (i < pushed.length && j < popped.length) {
            if (pushed[i] == popped[j]) {
                pushed[i] = -1;
                j++;

                while (i > 0 && pushed[i] == -1) {
                    i--;
                }
            } else {
                i++;
            }
        }

        i = pushed.length - 1;

        while (i > 0 && pushed[i] == -1) {
            i--;
        }

        while (i >= 0 && j < popped.length) {
            if (pushed[i] != popped[j]) {
                return false;
            }

            j++;

            while (i > 0 && pushed[i] == -1) {
                i--;
            }
        }

        return true;
    }
}
