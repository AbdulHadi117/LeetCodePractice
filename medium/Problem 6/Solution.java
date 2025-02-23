public class Solution {
    /*
     * Given a string S, convert it to zigzag pattern.
     * 
     @ param s the original string
     @ param numRows the number of rows for zigzag pattern
     @ return the converted string
     */
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()){
            return s;   // EDGE CASES
        }

        int idx = 0; // FOR CURRENT ROW
        int direction = 1; // FOR CURRENT DIRECTION

        // INITIALIZE ARRAY FOR ALL ROWS AS EMPTY STRING
        String[] rows = new String[numRows];
        for (int i = 0; i < numRows; i++){
            rows[i] = "";
        }

        // APPEND EACH CHARACTER TO CURRENT ROW
        for (char c : s.toCharArray()){
            rows[idx] += c;

            // CHANGE DIRECTION FOR DOWN
            if (idx == 0) direction = 1; 
            // CHANGE DIRECTION FOR UP
            else if (idx == numRows - 1){
                direction = -1;  
            }
            idx += direction; // MOVE TO NEXT ROW
        }

        // COMBINE ALL ROWS INTO SINGLE STRING
        String result = "";
        for (String row : rows){
            result += row;
        }

        return result;
    }
}