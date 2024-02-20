// 1.3: Write a method to replace all spaces in a string with "%20".
// You may assume that the string has sufficient space aat the end to hold
// the additional characters, and that you are given the "true" length of the string.
// Solution: p.194

package me.toddlasley.questions.ctci.arraysandstrings;

public class URLify {
    public static String replaceSpaces(char[] s, int trueLength) {
        int spaces = 0;
        int index = 0;

        for ( int i = 0; i < trueLength; i++ ) {
            if ( s[i] == ' ' )
                spaces++;
        }

        index = trueLength + spaces * 2;

         if ( trueLength < s.length )
            s[trueLength] = '\0'; //end the array

        for ( int i = trueLength - 1; i >= 0; i-- ) {
            if ( s[i] == ' ' ) {
                s[index - 1] = '0';
                s[index - 2] = '2';
                s[index - 3] = '%';
                index -= 3;
            } else {
                s[--index] = s[i];
            }
        }

        return new String(s);
    }

    public static void main(String[] args){
        String s1 = "Todd Lasley  ";
        String s2 = "This is a string      ";
        String s3 = "Make it a URL      ";

        System.out.println(String.format("URLify for '%s': %s:", s1, replaceSpaces(s1.toCharArray(), 11)));
        System.out.println(String.format("URLify for '%s': %s", s2, replaceSpaces(s2.toCharArray(), 16)));
        System.out.println(String.format("URLify for '%s': %s", s3, replaceSpaces(s3.toCharArray(), 13)));
    }
}
