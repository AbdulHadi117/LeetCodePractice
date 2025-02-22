
class Solution {

    /**
     ** Dynamic programming solution for the regular expression matching problem.
     ** The time complexity is O(m * n) and the space complexity is O(m * n).
     *@ param text the text to be matched
     *@ param pattern the pattern
     *$ eturn true if the text matches the pattern, false otherwise
     */
    public boolean isMatch(String text, String pattern) {
        // dp[i][j] is true if and only if the first i characters in text match
        // the first j characters in pattern
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];

        // base case: if the text is empty, then the pattern must be empty
        dp[text.length()][pattern.length()] = true;

        // iterate over the text from right to left
        for (int i = text.length(); i >= 0; i--) {
            // iterate over the pattern from right to left
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                
                // if the current character in the pattern is '*'
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    // then the current character in the text can be ignored
                    // or the current character in the text can be matched
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                } else {
                    // then the current character in the text must be matched
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        // return the result
        return dp[0][0];
    }

}


