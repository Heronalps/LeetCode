import java.util.HashSet;

public class IsHappy {
	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<>();
		int result = 0;
		while(true) {

			int len = ((Integer) n).toString().length();
			for (int i = 0; i < len ; i++) {
				result += (n % 10) * (n % 10);
				n /= 10;
			}
			System.out.println(result);
			if (set.contains(result)) {
				break;
			} else {
				set.add(result);
				n = result;
				result = 0;
			}
		}
		return result == 1;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(4));
	}
}