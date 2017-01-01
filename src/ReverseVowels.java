import java.lang.String;

public class ReverseVowels{
	public static String reverseVowels(String s){
		if (s.length() == 0) {
			return s;
		}
		char[] str = s.toCharArray();
		int[][] map = new int[2][str.length];
		for (int i = 0, j = 0; i < str.length ; i++) {
			switch(str[i]){
				case 65: map[0][j] = 65; map[1][j] = i + 1; j++; break;
				case 69: map[0][j] = 69; map[1][j] = i + 1; j++; break;
				case 73: map[0][j] = 73; map[1][j] = i + 1; j++; break;
				case 79: map[0][j] = 79; map[1][j] = i + 1; j++; break;
				case 85: map[0][j] = 85; map[1][j] = i + 1; j++; break;

				case 97: map[0][j] = 97; map[1][j] = i + 1; j++; break;
				case 101: map[0][j] = 101; map[1][j] = i + 1; j++; break;
				case 105: map[0][j] = 105; map[1][j] = i + 1; j++; break;
				case 111: map[0][j] = 111; map[1][j] = i + 1; j++; break;
				case 117: map[0][j] = 117; map[1][j] = i + 1; j++; break;
			
			}
		}
		if (map[1][0] == 0) {
			return s;
		}

		for (int i = 0, j = str.length - 1; i <= j; i++, j--) {
			while(map[1][j] == 0){
				j--;
			}
			str[map[1][i] - 1] = (char) (map[0][j]);
			str[map[1][j] - 1] = (char) (map[0][i]);
		}
		return String.valueOf(str);
	}


	public static void main(String[] args) {
		System.out.println(reverseVowels("Aa"));
		System.out.println(reverseVowels("leetcode"));
	}
}