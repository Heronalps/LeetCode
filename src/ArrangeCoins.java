public class ArrangeCoins{
	public static int arrangeCoins (int n) {
		int total = 0;
		int level = 0;
		int increment = 1;
		while(total < n) {
			total += increment;
			level++;
			increment++;
		}
		return total == n? level : level - 1;
	}

	public static int arrangeCoins2(int n) {//Binary Search
		int start = 0;
		int end = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			double seq = 0.5 * mid * mid + 0.5 * mid;
			if (seq > n) {
				end = mid - 1;
			} else if( seq < n) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return start - 1;
	}

	public static void main(String[] args) {
		System.out.println(arrangeCoins2(Integer.MAX_VALUE)); // 2
		System.out.println((Integer.MAX_VALUE/2 + Integer.MAX_VALUE) >>> 1);
		System.out.println(Integer.MAX_VALUE/2 + (Integer.MAX_VALUE - Integer.MAX_VALUE/2)/2);
		System.out.println("00" + Integer.toBinaryString(Integer.MAX_VALUE/2));
		System.out.println("0" + Integer.toBinaryString(Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(Integer.MAX_VALUE/2 + Integer.MAX_VALUE));
		System.out.println(Integer.toBinaryString(-1));

	}
}