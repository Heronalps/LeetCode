public class MaxSubarrayIII {

    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int len = nums.length;
        int[][] local = new int[len + 1][k + 1];
        int[][] global = new int[len + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            for (int i = j; i < len + 1; i++) {
                //local[j - 1][j] = Integer.MIN_VALUE;
                System.out.println("i : " + i);
                System.out.println("j : " + j);

                System.out.println("global : " + global[i - 1][j - 1]);
                System.out.println("local : " + local[i - 1][j]);
                if (i == j) {
                    local[i][j] = global[i - 1][j - 1] + nums[i - 1];
                } else {
                    local[i][j] = Math.max(global[i - 1][j - 1], local[i - 1][j]) + nums[i - 1];
                }


                if (i == j){
                    global[i][j] = local[i][j];
                }
                else {
                    global[i][j] = Math.max(global[i - 1][j], local[i][j]);
                }
            }
        }
        return global[len][k];
    }
}
