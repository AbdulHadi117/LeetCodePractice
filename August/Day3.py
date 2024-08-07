def reverseSubArrayEquals(array1, array2):
    # Sort and compare both arrays
    return sorted(array1) == sorted(array2)

# Example usage:
array1 = [1, 2, 3, 4]
array2 = [2, 4, 1, 3]

# Print whether the arrays can be made equal
print(reverseSubArrayEquals(array1, array2))
