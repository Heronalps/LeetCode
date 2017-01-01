import java.lang.Math;

public class PowerOfTwo{
	public static boolean powerOfTwo(int n) {
		if (n < 1) {
			return false;
		}
		while(n != 1) {
			if (n / 2 * 2 != n) {
				return false;
			}
			n /= 2;
		}
		return true;
	}

	public static boolean powerOfTwo2(int n) {
		if (n < 1) {
			return false;
		}
		return (n & (n - 1)) == 0;
	}

	public static void main(String[] args) {
		System.out.println(powerOfTwo2(0x80000000));
		int n = 0x80000000; // The smallest negative number in 32-bit system.
		double m = (Math.log(n)/Math.log(2));
		System.out.println(n);
	}
}