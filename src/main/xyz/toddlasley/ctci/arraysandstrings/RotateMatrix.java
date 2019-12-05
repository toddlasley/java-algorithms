// 1.7: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees.
// Solution: p. 203

package xyz.toddlasley.ctci.arraysandstrings;

public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        if( matrix.length == 0 || matrix.length != matrix[0].length )
            throw new IllegalArgumentException("Parameter must be a valid NxN matrix");

        int n = matrix.length;
        for ( int layer = 0; layer < n/2; layer++ ) {
            //first and last serve as the "bounds" that we manipulate the matrix within
            int first = layer;
            int last = n - 1 - layer;

            for ( int i = first; i < last; i++ ) {
                // to account for indices on left and bottom sides
                int offset = i - first;

                //set the top aside
                int top = matrix[first][i];
                //copy left to top
                matrix[first][i] = matrix[last - offset][first];
                //copy bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];
                //copy right to bottom
                matrix[last][last - offset] = matrix[i][last];
                //copy original top to right
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1 , 2, 3, 4},
            { 12, 13, 14, 5},
            { 11, 16, 15, 6 },
            { 10, 9, 8, 7}};

        System.out.println("Before rotation:");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        rotate(matrix);

        System.out.println("After rotation:");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
