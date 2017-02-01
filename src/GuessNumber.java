/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
import java.math.*;

public class GuessNumber {
    public static int guessNumber(int n) {
        int left = 0;
        int right = n;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if (guess(mid) == 0) {
        		return mid;
        	} else if(guess(mid) == 1){
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        return -1;
    }

    public static int guess(int num) {
    	int result = 6;
    	if (num == result) {
    		return 0;
    	} else if (num > result) {
    		return -1;
    	} else {
    		return 1;
    	}
    }
    public static void main(String[] args) {
    	System.out.println(guessNumber(10));
    	int m = 6;
    	int power = 1;
    	for (int i = 0; i < m; i++) {
    		power = power * 2;
    	}
    	System.out.println(power);
    }
}