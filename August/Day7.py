def numberToWords(number):
    # Handle the special case of zero
    if number == 0:
        return "Zero"

    # Arrays for single digits, tens, and teens
    units = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
    tens = [
        "",
        "Ten",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety",
    ]
    teens = [
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen",
    ]

    # Initialize the result string
    result = ""

    # Process the billions place
    if number >= 1000000000:
        # Recursively convert the billions part and add "Billion"
        result += numberToWords(number // 1000000000) + " Billion "
        # Reduce the number by removing the billions part
        number %= 1000000000

    # Process the millions place
    if number >= 1000000:
        # Recursively convert the millions part and add "Million"
        result += numberToWords(number // 1000000) + " Million "
        # Reduce the number by removing the millions part
        number %= 1000000

    # Process the thousands place
    if number >= 1000:
        # Recursively convert the thousands part and add "Thousand"
        result += numberToWords(number // 1000) + " Thousand "
        # Reduce the number by removing the thousands part
        number %= 1000

    # Process the hundreds place
    if number >= 100:
        # Recursively convert the hundreds part and add "Hundred"
        result += numberToWords(number // 100) + " Hundred "
        # Reduce the number by removing the hundreds part
        number %= 100

    # Process the tens place
    if number >= 20:
        # Convert the tens part using the tens array
        result += tens[number // 10] + " "
        # Reduce the number by removing the tens part
        number %= 10

    # Process the units and teens place
    if number > 0:
        if number < 10:
            # Convert the units part using the units array
            result += units[number] + " "
        else:
            # Convert the teens part using the teens array
            result += teens[number - 10] + " "

    # Return the result string without leading/trailing whitespace
    return result.strip()


# Example usage
number = 47483000  # Example number
print(numberToWords(number))
# Output: "Forty Seven Million Four Hundred Eighty Three Thousand"
