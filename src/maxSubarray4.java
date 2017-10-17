public class maxSubarray4 {

    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        if(nums.length < k){
            return 0;
        }

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int minPrefix = 0;

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            //System.out.println("prefixSum : " + prefixSum[i]);

            if (i >= k) {
                minPrefix = Math.min(minPrefix, prefixSum[i - k]);
                //System.out.println("Min prefix : " + minPrefix);
            }

            if (i >= k && prefixSum[i] - minPrefix > result){
                result = Math.max(result, prefixSum[i] - minPrefix);
                //System.out.println("result : " + result);
            }

        }
        return result;
    }
}
