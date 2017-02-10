/**
 * Created by michaelzhang on 2/8/17.
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        //Sanity check
        if (matrix == null || matrix.length == 0) {
            return false;
        }
//Binary search first column
        int row = bsColumn(matrix, target);
        if (row == -1) {
            return true;
        }
        return bsRow(matrix, row, target);

    }
    public static boolean bsRow(int[][] matrix, int row, int target) {
        int start = 0, end = matrix[0].length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][end] == target) {
            return true;
        }
        if (matrix[row][start] == target) {
            return true;
        }
        return false;
    }

    public static int bsColumn(int[][] matrix, int target){
        int start = 0, end = matrix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end][0] == target) {
            return -1;
        }
        if (matrix[start][0] == target) {
            return -1;
        }
        if(matrix[end][0] > target) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix, 3));
    }
}
