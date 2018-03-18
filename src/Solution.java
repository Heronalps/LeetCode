import java.util.*;



public class Solution {

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                int lives = liveNeighbors(board, row, col, rowLen, colLen);
                if (board[row][col] == 1 && (lives == 2 || lives == 3)) {
                    board[row][col] = 3;
                    //因为Default next state是0，所以只有2/3两种情况需要修改board值
                }
                if (board[row][col] == 0 && lives == 3) {
                    board[row][col] = 2; // Reborn scenario
                }
            }
        }
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                board[row][col] >>= 1; //推进到下一个state
            }
        }
    }
    private int liveNeighbors(int[][] board, int row, int col, int rowLen, int colLen) {
        int lives = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(rowLen - 1, row + 1); i++) {
            //用max和min来规定上下界，值得学习
            for (int j = Math.max(0, col - 1); j <= Math.min(colLen - 1, col + 1); j++) {
                lives += board[i][j] & 1;
            }
        }
        lives -= board[row][col]; //因为遍历了九宫格，所以剪掉自身值
        return lives;
    }








    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

    }
}
