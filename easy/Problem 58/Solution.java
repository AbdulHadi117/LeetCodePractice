
public class Solution {

    /*
     * Returns the length of the last word in the given string.
     *
     * The given string is split into words using spaces as the delimiter.
     * The length of the last element in the words array is returned.
     *
     @ param s the input string
     $ return the length of the last word in the string
     */
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");   // SPLITTING WORDS ON SPACE CHARACTERS
        return words[words.length - 1].length();    // LENGTH OF LAST ELEMENT IN WORDS ARRAY
    }
}
