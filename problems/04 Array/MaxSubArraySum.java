public class MaxSubArraySum {
    
    // Approach 1: Brute Force - O(n³)
    // Check all possible subarrays using three nested loops
    public static int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        // Start point of subarray
        for (int i = 0; i < nums.length; i++) {
            // End point of subarray
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                // Calculate sum from i to j
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    // Approach 2: Optimized Brute Force - O(n²)
    // Calculate sum while iterating, avoid recalculating from scratch
    public static int maxSubArrayOptimized(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        // Start point of subarray
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // End point of subarray, calculate sum incrementally
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    // Approach 3: Kadane's Algorithm - O(n)
    // Dynamic programming: decide at each position to extend or start new subarray
    public static int maxSubArrayKadane(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Either extend existing subarray or start fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("\nApproach 1 - Brute Force O(n³): " + maxSubArrayBruteForce(arr));
        System.out.println("Approach 2 - Optimized O(n²): " + maxSubArrayOptimized(arr));
        System.out.println("Approach 3 - Kadane's Algorithm O(n): " + maxSubArrayKadane(arr));
    }
}
