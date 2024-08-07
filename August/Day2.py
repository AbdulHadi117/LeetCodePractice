def minimumSwaps(nums):
    # Count the number of 1's in the list
    countOfOnes = nums.count(1)
    
    # If no 1's or all 1's, no swaps needed
    if countOfOnes == 0 or countOfOnes == len(nums):
        return 0

    # Initial window of size countOfOnes
    initialWindow = sum(nums[:countOfOnes])
    maxWindow = initialWindow

    # Slide the window through the list
    for index in range(len(nums)):
        # Update the window sum
        initialWindow -= nums[index]
        initialWindow += nums[(index + countOfOnes) % len(nums)]
        # Track the maximum number of 1's in any window
        maxWindow = max(maxWindow, initialWindow)

    # Minimum swaps needed
    return countOfOnes - maxWindow

# Example usage:
nums = [1, 0, 1, 0, 1, 0, 0, 1]
swaps = minimumSwaps(nums)
print(f"Minimum number of swaps needed: {swaps}")
