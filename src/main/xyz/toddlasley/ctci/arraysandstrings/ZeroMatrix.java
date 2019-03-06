// 1.8: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
// Solution: p. 204

package xyz.toddlasley.ctci.arraysandstrings;

public class ZeroMatrix {
    public static void zero(int[][] matrix){
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i < rows.length; i++){
            if(rows[i]){
                zeroRow(matrix, i);
            }
        }

        for(int i = 0; i < columns.length; i++){
            if(columns[i]){
                zeroColumn(matrix, i);
            }
        }
    }

    private static void zeroRow(int[][] matrix, int row){
        for(int j = 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    private static void zeroColumn(int[][] matrix, int column){
        for(int j = 0; j < matrix.length; j++){
            matrix[j][column] = 0;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1 , 0, 3, 4},
                { 12, 13, 14, 5},
                { 11, 16, 15, 6 },
                { 0, 9, 8, 7}};

        System.out.println("Before zero:");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }

        zero(matrix);

        System.out.println("After zero:");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
