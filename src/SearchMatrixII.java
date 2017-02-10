/**
 * Created by michaelzhang on 2/9/17.
 */
public class SearchMatrixII {
    public static int searchMatrix(int[][] matrix, int target) {
        //Sanity check
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length - 1;
        int col = 0;
        int counter = 0;
        while(inBound(row, col, matrix)) {
            if (matrix[row][col] == target) {
                counter++;
                row--;
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return counter;
    }
    public static boolean inBound(int row, int col, int[][] matrix) {
        if (row < 0 || col < 0 || row > matrix.length || col > matrix[row].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{2,4,7,8},{3,5,9,10}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
