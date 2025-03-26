class Solution {
    /**
     * Calculates the maximum number of water bottles that can be drank from given the numBottles and numExchange rules.
     *
     * @param numBottles  The number of water bottles we have.
     * @param numExchange The number of empty water bottles we need to exchange for one full water bottle.
     * @return The total number of water bottles that can be drank.
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxBottles = 0; // max bottles that can be obtained from the current bottles
        int newBottles = 0; // new bottles obtained from exchanging the current bottles
        int remainingBottles;   // remaining bottles that could not be exhanged

        /* 
         * loop until the number of bottles is not zero
         * maxBottles are updated as you drink the bottles
         * newBottles are obtained by exhanging the empty bottles
         * remainingBottles are the left which could not be exchanged
         * numBottles are the current number of bottles
         */
        while (numBottles != 0) {
            maxBottles = numBottles + newBottles;
            newBottles = numBottles / numExchange;  
            remainingBottles = numBottles % numExchange;
            numBottles = newBottles + remainingBottles;
        }
        return maxBottles;
    }
}