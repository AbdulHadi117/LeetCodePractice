import heapq

class KthLargest:
    def __init__(self, k, nums):
        """
        Initialize the class with the kth largest element to find and the initial list of numbers.
        The `heapq` module is used to maintain a min-heap of size k.
        """
        self.k = k
        self.min_heap = nums
        
        # Create a min-heap with the k largest elements from the initial list
        heapq.heapify(self.min_heap)
        
        # Maintain only the k largest elements in the heap
        while len(self.min_heap) > k:
            heapq.heappop(self.min_heap)
    
    def add(self, val):
        """
        Add a new value to the heap and return the kth largest element.
        The heap root is always the kth largest element, so retrieval is O(1).
        """
        # Add the new value to the heap
        heapq.heappush(self.min_heap, val)
        
        # If the heap size exceeds k, remove the smallest element
        if len(self.min_heap) > self.k:
            heapq.heappop(self.min_heap)
        
        # The kth largest element is the smallest element in the min-heap (O(1) retrieval)
        return self.min_heap[0]

# Example usage
obj = KthLargest(3, [4, 5, 8, 2])
result1 = obj.add(3)  # Adding 3, expected kth largest is 4
result2 = obj.add(5)  # Adding 5, expected kth largest is 5
result3 = obj.add(10) # Adding 10, expected kth largest is 5

print(result1)  # Output: 4
print(result2)  # Output: 5
print(result3)  # Output: 5
    

