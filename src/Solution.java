import java.util.*;



class Solution {


    public int longestConsecutive(int[] nums) {
        int result = 0, count = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(num + 1)) {
                count++;
                num++;
            }
            result = Math.max(result, count);
            count = 1;
        }
        return result;
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.size();
    }


}


