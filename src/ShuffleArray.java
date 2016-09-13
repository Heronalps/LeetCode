import java.util.HashSet;

/**
 * Created by michaelzhang on 9/13/16.
 */
public class ShuffleArray {

    int[] nums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = this.nums.length;
        int[] result = new int[n];
        //HashSet来确定此元素是否已经被选中
        //rand作为计数器,跳过已选元素后,index确定第几个元素为下一个入选元素
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++ ) {
            //随机数产生, 以3为例, Math.random = (0 ~ 0.999) -> (0 ~ 2.999) -> (1 ~ 3.999)
            // 在(1 ~ 4)的范围下,1,2,3才能同概率产生。
            int rand = (int) (Math.random() * (n - i) + 1);
            int index = 0;
            while(index < n && rand > 0) {
                if(!set.contains(this.nums[index])) {
                    index++;
                    rand--;
                } else {
                    index++;
                }
            }
            //确定随机数时是one based,因为随机产生0后,无法进入循环
            //写入元素时是zero based, 所以index - 1
            result[i] = this.nums[index - 1];
            set.add(this.nums[index - 1]);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ShuffleArray obj = new ShuffleArray(nums);
        for (int n : obj.reset()) {
            System.out.println(n);
        }
        for (int n : obj.shuffle()) {
            System.out.println(n);
        }

    }
}
