import java.util.Arrays;

public class Solution {

    /*
     * Computes the sum of a range of subarray sums in a given array.
     * The method first computes all possible subarray sums, stores them in an array, and then sorts the array.
     * Finally, the method computes the sum of the subarray sums from the leftIndex to rightIndex and returns the result.
     * The sum is computed modulo 1e9 + 7 to prevent overflow.
     *
     @ param array   the input array
     @ param leftIndex   the left index of the range of subarray sums to be computed
     @ param rightIndex  the right index of the range of subarray sums to be computed
     $ return the sum of the subarray sums in the given range
     */
    public int rangeSum(int[] array, int numberOfPositiveInts, int leftIndex, int rightIndex) {
        // Compute all possible subarray sums
        int[] subArraySums = new int[numberOfPositiveInts * (numberOfPositiveInts + 1) / 2];

        int k = 0;
        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i; j < numberOfPositiveInts; j++) {
                currentSum += array[j];
                subArraySums[k++] = currentSum;
            }
        }

        // Sort the subarray sums
        Arrays.sort(subArraySums);

        // Compute the sum of the subarray sums in the given range
        int sum = 0;
        final int mod = (int) (1e9 + 7);
        for (int idx = leftIndex - 1; idx < rightIndex; idx++) {
            sum = (sum + subArraySums[idx]) % mod;
        }

        return sum;
    }
}

