public class RemoveDuplicates{
	public static int removeDuplicates(int[] nums) {
		int slow = 0, fast = 0;
		while(fast < nums.length) {
			if (nums[slow] != nums[fast]) {
				nums[slow + 1] = nums[fast];
				slow++;
			} else {
				fast++;	
			}
		}
		return slow + 1;
	}

	public static int removeDuplicates2(int[] nums)
	{
		int dupes = 0;

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == nums[i - 1])
				dupes++;

			nums[i - dupes] = nums[i];
		}

		return nums.length - dupes;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 3, 3, 5};
		System.out.println(removeDuplicates2(nums)); // 4
		for(int num : nums){
			System.out.println(num);
		}
	}
}