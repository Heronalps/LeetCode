import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;

public class BinaryWatch{
	public static List<String> binaryWatch1(int num) {
		int[] hour = {8, 4, 2, 1};
		int[] minute = {32, 16, 8, 4, 2, 1};

		List<String> times = new LinkedList<String>();
		while(num > 0) {
			for (int i = 0; i < hour.length ; i++) {
				String time = hour[i] + ":00";
				times.add(time); 				
			}
			for (int j = 0; j < minute.length ;j++ ) {
				String time;
				if (String.valueOf(minute[j]).length() == 2) {
					time = "0:" + minute[j];	
				} else {
					time = "0:0" + minute[j];
				}
				times.add(time);
			}
			num--;
		}
		return times;
	}

	public static List<String> binaryWatch2(int num){
		HashMap<Integer, LinkedList<String>> timeMap = new HashMap<>();
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 60 ; j++) {
				int numberOfLED = binaryHelper(i) + binaryHelper(j);
				LinkedList<String> times;
				if (timeMap.containsKey(numberOfLED)) {
					times = timeMap.get(numberOfLED);
				} else {
					times = new LinkedList<String>();
				}
				if (j < 10) {
					times.add(i + ":0" + j);
				} else {
					times.add(i + ":" + j);
				}
				timeMap.put(numberOfLED, times);
			}
		}
		return timeMap.containsKey(num) ? timeMap.get(num) : new LinkedList<String>();
	}

	public static int binaryHelper(int num) {
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		while(num != 0){
			stack.push(num % 2);
			num /= 2;
		}
		while(!stack.isEmpty()){
			if (stack.pop() == 1) {
				result++;
			}
		}
		return result;
	}

	public static List<String> binaryWatch3(int nums) {
		List<String> time = new ArrayList<String>();
		for (int h = 0; h < 12; h++ ) {
			for (int m = 0; m < 60 ; m++) {
				if (Integer.bitCount(h * 64 + m) == nums) {
					time.add(String.format("%d:%02d", h, m));
				}
			}
		}
		return time;
	}
		
	public static void main(String[] args) {
		System.out.println(binaryWatch2(1));
		System.out.println(binaryWatch3(1));
		/*String result = String.format("One: %2$d Two: %1$d Three: %3$d",
			10, 20, 30);
		System.out.println(result);
		*/
	}
}