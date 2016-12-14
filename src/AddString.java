import java.lang.Math;
import java.util.Arrays;
import java.lang.String;
import java.lang.StringBuilder;

public class AddString{
	public static String addStrings(String num1, String num2) {
		int[] number1 = convertToInt(num1);
		int[] number2 = convertToInt(num2);
		int len = Math.max(number1.length, number2.length);
		int[] result = new int[len + 1];
		char[] summation = new char[len + 1];
		int carry = 0;
		int[] number3;
		int[] number4;

		if (number1.length > number2.length) {
			number3 = padding(number1, number2);
			number4 = number1;
		} else {
			number3 = padding(number2, number1);
			number4 = number2;
		}
		for (int i = len - 1; i >= 0; i--) {
			int sum = number3[i] + number4[i] + carry;
			result[i + 1] = sum % 10;
			carry = sum / 10; 	
		}

		if (carry > 0) {
			result[0] = carry;
		}

		for (int i = 0; i < summation.length; i++) {
			summation[i] = (char) (result[i] + '0');
		}

		if (summation[0] == '0') {
			char[] summationNoZero = new char[len];
			for (int i = 0; i < summationNoZero.length; i++) {
				summationNoZero[i] = summation[i + 1];
			}
			return new String(summationNoZero);
		}

		return new String(summation);
	}
	public static int[] convertToInt(String num) {
		char[] number = num.toCharArray();
		int[] numberInt = new int[number.length];
		for (int i = 0; i < number.length; i++ ) {
			numberInt[i] = number[i] - '0';
		}
		return numberInt;
	}

	public static int[] padding(int[] numberlong, int[] numbershort) {
		int[] numbershort_pad = new int[numberlong.length];
		int diff = numberlong.length - numbershort.length;
		for (int i = 0; i < numbershort_pad.length; i++) {
			if (i < diff) {
				numbershort_pad[i] = 0;
			} else {
				numbershort_pad[i] = numbershort[i - diff]; 				
			}
		}
		return numbershort_pad;
	}

	public static String addString2(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		int carry = 0;
		for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
			int x = i < 0 ? 0 : (num1.charAt(i) - '0');
			int y = i < 0 ? 0 : (num2.charAt(j) - '0');
			builder.insert(0, (x + y + carry) % 10);
			carry = (x + y + carry) / 10;
		}
		return builder.toString();
	} 

	public static void main(String[] args) {
		String num1 = "6913259244";
		String num2 = "6071103343";
		System.out.println(addString2(num1, num2));
	}
}