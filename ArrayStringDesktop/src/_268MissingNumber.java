import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _268MissingNumber {
    // Approach 1 sort
    public int missingNumberI(int[] nums){
        Arrays.sort(nums);

        // 2 edge case
        if (nums[nums.length - 1] != nums.length)
            return nums.length;
        else if (nums[0] != 0)
            return 0;

        for (int i = 1; i < nums.length; i++){
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum)
                return expectedNum;
        }
        return -1;
    }

    // Approach 2 Hash Set
    public int missingNumberII(int[] nums){
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int i = 0; i < expectedNumCount; i++){
            if (!numSet.contains(i))
                return i;
        }
        return -1;
    }

    // Approach 3 bit manipulation
    public int missingNumberIII(int[] nums){
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Approach 4 Gauss Formula
    public int missingNumberIV(int[] nums){
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums)
            actualSum += num;

        return expectedSum - actualSum;
    }
}
