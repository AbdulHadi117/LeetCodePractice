class Solution {
    /*
     * This function takes an integer n and returns true if Alice can win the game,
     * and false otherwise.
     * Alice can win the game if she can make the opponent lose the game by
     * making a move that leaves the opponent with no valid moves.
     *
     * The game is played as follows: Alice and Bob take turns to pick a number
     * from 1 to n, and the number they picked must be a divisor of n. If a
     * player cannot make a move, they lose the game.
     *
     @ param n the number to play the game with
     $ return true if Alice can win the game, false otherwise
     */
    public boolean divisorGame(int n) {
        return (n % 2 == 0);
    }
}