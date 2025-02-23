import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * Returns the length of the longest substring of the given string without repeating characters.
     @ param s the given string
     @ return the length of the longest substring
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxlength = 0;
        
        // Set to store the characters in the current window
        Set<Character> charSet = new HashSet<>();

        // Iterate through the string using the end pointer
        for (int end = 0; end < s.length(); end++) {
            // If the end pointer points to a character that is already in the set
            while (charSet.contains(s.charAt(end))) {
                // Remove the character at the start pointer from the set and move the start pointer forward
                charSet.remove(s.charAt(start));
                start++;
            }
            // Add the character at the end pointer to the set
            charSet.add(s.charAt(end));
            // Update the maximum length
            maxlength = Math.max(maxlength, end - start + 1);
        }
        // Return the maximum length
        return maxlength;
    }
}

