
public class Solution {

    /*
     * This function adds fractions given in a string expression and returns the result as a reduced fraction.
     *
     @ param expression A string representing a sum of fractions (e.g., "-1/2+1/2+1/3").
     $ return The resulting fraction in its simplest form as a string.
     */
    public String fractionAddition(String expression) {
        int resNum = 0, resDenom = 1;

        // Split the expression into individual fractions, considering signs
        String[] fractions = expression.replace("+", " +").replace("-", " -").split("\\s+");

        // Iterate over each fraction in the expression
        for (String fraction : fractions) {
            // Skip invalid or empty fractions
            if (fraction.isEmpty() || !fraction.contains("/")) {
                continue;
            }

            // Split the fraction into numerator and denominator
            String[] currFraction = fraction.split("/");
            if (currFraction.length != 2) {
                continue;
            }

            int currNum = Integer.parseInt(currFraction[0]);
            int currDenom = Integer.parseInt(currFraction[1]);

            // Calculate the new numerator and denominator
            resNum = resNum * currDenom + currNum * resDenom;
            resDenom = resDenom * currDenom;
        }

        // Determine if the result should be negative
        boolean isNegative = false;
        if (resNum < 0 || resDenom < 0) {
            isNegative = true;
        }

        // Reduce the fraction to its simplest form
        int gcdVal = gcd(resNum, resDenom);
        resNum = Math.abs(resNum / gcdVal);
        resDenom = Math.abs(resDenom / gcdVal);

        // Return the result as a string
        if (isNegative) {
            return "-" + resNum + "/" + resDenom;
        }
        return resNum + "/" + resDenom;
    }

    /*
     * Computes the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     *
     @ param a the first integer
     @ param b the second integer
     $ return the GCD of the two integers
     */
    private int gcd(int a, int b) {
        // Base case: if a is zero, return b as the GCD
        if (a == 0) {
            return b;
        }
        // Recursive call: compute GCD of b % a and a
        return gcd(b % a, a);
    }
}
