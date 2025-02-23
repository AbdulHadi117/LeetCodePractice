# Longest Palindromic SubString

## Problem Statement
Given a string `s`, return the longest palindromic substring in `s`.

## Examples

 - ### Example 1
    - **Input:** `s = "babad"`
    - **Output:** `"bab"`
    - **Explanation:** `"aba"` is also a valid answer.

 - ### Example 2
    - **Input:** `s = "cbbd"`
    - **Output:** `"bb"`

## Constraints
- `1 <= s.length <= 1000`
- `s` consists of only digits and English letters.

## Time Complexity
The time complexity of the algorithm is O(n), where n is the length of the transformed string `sPrime`. Since each character in the original string `s` is transformed into two characters in `sPrime` (with `#` characters added in between), the length of `sPrime` is approximately 2n. The algorithm iterates over `sPrime` once, and each expansion step (while loop) is amortized O(1) over the entire string. Therefore, the overall time complexity is O(n).

## Space Complexity
The space complexity of the algorithm is O(n), where n is the length of the transformed string `sPrime`. This is due to the additional storage needed for the `sPrime` string and the `palindromeRadii` array, both of which have a length proportional to the length of `sPrime`. Thus, the overall space complexity is O(n).

