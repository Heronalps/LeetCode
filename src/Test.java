import java.util.*;

/**
 * Created by michael.zhang on 8/11/2016.
 */
public class Test {
    public static int partitionArray(int[] nums, int k) {
        //Sanity check
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left <= right && left < k) {
                left++;
            }
            while(left <= right && right >= k) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = {7, 7, 9, 8, 6, 6, 8, 7, 9, 6, 8, 6};
        partitionArray(array, 10);
    }

}



