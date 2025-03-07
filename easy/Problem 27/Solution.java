class Solution {
    /*
     * Removes the given element from the given array and returns the number of elements
     * not equal to the given element.
     @ param nums the array of integers
     @ param val the element to be removed
     $ return the number of elements not equal to the given element
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;  // counter for numbers not equal to value
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[k] = nums[i];  // assign the inital index with the number
                k++;    // increase the count and index
            }
        }
        return k;   // return the count of numbers not equal to value
    }
}