# Problem 69. Sqrt(x)

## Description

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

### Constraints

* 0 <= x <= 2^31 - 1

### Examples

* Example 1:
	+ Input: x = 4
	+ Output: 2
	+ Explanation: The square root of 4 is 2, so we return 2.
* Example 2:
	+ Input: x = 8
	+ Output: 2
	+ Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

## Rules:

* You must not use any built-in exponent function or operator.
* For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

### Time Complexity Analysis
The time complexity of the binary search algorithm is O(log n), where n is the given input number. This is because the algorithm divides the search space in half with each iteration, until the target is found. The number of iterations performed is proportional to the logarithm of the input size.

### Space Complexity Analysis
The space complexity of the binary search algorithm is O(1), as the algorithm only uses a constant amount of additional space to store the two pointers, start and end. The space required does not change with the size of the input.
