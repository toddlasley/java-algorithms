// 1.4: Given a string, write a function to check if it is a permutation of a palindrome.
// Solution: p. 196

package xyz.toddlasley.ctci.arraysandstrings;

public class PalindromePermutation {
    public static boolean isPermutationofPalindrome(String phrase){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];

        for(char c : phrase.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    public static int getCharNumber(char c){
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(a <= val && val <= z){
            return val - a;
        }

        return -1;
    }

    public static void main(String[] args){
        String s1 = "acereca";
        String s2 = "abcde";
        String s3 = "Kayka";

        System.out.println(String.format("isPermutationofPalindrome() result for %s: %b",
                s1, isPermutationofPalindrome(s1)));
        System.out.println(String.format("isPermutationofPalindrome() result for %s: %b",
                s2, isPermutationofPalindrome(s2)));
        System.out.println(String.format("isPermutationofPalindrome() result for %s: %b",
                s3, isPermutationofPalindrome(s3)));
    }
}
