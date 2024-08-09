def numMagicSquaresInside(grid):
    count = 0  # Initialize counter for the number of magic squares
    rows = len(grid)  # Get the number of rows in the grid
    cols = len(grid[0])  # Get the number of columns in the grid

    # Iterate over each possible 3x3 subgrid in the grid
    for row in range(rows - 2):
        for col in range(cols - 2):
            # Check if the current 3x3 subgrid is a magic square
            if isMagicSquare(grid, row, col):
                count += 1  # Increment the count if it's a magic square

    return count  # Return the total number of magic squares found


def isMagicSquare(grid, row, col):
    # Track seen numbers to ensure all are unique and within 1-9
    alreadyseenElement = [False] * 10
    # Check each cell in the 3x3 subgrid
    for i in range(3):
        for j in range(3):
            num = grid[row + i][col + j]  # Get the current number
            # If the number is not between 1 and 9 or has been seen before, return False
            if num < 1 or num > 9:
                return False
            if alreadyseenElement[num]:
                return False
            alreadyseenElement[num] = True  # Mark the number as seen

    # Calculate the sums of the two diagonals
    diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2]
    diagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2]

    # If the diagonals don't have the same sum, it's not a magic square
    if diagonal1 != diagonal2:
        return False

    # Calculate the sums of each row in the subgrid
    row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2]
    row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2]
    row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2]

    # If any row sum is not equal to the diagonal sum, return False
    if not (row1 == row2 == row3 == diagonal1):
        return False

    # Calculate the sums of each column in the subgrid
    col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col]
    col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1]
    col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2]

    # If any column sum is not equal to the diagonal sum, return False
    if not (col1 == col2 == col3 == diagonal1):
        return False

    return True  # If all checks pass, the subgrid is a magic square


# Example Usage
grid = [[4, 3, 8, 4], [9, 5, 1, 9], [2, 7, 6, 2]]
print(numMagicSquaresInside(grid))  # Output: 1
