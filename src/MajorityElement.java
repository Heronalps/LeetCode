/**
 * Created by michael.zhang on 8/9/2016.
 */
import java.util.HashMap;

import static java.util.Arrays.sort;

public class MajorityElement {
    public int majorityElement(int[] nums) {
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

    public int majorityElement2(int[] num) {
        //Boyer-Moore Majority Voting Algorithm

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

    public int majorityElement3(int[] nums) {

        //先构造一个32位计数器，把每个数都转化成二进制
        //在32位的每一位累加，如果这一位上大于数组长度的一半，就证明Majority在这位上是1
        //把所有符合以上条件的位再转化成十进制数

        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    public static void main(String[] args) {

        MajorityElement m = new MajorityElement();
        System.out.println(m.majorityElement(new int[] {3, 5, 9, 1, 1, 1, 1, 1, 1, 1, 17, 17,12, 20}));
        System.out.println(m.majorityElement2(new int[] {3, 5, 9, 1, 1, 1, 1, 1, 1, 1, 17, 17,12, 20}));

    }
}
