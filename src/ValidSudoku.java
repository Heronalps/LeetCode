import java.lang.String;
import java.util.*;

public class ValidSudoku{
	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<Character>();
			HashSet<Character> column = new HashSet<Character>();
			HashSet<Character> cube	 = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !column.add(board[j][i])) {
					return false;			
				}
				int cubeUpleftRow = 3 * (i / 3);
				int cubeUpleftCol = 3 * (i % 3);
				Character ch = board[cubeUpleftRow + j / 3][cubeUpleftCol + j % 3];
				if (ch != '.' && !cube.add(ch)) {
					return false;				
				}			
			}		
		}		
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		board[0] = ".87654321".toCharArray();
		board[1] = "2........".toCharArray();
		board[2] = "2........".toCharArray();
		board[3] = "4........".toCharArray();
		board[4] = "5........".toCharArray();
		board[5] = "6........".toCharArray();
		board[6] = "7........".toCharArray();
		board[7] = "8........".toCharArray();
		board[8] = "9........".toCharArray();
		System.out.println(isValidSudoku(board));
	}
}