# Find Complement of an Integer
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

### Examples

#### Example 1

* Input: `num = 5`
* Output: `2`
* Explanation: The binary representation of `5` is `101` (no leading zero bits), and its complement is `010`. So you need to output `2`.

#### Example 2

* Input: `num = 1`
* Output: `0`
* Explanation: The binary representation of `1` is `1` (no leading zero bits), and its complement is `0`. So you need to output `0`.

### Constraints

* `1 <= num < 2^31`

### Time and Space Complexity

#### Time Complexity

The time complexity of this algorithm is O(log n) as it needs to traverse the bits of the input number once.

#### Space Complexity

The space complexity of this algorithm is O(log n) as the space required to store the binary representation of the input number is proportional to the number of bits in the number.

