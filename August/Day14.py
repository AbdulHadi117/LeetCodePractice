def convert(s, numRows):
    # No need to convert; just return the original string.
    if numRows == 1 or numRows >= len(s):
        return s
        
    # Initialize a list of empty strings, one for each row
    res = [''] * numRows
    
    # Set the initial index to 0 and the step (direction) to 1 (downwards)
    index, step = 0, 1
    
    # Iterate over each character in the string
    for char in s:
        # Append the character to the current row
        res[index] += char

        # If we're at the first row, start moving down (step = 1)
        if index == 0:
            step = 1
        # If we're at the last row, start moving up (step = -1)
        elif index == numRows - 1:
            step = -1
        
        # Move to the next row depending on the current direction (step)
        index += step

    # Join all rows together and return it
    return ''.join(res)

s = "PAYPALISHIRING"
numRows = 3
print(convert(s, numRows))
