# Kth Largest Element in a Stream

You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.

## Problem Description

Implement a class that maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. Specifically, we are looking for the kth highest score in the sorted list of all scores.

## Class Definition

### KthLargest

- **Constructor**: `KthLargest(int k, int[] nums)`
  - Initializes the object with the integer `k` and the stream of test scores `nums`.

- **Method**: `int add(int val)`
  - Adds a new test score `val` to the stream.
  - Returns the element representing the kth largest element in the pool of test scores so far.

## Examples

### Example 1

- **Input**:
  ```
  ["KthLargest", "add", "add", "add", "add", "add"]
  [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
  ```

- **Output**:
  ```
  [null, 4, 5, 5, 8, 8]
  ```

- **Explanation**:
  ```
  KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
  kthLargest.add(3); // returns 4
  kthLargest.add(5); // returns 5
  kthLargest.add(10); // returns 5
  kthLargest.add(9); // returns 8
  kthLargest.add(4); // returns 8
  ```

### Example 2

- **Input**:
  ```
  ["KthLargest", "add", "add", "add", "add"]
  [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
  ```

- **Output**:
  ```
  [null, 7, 7, 7, 8]
  ```

- **Explanation**:
  ```
  KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
  kthLargest.add(2); // returns 7
  kthLargest.add(10); // returns 7
  kthLargest.add(9); // returns 7
  kthLargest.add(9); // returns 8
  ```

## Constraints

- `0 <= nums.length <= 10^4`
- `1 <= k <= nums.length + 1`
- `-10^4 <= nums[i] <= 10^4`
- `-10^4 <= val <= 10^4`
- At most `10^4` calls will be made to `add`.

## Time Complexity Analysis

The time complexity of the `KthLargest` class operations is primarily determined by the operations on the priority queue (min-heap). 

1. **Constructor (`KthLargest`)**:
   - The constructor initializes the priority queue and iterates over the input array `nums`. For each element, it calls the `add` method.
   - Each call to `add` involves an `offer` operation to add an element to the heap, which takes `O(log k)` time, and potentially a `poll` operation to remove the smallest element, also `O(log k)`.
   - Therefore, if `n` is the length of `nums`, the time complexity of the constructor is `O(n log k)`.

2. **`add` Method**:
   - Each call to `add` involves adding an element to the heap, which is `O(log k)`, and potentially removing the smallest element from the heap, also `O(log k)`.
   - Thus, the time complexity for each call to `add` is `O(log k)`.

Overall, the dominant factor in the time complexity is the heap operations, leading to a time complexity of `O(n log k)` for the construction and `O(log k)` for each `add` operation.

## Space Complexity Analysis

The space complexity of the `KthLargest` class is determined by the space used by the priority queue (min-heap):

1. **Heap Storage**:
   - The priority queue is used to store the `k` largest elements at any time.
   - As a result, the space complexity for the priority queue is `O(k)` since it holds at most `k` elements.

2. **Additional Space**:
   - Apart from the priority queue, the class uses a constant amount of additional space for variables like `k`.

Overall, the space complexity of the `KthLargest` class is `O(k)`, as the space required grows linearly with the size of the priority queue. No additional space is used that depends on the size of the input array `nums`.

