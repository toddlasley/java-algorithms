// three sum algorithm that uses binary search
// given an array of distinct numbers, how many triples equal a given value?
// order of growth is N^2 log n with binary search being the key
// difference maker

public class ThreeSumBinarySearch
{
    public static int count(int[] a, int value)
    {
        int N = a.length;
        int count = 0;

        // sort the array (insertion sort O(N^2))
        // one might argue that something like merge sort would
        // be the better option but this portion of the algorithm 
        // has little impact when it comes to order of growth
        for(int i = 1; i < N; i++)
        {
            int j = i - 1;
            int n = a[i];

            while(n < a[j] && j >= 0)
            {
                a[j + 1] = a[j];
                j--;
            }
            
            a[j + 1] = n;
        }
        
        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
            {
                //search for the last value that will
                //complete the three-sum (binary search O(log n))
                int key = value - (a[i] + a[j]);

                int low = 0, high = N - 1;

                while (low <= high)
                {
                    int mid = low + (high - low) / 2;
                    if (key < a[mid])
                        high = mid - 1;
                    else if(key > a[mid])
                        low = mid + 1;
                    else
                        if(mid > j)
                            count++;
                }
            }
        
        return count;
    }

    public static void main(String[] args)
    {
        //test
    }
}