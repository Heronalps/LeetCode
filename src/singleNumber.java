import java.util.*;

/**
 * Created by michaelzhang on 9/3/16.
 */
public class singleNumber {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < (nums.length - 1) && (nums[i] == nums[i + 1])) {
            i += 2;
        }
        return nums[i];
    }

    public int singleNumber1(int[] nums) {
        HashSet<Integer> check = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            if(!check.remove(nums[i])) //这句为程序核心,不断加入,遇到重复就去除。
                check.add(nums[i]);
        return check.iterator().next();//HashSet中唯一剩下的就是Single Number。
    }

    public int singleNumber2(int[] nums) {

        /* Because the xor has three properties. 1,0^a=a 2,a^b=b^a 3,a^a=0
        so swapping the number would not change the output at the end,
        we can see the list as all the same numbers are adjacent.
        The same numbers would be 0 after xor. The one remaining would be the answer.
        * */

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++ ) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry pair = (Map.Entry) iter.next();
            if ((int) pair.getValue() != 3) {
                return (int) pair.getKey();
            }
        }
        throw new IllegalArgumentException("No solution found!");
    }

    public int singleNumber4(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                if ((n >> i & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            if (sum == 1){
                ans |= sum << i;
            } else if (sum == 2) {
                ans |= sum/2 << i;
            }
        }
        return ans;
    }

    public int[] singleNumber5(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        Iterator iter = map.entrySet().iterator();
        int[] result = new int[2];
        int index = 0;
        while (iter.hasNext()) {
            Map.Entry current = (Map.Entry) iter.next();
            if ((int) current.getValue() == 1) {
                result[index] = (int) current.getKey();
                index++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] myArray = {-1, -1, 3, 3, 2, 4};
        singleNumber myApp = new singleNumber();
        System.out.println(myApp.singleNumber5(myArray)[1]);

    }
}