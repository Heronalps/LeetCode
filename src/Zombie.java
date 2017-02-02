import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michaelzhang on 2/2/17.
 */
public class Zombie {
    public static int zombie(int[][] grid) {
        int[] deltaR = {-1, 1, 0, 0};
        int[] deltaC = {0, 0, -1, 1};
//Sanity Check
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int PEOPLE = 0;
        int ZOMBIE = 1;
        int WALL = 2;

// Initialize BFS queue
        int countPeople = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Point(i, j));
                }
                if (grid[i][j] == PEOPLE) {
                    countPeople++;
                }
            }
        }
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            while (size > 0){
                Point current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int row = current.x + deltaR[i];
                    int column = current.y + deltaC[i];

                    if (!isPeople(grid, row, column)) {
                        continue;
                    }
                    grid[row][column] = ZOMBIE;
                    countPeople--;
                    if (countPeople == 0) {
                        return days;
                    }
                    queue.offer(new Point(row, column));
                }
                size--;
            }
        }
        return -1;
    }
    public static boolean isPeople(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length) {
            return false;
        }
        return grid[row][column] == 0;
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,2,0,0}, {1,0,0,2,1}, {0,1,0,0,0}};
        System.out.println(zombie(grid));

    }
}
