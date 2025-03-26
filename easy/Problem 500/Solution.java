import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    /*
     * Finds words that can be typed using letters of a single row on a keyboard.
     *
     @ param words An array of words to be checked.
     $ return An array of words that can be typed using one row of a keyboard.
     */
    public String[] findWords(String[] words) {
        if (words.length == 0) {
            return new String[0]; // Return an empty array if input is empty
        }

        // Define sets for each row of the keyboard
        Set<Character> firstRow = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> secondRow = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> thirdRow = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        List<String> resultList = new ArrayList<>(); // List to store result words

        // Iterate over each word
        for (String word : words) {
            Set<Character> letters = new HashSet<>(); // Set to store unique letters of the word
            for (char c : word.toLowerCase().toCharArray()) {
                letters.add(c); // Add each character to the set
            }
            // Check if all letters belong to any one row
            if (firstRow.containsAll(letters) || secondRow.containsAll(letters) || thirdRow.containsAll(letters)) {
                resultList.add(word); // Add word to result list if it can be typed using one row
            }
        }

        return resultList.toArray(String[]::new); // Convert result list to array and return
    }

}