import java.util.*;



class Solution {

    class NumMatrix {
        int[][] prefix;
        public NumMatrix(int[][] matrix) {
            int rows = matrix.length;
            if (rows == 0) { // Guard 一下matrix为空的情况
                return;
            }
            int cols = matrix[0].length;
            prefix = new int[rows + 1][cols + 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    prefix[i + 1][j + 1]
                            = prefix[i][j + 1] +
                              prefix[i + 1][j] -
                              prefix[i][j] +
                              matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefix[row2 + 1][col2 + 1] -
                    prefix[row2 + 1][col1] -
                    prefix[row1][col2 + 1] +
                    prefix[row1][col1];
            // D点要用它的右下点，B要用右点，C要用下点，A不变。

        }
    }



    public static void main(String[] args) {

    }


}


