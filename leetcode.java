
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
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
    public int lengthOfLongestSubstring(String s) {
        // $ Initialize pointers and set
        int start = 0; // @ Start of the window
        int maxLength = 0; // @ Maximum length of substring found
        Set<Character> charSet = new HashSet<>(); // @ Set to track characters in the current window

        // $ Iterate over each character in the string with the end pointer
        for (int end = 0; end < s.length(); end++) {
            // * If character is already in the set, remove characters from the start
            // pointer
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }

            charSet.add(s.charAt(end)); // @ Add the current character to the set

            // * Update the maximum length found
            maxLength = Math.max(maxLength, end - start + 1);
        }

        // $ Return the maximum length
        return maxLength;
    }

    // % KthLargest class to find the kth largest element
    public static final class KthLargest {
        private final int k; // @ The kth largest element to find
        private final PriorityQueue<Integer> minHeap; // @ Min-heap to store the k largest elements

        // $ Constructor to initialize the min-heap and add elements from the array
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>(); // @ Initialize min-heap

            // * Add elements to the heap
            for (int num : nums) {
                add(num);
            }
        }

        // $ Adds a value to the heap and returns the kth largest element
        public int add(int val) {
            minHeap.offer(val); // @ Add the new value to the heap

            // * If heap exceeds size k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek(); // @ Return the kth largest element
        }
    }

    // % Find the longest palindromic substring
    public String longestPalindrome(String s) {
        // $ Check if the input string is null or empty
        if (s == null || s.length() == 0) {
            return "";
        }

        // $ Preprocess the input string
        StringBuilder sPrime = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sPrime.append(c).append("#");
        }

        int n = sPrime.length(); // @ Length of Transformed String
        int[] palindromeRadii = new int[n]; // @ Array to store the radius of palindromes
        int center = 0; // @ Center of Current rightmost palindrome
        int radius = 0; // @ Right edge of current rightmost palindrome

        for (int i = 0; i < n; i++) {
            // * Calculate the mirror index of the current index `i`
            int mirror = 2 * center - i;

            // * Use the mirror's radius to initialize the current index's radius
            if (i < radius) {
                palindromeRadii[i] = Math.min(
                        radius - i,
                        palindromeRadii[mirror]);
            }

            // * Expand the palindrome centered at `i`
            while (i + 1 + palindromeRadii[i] < n &&
                    i - 1 - palindromeRadii[i] >= 0 &&
                    sPrime.charAt(i + 1 + palindromeRadii[i]) == sPrime.charAt(i - 1 - palindromeRadii[i])) {
                palindromeRadii[i]++;
            }

            // * Update the center and radius if necessary
            if (i + palindromeRadii[i] > radius) {
                center = i;
                radius = i + palindromeRadii[i];
            }
        }

        // $ Find the maximum radius and its center Index
        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeRadii[i] > maxLength) {
                maxLength = palindromeRadii[i];
                centerIndex = i;
            }
        }
        int startIndex = (centerIndex - maxLength) / 2; // @ starting index of the longest palindrome

        // $ Return the longest palindrome
        String longestPalindrome = s.substring(
                startIndex, startIndex + maxLength);

        return longestPalindrome;
    }

    // % Convert a string to zigzag pattern
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // $ Initialize a StringBuilder array, one for each row
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }

        // $ Set the initial index to 0 and the step (direction) to 1 (downwards)
        int index = 0, step = 1;

        // $ Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // * Append the character to the current row's StringBuilder
            res[index].append(c);

            if (index == 0) {
                step = 1; // @start moving down (step = 1)
            } else if (index == numRows - 1) {
                step = -1; // @ start moving up (step = -1)
            }

            // * Move to the next row depending on the current direction (step)
            index += step;
        }

        // $ Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : res) {
            result.append(row);
        }

        // $ Return the final zigzag-converted string
        return result.toString();
    }

    // % Check if you can provide Lemonde Change
    public boolean lemonadeChange(int[] bills) {
        // $ Initialize counters for five and ten dollar bills
        int five = 0, ten = 0;
        // $ Iterate through each bill in the given array
        for (int bill : bills) {
            switch (bill) {
                // * If the bill is five dollar,
                case 5 -> five++; // @ Increment the five dollar counter
                // * If the bill is ten dollar,
                case 10 -> {
                    // @ If we don't have any five dollar bill, return false
                    if (five == 0) {
                        return false;
                    }
                    five--; // @ Decrement the five dollar counter
                    ten++; // @ Increment the ten dollar counter
                }
                // * If the bill is twenty dollar
                case 20 -> {
                    // @ If we have five and ten dollar bills,
                    if (five > 0 && ten > 0) {
                        five--; // @ Decrement the five dollar counter
                        ten--; // @ Decrement the ten dollar counter
                    }
                    // @ If we don't have ten but we have 3 or more five dollar bill
                    else if (five >= 3) {
                        five -= 3; // @ Decrement the five dollar counter by 3
                    }
                    // @ If we don't have any five or ten dollar bill, return false
                    else {
                        return false;
                    }
                }
            }
        }
        // $ Return true if we Can make change
        return true;
    }

    public int maxDistance(List<List<Integer>> arrays) {
        // $ Initialize the min,max values and maximum distance
        int minVal = arrays.get(0).get(0); // @ first element of first array
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1); // @ last element of first array
        int maxDistance = 0; // @ To store the maximum distance found

        // $ Iterate through each array starting from second one
        for (int index = 1; index < arrays.size(); index++) {
            List<Integer> currentArray = arrays.get(index);

            // * Calculate the potential maximum distance by considering:
            maxDistance = Math.max(
                    maxDistance, // @ Current maximum distance
                    Math.max(
                            Math.abs(currentArray.get(currentArray.size() - 1) - minVal), // @ Distance between current
                                                                                          // array's max and overall min
                            Math.abs(maxVal - currentArray.get(0)) // @ Distance between overall max and current array's
                                                                   // min
                    ));

            // * Update minVal and maxVal with the current array's first and last elements
            minVal = Math.min(minVal, currentArray.get(0));
            maxVal = Math.max(maxVal, currentArray.get(currentArray.size() - 1));
        }

        // $ Return the maximum distance
        return maxDistance;
    }

    // % Reverse the integer within range
    public int reverse(int x) {
        // $ Initialize the result to store the reversed number
        int result = 0;

        // $ Loop to reverse the digits of the Number
        while (x != 0) {
            int digit = x % 10; // @ Extract the last digit of number

            // *Check if the current result will overflow
            if ((result > Integer.MAX_VALUE / 10)
                    || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // @ Overflow case for positive numbers
            }
            if ((result < Integer.MIN_VALUE / 10)
                    || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // @ Overflow case for negative numbers
            }

            // * Update the result
            result = result * 10 + digit;
            x /= 10; // @ Remove the last digit from x
        }

        // $ Return the reversed number
        return result;
    }

    // % Find the nth ugly number
    public int nthUglyNumber(int n) {
        // $ Initialize an array to store the ugly numbers
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // @ As 1 is the first ugly number

        // $ Initialize three counters
        int i2 = 0, i3 = 0, i5 = 0;

        // $ Loop to find the nth ugly number
        for (int i = 1; i < n; i++) {

            // * Find the next ugly number
            int nextMultipleOf2 = uglyNumbers[i2] * 2;
            int nextMultipleOf3 = uglyNumbers[i3] * 3;
            int nextMultipleOf5 = uglyNumbers[i5] * 5;

            int nextUglyNumber = Math.min(Math.min(nextMultipleOf2, nextMultipleOf3), nextMultipleOf5);

            // * Update the counters
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
            }

            // * Store the next ugly number
            uglyNumbers[i] = nextUglyNumber;
        }

        // $ Return the nth ugly number
        return uglyNumbers[n - 1];
    }

    // % Convert String to Integer Values (ATOI)
    public int myAtoi(String s) {
        // $ Initialize variables
        int idx = 0, sign = 1, res = 0;

        // $ Ignore leading whitespaces
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        // $ Check if the next character is '-' or '+'
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = s.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }

        // $ Convert valid digits to integer
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } // @ If value goes out of range
            res = 10 * res + digit;
            idx++;
        }
        return sign * res;

        // $ Return the final result

    }

    // % Find the maximum area with most water contained
    public int maxArea(int[] height) {
        // $ Initialize Variables
        int max_area = 0, leftIndex = 0, rightIndex = height.length - 1;

        // $ Loop through the height from left to right
        while (leftIndex < rightIndex) {
            int length = rightIndex - leftIndex; // @ Length of Current Container
            int width = Math.min(height[leftIndex], height[rightIndex]); // @ Width of Current Container
            int area = length * width; // @ Area of Current Container

            // * Update the maximum area
            max_area = Math.max(area, max_area);

            // * Update the pointers to move in array
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max_area;
    }

    // % Convert Roman Number String to Integer Value

    public int romanToInt(String s) {
        // $ Mapping of Roman numerals to their corresponding integer values
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        // $ Initialize variables to =
        int ans = 0;
        int prevVal = 0;

        // $ Iterate over given string in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            // * Get current value of character
            int currentVal = values.get(s.charAt(i));

            // * If current value is less than previous value
            if (currentVal < prevVal) {
                ans -= currentVal; // @ subtract from answer
            } else {
                ans += currentVal; // @ Otherwise, add to answer
            }

            // $ Update previous value
            prevVal = currentVal;
        }

        // $ Return answer
        return ans;
    }

    // % Find the complement of the Number given
    public int findComplement(int num) {
        // $ Convert the number to binary
        String binary = "";
        while (num > 0) {
            binary = (num % 2) + binary;
            num /= 2;
        }

        // $ Convert the binary to complement
        String flipped = "";
        for (int index = 0; index < binary.length(); index++) {
            if (binary.charAt(index) == '0') {
                flipped += '1';
            } else {
                flipped += '0';
            }
        }

        // $ Convert the complement to decimal
        int result = 0;
        for (int index = 0; index < flipped.length(); index++) {
            result = result * 2 + (flipped.charAt(index) - '0');
        }
        return result;
    }

    // % Calculate the fraction Addition and Subtraction

    public String fractionAddition(String expression) {
        // $ Initialize the result variables
        int resNum = 0, resDenom = 1;

        // $ Split the expression into fractions
        String[] fractions = expression.replace("+", " +").replace("-", " -").split("\\s+");

        // $ Iterate over the fractions and add them to the result
        for (String fraction : fractions) {
            if (fraction.isEmpty() || !fraction.contains("/")) {
                continue;
            }

            String[] currFraction = fraction.split("/");
            if (currFraction.length != 2) {
                continue;
            }

            int currNum = Integer.parseInt(currFraction[0]);
            int currDenom = Integer.parseInt(currFraction[1]);

            // * Add the current fraction to the result
            resNum = resNum * currDenom + currNum * resDenom;
            resDenom = resDenom * currDenom;
        }

        // $ Determine if the result is negative
        boolean isNegative = false;
        if (resNum < 0 || resDenom < 0) {
            isNegative = true;
        }

        int gcdVal = gcd(resNum, resDenom); // @ Calculate the greatest common divisor

        // $ Update the result with the greatest common divisor
        resNum = Math.abs(resNum / gcdVal);
        resDenom = Math.abs(resDenom / gcdVal);

        // $ Return the result as a string
        if (isNegative) {
            return "-" + resNum + "/" + resDenom;
        }
        return resNum + "/" + resDenom;
    }

    private int gcd(int a, int b) {
        // @ If a is zero, return b
        if (a == 0) {
            return b;
        }
        // @ Calculate the greatest common divisor recursively
        return gcd(b % a, a);
    }

    // % Match the Regular Expression with Pattern
    public boolean isMatch(String text, String pattern) {
        // $ Create a 2D array to store the dynamic programming results
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // $ Initialize the last element of the 2D array to true
        dp[text.length()][pattern.length()] = true;

        // $ Iterate over the text and pattern in reverse order
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                // * Check if the current character in the text matches the current character in
                // the pattern
                boolean match = (i < text.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                // * Check if the current character in the pattern is '*'
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    // @ If it is, check if the current character in the text matches the preceding
                    // character in the pattern, and if so, move to the next character in the text
                    // and pattern
                    dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                } else {
                    // @ If not, just check if the current character in the text matches the current
                    // character in the pattern
                    dp[i][j] = match && dp[i + 1][j + 1];
                }
            }
        }
        // $ Return the result of the dynamic programming
        return dp[0][0];
    }

    // % Valid Parentheses
    public boolean isValid(String s) {
        // $ Create a mapping of opening to closing parentheses
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('[', ']');
        mapping.put('{', '}');
        // $ Initialize a stack to keep track of the parentheses
        Stack<Character> stack = new Stack<>();
        // $ Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // * If the character is an opening parenthesis,
            if (mapping.containsKey(c)) {
                stack.push(mapping.get(c)); // @ push its closing parenthesis onto the stack
            }
            // * If the character is a closing parenthesis,
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false; // @ If the stack is empty or the top of the stack doesn't match the current
                                  // character

                }
            }
        }
        // $ Return true if the stack is empty
        return stack.isEmpty();
    }

    // % Pass The Pillow
    public int passThePillow(int n, int time) {
        // $ Calculate the number of cycles
        int cyc = time / (n - 1);
        // $ Calculate the remainder
        int rem = time % (n - 1);
        // * If the number of cycles is odd,
        if (cyc % 2 != 0) {
            // @ Return the person who has the pillow after time seconds
            return n - rem;
        }
        // * If the number of cycles is even,
        else {
            // @ Return the person who has the pillow after time seconds
            return rem + 1;
        }
    }

    // % Remove Duplicates
    public int removeDuplicates(int[] nums) {
        // $ If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }
        // $ Initialize a variable 'i' to keep track of the index of the last unique
        // element
        int i = 0;
        // $ Iterate over the array
        for (int j = 1; j < nums.length; j++) {
            // * If the current element is not equal to the element at index 'i',
            if (nums[j] != nums[i]) {
                // @ Increment 'i' and assign the current element to the next index
                i++;
                nums[i] = nums[j];
            }
        }
        // $ Return the length of the new array after removing the duplicates
        return i + 1;
    }

    // % Keyboard Row
    public String[] findWords(String[] words) {
        // $ If the input array is empty, return an empty array
        if (words.length == 0) {
            return new String[0];
        }

        // $ Initialize sets to store the letters
        Set<Character> firstRow = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> secondRow = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> thirdRow = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

        // $ Initialize a list to store the words
        List<String> resultList = new ArrayList<>();

        // $ Iterate over each word in the input array
        for (String word : words) {
            // * Initialize a set to store the letters in the current word
            Set<Character> letters = new HashSet<>();
            // * Convert the current word to lowercase and iterate over each letter
            for (char c : word.toLowerCase().toCharArray()) {
                // @ Add the current letter to the set of letters
                letters.add(c);
            }
            // * Check if the set of letters can be typed using only one row of the keyboard
            if (firstRow.containsAll(letters) || secondRow.containsAll(letters) || thirdRow.containsAll(letters)) {
                // @ Add the current word to the result list
                resultList.add(word);
            }
        }

        // $ Convert the result list to an array of strings and return it
        return resultList.toArray(String[]::new);
    }
}