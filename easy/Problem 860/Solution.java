class Solution {
    /**
     * Given an array of bill amounts, determine if we can make change for the next customer
     * @param bills The array of bill amounts
     * @return true if we can make change for the next customer, false otherwise
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5 -> // Increment the five dollar counter
                    five++;
                case 10 -> {
                    if (five == 0) {
                        // If we don't have any five dollar bills, we can't make change
                        return false;
                    }
                    // Decrement the five dollar counter
                    five--;
                    // Increment the ten dollar counter
                    ten++;
                }
                case 20 -> {
                    if (five > 0 && ten > 0) {
                        // If we have both five and ten dollar bills, use the ten dollar bill
                        five--; // Decrement the five dollar counter
                        ten--; // Decrement the ten dollar counter
                    }
                    else if (five >= 3) {
                        // If we only have five dollar bills, use three of them
                        five -= 3; // Decrement the five dollar counter by 3
                    }
                    else {
                        // If we don't have enough bills to make change, return false
                        return false;
                    }
                }
            }
        }
        // If we made it through all the bills, we can make change
        return true;
    }
}