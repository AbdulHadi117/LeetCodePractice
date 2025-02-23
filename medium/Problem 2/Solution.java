
public class Solution {

    // Definition for singly-linked list.
    public static class ListNode {

        int val; // The value of the node.
        ListNode next; // The next node in the list.

        // Constructor for the node.
        public ListNode() {
        }

        /*
         * Constructor for a node with a value.
         @ param val the value of the node
         */
        ListNode(int val) {
            this.val = val;
        }

        /*
         * Constructor for a node with a value and a next node.
         @ param val the value of the node
         @ param next the next node in the list
         */
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
     * Adds two numbers represented by linked lists.
     @ param l1 the first number represented by a linked list
     @ param l2 the second number represented by a linked list
     @ return the sum of the two numbers represented by a linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a new linked list to store the sum
        ListNode result = new ListNode(0);
        ListNode current = result;

        // Carry the remainder
        int carry = 0;

        // Iterate through the two lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of the two nodes
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;

            // Add the two values and the carry
            int sum = val1 + val2 + carry;

            // Update the carry
            carry = sum / 10;

            // Add the new node to the result list
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next node in the two lists
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        // Return the next node in the result list
        return result.next;
    }
}
