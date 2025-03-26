# Problem 292 - Nim Game

## Description

You are playing the following Nim Game with your friend:

### Rules

* Initially, there is a heap of stones on the table.
* You and your friend will alternate taking turns, and you go first.
* On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
* The one who removes the last stone is the winner.

## Examples

### Example 1

* Input: n = 4
* Output: false
* Explanation: These are the possible outcomes:
	+ You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
	+ You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
	+ You remove 3 stones. Your friend removes the last stone. Your friend wins.
	In all outcomes, your friend wins.

### Example 2

* Input: n = 1
* Output: true

### Example 3

* Input: n = 2
* Output: true

## Constraints

* 1 <= n <= 231 - 1


## Algorithmic Complexity

### Time Complexity

The time complexity of the `canWinNim` method is O(1), as it only involves a simple modulo operation.

### Space Complexity

The space complexity of the `canWinNim` method is O(1), as it does not use any additional space.
