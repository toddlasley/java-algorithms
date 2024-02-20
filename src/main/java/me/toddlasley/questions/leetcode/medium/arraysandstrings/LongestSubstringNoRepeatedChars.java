package me.toddlasley.questions.leetcode.medium.arraysandstrings;

public class LongestSubstringNoRepeatedChars {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] table = new int[128];

        // use this variable to make note of the last string length
        // where a previous character was found
        int lastStringLength = 0;

        for ( int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);

            // if the current character has been seen before, we should
            // update lastStringLength if we have reached a larger length.
            // we want lastStringLength to be relative to the last matched
            // character
            lastStringLength = table[c] > 0
                    ? Math.max(lastStringLength, table[c])
                    : lastStringLength;

            // when we track characters that we've seen, we update the index
            // of table to be the current length that character was last seen
            table[c] = i + 1;

            // lastStringLength can change frequently, but result will only
            // be updated if the current length - the last matched string
            // length is greater than what we already have
            result = Math.max(result, i - lastStringLength + 1);
        }

        return result;
    }
}
