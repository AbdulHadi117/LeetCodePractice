# Three Consecutive Odds

Given an integer array `arr`, return `true` if there are three consecutive odd numbers in the array. Otherwise, return `false`.

## Examples

**Example 1:**

- **Input:** `arr = [2,6,4,1]`
- **Output:** `false`
- **Explanation:** There are no three consecutive odd numbers.

**Example 2:**

- **Input:** `arr = [1,2,34,3,4,5,7,23,12]`
- **Output:** `true`
- **Explanation:** `[5,7,23]` are three consecutive odd numbers.

## Constraints

- `1 <= arr.length <= 1000`
- `1 <= arr[i] <= 1000`

## Algorithmic Complexity

### Time Complexity

- **O(n):** The algorithm traverses the array once, making the time complexity O(n), where n is the length of the array.

### Space Complexity

- **O(1):** The algorithm uses a constant amount of extra space, therefore the space complexity is O(1).

