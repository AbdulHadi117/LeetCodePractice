public class Solution {
    public String reverseWords(String s) {
        
        String result = ""; // RESULT STRING TO RETURN
        s = s.trim();   // REMOVING ANY TRAILING SPACES BEFOREHAND

        String[] words = s.split("\\s+");   // SPLITTING STRING ON SPACE CHARACTER(S)
        for (int i = words.length - 1; i >= 0; i--){
            result += words[i] + " ";   // CONCATENATING WORDS IN REVERSE ORDER
        }

        return result.trim();   // RETURNING RESULT WITH NO TRAILING WHITESPACES
    }
}
