import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michaelzhang on 2/4/17.
 */
public class Permutation2 {
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null) {
            return rst;
        }

        if (nums.length == 0) {
            rst.add(new ArrayList<Integer>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(rst, list, index, nums);
        return rst;
    }

    public static void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, ArrayList<Integer> index, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(index.contains(i) || prev == nums[i]){ //Proudest line of code.
                // Index to make sure permutation has all elements,
                // prev to make sure only the first of duplicate elements enters the permutation.
                // "THIS PLACE HAS BEEN OCCUPIED BY THE SAME ELEMENT BEFORE! NO ENTER!"
                continue;
            }
            prev = nums[i];
            list.add(nums[i]);
            index.add(i);
            helper(rst, list, index, nums);
            list.remove(list.size() - 1);
            index.remove(index.size() - 1);
        }
    }

    public static void main(String[] args) {


        System.out.println(permute(new int[]{1,2,2,2}));

    }
}
