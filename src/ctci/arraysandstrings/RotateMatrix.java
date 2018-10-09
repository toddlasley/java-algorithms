// 1.7: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
// write a method to rotate the image by 90 degrees.
// Solution: p. 203

package ctci.arraysandstrings;

public class RotateMatrix {
    public static int[][] rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length)
            throw new IllegalArgumentException("Paramter must be a valid NxN matrix");

        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - 1 - layer;

            for(int i = first; i < last; i++){
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }

        return matrix;
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

        matrix = rotate(matrix);

        System.out.println("After rotation:");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
