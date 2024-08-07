def rangeSum(array, numberOfPositiveInts, leftIndex, rightIndex):
    subArraySums = []  # List to store sums of all subarrays

    # Generate all subarrays and calculate their sums
    for i in range(len(array)):
        currentSum = 0  # Initialize current subarray sum
        for j in range(i, numberOfPositiveInts):
            currentSum += array[j]  # Add element to current subarray sum
            subArraySums.append(currentSum)  # Append current subarray sum to list

    # Sort the list of subarray sums
    subArraySums.sort()

    # Return the sum of the specified range of sorted subarray sums, modulo 10^9 + 7
    return sum(subArraySums[leftIndex - 1:rightIndex]) % (10**9 + 7)

# Example usage:
array = [1, 2, 3, 4]
numberOfPositiveInts = 4
left_index = 1
right_index = 5

# Print the result of the range sum
print(rangeSum(array, numberOfPositiveInts, left_index, right_index))
