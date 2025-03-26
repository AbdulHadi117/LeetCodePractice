class Solution {
    /*
     * Checks if the given two arrays can be equal after performing a specific operation on the second array.
     * The operation is swapping the value at index i with the value at index j if the value at index i is different from the value at index j.
     @ param target the first array
     @ param arr the second array
     $ return true if the two arrays can be equal after performing the operation, false otherwise
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        // Check if the two arrays have the same length
        if (target.length != arr.length) {
            return false;
        }

        // Create an array to store the difference of the two arrays
        int[] counting = new int[1001];
        // Iterate over the elements of the two arrays
        for (int index = 0; index < target.length; index++) {
            // Increment the count of the target element
            counting[target[index]]++;
            // Decrement the count of the array element
            counting[arr[index]]--;
        }

        // Check if the counts of the elements are zero
        for (int count : counting) {
            if (count != 0) {
                return false;
            }
        }
        
        // If all the counts are zero, the two arrays can be equal after performing the operation
        return true;
    }
}