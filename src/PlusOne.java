public class PlusOne{
	public static int[] plusOne(int[] digits){
		digits[digits.length - 1] += 1;
		for (int i = digits.length - 1; i > 0; i--) {
			if(digits[i] == 10){
				digits[i] = 0;
				digits[i - 1]++;
			} else {
				break;
			}
		}
		if (digits[0] == 10) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			return newDigits;
		}
		return digits;
	}

	public static void main(String[] args) {
		int[] digits1 = {1, 0, 0, 0, 1};
		int[] digits2 = {9, 9, 9, 9, 9};
		int[] result1 = plusOne(digits1);
		int[] result2 = plusOne(digits2);
		for (int i = 0; i < result1.length ; i++) {
			System.out.println("result1 " + result1[i]);			
		}

		for (int i = 0; i < result2.length ; i++) {
			System.out.println("result2 " + result2[i]);			
		}
	}
}