// 1.6: Implement a method to perform basic string compression using the counts of repeated characters.
// (EX: aaabccccd = a3b1c3d1) If the compressed string would not become smaller than the original string,
// your method should return the original string;
// Solution: p. 202

package ctci.arraysandstrings;

public class StringCompression {
    public static String compress(String s){
        //the code in getCompressedLength is largely duplicated, but this can help reduced overhead if the
        //string has a lot of unique values and it enables us to initialize our StringBuilder with the resulting size
        int compressedLength = getCompressedLength(s);
        if(s.length() <= compressedLength){
            return s;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
        int consecutiveCount = 0;

        for(int i = 0; i < s.length(); i++){
            consecutiveCount++;

            if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)){
                sb.append(String.format("%s%s", s.charAt(i), String.valueOf(consecutiveCount)));
                consecutiveCount = 0;
            }
        }

        return sb.toString();
    }

    public static int getCompressedLength(String s){
        int consecutiveCount = 0;
        int compressedLength = 0;
        for(int i = 0; i < s.length(); i++){
            consecutiveCount++;

            if(i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)){
                compressedLength += 1 + String.valueOf(consecutiveCount).length();
                consecutiveCount = 0;
            }
        }

        return compressedLength;
    }

    public static void main(String[] args){
        String s1 = "aaabbcddd";
        String s2 = "abcdefg";
        String s3 = "aaaaaaaaaaaaabccd";

        System.out.println(String.format(".compress() result for %s: %s", s1, compress(s1)));
        System.out.println(String.format(".compress() result for %s: %s", s2, compress(s2)));
        System.out.println(String.format(".compress() result for %s: %s", s3, compress(s3)));
    }
}
