# Remove Duplicates from Sorted Array

## Problem Statement
Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

- Consider the number of unique elements of `nums` to be `k`.
- Change the array `nums` such that the first `k` elements contain the unique elements in the order they were initially present.
- The remaining elements are not important, as well as the size of `nums`.

## Custom Judge
The judge will test your solution with the following code:

```java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```
If all assertions pass, then your solution will be accepted.

## Examples

### Example 1
- **Input:** `nums = [1,1,2]`
- **Output:** `2, nums = [1,2,_]`
- **Explanation:** Your function should return `k = 2`, with the first two elements of `nums` being `1` and `2` respectively. It does not matter what you leave beyond the returned `k` (hence they are underscores).

### Example 2
- **Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`
- **Output:** `5, nums = [0,1,2,3,4,_,_,_,_,_]`
- **Explanation:** Your function should return `k = 5`, with the first five elements of `nums` being `0`, `1`, `2`, `3`, and `4` respectively. It does not matter what you leave beyond the returned `k` (hence they are underscores).

## Constraints
- `1 <= nums.length <= 3 * 10^4`
- `-100 <= nums[i] <= 100`
- `nums` is sorted in non-decreasing order.

## Algorithmic Analysis

### Time Complexity Analysis
The time complexity of the algorithm is O(n), where n is the length of the given array of integers. This is because the algorithm iterates over the array once, using two pointers, i and j, to traverse the array. The number of operations performed is proportional to the length of the array.

### Space Complexity Analysis
The space complexity of the algorithm is O(1), as the algorithm only uses a constant amount of space to store the two pointers, i and j. The space required does not change with the size of the input.
