public class PrefixArraySum {
    
    // Build prefix sum array
    public static int[] buildPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        return prefix;
    }
    
    // Get sum of subarray from index left to right using prefix sum
    // Formula: sum(left, right) = prefix[right] - prefix[left - 1]
    public static int rangeSum(int[] prefix, int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
    
    // Maximum subarray sum using prefix sum - O(n²)
    public static int maxSubArrayUsingPrefix(int[] nums) {
        int[] prefix = buildPrefixSum(nums);
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = rangeSum(prefix, i, j);
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        
        // Build and display prefix sum array
        int[] prefix = buildPrefixSum(arr);
        System.out.println("Prefix Sum: " + java.util.Arrays.toString(prefix));
        
        // Range sum queries
        System.out.println("\nRange Sum [2, 5]: " + rangeSum(prefix, 2, 5));
        System.out.println("Range Sum [0, 3]: " + rangeSum(prefix, 0, 3));
        
        // Maximum subarray sum using prefix
        System.out.println("\nMax Subarray Sum: " + maxSubArrayUsingPrefix(arr));
    }
}
