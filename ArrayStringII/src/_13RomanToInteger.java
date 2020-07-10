import java.util.HashMap;
import java.util.Map;

public class _13RomanToInteger {
    // Left to Right pass
    public int romanToInt(String s){
        Map<String, Integer> values = new HashMap<>();
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);

        int sum = 0;
        int i = 0;
        while (i < s.length()){
            // if at least 2 characters remaining and s.substring(i, i + 1) is in the hash map
            // that means it's a 2 digit value
            if (i < s.length() - 1){
                String doubleSymbol = s.substring(i, i + 2);
                if (values.containsKey(doubleSymbol)){
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue; // why use a continue here ? it should be used to jump out of the current while
                }
            }

            // otherwise, it must be the 1 character symbol case
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i++;
        }
        return sum;
    }
}
