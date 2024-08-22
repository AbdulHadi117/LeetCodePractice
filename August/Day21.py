def romanToInt(s):
    # Mapping of Roman numerals to their corresponding integer values
    values = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
        }
    # Initialize variables to =
    ans = prevVal = 0
    # Iterate over given string in reverse order
    for char in reversed(s):
        # Get current value of character
        currentVal = values[char]
        # If current value is less than previous value, subtract from answer
        if currentVal < prevVal:
            ans -= currentVal
        # Otherwise, add to answer
        else:
            ans += currentVal
        # Update previous value
        prevVal = currentVal
    # Return answer
    return ans
