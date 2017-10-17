import java.util.LinkedList;

public class maxSubarray5 {
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // write your code here
        int len = nums.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        int result = Integer.MIN_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < len + 1; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (!queue.isEmpty() && queue.getFirst() < i - k2){
                queue.removeFirst();
            }
            if (i >= k1) {
                while (!queue.isEmpty() && sum[queue.getLast()] > sum[i - k1]) {
                    queue.removeLast();
                }
                queue.add(i - k1);
            }
            if (!queue.isEmpty()) {
                result = Math.max(result, sum[i] - sum[queue.getFirst()]);
            }
        }
        return result;
    }
}
