class Solution {
    /*
     * Calculates the minimum number of operations required to traverse a file system represented by an array of logs.
     @ param logs An array of strings representing the logs.
     $ return The minimum number of operations required.
     */
    public int minOperations(String[] logs) {
        int level = 0;
        // Iterate through each log
        for (String log : logs){
            if (log.equals("../")) {
                // Move up one level
                level = Math.max(0,level-1);
            } else if (!log.equals("./")) {
                // Move down one level
                level += 1;
            }
        }
        return level;
    }
}