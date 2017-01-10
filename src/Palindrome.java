public class Palindrome{
	public static boolean isPalindrome(int x){
		int y = x;
		int reverse = 0;
		while(y > 0){
			reverse  = reverse * 10 + y % 10;
			y /= 10;
		}
		System.out.println(reverse);
		return reverse == x;
	}

	public static boolean isPalindrome2(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		int reverse = 0;
		while(x > reverse) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}
		System.out.println(reverse);
		return (x == reverse || x == reverse / 10);
	}


	public static void main(String[] args) {
		System.out.println(isPalindrome(-3223));
	}
}