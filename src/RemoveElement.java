public class RemoveElement{
	public static int removeElement(int[] nums, int val){
		int counter = 0, slow = 0, fast = nums.length - 1;
		while (slow <= fast){
			while(slow < nums.length && nums[slow] != val) slow++;
			while(fast >= 0 && nums[fast] == val) {
				fast--; 
				counter++;
			}
			if(slow < fast){
				nums[slow] = nums[fast];
				nums[fast] = val;
			}
		}
		return nums.length - counter;
	}

	public static int removeElement2(int[] A, int elem) {
	   int m = 0;    
	   for(int i = 0; i < A.length; i++){
	       if(A[i] != elem){
	           A[m] = A[i];
	           m++;
	       }
	   }
	   return m;
	}

	public static void main(String[] args) {
		int[] nums = {1};
		int val = 1;
		System.out.println("counter = " + removeElement(nums, val)); // 2
		
		for (int i = 0; i < nums.length ;i++ ) {
			System.out.println(nums[i]);
		}
	}
}