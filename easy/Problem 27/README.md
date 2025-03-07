# Remove Element from Array

## Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The order of the elements may change. Return the number of elements in `nums` that are not equal to `val`.

- Let `k` be the number of elements in `nums` which are not equal to `val`.
- Modify the array `nums` such that the first `k` elements contain the elements which are not equal to `val`.
- The remaining elements in `nums` are not important, as well as the size of `nums`.
- Return `k`.

## Custom Judge

The judge will test your solution using the following code:

```java
int[] nums = [...]; // Input array
int val = ...;      // Value to remove
int[] expectedNums = [...]; // Expected answer with correct length, sorted, and no values equaling `val`.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
```

If all assertions pass, your solution will be accepted.

## Examples

- **Example 1:**

  - **Input:** `nums = [3,2,2,3]`, `val = 3`
  - **Output:** `2, nums = [2,2,_,_]`
  - **Explanation:** Your function should return `k = 2`, with the first two elements of `nums` being `2`. The elements beyond `k` are not important.

- **Example 2:**

  - **Input:** `nums = [0,1,2,2,3,0,4,2]`, `val = 2`
  - **Output:** `5, nums = [0,1,4,0,3,_,_,_]`
  - **Explanation:** Your function should return `k = 5`, with the first five elements of `nums` containing `0, 0, 1, 3,` and `4`. The order of these five elements can vary.

## Constraints

- `0 <= nums.length <= 100`
- `0 <= nums[i] <= 50`
- `0 <= val <= 100`

## Algorithmic Analysis

### Time Complexity Analysis
The time complexity of the `removeElement` function is O(n), where n is the length of the input array `nums`. This is because the algorithm iterates over each element of the array exactly once. For each element, it performs a constant amount of work (comparison and possibly an assignment), making the time complexity proportional to the number of elements in the array.

### Space Complexity Analysis
The space complexity of the algorithm is O(1), as it does not use any additional data structures that grow with the size of the input. The algorithm modifies the input array in place and uses only a fixed number of additional variables (`k` and `i`), resulting in a constant space requirement regardless of the size of the array.

