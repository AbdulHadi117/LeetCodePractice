# Problem 1460: Make Two Arrays Equal by Reversing Sub-arrays

## Overview

You are given two integer arrays of equal length `target` and `arr`. In one step, you can select any non-empty subarray of `arr` and reverse it. You are allowed to make any number of steps.

Return `true` if you can make `arr` equal to `target` or `false` otherwise.

## Examples

### Example 1

Input: `target = [1,2,3,4], arr = [2,4,1,3]`
Output: `true`
Explanation: You can follow the next steps to convert `arr` to `target`:

- Reverse subarray `[2,4,1]`, `arr` becomes `[1,4,2,3]`
- Reverse subarray `[4,2]`, `arr` becomes `[1,2,4,3]`
- Reverse subarray `[4,3]`, `arr` becomes `[1,2,3,4]`
There are multiple ways to convert `arr` to `target`, this is not the only way to do so.

### Example 2

Input: `target = [7], arr = [7]`
Output: `true`
Explanation: `arr` is equal to `target` without any reverses.

### Example 3

Input: `target = [3,7,9], arr = [3,7,11]`
Output: `false`
Explanation: `arr` does not have value `9` and it can never be converted to `target`.

## Constraints

* `target.length == arr.length`
* `1 <= target.length <= 1000`
* `1 <= target[i] <= 1000`
* `1 <= arr[i] <= 1000`

## Algorithmic Complexity

### Time Complexity
The algorithm iterates over the elements of the two arrays once, and performs a constant amount of work for each element. The time complexity of the algorithm is O(n), where n is the length of the input arrays.

### Space Complexity
The algorithm uses an array of size m+1 to store the counts of the elements, and the size of this array is proportional to the maximum value in the input arrays. The space complexity of the algorithm is O(m), where m is the maximum value in the input arrays.