def maxDistance(arrays):
    # Initialize minVal and maxVal with the first and last element of the first array
    minVal = arrays[0][0]
    maxVal = arrays[0][-1]
    
    # Initialize maxDistance to store the maximum distance found
    maxDistance = 0

    # Loop through each array starting from the second one
    for i in range(1, len(arrays)):
        currentArray = arrays[i]
        
        # Calculate the potential maximum distance by considering:
        # 1. Difference between the last element of the current array and the smallest element seen so far.
        # 2. Difference between the largest element seen so far and the first element of the current array.
        maxDistance = max(
            maxDistance,                      # Current maximum distance
            abs(currentArray[-1] - minVal),   # Distance between current array's max and overall min
            abs(maxVal - currentArray[0])     # Distance between overall max and current array's min
        )

        # Update minVal and maxVal with the current array's first and last elements
        minVal = min(minVal, currentArray[0])
        maxVal = max(maxVal, currentArray[-1])

    # Return the maximum distance found
    return maxDistance


# Example usage
arrays = [[1, 4], [0, 5]]
print(maxDistance(arrays))  # Output should be 5
