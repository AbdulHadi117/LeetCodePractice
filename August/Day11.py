def lengthOfLongestSubstring(s):
    # Initialize pointers and set
    start = 0                # Start of the window
    max_length = 0           # Maximum length of substring found
    char_set = set()         # Set to track characters in the current window
    
    # Iterate over each character in the string with the end pointer
    for end in range(len(s)):
        # If character is already in the set, remove characters from the start pointer
        while s[end] in char_set:
            char_set.remove(s[start])
            start += 1
        
        # Add the current character to the set
        char_set.add(s[end])
        
        # Update the maximum length found
        max_length = max(max_length, end - start + 1)
    
    return max_length

# Example usage
print(lengthOfLongestSubstring("abcabcbb"))  # Output: 3 ("abc")
print(lengthOfLongestSubstring("bbbbb"))     # Output: 1 ("b")
print(lengthOfLongestSubstring("pwwkew"))    # Output: 3 ("wke")
