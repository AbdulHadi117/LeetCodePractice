
public class Solution {
    /*
     * Convert a string to an integer.
     * 
     @ param s the string to be converted
     @ return the integer value of the string
     */
    public int myAtoi(String s) {
        int idx = 0, sign = 1, res = 0;
        // skip leading spaces
        while (idx < s.length()
                && s.charAt(idx) == ' ') {
            idx++;
        }
        // check for sign
        if (idx < s.length()
                && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            // update sign
            sign = s.charAt(idx) == '+' ? 1 : -1;
            // skip sign
            idx++;
        }
        // iterate through the string
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            // get the current digit
            int digit = s.charAt(idx) - '0';
            // check for overflow
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                // return the maximum or minimum value if overflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // update the result
            res = 10 * res + digit;
            // move to the next digit
            idx++;
        }
        // return the final result
        return sign * res;
    }
}
