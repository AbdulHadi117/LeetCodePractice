# Crawler Log Folder

The Leetcode file system keeps a log each time a user performs a change folder operation. The operations are described as follows:

- `"../"`: Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
- `"./"`: Remain in the same folder.
- `"x/"`: Move to the child folder named `x` (This folder is guaranteed to always exist).

You are given a list of strings `logs` where `logs[i]` is the operation performed by the user at the `i-th` step.

The file system starts in the main folder, then the operations in `logs` are performed.

**Objective**: Return the minimum number of operations needed to go back to the main folder after the change folder operations.

## Examples

### Example 1

- **Input**: `logs = ["d1/","d2/","../","d21/","./"]`
- **Output**: `2`
- **Explanation**: Use the change folder operation `"../"` 2 times to go back to the main folder.

### Example 2

- **Input**: `logs = ["d1/","d2/","./","d3/","../","d31/"]`
- **Output**: `3`

### Example 3

- **Input**: `logs = ["d1/","../","../","../"]`
- **Output**: `0`

## Constraints

- `1 <= logs.length <= 103`
- `2 <= logs[i].length <= 10`
- `logs[i]` contains lowercase English letters, digits, '.', and '/'.
- `logs[i]` follows the format described in the statement.
- Folder names consist of lowercase English letters and digits.

## Complexity Analysis

- **Time Complexity**: The time complexity of the solution is `O(n)`, where `n` is the number of elements in the `logs` array. This is because the solution requires a single pass through the array, and the operations performed inside the loop take constant time.

- **Space Complexity**: The space complexity of the solution is `O(1)`, as it only uses a single integer variable to keep track of the level, and does not use any additional space that scales with the input size.

