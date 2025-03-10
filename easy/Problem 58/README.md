# Length of Last Word

## Problem Statement

Given a string `s` consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

## Examples

### Example 1

* Input: `s = "Hello World"`
* Output: `5`
* Explanation: The last word is "World" with length 5.

### Example 2

* Input: `s = "   fly me   to   the moon  "`
* Output: `4`
* Explanation: The last word is "moon" with length 4.

### Example 3

* Input: `s = "luffy is still joyboy"`
* Output: `6`
* Explanation: The last word is "joyboy" with length 6.

## Constraints

* `1 <= s.length <= 10^4`
* `s` consists of only English letters and spaces `' '`.
* There will be at least one word in `s`.

## Time Complexity Analysis

The time complexity of the algorithm is O(n), where n is the length of the input string `s`. This is because the algorithm iterates over the string once, splitting it into words using the `split` method, and then accessing the last word in the resulting array. The time complexity of the `split` method is O(n), where n is the length of the string, and the time complexity of accessing the last element in the array is O(1). Therefore, the overall time complexity of the algorithm is O(n).

## Space Complexity Analysis

The space complexity of the algorithm is O(n), where n is the length of the input string `s`. This is because the algorithm creates a new array of strings, of size equal to the number of words in the input string, to store the words split from the input string. The space used by this array is proportional to the length of the input string. Therefore, the overall space complexity of the algorithm is O(n).
