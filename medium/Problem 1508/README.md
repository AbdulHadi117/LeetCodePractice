# Range Sum of Sorted Subarray sums

## Description

You are given the array `nums` consisting of `n` positive integers. You computed the sum of all non-empty continuous subarrays from the array and then sorted them in non-decreasing order, creating a new array of `n * (n + 1) / 2` numbers.

Return the sum of the numbers from index `left` to index `right` (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo `10^9 + 7`.

## Examples

### Example 1

* Input: `nums = [1,2,3,4], n = 4, left = 1, right = 5`
* Output: `13`
* Explanation: All subarray sums are `1, 3, 6, 10, 2, 5, 9, 3, 7, 4`. After sorting them in non-decreasing order we have the new array `[1, 2, 3, 3, 4, 5, 6, 7, 9, 10]`. The sum of the numbers from index `le = 1` to `ri = 5` is `1 + 2 + 3 + 3 + 4 = 13`.

### Example 2

* Input: `nums = [1,2,3,4], n = 4, left = 3, right = 4`
* Output: `6`
* Explanation: The given array is the same as example 1. We have the new array `[1, 2, 3, 3, 4, 5, 6, 7, 9, 10]`. The sum of the numbers from index `le = 3` to `ri = 4` is `3 + 3 = 6`.

### Example 3

* Input: `nums = [1,2,3,4], n = 4, left = 1, right = 10`
* Output: `50`
* Explanation: The given array is the same as example 1. We have the new array `[1, 2, 3, 3, 4, 5, 6, 7, 9, 10]`. The sum of the numbers from index `le = 1` to `ri = 10` is `1 + 2 + 3 + 3 + 4 + 5 + 6 + 7 + 9 + 10 = 50`.

## Constraints

* `n == nums.length`
* `1 <= nums.length <= 1000`
* `1 <= nums[i] <= 100`
* `1 <= left <= right <= n * (n + 1) / 2`

## Time Complexity

The time complexity of the `rangeSum` function can be broken down into several components:

1. **Computing all possible subarray sums**: This involves iterating over the array to compute sums for all subarrays. The outer loop runs `n` times (where `n` is the length of the input array), and the inner loop runs up to `n` times in the worst case, resulting in `O(n^2)` time complexity for this step.

2. **Sorting the subarray sums**: Sorting the array of subarray sums has a time complexity of `O(m log m)`, where `m` is the number of subarray sums. Since `m` is `n * (n + 1) / 2`, this step has a time complexity of `O((n^2) log (n^2))`, which simplifies to `O(n^2 log n)`.

3. **Computing the sum of the subarray sums in the given range**: This involves iterating over the range `[leftIndex, rightIndex]` and has a time complexity of `O(k)`, where `k` is the range size. In the worst case, `k` can be `O(n^2)`.

Overall, the dominant factor is the sorting step, so the time complexity of the function is `O(n^2 log n)`.

## Space Complexity

The space complexity of the `rangeSum` function is determined by the storage required for the subarray sums:

1. **Subarray sums array**: The function creates an array to store all possible subarray sums. The size of this array is `m = n * (n + 1) / 2`, which is `O(n^2)`.

2. **Additional variables**: The function uses a few additional integer variables (`currentSum`, `sum`, `k`, etc.), which require `O(1)` space.

Overall, the space complexity of the function is `O(n^2)` due to the storage needed for the subarray sums array.

