class Solution {
    /*
     * This method takes an integer as input and returns its binary complement.
     @ param num The input number.
     $ return The binary complement of the input number.
     */
    public int findComplement(int num) {
        // Convert the number to its binary representation as a string
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }

        // Flip all the bits in the binary representation
        String flipped = "";
        for (int index = 0; index < binary.length(); index++) {
            if (binary.charAt(index) == '0') {
                flipped += '1';
            } else {
                flipped += '0';
            }
        }

        // Convert the flipped binary representation back to an integer
        int result = 0;
        for (int index = 0; index < flipped.length(); index++) {
            result = result * 2 + (flipped.charAt(index) - '0');
        }
        return result;
    }
}