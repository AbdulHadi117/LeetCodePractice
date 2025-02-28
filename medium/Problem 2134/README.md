# Minimum Swaps to Group All 1's Together
A swap is defined as taking two distinct positions in an array and swapping the values in them.

A circular array is defined as an array where we consider the first element and the last element to be adjacent.

Given a binary circular array `nums`, return the minimum number of swaps required to group all 1's present in the array together at any location.

## Examples
### Example 1
Input: `nums = [0,1,0,1,1,0,0]`
Output: `1`
Explanation:
*   Here are a few of the ways to group all the 1's together:
    *   `[0,0,1,1,1,0,0]` using 1 swap.
    *   `[0,1,1,1,0,0,0]` using 1 swap.
    *   `[1,1,0,0,0,0,1]` using 2 swaps (using the circular property of the array).
*   There is no way to group all 1's together with 0 swaps.
*   Thus, the minimum number of swaps required is `1`.

### Example 2
Input: `nums = [0,1,1,1,0,0,1,1,0]`
Output: `2`
Explanation:
*   Here are a few of the ways to group all the 1's together:
    *   `[1,1,1,0,0,0,0,1,1]` using 2 swaps (using the circular property of the array).
    *   `[1,1,1,1,1,0,0,0,0]` using 2 swaps.
*   There is no way to group all 1's together with 0 or 1 swaps.
*   Thus, the minimum number of swaps required is `2`.

### Example 3
Input: `nums = [1,1,0,0,1]`
Output: `0`
Explanation:
*   All the 1's are already grouped together due to the circular property of the array.
*   Thus, the minimum number of swaps required is `0`.

## Time Complexity Analysis

The time complexity of the algorithm is `O(n)`. This is because the algorithm iterates through the array twice. The first iteration is to count the number of 1's and the second iteration is to slide the window to find the maximum group of 1's. The number of operations performed is proportional to the size of the input array.

## Space Complexity Analysis

The space complexity of the algorithm is `O(1)`. This is because the algorithm only requires a fixed amount of additional memory, regardless of the size of the input array. It uses a few variables such as `countOfOnes`, `initialWindow`, and `maxWindow` to store intermediate values during execution. These variables do not depend on the size of the input array and remain constant in size, resulting in a constant space complexity.
