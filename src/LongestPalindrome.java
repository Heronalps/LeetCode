public class LongestPalindrome{
	public static int longestPalindrome(String s) {
		int[] map = new int[256];
		int result = 0;
		boolean mid = false;
		for (int i = 0; i < s.length() ; i++) {
			map[s.charAt(i)]++;
		}
		for (int num : map) {
			if (num != 0 && num % 2 == 0) {
				result += num;
			} else if (num != 1 && num % 2 != 0){
				result += (num - 1);
				mid = true;
			} else if (num == 1) {
				mid = true;
			}
		}

		if (mid == true) {
			return result + 1;
		}
		return result;
	}

	public static int longestPalindrome2(String s) {
		boolean[] map = new boolean[64];
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
		 	int cur = s.charAt(i) - 'A';
		 	map[cur] = !map[cur];
		 	if (map[cur] == false) {
		 		result += 2;
		 	}
		 }
		 return result == s.length() ? result: result + 1; 
	}

	public static void main(String[] args) {
		String s = "abccccddd"; // 7
		System.out.println(longestPalindrome2(s));
	} 
}