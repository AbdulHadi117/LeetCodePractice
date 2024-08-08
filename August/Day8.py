def spiralMatrixIII(rows, columns, rStart, cStart):
    # Initialize the result list with the starting position
    traversedPositions = [[rStart, cStart]]

    # Lambda function to check if a given position is within bounds of the grid
    isValid = lambda row, col: row >= 0 and row < rows and col >= 0 and col < columns

    # Start with no steps taken
    steps = 0

    # Initialize the current position
    currentRow, currentCol = rStart, cStart

    # Continue until all positions in the grid are traversed
    while len(traversedPositions) < rows * columns:
        steps += 1

        # Move right `steps` times
        for _ in range(steps):
            currentCol += 1
            if isValid(currentRow, currentCol):
                traversedPositions.append([currentRow, currentCol])

        # Move down `steps` times
        for _ in range(steps):
            currentRow += 1
            if isValid(currentRow, currentCol):
                traversedPositions.append([currentRow, currentCol])

        steps += 1

        # Move left `steps` times
        for _ in range(steps):
            currentCol -= 1
            if isValid(currentRow, currentCol):
                traversedPositions.append([currentRow, currentCol])

        # Move up `steps` times
        for _ in range(steps):
            currentRow -= 1
            if isValid(currentRow, currentCol):
                traversedPositions.append([currentRow, currentCol])

    # Return the list of all positions traversed in spiral order
    return traversedPositions


# Example usage
rows, columns = 5, 6
rStart, cStart = 1, 4
print(spiralMatrixIII(rows, columns, rStart, cStart))
