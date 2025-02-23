public class Solution {
    /*
     * Reverses the digits of an integer.
     *
     * If the reversed integer overflows, returns 0.
     *
     @ param x the integer to reverse
     @ return the reversed integer, or 0 if overflow occurs
     */
    public int reverse(int x) {
        long res = 0;  // Result variable to store the reversed number
        while (x != 0) {
            res = res * 10 + x % 10;  // Append the last digit of x to res
            x = x / 10;  // Remove the last digit from x
        }
        // Check for overflow
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) res;  // Cast the result back to int
        }
    }
}