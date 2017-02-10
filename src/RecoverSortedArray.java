import java.util.ArrayList;

/**
 * Created by michaelzhang on 2/9/17.
 */
public class RecoverSortedArray {
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        //Sanity check
        if (nums == null || nums.size() == 0) {
            return;
        }
        int offset = nums.size() - 1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                offset = i;
            }
        }
        reverse(nums, 0, offset);
        reverse(nums, offset + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);

    }
    public static void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, tmp);
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        recoverRotatedSortedArray(nums);
        for (int n : nums) {
            System.out.println(n);
        }
    }
}
