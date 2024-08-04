
import java.util.Arrays;

public class leetcode {

    //% Find two indices in the array that add up to the target
    public int[] twoSum(int[] inputArray, int target) {
        int[] outputArray = new int[2];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == target) {
                    outputArray[0] = i;
                    outputArray[1] = j;
                    return outputArray; //@ Return as soon as we find the pair
                }
            }
        }
        return outputArray;
    }

    //% Find the median of two sorted arrays
    public double findMedianSortedArrays(int[] inputArray1, int[] inputArray2) {
        int[] mergedArray = new int[inputArray1.length + inputArray2.length];
        int i = 0, j = 0, k = 0;

        //$ Merge the two arrays
        while (i < inputArray1.length && j < inputArray2.length) {
            if (inputArray1[i] < inputArray2[j]) {
                mergedArray[k++] = inputArray1[i++];
            } else {
                mergedArray[k++] = inputArray2[j++];
            }
        }

        //$ Copy remaining elements
        while (i < inputArray1.length) {
            mergedArray[k++] = inputArray1[i++];
        }
        while (j < inputArray2.length) {
            mergedArray[k++] = inputArray2[j++];
        }

        //$ Calculate median
        if (mergedArray.length % 2 != 0) {
            return mergedArray[mergedArray.length / 2];
        } else {
            return (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
        }
    }

    //% Check if an integer is a palindrome
    public boolean isPalindrome(int inputNumber) {
        if (inputNumber < 0) {
            return false; //@ Negative numbers are not palindromes
        }
        int originalNumber = inputNumber;
        int reverseNumber = 0;

        //$ Reverse the number
        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            inputNumber /= 10;
        }

        return reverseNumber == originalNumber;
    }

    //% Find the longest common prefix among an array of strings
    public String longestCommonPrefix(String[] inputStrings) {
        if (inputStrings.length == 0) {
            return "";
        }
        String prefix = inputStrings[0];

        //$ Compare the prefix with each string
        for (int index = 1; index < inputStrings.length; index++) {
            while (inputStrings[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); //@ Shorten the prefix
            }
        }
        return prefix;
    }

    //% Calculate the maximum number of water bottles you can drink
    public int numWaterBottles(int numberOfBottles, int numberOfExchange) {
        int totalBottles = numberOfBottles;

        //$ Keep exchanging bottles while possible
        while (numberOfBottles >= numberOfExchange) {
            int newBottles = numberOfBottles / numberOfExchange;
            int remainingBottles = numberOfBottles % numberOfExchange;
            totalBottles += newBottles;
            numberOfBottles = newBottles + remainingBottles;
        }

        return totalBottles;
    }

    //% Check if there are three consecutive odd numbers in the array
    public boolean threeConsecutiveOdds(int[] inputArray) {
        int countOfOdds = 0;

        //$ Traverse the array and count consecutive odds
        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] % 2 != 0) {
                countOfOdds++;
                if (countOfOdds == 3) {
                    return true; //@ Found three consecutive odds
                }
            } else {
                countOfOdds = 0; //@ Reset the count if an even number is found
            }
        }
        return false;
    }

    //% Calculate the minimum operations to return to the main folder
    public int minOperations(String[] inputLogs) {
        int currentLevel = 0;

        //$ Traverse the logs to calculate the current level
        for (String log : inputLogs) {
            if (log.equals("../")) {
                currentLevel = Math.max(0, currentLevel - 1); //@ Move up a level
            } else if (!log.equals("./")) {
                currentLevel++; //@ Move down a level
            }
        }

        return currentLevel;
    }

    //% Calculate the average waiting time for customers
    public double averageWaitingTime(int[][] customerArray) {
        double totalWaitingTime = 0;
        double currentTime = 0;

        //$ Traverse the customer array
        for (int[] customer : customerArray) {
            double orderTime = customer[0];
            double prepTime = customer[1];

            //* */ Calculate the time the customer will be free
            double freeTime = Math.max(currentTime, orderTime) + prepTime;
            double waitTime = freeTime - orderTime;
            totalWaitingTime += waitTime;
            currentTime = freeTime;
        }

        return totalWaitingTime / customerArray.length;
    }

    //% Count the number of seniors in the details array
    public int countSeniors(String[] detailsArray) {
        int countOfSeniors = 0;

        //$ Traverse the details array
        for (String detail : detailsArray) {
            int age = Integer.parseInt(detail.substring(11, 13)); //@ Extract age
            if (age > 60) {
                countOfSeniors++;
            }
        }

        return countOfSeniors;
    }

    //% Find the minimum swaps to group all 1s together
    public int minSwaps(int[] inputArray) {
        int countOfOnes = 0;

        //$ Count the number of 1s in the array
        for (int element : inputArray) {
            if (element == 1) {
                countOfOnes++;
            }
        }

        //$ If there are no 1s or the array consists entirely of 1s, return 0
        if (countOfOnes == 0 || countOfOnes == inputArray.length) {
            return 0;
        }

        //$ Calculate the sum of the initial window of size countOfOnes
        int initialWindowSum = 0;
        for (int i = 0; i < countOfOnes; i++) {
            initialWindowSum += inputArray[i];
        }

        int maxWindowSum = initialWindowSum;    //@ Initialize the maximum window sum with the initial window sum

        //$ Slide the window across the array to find the maximum sum of a window of size countOfOnes
        for (int i = 0; i < inputArray.length; i++) {
            initialWindowSum -= inputArray[i];
            initialWindowSum += inputArray[(i + countOfOnes) % inputArray.length];
            maxWindowSum = Math.max(maxWindowSum, initialWindowSum);
        }

        return countOfOnes - maxWindowSum;  //@ The minimum swaps needed to group all 1s together is the total number of 1s minus the maximum window sum

    }

    //% Check if two arrays are equal or not
    public boolean canBeEqual(int[] target, int[] arr) {

        //$ Check if the lengths of the two arrays are equal
        if (target.length != arr.length) {
            return false;   //@ Cannot be equal if they have different lengths
        }

        //$ Count the occurrences of each element in the target array
        int[] counting = new int[1001];
        for (int index = 0; index < target.length; index++) {
            counting[target[index]]++;
            counting[arr[index]]--;
        }

        //$ Check if the number of occurrences are zero
        for (int count : counting) {
            if (count != 0) {
                return false;   //@ Cannot be equal if the number of occurrences of an element is not equal
            }
        }

        return true;
    }

    //% Calculate the sum of the specified range of sorted subarray sums
    public int rangeSum(int[] array, int numberOfPositiveInts, int leftIndex, int rightIndex) {
        //$ Calculate the total number of subarrays
        int[] subArraySums = new int[numberOfPositiveInts * (numberOfPositiveInts + 1) / 2];

        //$ Generate all subarrays and calculate their sums
        for (int i = 0, k = 0; i < array.length; i++) {
            int currentSum = 0;  //@ Initialize current subarray sum
            for (int j = i; j < numberOfPositiveInts; j++) {
                currentSum += array[j];  //@ Add element to current subarray sum
                subArraySums[k++] = currentSum;  //@ Store current subarray sum
            }
        }

        //$ Sort the list of subarray sums
        Arrays.sort(subArraySums);

        //$ Calculate the sum of the specified range of sorted subarray sums
        int sum = 0;
        final int mod = (int) (1e9 + 7);
        for (int idx = leftIndex - 1; idx < rightIndex; idx++) {
            sum = (sum + subArraySums[idx]) % mod;
        }

        return sum;
    }
}
