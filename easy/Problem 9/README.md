# Palindrome Number

- **Goal**: Determine if a given integer `x` is a palindrome.
- **Output**: Return `true` if `x` is a palindrome, otherwise return `false`.

## Examples

- **Example 1:**
  - **Input**: `x = 121`
  - **Output**: `true`
  - **Explanation**: `121` reads the same forwards and backwards.

- **Example 2:**
  - **Input**: `x = -121`
  - **Output**: `false`
  - **Explanation**: Reads `-121` from left to right and `121-` from right to left, which is not the same.

- **Example 3:**
  - **Input**: `x = 10`
  - **Output**: `false`
  - **Explanation**: Reads `01` from right to left, which is different from `10`.

## Constraints

- `-2^31 <= x <= 2^31 - 1`

## Time and Space Complexity Analysis

### Time Complexity

The time complexity of the `isPalindrome` method is O(log10(x)), where x is the input number. This is because the while loop runs a number of times equal to the number of digits in the number x. The number of digits in x is proportional to log10(x), as each division by 10 reduces the number of digits by one.

### Space Complexity

The space complexity of the `isPalindrome` method is O(1). This is because the method uses a constant amount of additional space, which does not grow with the size of the input. The space used is for a few integer variables (`reversed` and `original`), and this does not change with the size of the input number.
