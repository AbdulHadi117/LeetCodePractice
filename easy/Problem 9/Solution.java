public class Solution {
    /*
     * Checks if a given integer is a palindrome.
     * 
     * A palindrome is a number that reads the same backward as forward.
     * 
     @ param number the integer to check
     $ return true if the integer is a palindrome, false otherwise
     */
    public boolean isPalindrome(int number) {
        // Negative numbers are not palindromes
        if (number < 0) {
            return false;
        }

        int reversed = 0;  // Variable to store the reversed number
        int original = number;  // Store the original number to compare later

        // Reverse the digits of the number
        while (number > 0) {
            int digit = number % 10;  // Get the last digit
            reversed = reversed * 10 + digit;  // Append it to the reversed number
            number = number / 10;  // Remove the last digit from the number
        }

        // Check if the reversed number is equal to the original number
        return reversed == original;
    }
}