public class Solution {
    /*
     * Finds the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, returns an empty string.
     *
     @ param strs The array of strings
     $ return The longest common prefix string
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // The prefix is the first string in the array
        String prefix = strs[0];

        // Iterate over the rest of the strings in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string does not start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Remove the last character of the prefix
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}