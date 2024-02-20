// 1.1: Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures? (assuming ASCII character set)
// Solution: p. 192

package me.toddlasley.questions.ctci.arraysandstrings;

public final class IsUnique {
    public static boolean isUnique(String s){
        if(s.length() > 128)
            return false;

        boolean[] charSet = new boolean[128];
        for ( int i = 0; i < s.length(); i++ ) {
            int val = s.charAt(i);

            if ( charSet[val] ) {
                return false;
            }

            charSet[val] = true;
        }

        return true;
    }

    public static void main(String[] args){
        String s1 = "abcdefg";
        String s2 = "abbcdefgh";
        String s3 = "987654321";

        System.out.println(String.format("%s result for isUnique(): %b", s1, isUnique(s1)));
        System.out.println(String.format("%s result for isUnique(): %b", s2, isUnique(s2)));
        System.out.println(String.format("%s result for isUnique(): %b", s3, isUnique(s3)));
    }
}
