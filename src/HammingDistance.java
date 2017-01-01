public class HammingDistance{
	public static int hammingDistance(int x, int y){
		int exclor = x ^ y;
		int counter = 0;
		while(exclor != 0){
			if ((exclor & 1) == 1) {
				counter++;
			}
			exclor /= 2;
		}
		return counter;
	}

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}
}