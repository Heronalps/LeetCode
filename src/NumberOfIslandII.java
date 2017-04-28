import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaelzhang on 4/28/17.
 */
public class NumberOfIslandII {
    class UnionFind{
        int[] parent;

        UnionFind(int n, int m){
            //Put point and representative pairs into the map
            parent = new int[n * m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    int index = convertToID(i, j, m);
                    parent[index] = index;
                }
            }
        }
        int compressed_find(int point){
            if (point == parent[point]){
                return point;
            }
            parent[point] = compressed_find(parent[point]);
            return parent[point];
        }

        void union(int pointX, int pointY){
            int parentX = compressed_find(pointX);
            int parentY = compressed_find(pointY);
            if (parentX == parentY){
                return;
            }
            parent[parentX] = parentY;
        }
    }

    private int convertToID(int x, int y, int n){
        return x * n + y;
    }

    private boolean isValid(int[][] matrix, int row, int col){
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] == 1){
            return true;
        }
        return false;
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (operators == null || operators.length == 0){
            return result;
        }
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        int[][] matrix = new int[n][m];
        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        for (Point point : operators){
            if (matrix[point.x][point.y] != 1){
                matrix[point.x][point.y] = 1;
                count++;
                int index = convertToID(point.x, point.y, m);
                for (int i = 0; i < 4; i++) {
                    int row = point.x + deltaX[i];
                    int col = point.y + deltaY[i];
                    if (isValid(matrix, row, col)) {
                        int indexPrime = convertToID(row, col, m);
                        int parentX = uf.compressed_find(index);
                        int parentY = uf.compressed_find(indexPrime);
                        if (parentX != parentY) {
                            uf.union(index, indexPrime);
                            count--;
                        }
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}
