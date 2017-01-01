public class HammingWeight{
	public static int hammingWeight(int n){
		int counter = 0;
		while(n != 0) {
			n = n & (n - 1);
			counter++;
		}
		return counter;
	}
	public static void main(String[] args) {
		System.out.println(Integer.bitCount(-1));
		System.out.println(hammingWeight(-1));
	}
}