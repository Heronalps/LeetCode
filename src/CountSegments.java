public class CountSegments{
	public static int countSegments(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int num = 1;
		int i = 0, j = s.length() - 1;
		while(i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		while(j > 0 && s.charAt(j) == ' '){
			j--;
		}
		if (i == s.length() && j == 0) return 0; // all whitespace!

		for (; i <= j; i++) {
			if (s.charAt(i) == ' ' && s.charAt(i + 1) != ' ') {
				num++;
			}
		}
		return num;
	}

	public static int countSegments2(String s) {
		int segs = 0;
		char[] chars = s.toCharArray();
		for(int i=0;i<chars.length;i++) {
		    if(chars[i]!=' ') segs++;
		    while(i<chars.length && chars[i]!=' ') i++;
		}
		return segs;
	}

	public static void main(String[] args) {
		String str = "      Hello,       my name is         Michael";
		System.out.println(countSegments2(str)); // 5
		
	}
}