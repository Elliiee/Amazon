import java.lang.reflect.Array;
import java.util.Arrays;

public class _16ThreeSumClosest {
    // Approach 1 Two Pointers
    // The same technique as 3 Sum
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && diff != 0; i++){
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;

                if (sum < target)
                    lo++;
                else
                    hi--;
            }
        }
        return target - diff;
    }

    // Approach 2 Binary Search

}
