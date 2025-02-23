public class Solution {
    /*
     * Finds the longest palindromic substring in the given string.
     *
     * This algorithm uses Manacher's Algorithm to find the longest palindromic substring.
     *
     @ param s The string to find the longest palindromic substring
     @ return The longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Create a new string with '#' characters separating each character
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        // The length of the string
        int n = sPrime.length();

        // The array to store the radius of the palindrome at each center
        int[] palindromeRadii = new int[n];

        // The current center and radius of the palindrome
        int center = 0;
        int radius = 0;

        // Iterate through the string
        for (int i = 0; i < n; i++) {
            // The mirror of the current character
            int mirror = 2 * center - i;

            // If the current character is within the current radius
            if (i < radius) {
                // Copy the radius from the mirrored character
                palindromeRadii[i] = Math.min(
                    radius - i,
                    palindromeRadii[mirror]
                );
            }

            // Expand the palindrome centered at i
            while (
                i + 1 + palindromeRadii[i] < n &&
                i - 1 - palindromeRadii[i] >= 0 &&
                sPrime.charAt(i + 1 + palindromeRadii[i]) ==
                    sPrime.charAt(i - 1 - palindromeRadii[i])
            ) {
                // Increase the radius
                palindromeRadii[i]++;
            }

            // Update the center and radius
            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        // Find the maximum length and center index
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }

        // Calculate the start index of the longest palindrome
        int startIndex = (centerIndex - maxLength) / 2;

        // Return the longest palindrome
        String longestPalindrome = s.substring(
            startIndex,
            startIndex + maxLength
        );

        return longestPalindrome;
    }
}