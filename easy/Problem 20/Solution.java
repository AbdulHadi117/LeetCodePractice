import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    /*
     * Checks if a given string is a valid parentheses sequence.
     * The string is valid if every open parenthesis can be matched to a corresponding close parenthesis,
     * and no parentheses are left unmatched.
     * 
     @ param s the string to be checked
     $ return true if the string is a valid parentheses sequence, false otherwise
     */
    public boolean isValid(String s) {
        // Create a mapping of open to close parentheses
        Map<Character,Character> mapping = new HashMap<>();
        mapping.put('(',')');
        mapping.put('{','}');
        mapping.put('[',']');

        // Create a stack to keep track of the opening parentheses
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            // If the current character is an opening parenthesis, push it to the stack
            if (mapping.containsKey(c)){
                stack.push(mapping.get(c));
            }else{
                // If the current character is a closing parenthesis, check if it matches the top of the stack
                if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        // After iterating through the entire string, the stack should be empty if the string is valid
        return stack.isEmpty();
    }
}