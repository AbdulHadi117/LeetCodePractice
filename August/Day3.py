def canBeEqual(array1, array2):
    # Check if arrays have different lengths
    if len(array1) != len(array2):
        return False

    # Sort and compare both arrays
    return sorted(array1) == sorted(array2)

# Example usage:
array1 = [1, 2, 3, 4]
array2 = [2, 4, 1, 3]

# Print whether the arrays can be made equal
print(canBeEqual(array1, array2))
