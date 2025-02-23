public class Solution {
    /*
     @ param n the n-th ugly number
     @ return the n-th ugly number
     */
    public int nthUglyNumber(int n) {
        // dp[i] is the ith ugly number
        int[] dp = new int[n];
        dp[0] = 1;

        // idx2, idx3, idx5 are the indices of the last ugly numbers
        // that are multiples of 2, 3, 5, respectively
        int idx2 = 0, idx3 = 0, idx5 = 0;

        // Iterate from the 1st ugly number to the nth ugly number
        for (int i = 1; i < n; i++) {
            int nextMultipleOf2 = dp[idx2] * 2;
            int nextMultipleOf3 = dp[idx3] * 3;
            int nextMultipleOf5 = dp[idx5] * 5;
            int minVal = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            // If the minVal is equal to the next multiple of 2, then move the index of 2
            if (minVal == nextMultipleOf2) {
                idx2++;
            }
            // If the minVal is equal to the next multiple of 3, then move the index of 3
            if (minVal == nextMultipleOf3) {
                idx3++;
            }
            // If the minVal is equal to the next multiple of 5, then move the index of 5
            if (minVal == nextMultipleOf5) {
                idx5++;
            }
            dp[i] = minVal;
        }
        // Return the n-th ugly number
        return dp[n - 1];
    }
}