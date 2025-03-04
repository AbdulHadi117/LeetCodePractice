import java.util.HashMap;
import java.util.Map;
public class Solution {
    /*
     * Convert a Roman numeral string to an integer
     @ param s the Roman numeral string
     $ return the integer value
     */
    public int romanToInt(String s) {
        Map<Character,Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        int ans = 0, prevVal = 0;
        for (int i = s.length()-1; i >=0; i--){
            int currentVal = values.get(s.charAt(i));
            // If the current value is less than the previous value, it should be subtracted
            // instead of added
            if (currentVal < prevVal){ans -= currentVal;}
            else{ans += currentVal;}
            prevVal = currentVal;
        }
        return ans;
    }
}