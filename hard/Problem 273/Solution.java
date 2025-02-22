
class Solution {

    /**
     ** Converts a non-negative integer to its English words representation.
     * 
     *@ param number the number to be converted to words
     *$ return the English words representation of the number
     */
    public String numberToWords(int number) {
        if (number == 0) {
            return "Zero";
        }

        // Arrays to store words for units, tens, and teens
        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

        String result = "";

        // Handle billions
        if (number >= 1000000000) {
            result += numberToWords(number / 1000000000) + " Billion ";
            number %= 1000000000;
        }

        // Handle millions
        if (number >= 1000000) {
            result += numberToWords(number / 1000000) + " Million ";
            number %= 1000000;
        }

        // Handle thousands
        if (number >= 1000) {
            result += numberToWords(number / 1000) + " Thousand ";
            number %= 1000;
        }

        // Handle hundreds
        if (number >= 100) {
            result += numberToWords(number / 100) + " Hundred ";
            number %= 100;
        }

        // Handle tens and units
        if (number >= 20) {
            result += tens[number / 10] + " ";
            number %= 10;
        }

        // Handle numbers less than 20
        if (number > 0) {
            if (number < 10) {
                result += units[number] + " ";
            } else {
                result += teens[number - 10] + " ";
            }
        }

        // Trim any extra spaces and return the result
        return result.trim();
    }
}

