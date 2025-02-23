# Longest Substring Without Repeating Characters

Given a string s, find the length of the longest  **substring**  without duplicate characters.

## Examples

* **Example 1**
	+ Input: s = "abcabcbb"
	+ Output: 3
	+ Explanation: The answer is "abc", with the length of 3.
* **Example 2**
	+ Input: s = "bbbbb"
	+ Output: 1
	+ Explanation: The answer is "b", with the length of 1.
* **Example 3**
	+ Input: s = "pwwkew"
	+ Output: 3
	+ Explanation: The answer is "wke", with the length of 3.
	+ Notice that the answer must be a **substring**, "pwke" is a **subsequence** and not a **substring**.

## Constraints

* 0 <= s.length <= 5 \* 10^4
* s consists of English letters, digits, symbols and spaces.

## Time Complexity

The time complexity of the function is O(n), where n is the length of the string. The function iterates over the string once, using two pointers, start and end, to traverse the string. In the worst case, all characters in the string are unique, and the function has to iterate over the entire string, resulting in a time complexity of O(n).

## Space Complexity

The space complexity of the function is O(min(n, m)), where n is the length of the string and m is the size of the character set. The function uses a set to store the characters in the current window, which has a maximum size of m. In the worst case, the size of the set is equal to the length of the string, resulting in a space complexity of O(n).

