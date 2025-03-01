
public class Solution {
    /*
     * Finds two numbers in an array that add up to a specific target.
     * 
     @ param nums the array of integers
     @ param target the target sum
     $ return an array containing the indices of the two numbers that add up to the target
     */
    public int[] twoSum(int[] nums, int target) {
        // Initialize result array to store indices
        int[] result = new int[2];
        
        // Iterate over each element in the array
        for (int i = 0; i < nums.length; i++) {
            // Check the next elements to find a pair
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of the pair equals the target, store their indices
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result; // Return the result immediately
                }
            }
        }
        
        // Return the result array (default values if no pair is found)
        return result;
    }
}
