import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by michaelzhang on 2/5/17.
 */
public class subsetsWithDup {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, subset, result, 0);
        return result;
    }

    public static void helper(int[] nums,
                              ArrayList<Integer> subset,
                              ArrayList<ArrayList<Integer>> result,
                              int index){
        // Base case to do
        result.add(new ArrayList<>(subset));
        int prev = Integer.MIN_VALUE;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            }
            prev = nums[i];
            subset.add(nums[i]);
            helper(nums, subset, result, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(subsetsWithDup(new int[]{1,2,2}));

    }
}
