# Median of Two Sorted Arrays

Given two sorted arrays `array1` and `array2` of size `m` and `n` respectively, return the median of the two sorted arrays.

## Examples

### Example 1

*   Input: `array1 = [1,3]` , `array2 = [2]`
*   Output: `2.00000`
*   Explanation: merged array = `[1,2,3]` and median is `2`.

### Example 2

*   Input: `array1 = [1,2]` , `array2 = [3,4]`
*   Output: `2.50000`
*   Explanation: merged array = `[1,2,3,4]` and median is `(2 + 3) / 2 = 2.5`.

## Constraints

*   `array1.length == m`
*   `array2.length == n`
*   `0 <= m <= 1000`
*   `0 <= n <= 1000`
*   `1 <= m + n <= 2000`
*   `-10^6 <= array1[i], array2[i] <= 10^6`

## Time Complexity

The time complexity of this algorithm is O(n + m), where n is the length of array1 and m is the length of array2. This is because the algorithm iterates through each element of both arrays once.

## Space Complexity

The space complexity of this algorithm is O(n + m), where n is the length of array1 and m is the length of array2. This is because the algorithm creates a new merged array of size n + m.

