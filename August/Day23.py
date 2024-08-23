def fractionAddition(expression):
    # This function calculates the greatest common divisor (GCD) of two numbers using Euclid's algorithm.
    def gcd(a, b):
        if a == 0:
            return b
        return gcd(b % a, a)

    # Split the expression into multiple fractions and convert them to integers.
    fractions = expression.replace("+", " +").replace("-", " -").split()
    resultNum = 0
    resultDenom = 1
    for fraction in fractions:
        currNum, currDenom = fraction.split("/")
        currNum, currDenom = int(currNum), int(currDenom)

        # Calculate the result of the expression by adding and subtracting the fractions.
        resultNum = resultNum * currDenom + currNum * resultDenom
        resultDenom = resultDenom * currDenom

    # Determine if the result is negative.
    isNegative = False
    if resultNum < 0 or resultDenom < 0:
        isNegative = True

    # Calculate the GCD of the result and reduce the result to the simplest form.
    gcdVal = gcd(resultNum, resultDenom)
    resultNum = abs(resultNum // gcdVal)
    resultDenom = abs(resultDenom // gcdVal)

    # Return the result as a string.
    if isNegative:
        return f"-{resultNum}/{resultDenom}"
    
    return f"{resultNum}/{resultDenom}"

# Example Usage
expression = "1/3-1/2"
print(fractionAddition(expression))
