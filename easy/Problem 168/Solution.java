
class Solution {

    /*
     * Converts an integer columnNumber to its corresponding title in Microsoft Excel column naming convention.
     *
     @ param columnNumber an integer representing the column number in Microsoft Excel
     $ return a string representing the title of the column in Microsoft Excel column naming convention
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();  // INITIALIZE AN EMPTY STRING
        while (columnNumber > 0) {   // WHILE COLUMN NUMBER IS NOT ZERO
            columnNumber--;     // DECREMENT THE NUMBER FOR 0-BASED INDEX
            int remain = columnNumber % 26;  // FIND THE REMAINDER BY 26
            result.append((char) (remain + 'A')); // MAP REMAINDER TO ALPHABET AND APPEND IT
            columnNumber /= 26; // UPDATE THE COLUMN NUMBER FOR NEXT ITERATION
        }
        return result.reverse().toString(); // RETURN THE RESULTED STRING
    }
}
