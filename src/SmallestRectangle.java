import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michaelzhang on 2/2/17.
 */
public class SmallestRectangle {
    private static int[] deltaRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] deltaCol = {-1, 0, 1, -1, 1, -1, 0, 1};


    public static int minArea(char[][] image, int x, int y) {
        if (image.length == 0 || image[x].length == 0) {
            return 0;
        }
        int numRow = image.length;
        int numCol = image[x].length;
        boolean[][] isVisited = new boolean[numRow][numCol];

        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        isVisited[x][y] = true;
        int area = 1;
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            if (image[current.x][current.y] == '1') {
                for (int i = 0; i < 8; i++) {
                    int col = current.y + deltaCol[i];
                    int row = current.x + deltaRow[i];
                    if (!inBound(image, row, col) || isVisited[row][col]) {
                        continue;
                    }

                    if (image[row][col] == '1' || (image[row][col] == '0' && isPadding(image, row, col))) {
                        image[row][col] = '1';
                        queue.offer(new Point(row, col));
                        area++;
                    }
                    isVisited[row][col] = true;
                }
            }
        }
        return area;
    }

    public static boolean inBound(char[][] image, int row, int column) {
        if (row < 0 || column < 0 || row >= image.length || column >= image[row].length) {
            return false;
        }
        return true;
    }

    public static boolean isPadding(char[][] image, int row, int column) {

        boolean rowHasOne = false, colHasOne = false;

        for (int i = 0; i < image[0].length; i++) {
            if (image[row][i] == '1') {
                rowHasOne = true;
                break;
            }
        }
        for (int j = 0; j < image.length; j++) {
            if (image[j][column] == '1') {
                colHasOne = true;
                break;
            }
        }
        return rowHasOne && colHasOne;
    }

    public static void main(String[] args){
        String[] tmp = {"0000000000000000000000001100111111110000000000000000000000000000000000000000000",
                "0000000000000000000000000111111111110000000000000000000000000000000000000000000",
                "0000000000000000000000000001111110110000000000000000000000000000000000000000000",
                "0000000000000000000000000011111110100000000000000000000000000000000000000000000",
                "0000000000000000000000001111111110000000000000000000000000000000000000000000000"};
        char[][] image = new char[5][79];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = tmp[i].charAt(j);
            }
        }
        System.out.println(minArea(image, 3, 34));
    }
}
