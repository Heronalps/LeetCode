/**
 * Created by michaelzhang on 4/25/17.
 */
import java.util.*;

class PointM{
    int row;
    int col;
    PointM(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class BuildPostOffice {
    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0){
            return -1;
        }
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    continue;
                }
                int[][] visited = new int[grid.length][grid[0].length];
                Queue<PointM> queue = new LinkedList<>();
                queue.offer(new PointM(i, j));
                int totalDis = 0;
                while(!queue.isEmpty()){
                    PointM current = queue.poll();
                    for (int k = 0; k < 4; k++){
                        int rowX = current.row + deltaX[k];
                        int colX = current.col + deltaY[k];
                        if (isValid(grid, rowX, colX) && visited[rowX][colX] == 0){
                            queue.offer(new PointM(rowX, colX));
                            visited[rowX][colX] = 1;
                        }
                    }
                    totalDis += Math.abs(current.row - i) + Math.abs(current.col - j);
                }
                minDis = Math.min(totalDis, minDis);
            }
        }
        return minDis;
    }
    private static boolean isValid(int[][] grid, int row, int col){
        // Within boundary and equals to 1
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},{1,0,1,1},{0,1,0,0}};
        System.out.println(shortestDistance(grid));
    }
}
