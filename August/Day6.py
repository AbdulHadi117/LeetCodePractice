def minimumPushes(word):    
    # Initialize a frequency count list for each letter
    frequencyCount = [0] * 26
    
    # Count the frequency of each character in the input word
    for char in word:
        frequencyCount[ord(char) - ord('a')] += 1  # Optimized character indexing

    # Sort the frequency count in descending order
    sortedCount = sorted(frequencyCount, reverse=True)
    
    # Initialize the minimum pushes required
    minimumPushes = 0
    
    # Calculate the minimum pushes needed based on sorted frequencies
    for index in range(len(sortedCount)):
        if sortedCount[index] == 0:  # Stop if the count is zero
            break
        # Calculate the pushes needed for the current frequency
        minimumPushes += (index // 8 + 1) * sortedCount[index]
    
    return minimumPushes

# Example usage
word = "aabbccddeeffgghhiiiiii"
minimumPushesRequired = minimumPushes(word)
print(f"Minimum number of pushes needed: {minimumPushesRequired}")
