
class Solution {

    /*
     * Given an integer n, return the number of distinct ways to climb n stairs.
     * Each time you can either climb 1 or 2 steps.
     * 
     @ param n the number of stairs
     $ return the number of distinct ways to climb n stairs
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;   // BASE CASES
        }
        // FIBONACCI SERIES OR DYNAMIC PROGRAMMING APPROACH
        // 
        // The number of distinct ways to climb n stairs is the sum of the number of
        // ways to climb n-1 stairs and n-2 stairs.
        // 
        // We use a dynamic programming approach to store the results of the subproblems
        // in an array and use them to compute the solution to the current problem.
        // 
        // The time complexity of this algorithm is O(n) and the space complexity is O(1).

        int prev1 = 2;  // WAYS TO CLIMB PREVIOUS STAIR (INITIALLY 2)
        int prev2 = 1;  // WAYS TO CLIMB STAIR BEFORE PREVIOUS (INITIALLY 1)
        int curr = 0;   // WAYS TO CLIMB CURRENT STEP

        for (int i = 2; i < n; i++) {
            curr = prev1 + prev2;   // COMPUTING CURRENT FROM PREVIOUS WAYS

            // UPDATING PREVIOUS VARIABLES FOR NEXT ITERATION
            prev2 = prev1;
            prev1 = curr;
        }

        // RETURNING WAYS TO CLIMB THE CURRENT STEP
        return curr;
    }
}
