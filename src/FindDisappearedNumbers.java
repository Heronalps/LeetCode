import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class FindDisappearedNumbers{
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		int[] standard = new int[nums.length];
		Arrays.sort(nums);
		int i = 0, j = 0, k = 0;
		for (; i < standard.length; i++) {
			standard[i] = i + 1;
		}
		while(k < standard.length){
			while( j < nums.length && nums[j] < standard[k]) {
				j++;
			}
			if (j == nums.length) {
				while(k < j){
					list.add(standard[k]);
					k++;
				}
			} else if (nums[j] != standard[k]) {
				while(standard[k] < nums[j]){
					list.add(standard[k]);
					k++;
				}
			}
			k++;
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] {1, 2, 2, 3, 3, 4, 7, 8}));
	}
}