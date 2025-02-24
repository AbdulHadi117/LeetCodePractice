import java.util.List;

class Solution {
    /*
     * This function takes a list of sorted arrays and returns the maximum absolute difference of two elements
     * that are in different arrays.
     *
     @ param arrays A list of sorted arrays
     $ return The maximum absolute difference of two elements that are in different arrays
     */
    public int maxDistance(List<List<Integer>> arrays) {
        // Initialize the minimum and maximum values
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size()-1);
        int maxDistance = 0;
        // Iterate over the arrays
        for (int index = 1; index < arrays.size();index++){
            List<Integer> currentArray = arrays.get(index);
            // Calculate the maximum absolute difference
            maxDistance = Math.max(
                maxDistance,Math.max(
                    // The maximum absolute difference between the maximum value in the previous array and the minimum value in the current array
                    Math.abs(currentArray.get(currentArray.size()-1)-minVal),
                    // The maximum absolute difference between the minimum value in the previous array and the maximum value in the current array
                    Math.abs(maxVal - currentArray.get(0))
                )
            );
            // Update the minimum and maximum values
            minVal = Math.min(minVal,currentArray.get(0));
            maxVal = Math.max(maxVal,currentArray.get(currentArray.size()-1));
        }
        return maxDistance;
    }
}