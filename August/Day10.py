# Definition for singly-linked list node.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Function to add two numbers represented by linked lists.
def add_two_numbers(l1, l2):
    return add_two_numbers_helper(l1, l2, 0)

# Helper function to perform the addition with carry.
def add_two_numbers_helper(l1, l2, carry):
    if l1 is None and l2 is None and carry == 0:
        return None

    val1 = l1.val if l1 else 0
    val2 = l2.val if l2 else 0
    total_sum = val1 + val2 + carry
    carry = total_sum // 10

    return ListNode(total_sum % 10, add_two_numbers_helper(l1.next if l1 else None, l2.next if l2 else None, carry))

# Helper function to create a linked list from a list of numbers.
def create_linked_list(numbers):
    dummy = ListNode()
    current = dummy
    for number in numbers:
        current.next = ListNode(number)
        current = current.next
    return dummy.next

# Helper function to print the linked list.
def print_linked_list(node):
    while node:
        print(node.val, end=" -> " if node.next else "\n")
        node = node.next

# Example usage:
# Representing the numbers 342 (2 -> 4 -> 3) and 465 (5 -> 6 -> 4)
l1 = create_linked_list([2, 4, 3])
l2 = create_linked_list([5, 6, 4])

# Adding the two numbers
result = add_two_numbers(l1, l2)

# Print the resulting linked list (7 -> 0 -> 8 represents the number 807)
print_linked_list(result)
