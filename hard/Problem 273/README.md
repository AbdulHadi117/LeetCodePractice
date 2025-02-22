# Integer to English Words

Convert a non-negative integer `num` to its English words representation.

## Example 1

Input: `num = 123`
Output: `"One Hundred Twenty Three"`

## Example 2

Input: `num = 12345`
Output: `"Twelve Thousand Three Hundred Forty Five"`

## Example 3

Input: `num = 1234567`
Output: `"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"`

## Constraints

* `0 <= num <= 2^31 - 1`


## Time Complexity
The time complexity of the function is `O(log N)`. The function recursively breaks down the number by dividing it by powers of 10 (billions, millions, thousands, hundreds), making the number of recursive calls proportional to the number of digits in the input number. Since each recursive call operates on a reduced number of digits, the function's complexity can be described as logarithmic in terms of the number of digits.

## Space Complexity
The space complexity of the function is `O(1)` in terms of auxiliary space used, since it uses a constant amount of space for storing the words arrays and a small number of additional variables. However, the recursive approach means that there is a call stack usage proportional to the number of recursive calls, which in the worst case (for very large numbers) could be `O(log N)`.

