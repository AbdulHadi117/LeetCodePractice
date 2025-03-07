# Find Index of First Occurrence in a String

## Description

Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or -1 if `needle` is not part of `haystack`.

## Examples

### Example 1

* Input: `haystack` = "sadbutsad", `needle` = "sad"
* Output: 0
* Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.

### Example 2

* Input: `haystack` = "leetcode", `needle` = "leeto"
* Output: -1
* Explanation: "leeto" did not occur in "leetcode", so we return -1.

## Constraints

* 1 <= `haystack.length`, `needle.length` <= 104
* `haystack` and `needle` consist of only lowercase English characters.

## Time Complexity Analysis

The time complexity of the `strStr` method is primarily determined by the `indexOf` method used within it. The `indexOf` method in Java performs a search for the `needle` string within the `haystack` string. In the worst case, if the `needle` is not present, the method needs to check each substring of length equal to `needle` within `haystack`, resulting in a time complexity of O(m * n), where `m` is the length of the `haystack` and `n` is the length of the `needle`. However, the average time complexity is often closer to O(m + n) due to optimizations in the underlying implementation.

## Space Complexity Analysis

The space complexity of the `strStr` method is O(1) because it uses a constant amount of extra space regardless of the input size. The method does not allocate additional space that scales with the size of the input strings. The primary operation, `indexOf`, operates in-place on the input strings without requiring additional data structures like arrays or lists. This makes the space complexity constant.

