import java.lang.Math;

public class PowerOfThree {
	public static boolean powerOfThree(int n) {
		if (n < 1) {
			return false;
		}

		while(n != 1) {
			if (n % 3 != 0) {
				return false;
			} 
			n /= 3;
		}
		return true;
	}

	public static boolean powerOfThree2(int n) {
		double epsilon = 0.00001;
		return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
	}

	public static void main(String[] args) {
		System.out.println(powerOfThree2(9));
	}
}