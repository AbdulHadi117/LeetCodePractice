# Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

## Symbol Values

* I: 1
* V: 5
* X: 10
* L: 50
* C: 100
* D: 500
* M: 1000

## Writing Roman Numerals

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.

## Subtraction in Roman Numerals

There are six instances where subtraction is used:

* I can be placed before V (5) and X (10) to make 4 and 9.
* X can be placed before L (50) and C (100) to make 40 and 90.
* C can be placed before D (500) and M (1000) to make 400 and 900.

## Task

Given a roman numeral, convert it to an integer.

### Examples

* Input: s = "III"
Output: 3
Explanation: III = 3.

* Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

* Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

### Constraints

* 1 <= s.length <= 15
* s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
* It is guaranteed that s is a valid roman numeral in the range [1, 3999].


### Space and Time Complexity Analysis

#### Time Complexity

The time complexity of this algorithm is O(n) as it needs to traverse the string once to calculate the integer value.

#### Space Complexity

The space complexity of this algorithm is O(1) as it needs a constant amount of additional space to store the hashmap of values and the result. The space used is independent of the input size.
