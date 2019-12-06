// 1.9: Assume you have a method called isSubstring which checks if one work is a subrsting of another.
// (I just used the String.indexOf method) Given two strings, s1 and s2, write code to check if s2 is a
// rotation of s1 using only one call to isSubstring.
// Solution: p. 206

package xyz.toddlasley.ctci.arraysandstrings;

public class StringRotation {
    //is s2 a rotated version of s1?
    //i.e. s1 = javaiscool, s2 = iscooljava, rotationCheck() returns true
    public static boolean rotationCheck(String s1, String s2) {
        if ( s1.length() == s2.length() && s1.length() != 0 ) {
            String duplicated = s2 + s2;
            return duplicated.indexOf(s1) > -1;
        }

        return false;
    }

    public static void main(String[] args){
        String s1 = "apple";
        String s2 = "pleap";
        String s3 = "dogsandcats";
        String s4 = "catsanddogs";
        String s5 = "iheartjava";
        String s6 = "javaiheart";

        System.out.println(String.format("%s is a rotated version of %s. %b", s2, s1, rotationCheck(s1, s2)));
        System.out.println(String.format("%s is a rotated version of %s. %b", s4, s3, rotationCheck(s3, s4)));
        System.out.println(String.format("%s is a rotated version of %s. %b", s6, s5, rotationCheck(s5, s6)));
    }
}
