
import java.util.PriorityQueue;

final class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    /*
     * Constructor for the KthLargest class
     * 
     @ param k the kth largest element to be tracked
     @ param nums the array of numbers to be added to the data structure
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    /**
     * Adds a new element to the data structure and updates the kth largest
     * element
     *
     * @param val the new element to be added
     * @return the kth largest element in the data structure
     */
    public int add(int val) {
        // Add the new element to the min heap
        minHeap.offer(val);

        // If the size of the min heap is greater than k, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Return the kth largest element, which is the root of the min heap
        return minHeap.peek();
    }
}
