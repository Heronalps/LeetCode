import java.lang.Math;

public class HouseRobber{
	public static int rob(int[] nums) {
		int[][] cash = new int[nums.length + 1][2];
		for (int i = 0; i < nums.length; i++) {
			cash[i + 1][0] = cash[i][1] + nums[i];
			cash[i + 1][1] = Math.max(cash[i][0], cash[i][1]);
		}
		return Math.max(cash[nums.length][0], cash[nums.length][1]);
	}

	public static int rob1(int[] nums) {
	    if(nums.length==0) return 0;
	    if(nums.length==1) return nums[0];

	    //Initialize an arrays to store the money
		int[] mark = new int[nums.length];

	    //We can infer the formula from problem:mark[i]=max(num[i]+mark[i-2],mark[i-1])
	    //so initialize two nums at first.
		mark[0] = nums[0];
		mark[1] = Math.max(nums[0], nums[1]);

	    //Using Dynamic Programming to mark the max money in loop.
		for(int i=2;i<nums.length;i++){
			mark[i] = Math.max(nums[i]+mark[i-2], mark[i-1]);
		}
		return mark[nums.length-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 1, 1, 2, 3, 5, 1, 5, 8};
		System.out.println(rob1(nums)); 
	}
}