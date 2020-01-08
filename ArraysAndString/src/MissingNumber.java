import java.util.HashSet;
import java.util.Set;

/*
Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
find the one that is missing from the array.
Note:
Your algorithm should run in linear runtime complexity.
Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums){
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums){
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;

        for (int i = 0; i < expectedNumCount; i++){
            if (!numSet.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
