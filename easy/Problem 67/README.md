# Problem 67: Add Binary

## Description

Given two binary strings `a` and `b`, return their sum as a binary string.

## Examples

### Example 1

#### Input

* `a = "11"`
* `b = "1"`

#### Output

* `"100"`

### Example 2

#### Input

* `a = "1010"`
* `b = "1011"`

#### Output

* `"10101"`

## Constraints

* `1 <= a.length, b.length <= 10^4`
* `a` and `b` consist only of `'0'` or `'1'` characters.
* Each string does not contain leading zeros except for the zero itself.
### Time Complexity

The time complexity for this algorithm is O(max(m, n)) where m and n are the lengths of strings a and b respectively. This is because the algorithm iterates from right to left and performs a constant amount of work for each bit in the strings. The maximum number of iterations is determined by the length of the longest string.

### Space Complexity

The space complexity for this algorithm is O(max(m, n)) where m and n are the lengths of strings a and b respectively. This is because the algorithm uses a StringBuilder to store the result, and the maximum length of the result string is the length of the longest string.
