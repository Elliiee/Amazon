public class _11ContainerWithMostWater {
    // Approach 1 Brute Force
    // Simply consider every possible pair of lines and find the max.
    public int maxArea(int[] height){
        int maxArea = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return maxArea;
    } // O(n*n); O(1)

    // Approach 2 Two Pointers
    public int maxAreaII(int[] height){
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    } // O(N); O(1)
}
