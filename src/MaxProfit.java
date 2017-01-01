import java.util.Arrays;
import java.util.HashMap;

public class MaxProfit{
	public static int maxProfit(int[] prices) { //Only works when no duplicate element
		int len = prices.length;
		int maxProfit = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < len; i++) {
			map.put(prices[i], i);
		}
		int[] sorted = Arrays.copyOf(prices, prices.length);
		Arrays.sort(sorted);
		int buy = 0;
		int sell = len - 1;
		while(buy < sell){
			if ( map.get(sorted[sell]) > map.get(sorted[buy])) {
				maxProfit = sorted[sell] - sorted[buy];
				break;
			}

			int buyplus = 0;
			int sellminus = 0;
			if (map.get(sorted[sell]) > map.get(sorted[buy + 1])) {
				buyplus = sorted[sell] - sorted[buy + 1];
			}
			if (map.get(sorted[sell - 1]) > map.get(sorted[buy])) {
			 	sellminus = sorted[sell - 1] - sorted[buy];
			 } 

			 if (buyplus == 0 && sellminus == 0) {
			 	buy++;
			 	sell--;
			 } else {
			 	maxProfit = Math.max(buyplus, sellminus);
			 	break;
			 }
		}
		return maxProfit;
	}

	public static int maxProfit2(int[] prices) {
		//Kadane's Algorithm
		int maxCur = 0, maxTotal = 0;
		for (int i = 1 ; i < prices.length ;i++ ) {
			maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
			maxTotal = Math.max(maxCur, maxTotal);
		}
		return maxTotal;
	}

	public static int maxProfit3(int[] prices){
		//Keep updating the min and maintain the max
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit3(prices));
	}
}















