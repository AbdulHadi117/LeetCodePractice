# Plus One

## Problem Description

You are given a large integer represented as an integer array `digits`, where each `digits[i]` is the i-th digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

The task is to increment the large integer by one and return the resulting array of digits.

## Examples

- **Example 1:**
  - **Input:** `digits = [1,2,3]`
  - **Output:** `[1,2,4]`
  - **Explanation:** The array represents the integer 123. Incrementing by one gives 123 + 1 = 124. Thus, the result should be `[1,2,4]`.

- **Example 2:**
  - **Input:** `digits = [4,3,2,1]`
  - **Output:** `[4,3,2,2]`
  - **Explanation:** The array represents the integer 4321. Incrementing by one gives 4321 + 1 = 4322. Thus, the result should be `[4,3,2,2]`.

- **Example 3:**
  - **Input:** `digits = [9]`
  - **Output:** `[1,0]`
  - **Explanation:** The array represents the integer 9. Incrementing by one gives 9 + 1 = 10. Thus, the result should be `[1,0]`.

## Constraints

- `1 <= digits.length <= 100`
- `0 <= digits[i] <= 9`
- `digits` does not contain any leading 0's.

## Complexity Analysis

### Time Complexity

The time complexity of the `plusOne` method is O(n), where n is the length of the input array `digits`. In the worst case, we might need to iterate through all the digits (such as when the input is `[9, 9, 9]`), which involves a single pass over the array.

### Space Complexity

The space complexity of the `plusOne` method is O(1) for in-place operations. However, in the case where all digits are 9 (e.g., `[9, 9, 9]`), a new array of size `n + 1` is created to accommodate the carry, which results in an O(n) space complexity.

