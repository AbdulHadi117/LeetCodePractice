# Regular Expression Matching

## Problem Description

Given an input string `s` and a pattern `p`, implement regular expression matching with support for the following:

- `'.'`: Matches any single character.
- `'*'`: Matches zero or more of the preceding element.

The matching should cover the entire input string, not just a partial match.

## Examples

### Example 1

- **Input**: `s = "aa"`, `p = "a"`
- **Output**: `false`
- **Explanation**: The pattern "a" does not match the entire string "aa".

### Example 2

- **Input**: `s = "aa"`, `p = "a*"`
- **Output**: `true`
- **Explanation**: The '*' allows for zero or more of the preceding element 'a'. Repeating 'a' once results in "aa".

### Example 3

- **Input**: `s = "ab"`, `p = ".*"`
- **Output**: `true`
- **Explanation**: The pattern ".*" matches "zero or more (*) of any character (.)".

## Constraints

- `1 <= s.length <= 20`
- `1 <= p.length <= 20`
- The string `s` contains only lowercase English letters.
- The pattern `p` contains only lowercase English letters, `'.'`, and `'*'`.
- Every '*' character in the pattern `p` will have a preceding valid character to match.

## Complexity Analysis

- **Time Complexity**: O(m * n)
  - In the worst case, the algorithm iterates over the text and the pattern `m` and `n` times, respectively.

- **Space Complexity**: O(m * n)
  - A dynamic programming (dp) array of size `m * n` is used to store intermediate results.

