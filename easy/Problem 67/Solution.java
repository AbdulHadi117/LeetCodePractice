
public class Solution {

    /*
     * Given two binary strings, return their sum (also a binary string).
     @ param a the first binary string
     @ param b the second binary string
     $ return the sum of a and b in binary
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        // IMPLEMENTING AN N BIT ADDER
        int i = a.length() - 1; // POINTER FOR STRING A
        int j = b.length() - 1; // POINTER FOR STRING B
        int carry = 0;          // CARRY BIT

        // PERFORM BIT BY BIT ADDITION FROM RIGHT TO LEFT
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            // SUM IS A XOR B XOR CARRY
            int sum = bitA ^ bitB ^ carry;
            result.append(sum);

            // CALCULATE NEW CARRY
            // CARRY WILL CHANGE IF A AND B = 1
            // CARRY WILL CHANGE IF ANY OF A, B = 1 AND PREV CARRY = 1
            carry = (bitA & bitB) | (carry & (bitA ^ bitB));

            // SHIFTING POINTERS TO THE NEXT BIT
            i--;
            j--;
        }

        // RETURN THE REVERSE AS IT WAS APPENEDED IN REVERSE ORDER
        return result.reverse().toString();
    }
}
