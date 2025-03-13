
public class Solution {

    /*
     * Computes the integer square root of a given number.
     * 
     @ param x The number for which to compute the integer square root.
     $ return The integer square root of x.
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;   // EDGE CASE
        }
        // IMPLEMENTING A BINARY SEARCH
        int start = 0;
        int end = x / 2;
        int ans = 0;    // FOR THE ROUNDED INTEGER IF X IS NOT PERFECT SQUARE

        while (start <= end) {

            int mid = (start + end) / 2;
            long sqr = (long) mid * mid;   // CALCUATING SQUARE OF CURRENT MID
            
            if (sqr == x) {
                return mid;   // RETURN IF X IS PERFECT SQUARE OF MID
            } else if (sqr < x) {  // IF COMPUTED SQUARE < X
                ans = mid;  // MID IS CANDIDATE FOR ROUNDED INTEGER
                start = mid + 1;    // SEARCH IN LOWER RANGE
            } else {    // IF COMPUTED SQUARE > X
                end = mid - 1;  // SEARCH IN HIGHER RANGE
            }
        }
        return ans; // RETURN THE ROUNDED INTEGER IF X IS NOT PERFECT SQUARE
    }
}
