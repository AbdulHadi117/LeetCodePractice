
class Solution {

    /*
     * Finds the number of magic squares in a given grid.
     *
     * A magic square is a 3x3 subgrid where all rows, columns, and diagonals have the same sum,
     * and all numbers are distinct and between 1 and 9.
     *
     @ param grid the given grid
     $ return the total number of magic squares found in the grid
     */
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;  // Initialize counter for the number of magic squares
        int rows = grid.length;  // Get the number of rows in the grid
        int cols = grid[0].length;  // Get the number of columns in the grid

        // Iterate over each possible 3x3 subgrid in the grid
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                // Check if the current 3x3 subgrid is a magic square
                if (isMagicSquare(grid, row, col)) {
                    count++;  // Increment the count if it's a magic square
                }
            }
        }

        return count;  // Return the total number of magic squares found
    }

    /*
     * Checks if a given 3x3 subgrid is a magic square.
     * A magic square is a 3x3 subgrid where all rows, columns, and diagonals have the same sum,
     * and all numbers are distinct and between 1 and 9.
     *
     @ param grid the given grid
     @ param row the row where the top-left cell of the subgrid is located
     @ param col the column where the top-left cell of the subgrid is located
     $ return true if the subgrid is a magic square, false otherwise
     */
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        boolean[] alreadySeenElement = new boolean[10];  // Track seen numbers to ensure all are unique and within 1-9

        // Check each cell in the 3x3 subgrid to ensure all numbers are between 1 and 9 and unique
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];  // Get the current number
                // If the number is not between 1 and 9 or has been seen before, return false
                if (num < 1 || num > 9 || alreadySeenElement[num]) {
                    return false;
                }
                alreadySeenElement[num] = true;  // Mark the number as seen
            }
        }

        // Calculate the sums of the two diagonals
        int diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

        // If the diagonals don't have the same sum, it's not a magic square
        if (diagonal1 != diagonal2) {
            return false;
        }

        // Calculate the sums of each row in the subgrid and check if they have the same sum
        int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

        // If any row sum is not equal to the diagonal sum, return false
        if (row1 != diagonal1 || row2 != diagonal1 || row3 != diagonal1) {
            return false;
        }

        // Calculate the sums of each column in the subgrid and check if they have the same sum
        int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        // If any column sum is not equal to the diagonal sum, return false
        return !(col1 != diagonal1 || col2 != diagonal1 || col3 != diagonal1);
        // If all checks pass, the subgrid is a magic square
    }
}

