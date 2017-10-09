public class LongestPalindromeSubstring {

    public static String longestPalindrome(String s) {
        // write your code here
        boolean[][] dp = new boolean[1000][1000];
        int len = s.length();
        int maxLength = 1, startIndex = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {

                System.out.println("i : " + i);
                System.out.println("j : " + j);
                if ( ((j - i <= 2) || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    System.out.println("dp : " + dp[i][j]);

                    if (maxLength < (j - i + 1)) {
                        maxLength = j - i + 1;
                        startIndex = i;
                    }
                    System.out.println("maxLength : " + maxLength);
                    System.out.println("startIndex : " + startIndex);
                }
                System.out.println("==================");
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    public static String longestPalindrome2(String s) {
        // write your code here
        int len = s.length();
        int low = 0, high = 0, start = 0, maxLength = 1, temp = 0;
        for (int i = 0; i < len; i++) {
            low = i;
            high = i + 1;
            temp = helper(s, low, high);
            if (temp > maxLength) {
                maxLength = temp;
                start = i - (maxLength / 2 - 1);
            }

            low = i;
            high = i;
            temp = helper(s, low, high);
            if (temp > maxLength) {
                maxLength = temp;
                start = i - maxLength / 2;
            }
        }
        return s.substring(start, start + maxLength);
    }

    private static int helper(String str, int low, int high) {
        int maxLen = 0;
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            maxLen = (high - low + 1);
            low--;
            high++;
        }
        return maxLen;
    }
}
