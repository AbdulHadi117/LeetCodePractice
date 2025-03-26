# Lemonade Change

## Overview
- **Scenario**: Customers in a queue at a lemonade stand, each paying with $5, $10, or $20 bills.
- **Objective**: Provide the correct change for each transaction.

## Key Points
- **Lemonade Price**: $5
- **Initial Condition**: No change in hand initially.

## Problem Statement
- **Input**: Integer array `bills` where `bills[i]` is the bill paid by the ith customer.
- **Output**: `true` if correct change can be provided to all customers, otherwise `false`.

## Examples

### Example 1
- **Input**: `bills = [5,5,5,10,20]`
- **Output**: `true`
- **Explanation**:
  - Collect $5 bills from first 3 customers.
  - For the 4th customer, collect $10 and give back $5.
  - For the 5th customer, give $10 and $5 as change.

### Example 2
- **Input**: `bills = [5,5,10,10,20]`
- **Output**: `false`
- **Explanation**:
  - Collect $5 bills from the first 2 customers.
  - For the next 2 customers, collect $10 and give back $5.
  - Cannot give $15 change to the last customer.

## Constraints
- `1 <= bills.length <= 105`
- `bills[i]` can be either 5, 10, or 20.

### Algorithmic Analysis

#### Time Complexity

The time complexity of the algorithm is O(n). This is because the algorithm uses a single loop to process each element of the `bills` array exactly once. Within the loop, the operations performed (such as updating counters and checking conditions) are all executed in constant time, regardless of the size of the input. Thus, the overall time complexity is directly proportional to the number of elements in the input array, `n`.

#### Space Complexity

The space complexity of the algorithm is O(1). This is because the algorithm only requires a fixed amount of additional memory, regardless of the size of the input array. The space used is for a few integer variables (`five` and `ten`), and this does not change with the size of the input array.
