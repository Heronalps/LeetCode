public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] pointers = new int[primes.length];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < pointers.length; j++) {
                if (dp[pointers[j]] * primes[j] == dp[i - 1]) {
                    pointers[j]++; // De-duplicate
                }
                dp[i] = Math.min(dp[pointers[j]] * primes[j], dp[i]);
            }
        }
        return dp[n - 1];
    }

}
