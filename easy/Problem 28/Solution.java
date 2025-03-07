public class Solution{
    /*
     * Returns the index of the first occurrence of the needle in the haystack, or -1 if the needle is not part of the haystack.
     *
     @ param haystack The string in which to search for the needle.
     @ param needle The string to search for within the haystack.
     $ return The index of the first occurrence of the needle in the haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // Use the built-in indexOf method to find the position of the needle in the haystack
        return haystack.indexOf(needle);
    }
}