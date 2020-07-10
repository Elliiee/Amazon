public class _238ProductOfArrayExceptSelf {
    // Approach 1 left product * right product
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] answer = new int[n];

        l[0] = 1; // there is no element to the left of index 0, so it's product is 1
        for (int i = 1; i < n; i++){
            l[i] = nums[i-1] * l[i-1];
        }

        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--){
            r[i] = nums[i + 1] * r[i + 1];
        }

        for (int i = 0; i < n; i++){
            answer[i] = l[i] * r[i];
        }

        return answer;
    }

    // Approach 2
    public int[] productExceptSelfII(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++){
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        int r = 1;
        for (int i = n - 1; i >= 0; i--){
            answer[i] = answer[i] * r;
            r = r * nums[i];
        }

        return answer;
    }
}
