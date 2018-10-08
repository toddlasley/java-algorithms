// 1.2: Given two strings, write a method to decide if one is a permutation of the other.
// Solution: p. 193 (assume case sensitive and whitespace is significant)

package ctci.arraysandstrings;

public class CheckPermutation {
    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        int[] letters = new int[128]; //assuming ASCII character set
        for(int i = 0; i < s1.length(); i++){
            letters[s1.charAt(i)]++;
        }

        for(int i = 0; i < s2.length(); i++){
            char val = s2.charAt(i);
            letters[val]--;

            if(letters[val] < 0){
                return false;
            }
        }

        //because both strings are equal in length, any mismatch between the two strings
        //will be detected in the second for loop
        return true;
    }

    public static void main (String[] args){
        String s1 = "abcd";
        String s2 = "dabc";
        String s3 = "lmnop";
        String s4 = "noqlm";
        String s5 = "abcde ";
        String s6 = "edcba";

        System.out.println(String.format("%s and %s isPermutation() result: %b", s1, s2, isPermutation(s1, s2)));
        System.out.println(String.format("%s and %s isPermutation() result: %b", s3, s4, isPermutation(s3, s4)));
        System.out.println(String.format("%s and %s isPermutation() result: %b", s5, s6, isPermutation(s5, s6)));
    }
}
