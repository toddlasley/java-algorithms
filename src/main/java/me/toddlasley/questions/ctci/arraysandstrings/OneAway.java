// 1.5: There are three types of edits that can be performed on strings: insert a character, remove a character,
// or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
// Solution: p. 199

package me.toddlasley.questions.ctci.arraysandstrings;
import java.lang.Math;

public class OneAway {
    public static boolean isStringOneEditAway(String s1, String s2){
        if ( Math.abs(s1.length() - s2.length() ) > 1 ) {
            return false;
        }

        String a = s1.length() > s2.length() ? s1 : s2;
        String b = s1.length() > s2.length() ? s2 : s1;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while ( index1 < a.length() && index2 < b.length() ) {
            if ( a.charAt(index1) != b.charAt(index2) ) {
                if ( foundDifference ) {
                    return false;
                }

                foundDifference = true;

                if ( a.length() == b.length() )
                    index2++;

            } else {
                index2++;
            }

            index1++;
        }

        return true;
    }

    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "abc";
        String s3 = "fdsa";
        String s4 = "fdsAab";
        String s5 = "lmnop";
        String s6 = "lmnopq";

        System.out.println(String.format(".isStringOneEditAway() result for %s and %s: %b",
                s1, s2, isStringOneEditAway(s1, s2)));
        System.out.println(String.format(".isStringOneEditAway() result for %s and %s: %b",
                s3, s4, isStringOneEditAway(s3, s4)));
        System.out.println(String.format(".isStringOneEditAway() result for %s and %s: %b",
                s5, s6, isStringOneEditAway(s5, s6)));
    }
}
