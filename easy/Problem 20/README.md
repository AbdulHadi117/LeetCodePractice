# Valid Parentheses

Given a string `s` containing just the characters `'(', ')', '{', '}', '[' and ']',` determine if the input string is valid.

## Definition of a valid string

A string is valid if:

* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.

## Examples

### Example 1

* Input: `s = "()"`
* Output: `true`

### Example 2

* Input: `s = "()[]{}"`
* Output: `true`

### Example 3

* Input: `s = "(]"`
* Output: `false`

### Example 4

* Input: `s = "([])"`
* Output: `true`

## Constraints

* `1 <= s.length <= 104`
* `s` consists of parentheses only `'()[]{}'`.

## Algorithmic Analysis

### Time Complexity Analysis
The time complexity of the `isValid` method is O(n), where n is the length of the string. This is because the algorithm iterates over the string once, and each operation (pushing to the stack and popping from the stack) is a constant time operation.

### Space Complexity Analysis
The space complexity of the `isValid` method is O(n), where n is the length of the string. This is because in the worst case, every character in the string is pushed to the stack, resulting in a space complexity of O(n).
