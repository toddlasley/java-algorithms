// Given a paragraph and a list of banned words, return the most frequent word that is not in the list
// of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer
// is unique.
// Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the
// paragraph are not case sensitive.  The answer is in lowercase.

package xyz.toddlasley.leetcode.easy.arraysandstrings;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String result = "";

        Set<String> bannedWords = new HashSet<>();

        for ( int i = 0; i < banned.length; i++ ) {
            bannedWords.add(banned[i]);
        }

        Map<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase().trim();

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < paragraph.length(); i++ ) {
            char c = paragraph.charAt(i);

            if ( c >= 'a' && c <= 'z' ) {
                sb.append(c);
            } else if ( sb.length() > 0 ) {
                addWordCountToMap(sb.toString(), map, bannedWords);

                sb = new StringBuilder();
            }

            if ( i == paragraph.length() - 1 && sb.length() > 0 ) {
                addWordCountToMap(sb.toString(), map, bannedWords);
            }
        }

        int currentMax = 0;

        for ( String word : map.keySet() ) {
            int count = map.get(word);
            if ( count > currentMax ) {
                currentMax = count;
                result = word;
            }
        }

        return result;
    }

    private static void addWordCountToMap(String word, Map<String, Integer> map, Set<String> bannedWords) {
        if ( !bannedWords.contains(word) ) {
            if ( map.containsKey(word) ) {
                int count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }
    }
}
