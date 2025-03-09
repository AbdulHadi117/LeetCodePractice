# Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

## Examples

- **Example 1:**
  - **Input:** `nums = [1,3,5,6]`, `target = 5`
  - **Output:** `2`

- **Example 2:**
  - **Input:** `nums = [1,3,5,6]`, `target = 2`
  - **Output:** `1`

- **Example 3:**
  - **Input:** `nums = [1,3,5,6]`, `target = 7`
  - **Output:** `4`

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` contains distinct values sorted in ascending order.
- `-10^4 <= target <= 10^4`

## Algorithmic Analysis

### Time Complexity Analysis
The time complexity of the algorithm is O(log n), where n is the length of the given array of integers. This is because the algorithm uses binary search to traverse the array, dividing the search space in half with each iteration. The number of operations performed is proportional to the logarithm of the length of the array.

### Space Complexity Analysis
The space complexity of the algorithm is O(1), as the algorithm only uses a constant amount of space to store the two pointers, left and right. The space required does not change with the size of the input.
