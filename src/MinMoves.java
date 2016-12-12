import java.util.Arrays;

public class MinMoves{
	public static int minMoves(int[] nums){
		Arrays.sort(nums);
		int i = 0;
		int min = nums[i];
		int counter = 0;
		int len = nums.length;

		for (; i < len - 2; i += 2) {
			counter += nums[i + 2] - 2 * min + nums[i + 1];
		}
		if(len % 2 == 0) {
			counter += nums[len - 1] - min;
		}
		return counter;
	}

	public static int minMoves2(int[] nums) {
		int i = 0;
		int min = nums[i];
		int sum = 0;
		for(int num : nums) {
			min = Math.min(min, num);
			sum += num;
		}
		return sum - nums.length * min;
	}


	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3}; //Result = 3
		int[] nums2 = {1, 8, 13, 15, 19, 21}; //Result = 71
		System.out.println(minMoves2(nums1));
		System.out.println(minMoves2(nums2));

	}
}