public class PowerOfFour{
	public static boolean isPowerOfFour(int num){
		return ((num & (num - 1)) == 0) && ((num % 3 == 1));
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(2));
	}
}