
public class Solution {

    /*
     * Returns the index of the target element in the given sorted array.
     * If the target element is not found, returns the index where it should be inserted to maintain the sorted order.
     * 
     @ param nums the given sorted array
     @ param target the target element to be searched
     $ return the index of the target element if found, otherwise the index where it should be inserted
     */
    public int searchInsert(int[] nums, int target) {
        // SOLVING WITH BINARY SEARCH O(LOG N)

        // TWO POINTERS FOR TRAVERSING
        int left = 0;
        int right = nums.length - 1;

        // IMPLEMENTING BINARY SEARCH
        while (left <= right) {
            int mid = (left + right) / 2;   // ASSIGNING MIDDLE VALUE
            if (nums[mid] == target) {
                return mid;     // RETURN MID VALUE IF TARGET AT MID
            } else if (nums[mid] < target) {
                left = mid + 1; // CHANGE STARTING POINTER IF TARGET > MID
            } else {
                right = mid - 1;    // CHANGE ENDING POINTER IF TARGET < MID
            }
        }

        // IF TARGET NOT FOUND, RETURN INSERTION INDEX
        return left;
    }
}
