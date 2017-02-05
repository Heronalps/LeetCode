import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michaelzhang on 2/5/17.
 */
public class PermutationI {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        /*if (nums == null || nums.length == 0) {
            return result;
        }
        //Need zero-length permutation in result if nums == []
        */
        Arrays.sort(nums);
        List<Integer> permutation = new ArrayList<>();
        helper(nums, permutation, result);
        return result;
    }

    private static void helper(int[] nums,
                               List<Integer> permutation,
                               List<List<Integer>> result){
        //Base case to do
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(permutation.contains(nums[i])){
                continue;
            }
            permutation.add(nums[i]);
            helper(nums, permutation, result);
            permutation.remove(permutation.size() - 1);
        }
    }



    public static void main(String[] args) {

        System.out.println(permute(new int[] {1,2,3}));

    }
}
