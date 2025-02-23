public class Solution {
    /*
     * Returns the maximum area that can be formed between two lines in a given array.
     * 
     @ param height An array of integers representing the height of lines.
     @ return The maximum area that can be formed.
     */
    public int maxArea(int[] height) {
        int maxArea = 0, leftIndex = 0, rightIndex = height.length - 1;
        // keep track of the maximum area
        while (leftIndex < rightIndex) {
            // calculate the length between the two lines
            int length = rightIndex - leftIndex;
            // calculate the width which is the minimum height of the two lines
            int width = Math.min(height[leftIndex], height[rightIndex]);
            // calculate the area
            int area = length * width;
            // update the maximum area
            maxArea = Math.max(area, maxArea);
            // if the height of the left line is less than the right line, move the left line to the right
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                // else move the right line to the left
                rightIndex--;
            }
        }
        return maxArea;
    }
}