# Excel Sheet Column Title

Given an integer `columnNumber`, return its corresponding column title as it appears in an Excel sheet.

## Examples

### Example 1

* Input: `columnNumber = 1`
* Output: `"A"`

### Example 2

* Input: `columnNumber = 28`
* Output: `"AB"`

### Example 3

* Input: `columnNumber = 701`
* Output: `"ZY"`

## Constraints

* `1 <= columnNumber <= 2^31 - 1`

## Complexity Analysis

### Time Complexity

* The algorithm's time complexity is **O(log n)** because the loop runs approximately `log_26 n` times, where `n` is the input `columnNumber`. This is due to the division by 26 in each iteration, which reduces the size of `columnNumber` exponentially.

### Space Complexity

* The space complexity is **O(1)** since the space used by the algorithm does not depend on the size of the input `columnNumber`. The `StringBuilder` is used for creating the result string but this space is considered constant relative to the input size.

