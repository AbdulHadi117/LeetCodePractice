import java.util.Arrays;

public class Solution {
    /*
     * Calculates the minimum number of pushes required to type a given word using a keyboard.
     * The keyboard has 26 keys, and each key can type one letter of the alphabet.
     * Each row of the keyboard can hold 8 keys, and the cost of reaching each row increases.
     * 
     @ param word The word to be typed using the keyboard.
     $ return The minimum number of pushes required to type the word.
     */
    public int minimumPushes(String word) {
        int alphabetSize = 26; // Total number of letters in the alphabet
        int[] freqCount = new int[alphabetSize]; // Array to store frequency of each letter

        // Count the frequency of each character in the word
        for (char character : word.toCharArray()) {
            freqCount[character - 'a']++;
        }

        // Sort frequencies in ascending order
        Arrays.sort(freqCount);

        // Reverse the array to have frequencies in descending order
        for (int i = 0; i < alphabetSize / 2; i++) {
            int temp = freqCount[i];
            freqCount[i] = freqCount[alphabetSize - 1 - i];
            freqCount[alphabetSize - 1 - i] = temp;
        }

        int minPushes = 0; // Variable to store the minimum number of pushes

        // Calculate the minimum pushes required based on frequency and row position
        for (int i = 0; i < freqCount.length; i++) {
            if (freqCount[i] == 0) {
                break; // Break if there are no more characters with frequency > 0
            }
            // Calculate the pushes for each frequency and accumulate
            minPushes += ((i / 8) + 1) * freqCount[i];
        }

        return minPushes; // Return the total minimum number of pushes
    }
}