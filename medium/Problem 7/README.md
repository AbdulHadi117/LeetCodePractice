# Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

## Examples

* **Example 1**
	+ Input: x = 123
	+ Output: 321
* **Example 2**
	+ Input: x = -123
	+ Output: -321
* **Example 3**
	+ Input: x = 120
	+ Output: 21

## Constraints

* -231 <= x <= 231 - 1

**Time Complexity:**
The time complexity of the `reverse` method is O(log10(x)). This is because the number of iterations in the while loop is proportional to the number of digits in the number `x`. Each division by 10 reduces the number of digits by one, which means the loop will run a number of times equal to the number of digits in `x`.

**Space Complexity:**
The space complexity of the `reverse` method is O(1). This is because the method uses a constant amount of additional space regardless of the input size. The space used is for a few integer variables (`res` and `x`), and this does not grow with the size of the input number.

