/**
 * Created by michael.zhang on 8/9/2016.
 */
import java.util.Arrays.*;
import java.util.HashMap;

import static java.util.Arrays.sort;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int[] majority = {nums[0], 1};
        for (int i = 0; i < nums.length; i++ ) {
            if (counter.containsKey(nums[i])) {
                int new_count = counter.get(nums[i]) + 1;
                counter.put(nums[i], new_count);
                if (new_count > majority[1]) {
                    majority[0] = nums[i];
                    majority[1] = new_count;
                }
            } else {
                counter.put(nums[i], 1);
            }
        }
        return majority[0];
    }

    public static int majorityElement2(int[] num) {
        //因为Majority > n/2，所以major元素一定比剩余的其他元素多至少一个。
        //如果counter被抵消成零，后面必有多一个major元素，使major重新变正确。
        //这个算法运用了Majority > n/2这个性质

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 9, 1, 1, 1, 1, 1, 1, 1, 17, 17,12, 20};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));

    }
}
