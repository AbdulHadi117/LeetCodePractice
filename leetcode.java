
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;

public class leetcode {
    // % ListNode DataType
    public class ListNode {
        int data; // @ Holds the data passed into ListNode
        ListNode next; // @ Recursive pointer to the next ListNode

        // $ Implementation of the ListNode
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // % Find two indices in the array that add up to the target
    public int[] twoSum(int[] inputArray, int target) {
        int[] outputArray = new int[2];
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == target) {
                    outputArray[0] = i;
                    outputArray[1] = j;
                    return outputArray; // @ Return as soon as we find the pair
                }
            }
        }
        return outputArray;
    }

    // % Find the median of two sorted arrays
    public double findMedianSortedArrays(int[] inputArray1, int[] inputArray2) {
        int[] mergedArray = new int[inputArray1.length + inputArray2.length];
        int i = 0, j = 0, k = 0;

        // $ Merge the two arrays
        while (i < inputArray1.length && j < inputArray2.length) {
            if (inputArray1[i] < inputArray2[j]) {
                mergedArray[k++] = inputArray1[i++];
            } else {
                mergedArray[k++] = inputArray2[j++];
            }
        }

        // $ Copy remaining elements
        while (i < inputArray1.length) {
            mergedArray[k++] = inputArray1[i++];
        }
        while (j < inputArray2.length) {
            mergedArray[k++] = inputArray2[j++];
        }

        // $ Calculate median
        if (mergedArray.length % 2 != 0) {
            return mergedArray[mergedArray.length / 2];
        } else {
            return (double) (mergedArray[mergedArray.length / 2] + mergedArray[mergedArray.length / 2 - 1]) / 2;
        }
    }

    // % Check if an integer is a palindrome
    public boolean isPalindrome(int inputNumber) {
        if (inputNumber < 0) {
            return false; // @ Negative numbers are not palindromes
        }
        int originalNumber = inputNumber;
        int reverseNumber = 0;

        // $ Reverse the number
        while (inputNumber > 0) {
            int lastDigit = inputNumber % 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
            inputNumber /= 10;
        }

        return reverseNumber == originalNumber;
    }

    // % Find the longest common prefix among an array of strings
    public String longestCommonPrefix(String[] inputStrings) {
        if (inputStrings.length == 0) {
            return "";
        }
        String prefix = inputStrings[0];

        // $ Compare the prefix with each string
        for (int index = 1; index < inputStrings.length; index++) {
            while (inputStrings[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // @ Shorten the prefix
            }
        }
        return prefix;
    }

    // % Calculate the maximum number of water bottles you can drink
    public int numWaterBottles(int numberOfBottles, int numberOfExchange) {
        int totalBottles = numberOfBottles;

        // $ Keep exchanging bottles while possible
        while (numberOfBottles >= numberOfExchange) {
            int newBottles = numberOfBottles / numberOfExchange;
            int remainingBottles = numberOfBottles % numberOfExchange;
            totalBottles += newBottles;
            numberOfBottles = newBottles + remainingBottles;
        }

        return totalBottles;
    }

    // % Check if there are three consecutive odd numbers in the array
    public boolean threeConsecutiveOdds(int[] inputArray) {
        int countOfOdds = 0;

        // $ Traverse the array and count consecutive odds
        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] % 2 != 0) {
                countOfOdds++;
                if (countOfOdds == 3) {
                    return true; // @ Found three consecutive odds
                }
            } else {
                countOfOdds = 0; // @ Reset the count if an even number is found
            }
        }
        return false;
    }

    // % Calculate the minimum operations to return to the main folder
    public int minOperations(String[] inputLogs) {
        int currentLevel = 0;

        // $ Traverse the logs to calculate the current level
        for (String log : inputLogs) {
            if (log.equals("../")) {
                currentLevel = Math.max(0, currentLevel - 1); // @ Move up a level
            } else if (!log.equals("./")) {
                currentLevel++; // @ Move down a level
            }
        }

        return currentLevel;
    }

    // % Calculate the average waiting time for customers
    public double averageWaitingTime(int[][] customerArray) {
        double totalWaitingTime = 0;
        double currentTime = 0;

        // $ Traverse the customer array
        for (int[] customer : customerArray) {
            double orderTime = customer[0];
            double prepTime = customer[1];

            // * Calculate the time the customer will be free
            double freeTime = Math.max(currentTime, orderTime) + prepTime;
            double waitTime = freeTime - orderTime;
            totalWaitingTime += waitTime;
            currentTime = freeTime;
        }

        return totalWaitingTime / customerArray.length;
    }

    // % Count the number of seniors in the details array
    public int countSeniors(String[] detailsArray) {
        int countOfSeniors = 0;

        // $ Traverse the details array
        for (String detail : detailsArray) {
            int age = Integer.parseInt(detail.substring(11, 13)); // @ Extract age
            if (age > 60) {
                countOfSeniors++;
            }
        }

        return countOfSeniors;
    }

    // % Find the minimum swaps to group all 1s together
    public int minSwaps(int[] inputArray) {
        int countOfOnes = 0;

        // $ Count the number of 1s in the array
        for (int element : inputArray) {
            if (element == 1) {
                countOfOnes++;
            }
        }

        // $ If there are no 1s or the array consists entirely of 1s, return 0
        if (countOfOnes == 0 || countOfOnes == inputArray.length) {
            return 0;
        }

        // $ Calculate the sum of the initial window of size countOfOnes
        int initialWindowSum = 0;
        for (int i = 0; i < countOfOnes; i++) {
            initialWindowSum += inputArray[i];
        }

        int maxWindowSum = initialWindowSum; // @ Initialize the maximum window sum with the initial window sum

        // $ Slide the window to find the maximum sum of a window of size countOfOnes
        for (int i = 0; i < inputArray.length; i++) {
            initialWindowSum -= inputArray[i];
            initialWindowSum += inputArray[(i + countOfOnes) % inputArray.length];
            maxWindowSum = Math.max(maxWindowSum, initialWindowSum);
        }
        // $ The minimum swaps needed is the total number of 1s minus the maximum sum
        return countOfOnes - maxWindowSum;

    }

    // % Check if two arrays are equal or not
    public boolean canBeEqual(int[] target, int[] arr) {

        // $ Check if the lengths of the two arrays are equal
        if (target.length != arr.length) {
            return false; // @ Cannot be equal if they have different lengths
        }

        // $ Count the occurrences of each element in the target array
        int[] counting = new int[1001];
        for (int index = 0; index < target.length; index++) {
            counting[target[index]]++;
            counting[arr[index]]--;
        }

        // $ Check if the number of occurrences are zero
        for (int count : counting) {
            if (count != 0) {
                return false; // @ Cannot be equal if the number of occurrences of an element is not equal
            }
        }

        return true;
    }

    // % Calculate the sum of the specified range of sorted subarray sums
    public int rangeSum(int[] array, int numberOfPositiveInts, int leftIndex, int rightIndex) {
        // $ Calculate the total number of subarrays
        int[] subArraySums = new int[numberOfPositiveInts * (numberOfPositiveInts + 1) / 2];

        // $ Generate all subarrays and calculate their sums
        for (int i = 0, k = 0; i < array.length; i++) {
            int currentSum = 0; // @ Initialize current subarray sum
            for (int j = i; j < numberOfPositiveInts; j++) {
                currentSum += array[j]; // @ Add element to current subarray sum
                subArraySums[k++] = currentSum; // @ Store current subarray sum
            }
        }

        // $ Sort the list of subarray sums
        Arrays.sort(subArraySums);

        // $ Calculate the sum of the specified range of sorted subarray sums
        int sum = 0;
        final int mod = (int) (1e9 + 7);
        for (int idx = leftIndex - 1; idx < rightIndex; idx++) {
            sum = (sum + subArraySums[idx]) % mod;
        }

        return sum;
    }

    // % Find the kth distinct element in an array
    public String kthDistinct(String[] array, int kthDistinctElement) {
        // $ Map to store the count of Strings
        Map<String, Integer> distinctCount = new HashMap<>();

        // $ Count the occurrences of each String
        for (String element : array) {
            distinctCount.put(element, distinctCount.getOrDefault(element, 0) + 1);
        } // @ Increment the count for the current string in the map

        // $ Find the kth distinct element
        for (String element : array) {
            if (distinctCount.get(element) == 1) { // @ Check if current string appears exactly once
                if (kthDistinctElement == 1) {
                    return element; // @ Return the kth Distinct Element if found
                }
                kthDistinctElement--; // @ Decrement the counter
            }
        }

        // $ Return an empty string if the kth distinct element is not found
        return "";
    }

    // % Find Minimum Number of Pushes needed to type word
    public int minimumPushes(String word) {

        // $ Count the occurrences of each character in the word
        int alphabetSize = 26;
        int[] freqCount = new int[alphabetSize];
        for (char character : word.toCharArray()) {
            freqCount[character - 'a']++;
        }

        // $ Sort the array in descending order
        Arrays.sort(freqCount); // @ Sort the Array
        for (int index = 0; index < alphabetSize / 2; index++) {
            int temp = freqCount[index];
            freqCount[index] = freqCount[alphabetSize - 1 - index];
            freqCount[alphabetSize - 1 - index] = temp;
        }

        // $ Calculate the number of pushes needed
        int minPushes = 0;
        for (int index = 0; index < freqCount.length; index++) {
            if (freqCount[index] == 0) {
                break;
            }
            minPushes += ((index / 8) + 1) * freqCount[index];
        }
        return minPushes;
    }

    // % Convert Number into English Word Representation
    public String numberToWords(int number) {

        if (number == 0) {
            return "Zero";
        } // @ Handle the case of Zero

        // $ Arrays to map numbers to their word equivalents

        String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
        String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] teens = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen" };

        String result = ""; // @ Initialize the result String

        // $ Process Billions place if applicable
        if (number >= 1000000000) {
            result += numberToWords(number / 1000000000) + " Billion ";
            number %= 1000000000; // @ Reduce the number
        }

        // $ Process Millions place if applicable
        if (number >= 1000000) {
            result += numberToWords(number / 1000000) + " Million ";
            number %= 1000000; // @ Reduce the number
        }

        // $ Process Thousands place if applicable
        if (number >= 1000) {
            result += numberToWords(number / 1000) + " Thousand ";
            number %= 1000; // @ Reduce the number
        }

        // $ Process Hundreds place if applicable
        if (number >= 100) {
            result += numberToWords(number / 100) + " Hundred ";
            number %= 100; // @ Reduce the number
        }

        // $ Process Tens place if applicable
        if (number >= 20) {
            result += tens[number / 10] + " ";
            number %= 10; // @ Reduce the number
        }

        // $ Process Units place
        if (number > 0) {
            if (number < 10) {
                result += units[number] + " ";
            } else {
                result += teens[number - 10] + " ";
            }
        }

        // $ Return the result
        return result.trim(); // @ Trim any extra spaces
    }

    // % Spiral Matrix III
    public List<int[]> sprialMatrixIII(int rows, int columns, int rStart, int cStart) {
        // $ List to Store the traversed Positions
        List<int[]> traversedPosition = new ArrayList<>();
        traversedPosition.add(new int[] { rStart, cStart }); // @ Start with initial position

        // $ Predicate to check if the position is valid
        BiPredicate<Integer, Integer> isValid = (row, col) -> (row >= 0 && row < rows) && (col >= 0 && col < columns);

        int steps = 0; // @ Steps to move in each direction
        int currentRow = rStart, currentCol = cStart; // @ Current position on Grid

        // $ Loop until all positions are traversed
        while (traversedPosition.size() < rows * columns) {
            steps++; // @ Increment StepSize for Spiral Movement

            // $ Loop through steps to move in Right and Down direction

            for (int i = 0; i < steps; i++) {
                currentCol++; // @ Move Right to Next Column
                if (isValid.test(currentRow, currentCol)) {
                    traversedPosition.add(new int[] { currentRow, currentCol });
                } // @ Add Position if its within bounds of Grid
            }

            for (int i = 0; i < steps; i++) {
                currentRow++; // @ Move Down to Next Row
                if (isValid.test(currentRow, currentCol)) {
                    traversedPosition.add(new int[] { currentRow, currentCol });
                } // @ Add Position if its within bounds of Grid
            }

            steps++; // @ Increment StepSize for Spiral Movement

            // $ Loop through steps to move in Up and Left direction
            for (int i = 0; i < steps; i++) {
                currentCol--; // @ Move left to the Previous Column
                if (isValid.test(currentRow, currentCol)) {
                    traversedPosition.add(new int[] { currentRow, currentCol });
                } // @ Add Position if its within bounds of Grid
            }
            for (int i = 0; i < steps; i++) {
                currentRow--; // @ Move Up to the previous Row
                if (isValid.test(currentRow, currentCol)) {
                    traversedPosition.add(new int[] { currentRow, currentCol });
                } // @ Add Position if its within bounds of Grid
            }
        }

        // $ Return the list of traversed positions
        return traversedPosition;
    }

    // % Number of Magic Squares Inside a Grid
    public int numMagicSquaresInside(int[][] grid) {
        // $ Initialize counter for the number of magic squares
        int count = 0;
        int rows = grid.length; // @ Get the number of rows in the grid
        int cols = grid[0].length; // @ Get the number of columns in the grid

        // $ Iterate over each possible 3x3 subgrid in the grid
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {

                // * Check if the current 3x3 subgrid is a magic square
                boolean[] alreadySeenElement = new boolean[10]; // @ Track seen numbers
                boolean isMagic = true;

                // * Validate all numbers in the 3x3 subgrid
                for (int i = 0; i < 3 && isMagic; i++) {
                    for (int j = 0; j < 3 && isMagic; j++) {
                        int num = grid[row + i][col + j];
                        // @ Check if number is within 1-9 and not already seen
                        if (num < 1 || num > 9 || alreadySeenElement[num]) {
                            isMagic = false;
                        }
                        alreadySeenElement[num] = true;
                    }
                }

                if (!isMagic)
                    continue;

                // * Calculate the diagonal sums
                int diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
                int diagonal2 = grid[row + 2][col] + grid[row + 1][col + 1] + grid[row][col + 2];

                if (diagonal1 != diagonal2)
                    continue; // @ Check if diagonals have the same sum

                // * Calculate the row sums
                int row1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
                int row2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
                int row3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];

                if (row1 != diagonal1 || row2 != diagonal1 || row3 != diagonal1)
                    continue; // @ Check if all rows have the same sum

                // * Calculate the column sums
                int col1 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
                int col2 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
                int col3 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];

                if (col1 != diagonal1 || col2 != diagonal1 || col3 != diagonal1)
                    continue; // @ Check if all columns have the same sum

                // * If all checks pass, it is a magic square
                count++;
            }
        }
        return count; // @ Return the total number of magic squares found
    }

    // % Add two numbers represented by linked lists.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // $ Helper Functions
        class Helper {
            // $ Helper method to perform the addition with carry.
            private ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry) {
                // * Base case: If both lists are exhausted and no carry, return null
                if (l1 == null && l2 == null && carry == 0) {
                    return null;
                }

                // * Get values from the current nodes
                int val1 = (l1 == null) ? 0 : l1.data;
                int val2 = (l2 == null) ? 0 : l2.data; // @ 0 if node is null

                // * Add the values and carry
                int sum = val1 + val2 + carry;
                carry = sum / 10; // @ Update carry for the next node

                // * Create a new node with the digit of the sum
                ListNode result = new ListNode(sum % 10);

                // * Recursively call the next node with updated carry
                result.next = addTwoNumbersHelper((l1 == null) ? null : l1.next,
                        (l2 == null) ? null : l2.next, carry);

                return result;
            }

            // $ Helper method to print the linked list.
            private void printLinkedList(ListNode node) {
                while (node != null) {
                    // * Print the value of the current node followed by " -> "
                    System.out.print(node.data + (node.next != null ? " -> " : "\n"));
                    node = node.next; // @ Move to the next node
                }
            }
        }

        // $ Create a new Helper object
        Helper helper = new Helper();

        // $ Print the original lists
        helper.printLinkedList(l1);
        helper.printLinkedList(l2);

        // $ Call helper method with initial carry of 0
        return helper.addTwoNumbersHelper(l1, l2, 0);
    }

    // % Find the length of longest substring without repeating charcaters
    public int lengthOfLongestSubstring(String s){
        // $ Initialize pointers and set
        int start = 0;                //@ Start of the window
        int maxLength = 0;           //@ Maximum length of substring found
        Set<Character> charSet = new HashSet<>(); //@ Set to track characters in the current window
        
        //$ Iterate over each character in the string with the end pointer
        for (int end = 0; end < s.length(); end++) {
            // * If character is already in the set, remove characters from the start pointer
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }
            
            charSet.add(s.charAt(end)); //@ Add the current character to the set
            
            //* Update the maximum length found
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        //$ Return the maximum length
        return maxLength;
    }
}