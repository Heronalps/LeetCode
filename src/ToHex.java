import java.lang.StringBuilder;
import java.lang.Integer;

public class ToHex{
	public static String toHex(int num){
		if (num == 0) {
			return "0";
		}
		StringBuilder builder = new StringBuilder();
		double number = (double) num;
		if (number < 0) {
			number = Math.pow(2, 32) + number;
		}
		while (number >= 1) {
			int digit = (int) (number % 16);
			builder.insert(0, getDigit(digit));
			number /= 16;
		}
		return builder.toString();
	}

	public static char getDigit(int num) {
		char hex = ' ';
		if (num < 10) {
			hex = (char) (num + '0');
		} else {
			switch(num) {
				case 10: hex = 'a'; break;
				case 11: hex = 'b'; break;
				case 12: hex = 'c'; break;
				case 13: hex = 'd'; break;
				case 14: hex = 'e'; break;
				case 15: hex = 'f'; break;
			}
		}
		return hex;
	}

	public static String toHex2(int num) {
		StringBuilder result = new StringBuilder();
		while(num != 0) {
			int n = (num & 0xf);
			n += n < 10 ? '0' : 'a' - 10;
			result.insert(0, (char) n);	 
			num >>>= 4;
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(toHex2(-2));		
	}	
}