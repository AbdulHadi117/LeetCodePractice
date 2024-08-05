def kthDistinct(array,kthDistinctElement):    
    # Create a dictionary to store the frequency of each element
    distinctElements = {}
    # Loop through the array
    for char in array:
        # If the element is not in the dictionary
        if char not in distinctElements:
            # Add it to the dictionary
            distinctElements[char] = 1
        # If the element is in the dictionary
        else:
            # Increment its frequency
            distinctElements[char] += 1
    # Loop through the dictionary
    for char in array:
        # If the frequency of the element is 1
        if distinctElements[char] == 1:
            # If the element is the kth distinct element
            if kthDistinctElement == 1:
                # Return it
                return char
            # Decrement the k
            kthDistinctElement -= 1
    # If the kth distinct element is not found
    return -1

# Example usage:
array = ["d","b","c","b","c","a"]
kthDistinctElement = 2
# Print the result
print(kthDistinct(array,kthDistinctElement))