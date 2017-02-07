import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by michaelzhang on 2/6/17.
 */
public class BuildPostOfficeII {
    private int EMPTY = 0;
    private int HOUSE = 1;
    private int WALL  = 2;
    private int[] deltaR = {-1, 0, 1, 0};
    private int[] deltaC = {0, -1, 0, 1};
    private int[][] grid;
    private int ROW, COL;

    public void	setGrid(int[][] grid){
        ROW = grid.length;
        COL = grid[0].length;
        this.grid = grid;
    }

    public List<Point> getPoints(int type){
        List<Point> result = new ArrayList<>();
        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == type) {
                    result.add(new Point(row, col));
                }
            }
        }
        return result;
    }

    public void bfs(Point house, int[][] distanceSum, int[][] visitedSum) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[ROW][COL];
        queue.offer(house);
        visited[house.x][house.y] = true;
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while(size > 0){
                Point current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Point adjacent = new Point(current.x + deltaR[i], current.y + deltaC[i]);
                    if (!inBound(adjacent)) {
                        continue;
                    }
                    if (visited[adjacent.x][adjacent.y] == true) {
                        continue;
                    }
                    visited[adjacent.x][adjacent.y] = true;
                    distanceSum[adjacent.x][adjacent.y] += step;
                    visitedSum[adjacent.x][adjacent.y]++;
                    queue.offer(adjacent);
                }
                size--;
            }
        }
    }

    public boolean inBound(Point point){
        if (point.x < 0 || point.x >= ROW || point.y < 0 || point.y >= COL) {
            return false;
        }
        return grid[point.x][point.y] == EMPTY;
    }

    public int shortestDistance(int[][] grid) {
        //sanity check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        setGrid(grid);
        List<Point> houses = getPoints(HOUSE);
        int[][] distanceSum = new int[ROW][COL];
        int[][] visitedSum  = new int[ROW][COL];
        for (Point house : houses) {
            bfs(house, distanceSum, visitedSum);
        }
        int shortest = Integer.MAX_VALUE;
        List<Point> empties = getPoints(EMPTY);
// Select place for post office
        for (Point empty : empties) {
            if (visitedSum[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        grid[0][1] = 1;
        grid[1][0] = 1;
        grid[2][1] = 1;
        grid[1][4] = 1;
        grid[1][3] = 2;
        BuildPostOfficeII ex = new BuildPostOfficeII();
        System.out.println(ex.shortestDistance(grid));

    }
}
