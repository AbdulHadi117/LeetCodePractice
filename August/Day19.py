def myAtoi(string):
    # Initialize variables
    index = 0
    sign = 1
    res = 0
    max_int = 2**31 - 1
    min_int = -(2**31)

    # Skip leading whitespaces
    while index < len(string) and string[index] == " ":
        index += 1

    # Check if the first non-whitespace character is a sign
    if index < len(string) and (string[index] == "+" or string[index] == "-"):
        sign = 1 - 2 * (string[index] == "-")
        index += 1

    # Convert valid digits to integer
    while index < len(string) and string[index].isdigit():
        res = res * 10 + int(string[index])
        index += 1

    # Multiply the result by the sign
    res = sign * res

    # Limit the result within the 32-bit integer range
    return min(max(res, min_int), max_int)


# Test the function
string = "words and 987"
print(myAtoi(string))
