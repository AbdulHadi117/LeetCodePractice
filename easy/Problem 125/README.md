# Valid Palindrome

## Problem Statement

A phrase is considered a palindrome if, after:

- Converting all uppercase letters into lowercase
- Removing all non-alphanumeric characters

It reads the same forward and backward. Alphanumeric characters include both letters and numbers.

Given a string `s`, your task is to determine whether it is a palindrome.

## Examples

- **Example 1:**
  - **Input:** `s = "A man, a plan, a canal: Panama"`
  - **Output:** `true`
  - **Explanation:** After processing, `"amanaplanacanalpanama"` is a palindrome.

- **Example 2:**
  - **Input:** `s = "race a car"`
  - **Output:** `false`
  - **Explanation:** After processing, `"raceacar"` is not a palindrome.

- **Example 3:**
  - **Input:** `s = " "`
  - **Output:** `true`
  - **Explanation:** The input string becomes an empty string `""` after removing non-alphanumeric characters. Since an empty string reads the same forward and backward, it is considered a palindrome.

## Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of printable ASCII characters.

## Algorithmic Analysis

### Time Complexity Analysis
The time complexity of the `isPalindrome` method is O(n), where n is the length of the string. This is because the algorithm iterates over the string once, and each operation (pushing to the stack and popping from the stack) is a constant time operation.

### Space Complexity Analysis
The space complexity of the `isPalindrome` method is O(n), where n is the length of the string. This is because in the worst case, every character in the string is pushed to the stack, resulting in a space complexity of O(n).
