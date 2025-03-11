
public class Solution {

    /*
     * Given a non-negative integer represented as a non-empty array of digits,
     * plus one to the integer.
     @ param digits the array of integers
     $ return the resulting array of integers
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // IF LAST DIGIT < 9
            if (digits[i] < 9) {
                // INCREMENT IT BY 1
                digits[i]++;
                // RETURN THE ARRAY
                // {1, 2, 4} becomes {1, 2, 5}
                return digits;
            }
            // WHEN LAST DIGIT IS 9, CHANGE IT TO ZERO
            digits[i] = 0;
            // {1, 9, 9} BECOMES {1, 9, 0} AFTER FIRST ITERATION
            // {1, 9, 0} BECOMES {1, 0, 0} AFTER SECOND ITERATION
            // {1, 0, 0} BECOMES {2, 0, 0} AFTER THIRD ITERATION WHEN IF CONDITION FULLFILS
            // {2, 0, 0} IS RETURNED IN THE IF CONDITION
        }

        // INCASE {9 ,9 ,9} AFTER LOOP IT WILL BECOME {0, 0, 0}
        // NEW ARRAY IS INITIALIZED WITH LENGTH 1 GREATER
        // FOR {9, 9, 9} -> {0, 0, 0, 0}
        int[] newDigits = new int[digits.length + 1];
        // FIRST ELEMENT IS CHANGED TO 1
        // {0, 0, 0, 0} BECOMES {1, 0, 0,0}

        return newDigits;   // RETURN THE NEW ARRAY
    }
}
