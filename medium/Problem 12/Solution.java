
public class Solution {

    /*
     * Converts an integer to its Roman numeral representation.
     *
     @ param num The integer to convert
     @ return The Roman numeral representation of the integer
     */
    public String intToRoman(int num) {
        // MAPPING INTEGER VALUES TO ROMAN VALUES IN PARALLEL ARRAYS
        int[] integer = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };
        String[] roman = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };
        int idx = 0;     // INDEX COUNTER TO TRAVERSE BOTH ARRAYS
        String result = ""; // RESULTING STRING
        // LOOP UNTIL THE NUMBER IS 0
        while (num > 0) {
            // IF THE NUMBER IS GREATER THAN OR EQUAL TO THE current INTEGER VALUE
            if (num >= integer[idx]) {   // FOR THE VALUE NUMBER MATCHES OR IS GREATER THAN
                // APPEND THE MAPPED ROMAN INTO STRING
                result += roman[idx];
                // UPDATE THE NUMBER BY SUBTRACTING THE VALUE
                num -= integer[idx];
            } else {
                // IF NOT, INCREASE THE INDEX TO MATCH NEXT INTEGER VALUE
                idx++;
            }
        }
        return result;  // RETURN THE STRING
    }
}
