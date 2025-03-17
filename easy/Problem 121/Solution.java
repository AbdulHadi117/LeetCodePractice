
class Solution {

    /*
     * This function takes an array of prices and returns the maximum profit that can be obtained.
     * The maximum profit is the maximum difference between the selling price and the buying price.
     * The buying price must be lower than the selling price.
     * The function uses a greedy algorithm to find the maximum profit.
     @ param prices An array of prices
     $ return The maximum profit that can be obtained
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];    // BUY AT FIRST DAY
        int profit = 0;     // NET PROFIT IS ZERO

        for (int i = 1; i < prices.length; i++) {    // GO THROUGH THE DAYS
            if (prices[i] < buy) {   // IF PRICE IS FOUND LOWER THAN PREVIOUS BUY
                buy = prices[i];    // BUY ON ith DAY
            } else { // IF PRICE IS MORE THAN PREVIOUS BUY, OPPORTUNITY TO SELL
                if (prices[i] - buy > profit) {  // IF SELLING YEILDS A GREATER PROFIT
                    profit = prices[i] - buy;   // SELL AND SAVE THE PROFIT
                }
            }
        }

        return profit;        // RETURN THE NET MAXIMUM PROFIT
    }
}
