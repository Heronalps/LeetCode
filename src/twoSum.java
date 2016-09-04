import java.util.HashMap;
import java.util.Map;

/**
 * Created by michaelzhang on 9/3/16.
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {

        /*Arrays.sort(nums);
        int index = 0;
        while (index < nums.length && nums[index] <= target) {
            index++;
        }*/
        //排序会导致Element位置错乱

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {j, i};
                    //当需要在loop中返回值时,在loop外声明一个变量进行传导,在loop外返回。

                }
            }
        }
        throw new IllegalArgumentException("No two Sum Solutions");
        //或者抛出一个异常,表示无返回值。
    }

    public int[] twoSum2(int[] nums, int target) {
        //Two-Pass Hash Table
        //把二重循环中的一重用HashMap代替,O(N^2) => O(N)
        //查找方式为: 定一点,向前找。
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            indexMap.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (indexMap.containsKey(complement) && indexMap.get(complement)!= j) {
                //因为都加入了HashMap,所以需要避开重复自身

                return new int[] {j, indexMap.get(complement)};
            }
        }
        throw new IllegalArgumentException("No Summary solution found!");
    }

    public int[] twoSum3(int[] nums, int target) {
        //One-pass Hash Table
        //边插入HashMap边查找: 定一点,向后找

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++ ) {
            int complement = target - nums[i];
            if (indexMap.containsKey(complement)) {
                return new int[] {indexMap.get(complement), i};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No summary solution found!");
    }

    public static void main(String[] args) {
        int[] myArray = {3, 2, 4};
        twoSum myApp = new twoSum();
        int[] result = myApp.twoSum3(myArray, 6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
