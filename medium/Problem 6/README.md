# Zigzag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

- `P`   `A`   `H`   `N`
- `A P L S I I G`
- `Y`   `I`   `R`

And then read line by line: `"PAHNAPLSIIGYIR"`

## Examples

### Example 1

- Input: s = "PAYPALISHIRING", numRows = 3
- Output: "PAHNAPLSIIGYIR"

### Example 2

- Input: s = "PAYPALISHIRING", numRows = 4
- Output: "PINALSIGYAHRPI"

## Explanation

- `P`     `I`    `N`
- `A`   `L S`  `I G`
- `Y A`   `H R`
- `P`     `I`

## Constraints

- 1 <= s.length <= 1000
- s consists of English letters (lower-case and upper-case), ',' and '.'.
- 1 <= numRows <= 1000

## Complexity Analysis

### Time Complexity

The time complexity of the `convert` function is O(n), where n is the length of the input string `s`. This is because the function iterates through each character of the string exactly once to distribute them into the respective rows. The subsequent combination of rows into a single string also takes O(n) time, as it involves concatenating each row string. Therefore, the overall time complexity is O(n).

### Space Complexity

The space complexity of the `convert` function is O(n). This is due to the additional storage needed for the `rows` array, which stores the characters for each row of the zigzag pattern. Each character in the input string `s` is stored in one of the rows, resulting in a total space requirement proportional to the length of `s`. Therefore, the overall space complexity is O(n).

