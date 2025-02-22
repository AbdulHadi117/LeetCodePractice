class Solution {
    /**
     ** Finds the median of two sorted arrays by merging them into one sorted array, then choosing the middle element(s).
     ** If the merged array has an even number of elements, the median is the average of the two middle elements.
     ** Otherwise, the median is the middle element.
     *@ param array1 the first sorted array
     *@ param array2 the second sorted array
     *$ return the median of the two arrays
     */
    public double findMedianSortedArrays(int[] array1, int[] array2) {
        // create merged array
        int[] merged = new int[array1.length + array2.length];

        // indexes for array1, array2, and merged array
        int idx1 = 0, idx2 = 0, idx3 = 0;

        // merge the two arrays
        while (idx1 < array1.length && idx2 < array2.length) {
            if (array1[idx1] < array2[idx2]) {
                // add the smaller element to the merged array
                merged[idx3++] = array1[idx1++];
            } else {
                // add the smaller element to the merged array
                merged[idx3++] = array2[idx2++];
            }
        }
        // add remaining elements from array1
        while (idx1 < array1.length) {
            merged[idx3++] = array1[idx1++];
        }
        // add remaining elements from array2
        while (idx2 < array2.length) {
            merged[idx3++] = array2[idx2++];
        }
        // get median
        if (merged.length % 2 == 0) {
            // if the merged array has an even number of elements, the median is the average of the two middle elements
            return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2.0;
        } else {
            // otherwise, the median is the middle element
            return merged[merged.length / 2];
        }
    }

}
