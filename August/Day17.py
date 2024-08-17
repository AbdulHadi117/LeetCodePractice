def reverse(x):
    # Base case: If the input is 0, return 0 immediately
    if x == 0:
        return 0

    # Determine the sign of the number: -1 for negative, 1 for positive
    sign = -1 if x < 0 else 1

    # Convert the number to its absolute value to simplify the reversal process
    x = abs(x)

    # Initialize the result to store the reversed number
    result = 0

    # Loop to reverse the digits of the number
    while x > 0:
        # Multiply the current result by 10 and add the last digit of x
        result = result * 10 + x % 10

        # Remove the last digit from x
        x //= 10

    # Check if the reversed number exceeds the 32-bit signed integer limit
    if result > 2**31 - 1:
        return 0  # Return 0 if the result is out of bounds

    # Return the reversed number with its original sign
    return max(-(2**31), min(2**31 - 1, result * sign))

# Example Usage
x = 123
print(reverse(x))