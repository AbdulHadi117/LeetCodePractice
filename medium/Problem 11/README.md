# Container With Most Water

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

## Examples

### Example 1
![alt text](image.png)

Input: `height = [1,8,6,2,5,4,8,3,7]`

Output: `49`

Explanation: The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`. In this case, the max area of water (blue section) the container can contain is `49`.

### Example 2

Input: `height = [1,1]`

Output: `1`

## Constraints

- `n == height.length`
- `2 <= n <= 105`
- `0 <= height[i] <= 104`

## Time Complexity

The time complexity of the `maxArea` function is O(n), where n is the length of the input array `height`. This is because the algorithm uses a two-pointer approach, with each pointer moving across the array only once, resulting in a single pass through the array.

## Space Complexity

The space complexity of the `maxArea` function is O(1) because it uses a constant amount of extra space. The only additional space used is for a few integer variables (`maxArea`, `leftIndex`, `rightIndex`, `length`, `width`, and `area`), which do not depend on the size of the input array.

