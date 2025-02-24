
class Solution {

    // The minimum and maximum values of the row and column
    int minX, minY, maxX, maxY, index;
    int[][] result;

    /*
     * Returns a spiral matrix of size rows x cols, starting at row rStart and column cStart
     * The spiral matrix is filled with the numbers from 1 to n, in order, in a spiral pattern
     * The spiral pattern starts from the top left, moves right, then moves down, then moves left, and then moves up
     * The pattern continues until the entire matrix is filled
     * The result matrix is a 2D array of integers, where each element is an array of two elements, the row and column indices
     @ param rows the number of rows in the matrix
     @ param cols the number of columns in the matrix
     @ param rStart the starting row index
     @ param cStart the starting column index
     $ return a 2D array of integers, representing the spiral matrix
     */
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        // Calculate the number of items in the spiral matrix
        int n = cols * rows;

        // Initialize the result matrix
        result = new int[n][];

        // Initialize the boundaries
        minX = cStart;
        maxX = cStart + 1;
        minY = rStart;
        maxY = rStart;

        // Initialize the index
        index = 0;

        // Add the starting point to the result
        result[index++] = new int[]{rStart, cStart};

        // Loop until we have filled the result matrix
        while (true) {
            // Move right
            if (minY >= 0) {
                right(Math.max(0, minX + 1), Math.min(cols - 1, maxX));
            }

            // Move down if there is space
            maxY++;
            // Check if we have filled the result matrix
            if (index >= n) {
                break;
            }

            // Move left
            if (maxX < cols) {
                down(Math.max(0, minY + 1), Math.min(rows - 1, maxY));
            }

            // Move left boundary
            minX--;
            // Check if we have filled the result matrix
            if (index >= n) {
                break;
            }

            // Move up
            if (maxY < rows) {
                left(Math.min(cols - 1, maxX - 1), Math.max(0, minX));
            }

            // Move up boundary
            minY--;
            // Check if we have filled the result matrix
            if (index >= n) {
                break;
            }

            // Move right
            if (minX >= 0) {
                up(Math.min(rows - 1, maxY - 1), Math.max(0, minY));
            }

            // Move right boundary
            maxX++;
            // Check if we have filled the result matrix
            if (index >= n) {
                break;
            }
        }

        // Return the result matrix
        return result;
    }

    /*
     * Moves right, starting from the current row at minY, and ending at the rightmost column at end.
     *
     @ param start The starting column index
     @ param end The ending column index
     */
    public void right(int start, int end) {
        // Move right, starting from the current row at minY, and ending at the rightmost column at end
        // We are adding elements to the result matrix, so we start at the current index and move right
        for (int i = start; i <= end; i++) {
            // For each element in the current row, from the start to the end, add it to the result matrix
            result[index++] = new int[]{minY, i};
        }
    }

    /*
     * Moves left, starting from the current row at maxY, and ending at the leftmost column at end
     * This method is used to fill the result matrix with the elements of the spiral matrix
     * in a left direction
     @ param start The starting column index
     @ param end The ending column index
     */
    public void left(int start, int end) {
        // Move left, starting from the current row at maxY, and ending at the leftmost column at end
        // We are adding elements to the result matrix, so we start at the current index and move left
        for (int i = start; i >= end; i--) {
            // For each element in the current row, from the start to the end, add it to the result matrix
            // We are moving left, so the column index is decreasing
            result[index++] = new int[]{maxY, i};
        }
    }

    /*
     * Moves down, starting from the current column at minX, and ending at the bottommost row at end
     * This method is used to fill the result matrix with the elements of the spiral matrix
     * in a down direction
     *
     @ param start The starting row index
     @ param end The ending row index
     */
    public void down(int start, int end) {
        // Loop from the starting row index to the ending row index
        for (int i = start; i <= end; i++) {
            // Add the current position in the matrix to the result
            // The row index is 'i', and the column index is 'maxX'
            // Increment the index to store the next result
            result[index++] = new int[]{i, maxX};
        }
    }

    /*
     * Moves up, starting from the current column at maxX, and ending at the topmost row at end
     * This method is used to fill the result matrix with the elements of the spiral matrix
     * in a up direction
     *
     @ param start The starting row index
     @ param end The ending row index
     */
    public void up(int start, int end) {
        // Iterate from the starting row index down to the ending row index
        for (int i = start; i >= end; i--) {
            // Add the current position to the result matrix
            // The row index is 'i', and the column index is 'minX'
            // Increment the index to store the next result
            result[index++] = new int[]{i, minX};
        }
    }
}
