import java.util.*;

public class Solution2 {

        int[][] nums;
        int[][] tree;
        int rowLen, colLen;

        public Solution2(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            rowLen = matrix.length;
            colLen = matrix[0].length;
            nums = new int[rowLen][colLen];
            tree = new int[rowLen + 1][colLen + 1];
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        public void update(int row, int col, int val) {
            int delta = val - nums[row][col];
            nums[row][col] += delta; // 更新nums一定要在update函数里，不能在constructor中
            for (int i = row + 1; i < rowLen + 1; i += lowBit(i)) { // index用lowBit更新
                for (int j = col + 1; j < colLen + 1; j += lowBit(j)) { // row和col一定加一开始
                    tree[i][j] += delta;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (rowLen == 0 || colLen == 0) {
                return 0;
            }
            return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
            // 四个rectangle，求切割部分, 以矩阵左上角为原点
        }

        private int sum(int row, int col) {
            int sum = 0;
            for (int i = row; i > 0; i -= lowBit(i)) {
                // tree数组比nums的xy坐标大1
                // sum求的是[row][col]左上点，到左上[0][0]的prefix sum
                // 所以，sumRegion中要变换坐标
                for (int j = col; j > 0; j -= lowBit(j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }

        private int lowBit(int num) {
            return (-num) & num; // 2’s complement AND original
        }


    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        Solution2 sol = new Solution2(matrix);
        sol.sumRegion(2,1,4,3);
        sol.update(3,2,2);
        sol.sumRegion(2,1,4,3);

    }
}
