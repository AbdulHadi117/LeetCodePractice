class Solution {
    /*
     * This method takes a string as input and checks if the given string is a palindrome.
     @ param s the given string
     $ return true if the string is a palindrome, false otherwise
     */
    public boolean isPalindrome(String s) {
        // Validate the given input string
        String validString = validate(s);

        // Edge case: empty string
        if (validString.length() == 0) return true;

        // Two pointer approach
        int left = 0;
        int right = validString.length() - 1;

        // Traverse the string
        while (left < right) {   // If characters at both edges don't match
            if(validString.charAt(left) != validString.charAt(right)){
                return false;   // Phrase is not a palindrome
            }

            // Increment and decrement the pointers
            left++;
            right--;
        }
        return true;    // Phrase is palindrome if whole phrase is traversed
    }
    
    /*
     * Converts the string to lowercase and removes all non-alphanumeric characters.
     * 
     @ param s the input string
     $ return the validated string containing only lowercase alphanumeric characters
     */
    public String validate(String s) {
        s = s.toLowerCase(); // Convert the string to lowercase
        StringBuilder res = new StringBuilder(); // Use StringBuilder for efficient string manipulation

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Check if the character is alphanumeric
            if (Character.isLetterOrDigit(c)) {
                res.append(c); // Append the character to the result
            }
        }

        return res.toString(); // Return the validated string
    }
}