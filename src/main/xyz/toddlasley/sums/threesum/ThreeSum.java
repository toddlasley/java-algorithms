// brute force three sum algorithm.
// given an array of distinct numbers, how many triples equal a given value?

package xyz.toddlasley.sums.threesum;

public class ThreeSum
{
    public static int count(int[] a, int value)
    {
        int N = a.length;
        int count = 0;
        
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
                for(int k = j + 1; k < N; k++)
                    if(a[i] + a[j] + a[k] == value)
                        count++;
        
        return count;
    }

    public static void main(String[] args)
    {
        //test
    }
}