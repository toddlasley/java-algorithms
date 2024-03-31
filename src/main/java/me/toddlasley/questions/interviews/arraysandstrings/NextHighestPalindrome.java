package me.toddlasley.questions.interviews.arraysandstrings;

// Given a number, find the next highest palindrome.

public class NextHighestPalindrome {

    public static int[] nextHighestPalindrome(final int[] number) {
        if (number == null || number.length == 0) {
            return null;
        } else if (number.length == 1) {
            if (number[0] == 9) {
                return new int[] {1, 1};
            } else {
                number[0]++;
                return number;
            }
        }

        final int mid = (number.length - 1) / 2;
        int left = mid;
        int right = left + 1;
        final boolean isOddLength = number.length % 2 != 0;

        if (isOddLength) {
            left--;
        }

        while (left >= 0 && number[left] == 9 && number[left] == number[right]) {
            left--;
            right++;
        }

        if (left < 0) {
            final int[] newNumber = new int[number.length + 1];
            newNumber[0] = 1;
            newNumber[number.length] = 1;
            return newNumber;
        } else if (number[right] < number[left]) {
            matchOutward(number, left, right);
        } else if (number[left] <= number[right]) {
            if (isOddLength && number[mid] != 9) {
                number[mid]++;
                matchOutward(number, mid - 1, mid + 1);
            } else {
                while (number[left] == 9) {
                    left--;
                    right++;
                }

                number[left]++;
                zeroBetween(number, left + 1, right - 1);
                matchOutward(number, left, right);
            }
        }

        return number;
    }

    private static void matchOutward(final int[] number, int left, int right) {
        while (left >= 0) {
            number[right] = number[left];

            left--;
            right++;
        }
    }

    private static void zeroBetween(final int[] number, int from, int to) {
        for (int i = from; i <= to; i++) {
            number[i] = 0;
        }
    }
}
