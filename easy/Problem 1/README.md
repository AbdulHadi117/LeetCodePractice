# Two Sum

## Description

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

## Examples

### Example 1

Input: `nums = [2,7,11,15]`, `target = 9`
Output: `[0,1]`
Explanation: Because `nums[0] + nums[1] == 9`, we return `[0, 1]`.

### Example 2

Input: `nums = [3,2,4]`, `target = 6`
Output: `[1,2]`

### Example 3

Input: `nums = [3,3]`, `target = 6`
Output: `[0,1]`

## Constraints

* `2 <= nums.length <= 10^4`
* `-10^9 <= nums[i] <= 10^9`
* `-10^9 <= target <= 10^9`
* Only one valid answer exists.

## Analysis

### Time Complexity

The time complexity of the algorithm is `O(n^2)`, where `n` is the number of elements in the array. This is because the algorithm has a nested loop structure, where the outer loop iterates over each element in the array and the inner loop iterates over the elements from the current position to the end of the array. The number of operations performed is proportional to the square of the number of elements in the array.

### Space Complexity

The space complexity of the algorithm is `O(1)`, since the algorithm only uses a constant amount of space to store the result array and the loop variables. The space required does not change with the size of the input.
