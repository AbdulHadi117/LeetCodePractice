# Ugly Number II

An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

## Examples

- **Example 1**

  - **Input:** n = 10  
  - **Output:** 12  
  - **Explanation:** [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

- **Example 2**

  - **Input:** n = 1  
  - **Output:** 1  
  - **Explanation:** 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

## Constraints

- 1 <= n <= 1690

## Complexity Analysis

- **Time Complexity**: O(n)
  - The algorithm calculates each ugly number from 1 to n using a dynamic programming approach. It iterates over the range from 1 to n, performing constant-time operations within each iteration. Thus, the overall time complexity is O(n).

- **Space Complexity**: O(n)
  - The algorithm uses an array `dp` of size `n` to store the computed ugly numbers. This additional space requirement results in a space complexity of O(n).

