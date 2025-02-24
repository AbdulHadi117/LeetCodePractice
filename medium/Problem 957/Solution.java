
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
     * Computes the state of the prison cells after n days.
     *
     @ param cells the initial state of the prison cells
     @ param n the number of days to iterate
     $ return the state of the prison cells after n days
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        // The initial state of the prison.
        int[] currentState = cells.clone();
        // The number of days that have passed.
        int day = 0;
        // A map to store the state of the prison and the day it was seen.
        Map<String, Integer> seen = new HashMap<>();

        // Iterate until we have reached the nth day.
        while (day < n) {
            // Convert the current state of the prison to a string.
            String stateString = stateToString(currentState);
            // Check if we have seen this state before.
            if (seen.containsKey(stateString)) {
                // If we have seen this state before, then we know that there is a cycle of states.
                // The cycle starts at the day the state was seen.
                int cycleStart = seen.get(stateString);
                // The length of the cycle is the difference between the current day and the start of the cycle.
                int cycleLength = day - cycleStart;
                // The remaining days is the number of days left until the nth day, modulo the length of the cycle.
                int remainingDays = (n - day) % cycleLength;
                // Iterate the remaining days, updating the current state of the prison.
                for (int i = 0; i < remainingDays; i++) {
                    currentState = nextDay(currentState);
                }
                // Return the current state of the prison at the end of the nth day.
                return currentState;
            }
            // Add the current state of the prison to the map.
            seen.put(stateString, day);
            // Update the current state of the prison.
            currentState = nextDay(currentState);
            // Increment the day.
            day++;
        }

        // Return the current state of the prison at the end of the nth day.
        return currentState;
    }

    /*
     * Computes the state of the prison cells after one day.
     *
     * In the prison, each cell can be either occupied (1) or unoccupied (0).
     * After one day, the state of the prison cells is updated according to the following rules:
     %  - A cell is occupied if exactly one of its two neighbors is occupied.
     %  - A cell is unoccupied if neither of its two neighbors is occupied.
     %  - A cell is unoccupied if both of its two neighbors are occupied.
     *
     @ param cells the current state of the prison cells
     $ return the state of the prison cells after one day
     */
    private int[] nextDay(int[] cells) {
        // Create a new array to hold the state of the prison cells after one day.
        int[] nextDay = new int[cells.length];

        // Iterate over the cells in the prison, computing the state of each cell after one day.
        for (int i = 1; i < cells.length - 1; i++) {
            // The cell is occupied if exactly one of its two neighbors is occupied.
            // Otherwise, the cell is unoccupied.
            nextDay[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }

        // Return the state of the prison cells after one day.
        return nextDay;
    }

    /*
     * Converts the state of the prison cells to a string.
     *
     @ param state the state of the prison cells
     $ return a string representation of the state of the prison cells
     */
    private String stateToString(int[] state) {
        StringBuilder sb = new StringBuilder();
        for (int cell : state) {
            // Append the cell's value to the string builder.
            // The cell's value is either 0 (unoccupied) or 1 (occupied).
            sb.append(cell);
        }
        // Return the string representation of the state of the prison cells.
        return sb.toString();
    }
}
