Reverse Words in a String
==========================

Problem Statement
----------------

Given an input string `s`, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

The returned string should only have a single space separating the words. Do not include any extra spaces.

Constraints
------------

* `1 <= s.length <= 10^4`
* `s` contains English letters (upper-case and lower-case), digits, and spaces `' '`.
* There is at least one word in `s`.

Examples
--------

### Example 1

Input: `s = "the sky is blue"`
Output: `"blue is sky the"`

### Example 2

Input: `s = "  hello world  "`
Output: `"world hello"`

### Example 3

Input: `s = "a good   example"`
Output: `"example good a"`

## Analysis

### Time Complexity

The time complexity of the `reverseWords` function is O(n), where n is the length of the input string `s`. The function iterates over the string twice. Once to split the string into words and once to concatenate the words in reverse order. The time complexity of the `split` and `trim` functions is also O(n), so the overall time complexity is O(n).

### Space Complexity

The space complexity of the `reverseWords` function is O(n), where n is the length of the input string `s`. The function stores the words in the `words` array and the result string in the `result` variable. The space used by the words array and the result string grows with the size of the input string. Therefore, the overall space complexity is O(n).
