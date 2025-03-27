class Solution {
    /*
     * Given an array of integers, return true if there are three consecutive odd numbers in the array, false otherwise.
     @ param arr the given array of integers
     $ return true if there are three consecutive odd numbers, false otherwise
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0; // count of odd numbers we have found
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){ // if the current number is odd
                count += 1; // increment the count
            } else {
                count = 0; // reset the count
            }
            if (count == 3){ // if we have three odd numbers in a row
                return true; // return true
            }
        }
        return false; // return false if there are no three consecutive odd numbers
    }
}