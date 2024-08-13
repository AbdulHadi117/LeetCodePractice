def longestPalindrome(s):
    # Check if the entire string is already a palindrome
    if s == s[::-1]:
        return s
    
    # Transform the input string by inserting '#' between each character and at the ends
    transformed = "#" + "#".join(s) + "#"
    n = len(transformed)
    
    # Array to store the radius of the palindrome centered at each character
    palindrome_radii = [0] * n
    center = 0  # Center of the current rightmost palindrome
    right_edge = 0  # Right edge of the current rightmost palindrome
    
    for i in range(n):
        # Calculate the mirror index of the current index `i`
        mirror = 2 * center - i
        
        # Use the mirror's radius to initialize the current index's radius
        if i < right_edge:
            palindrome_radii[i] = min(right_edge - i, palindrome_radii[mirror])
        
        # Expand the palindrome centered at `i`
        while (i + 1 + palindrome_radii[i] < n and
               i - 1 - palindrome_radii[i] >= 0 and
               transformed[i + 1 + palindrome_radii[i]] ==
               transformed[i - 1 - palindrome_radii[i]]):
            palindrome_radii[i] += 1
        
        # Update the center and right edge if the expanded palindrome is beyond the current right edge
        if i + palindrome_radii[i] > right_edge:
            center = i
            right_edge = i + palindrome_radii[i]
    
    # Find the maximum radius and its center index
    max_radius = max(palindrome_radii)
    center_index = palindrome_radii.index(max_radius)
    
    # Calculate the starting index of the longest palindrome in the original string
    start_index = (center_index - max_radius) // 2
    
    # Extract and return the longest palindrome substring
    return s[start_index : start_index + max_radius]

s = "babad"
print(longestPalindrome(s))  # Output: "bab" or "aba"
