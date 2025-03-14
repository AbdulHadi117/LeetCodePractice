Climbing Stairs
===============

You are climbing a staircase. It takes `n` steps to reach the top.

Each time you can either climb **1** or **2** steps. In how many distinct ways can you climb to the top?

### Example 1

* Input: `n = 2`
* Output: `2`
* Explanation: There are two ways to climb to the top.
	+ **1 step + 1 step**
	+ **2 steps**

### Example 2

* Input: `n = 3`
* Output: `3`
* Explanation: There are three ways to climb to the top.
	+ **1 step + 1 step + 1 step**
	+ **1 step + 2 steps**
	+ **2 steps + 1 step**

### Constraints

* `1 <= n <= 45`

### Complexity Analysis

#### Time Complexity

The time complexity of the algorithm is O(n) because it needs to traverse the range from 2 to n to calculate the number of distinct ways to climb the staircase. Each iteration performs constant-time operations, so the overall time complexity is linear.

#### Space Complexity

The space complexity of the algorithm is O(1) because the space required does not change with the size of the input. The algorithm uses a constant amount of space to store the variables `prev1`, `prev2`, and `curr`, which are used to store the number of distinct ways to climb the staircase.
