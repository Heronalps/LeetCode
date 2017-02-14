import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by michaelzhang on 2/12/17.
 */
public class SubarrayClosest {
    static class Pair implements Comparator<Pair> {
        int sum;
        int index;
        public Pair(){}
        public Pair(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
        public int compare(Pair a, Pair b) {
            return a.sum - b.sum;
        }
    }
    public static int[] subarraySumClosest(int[] nums) {
        // Sanity Check
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] result = new int[2];
        int diffToZero = Integer.MAX_VALUE;
        Pair[] prefixSum = new Pair[nums.length + 1];
        prefixSum[0] = new Pair(0, -1);
        for (int i = 1; i < prefixSum.length; i++) {
            int newSum = prefixSum[i - 1].sum + nums[i - 1];
            prefixSum[i] = new Pair(newSum, i - 1);
        }
        Arrays.sort(prefixSum, new Pair());
        for (int i = 1; i < prefixSum.length; i++) {
            if (Math.abs(prefixSum[i].sum - prefixSum[i - 1].sum) < diffToZero) {
                if (prefixSum[i].index < prefixSum[i - 1].index) {
                    result[0] = prefixSum[i].index + 1;
                    result[1] = prefixSum[i - 1].index;
                } else {
                    result[0] = prefixSum[i - 1].index + 1;
                    result[1] = prefixSum[i].index;
                }
                diffToZero = Math.abs(prefixSum[i].sum - prefixSum[i - 1].sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-10,-2,-3,-100,1,2,3,-1,4};
        System.out.println(subarraySumClosest(a));
    }

}
