## Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

- If there is no common prefix, return an empty string `""`.

### Examples

- **Example 1:**

  - **Input:** `strs = ["flower","flow","flight"]`
  - **Output:** `"fl"`

- **Example 2:**

  - **Input:** `strs = ["dog","racecar","car"]`
  - **Output:** `""`
  - **Explanation:** There is no common prefix among the input strings.

### Constraints

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` consists of only lowercase English letters if it is non-empty.

### Time Complexity Analysis
O(n*m) where n is the length of the array and m is the length of the longest string in the array. This is because in the worst case, the algorithm iterates over every string in the array and every character in the string.

### Space Complexity Analysis
O(1) as the space required does not change with the size of the input. The space required is constant and is used to store the longest common prefix string.
