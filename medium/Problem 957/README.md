# Prison Cells in N Days

There are 8 prison cells in a row and each cell is either occupied or vacant.

## Rules

Each day, whether the cell is occupied or vacant changes according to the following rules:

*   If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
*   Otherwise, it becomes vacant.
*   Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.

## Problem Statement

You are given an integer array `cells` where `cells[i]` == `1` if the ith cell is occupied and `cells[i]` == `0` if the ith cell is vacant, and you are given an integer `n`.

Return the state of the prison after `n` days (i.e., `n` such changes described above).

## Example 1

- Input: `cells` = \[0,1,0,1,1,0,0,1], `n` = 7
- Output: \[0,0,1,1,0,0,0,0]

## Explanation

The following table summarizes the state of the prison on each day:

*   Day 0: \[0, 1, 0, 1, 1, 0, 0, 1]
*   Day 1: \[0, 1, 1, 0, 0, 0, 0, 0]
*   Day 2: \[0, 0, 0, 0, 1, 1, 1, 0]
*   Day 3: \[0, 1, 1, 0, 0, 1, 0, 0]
*   Day 4: \[0, 0, 0, 0, 0, 1, 0, 0]
*   Day 5: \[0, 1, 1, 1, 0, 1, 0, 0]
*   Day 6: \[0, 0, 1, 0, 1, 1, 0, 0]
*   Day 7: \[0, 0, 1, 1, 0, 0, 0, 0]

## Constraints

*   `cells.length` == 8
*   `cells[i]` is either 0 or 1.
*   1 <= `n` <= 10^9

### Time Complexity

The time complexity of the `prisonAfterNDays` function is O(min(n, 2^c)), where `n` is the number of days and `c` is the length of the `cells` array (which is 8 in this problem). 

- The worst-case scenario occurs when there is no cycle in the states, and we iterate for `n` days. Each day involves calling the `nextDay` function, which has a time complexity of O(c) because it processes each cell once.
- The cycle detection involves converting the state to a string using `stateToString`, which also takes O(c) time.
- However, because there are only 2^c possible states and once a cycle is detected, we only iterate through the remaining days modulo the cycle length, the number of iterations is limited to at most 2^c before detecting a cycle.

### Space Complexity

The space complexity of the algorithm is O(2^c) due to the `seen` map, which can store up to 2^c different states of the prison. Each state is stored as a string, which takes O(c) space. The `currentState` and `nextDay` arrays each take O(c) space as well.

