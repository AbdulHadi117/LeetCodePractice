# **Fraction Addition and Subtraction**

  - **Given**: A string expression representing an expression of fraction addition and subtraction.
  - **Return**: The calculation result in string format.

## **Description**

  - The final result should be an irreducible fraction.
  - If the final result is an integer, convert it to a fraction format with a denominator of 1. For example, 2 should be converted to 2/1.

## **Examples**

  - **Example 1**
    - **Input**: `expression = "-1/2+1/2"`
    - **Output**: `"0/1"`

  - **Example 2**
    - **Input**: `expression = "-1/2+1/2+1/3"`
    - **Output**: `"1/3"`

  - **Example 3**
    - **Input**: `expression = "1/3-1/2"`
    - **Output**: `"-1/6"`

## **Constraints**

  - The input string only contains characters: '0' to '9', '/', '+', and '-'.
  - Each fraction (input and output) is in the format ±numerator/denominator.
  - If the first input fraction or the output is positive, '+' is omitted.
  - The input contains valid irreducible fractions with numerators and denominators in the range [1, 10].
  - If the denominator is 1, the fraction is an integer in fraction format.
  - The number of given fractions ranges from 1 to 10.
  - The numerator and denominator of the final result are guaranteed to be valid and within the range of 32-bit integers.

## **Time Complexity**

The time complexity of the algorithm is O(n) where n is the length of the expression string.
This is because the code iterates through the expression string once, performing a constant amount of operations for each character in the string.

## **Space Complexity**

The space complexity of the algorithm is O(n) as well.
This is because the code creates an array of strings to store the individual fractions in the expression, and the size of this array is proportional to the length of the expression string.
