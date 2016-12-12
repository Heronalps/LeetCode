import java.util.LinkedList;
import java.lang.String;

public class FirstUniqChar {
	public static int firstUniqChar(String s){
		int[] map = new int[26];
		LinkedList<Integer> firstIndex = new LinkedList<>();
		int result = -1;
		for (int i = 0; i < s.length() ; i++ ) {
			int index = s.charAt(i) - 'a';
			if (++map[index] == 1) {
				firstIndex.add(index);
			}
			if (!firstIndex.isEmpty() && map[firstIndex.peek()] > 1) {
				while(!firstIndex.isEmpty() && map[firstIndex.peek()] != 1) {
					firstIndex.remove();
				}
			}
		}
		if (firstIndex.peek() != null) {
			result = s.indexOf((char) (firstIndex.peek() + 'a'));
		}
		return result;
	}

	public static int firstUniqChar2(String s) { // Two Scans
		int[] map = new int[26];


		for (int i = 0; i < s.length() ;i++ ) {
			map[s.charAt(i) - 'a']++;	
		}

		for(int j = 0; j < s.length(); j++ ) {
			if (map[s.charAt(j) - 'a'] == 1) {
				return j;
			}
		}
		return 0;
	}

	public static int firstUniqChar3(String s) { // Fast and slow pointers
		if (s.length() == 0) {
			return -1;
		}
		int[] map = new int[26];
		int slow = 0, fast = 0;
		map[s.charAt(slow) - 'a']++;
		while(slow < s.length()) {
			fast++;
			if (fast == s.length()) {
				return slow;
			} else {
				map[s.charAt(fast) - 'a']++;
			}

			if ( s.charAt(fast) == s.charAt(slow)) {
				while(slow < s.length() && map[s.charAt(slow) - 'a'] > 1){
					slow++;
				}
				if (slow == s.length()) {
					return -1;
				}
				if (map[s.charAt(slow) - 'a'] == 0) {//Not necessary, but it will accelerate the process.
					fast = slow; //fast will catch up slow anyway.
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "loveleetcode"; // 2
		String str2 = "aadadaad"; // -1
		String str3 = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb"; //61
		String str4 = "cc";//-1
		System.out.println(firstUniqChar3(str));
	}
}