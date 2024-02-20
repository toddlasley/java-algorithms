// Given an array of strings, group anagrams together.
// Original: https://bit.ly/2FeAwKi

package me.toddlasley.questions.leetcode.medium.arraysandstrings;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for ( int i = 0; i < strs.length; i++ ) {
            String currentString = strs[i];

            int[] table = new int[26];

            for ( char c : currentString.toCharArray() ) {
                table[c - 'a']++;
            }

            String key = Arrays.toString(table);

            List list = map.getOrDefault(key, new ArrayList<String>());

            list.add(currentString);

            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
