class Solution {
    /*
     * Removes duplicates from the given array of integers and returns the number of unique elements.
     * 
     @ param nums the given array of integers
     $ return the number of unique elements
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){return 0;}
        int i = 0;
        // Iterate through the array with j
        for (int j = 1; j < nums.length;j++){
            // If the current element at j is different from the previous element at i
            if (nums[j] != nums[i]){
                // Increment i and assign the element at j to the element at i
                i++;
                nums[i] = nums[j];
            }
        }
        // Return the number of unique elements which is i + 1
        return i + 1;   
    }
}