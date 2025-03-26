class Solution {
    /*
     * Determines if you can win the Nim game given the number of stones.
     *
     @ param n the number of stones in the heap
     $ return true if you can win the game, false otherwise
     * 
     * In the Nim game, you can always win if the number of stones n is not a multiple of 4.
     * If n is a multiple of 4, the opponent can always force a win.
     */
    public boolean canWinNim(int n) {
        // Check if n is not a multiple of 4
        return (n % 4 != 0);
    }
}