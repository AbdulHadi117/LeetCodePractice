public class Solution {
    /*
     * Calculates the average waiting time for all customers.
     * The average waiting time is defined as the total waiting time divided by the number of customers.
     * The total waiting time is the sum of the waiting time for each customer.
     * The waiting time for each customer is the time it takes for the chef to prepare the order from the time the order is placed.
     * The chef takes the order at the order time and takes timeToPrepare to prepare the order.
     * The chef should get free at the maximum of the order time plus the time to prepare and the current waiting time.
     * The customer will wait for the time to free minus the order time.
     @ param customers a 2D array of integers where customers[i] = [orderTimei, timeToPreparei]
     $ return the average waiting time for all customers
     */
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0.0; // total waiting time for all customers
        double currentWaitingTime = 0.0; // current waiting time for each customers

        for (int[] customer : customers) {
            double orderTime = customer[0]; // Order Placed Time
            double timeToPrepare = customer[1]; // Time to prepare the order

            // Calculate the time the chef should get free
            double timeToFree = (currentWaitingTime == 0) ? orderTime + timeToPrepare
                    : Math.max(orderTime + timeToPrepare, currentWaitingTime);

            // Calculate the waiting time for this customer
            double waitingTime = timeToFree - orderTime;

            // Add the waiting time to the total waiting time
            totalWaitingTime += waitingTime;

            // Update the current waiting time
            currentWaitingTime = timeToFree;    // Chef will be free at timeToFree
        }

        // Calculate the average waiting time
        double averageWaitingTime = totalWaitingTime / customers.length;

        return averageWaitingTime;
    }
}
