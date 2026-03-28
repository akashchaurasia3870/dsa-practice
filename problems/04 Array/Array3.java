public class Array3 {
    
    // 1. ITERATIVE BINARY SEARCH - O(log n)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not found
    }
    
    // 2. RECURSIVE BINARY SEARCH - O(log n)
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearchHelper(arr, target, mid + 1, right);
        else return binarySearchHelper(arr, target, left, mid - 1);
    }
    
    // 3. FIRST OCCURRENCE (leftmost)
    public static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // 4. LAST OCCURRENCE (rightmost)
    public static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // 5. COUNT OCCURRENCES
    public static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0;
        int last = lastOccurrence(arr, target);
        return last - first + 1;
    }
    
    // 6. FLOOR (largest element <= target)
    public static int floor(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] <= target) {
                result = arr[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    // 7. CEILING (smallest element >= target)
    public static int ceiling(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= target) {
                result = arr[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    // 8. SEARCH IN ROTATED SORTED ARRAY
    public static int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) return mid;
            
            // Left half sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    
    // 9. FIND PEAK ELEMENT
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    // 10. SQUARE ROOT (integer part)
    public static int sqrt(int x) {
        if (x < 2) return x;
        
        int left = 1, right = x / 2;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            
            if (square == x) return mid;
            else if (square < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test 1: Basic Binary Search
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Binary Search (7): " + binarySearch(arr1, 7)); // 3
        System.out.println("Recursive Search (11): " + binarySearchRecursive(arr1, 11)); // 5
        
        // Test 2: First and Last Occurrence
        int[] arr2 = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("First occurrence (2): " + firstOccurrence(arr2, 2)); // 1
        System.out.println("Last occurrence (2): " + lastOccurrence(arr2, 2)); // 3
        System.out.println("Count (2): " + countOccurrences(arr2, 2)); // 3
        
        // Test 3: Floor and Ceiling
        int[] arr3 = {1, 3, 5, 7, 9};
        System.out.println("Floor (6): " + floor(arr3, 6)); // 5
        System.out.println("Ceiling (6): " + ceiling(arr3, 6)); // 7
        
        // Test 4: Rotated Array
        int[] arr4 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Search in rotated (0): " + searchRotated(arr4, 0)); // 4
        
        // Test 5: Peak Element
        int[] arr5 = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak element index: " + findPeak(arr5)); // 2
        
        // Test 6: Square Root
        System.out.println("Sqrt(16): " + sqrt(16)); // 4
        System.out.println("Sqrt(17): " + sqrt(17)); // 4
    }
}

/*
 * BINARY SEARCH INTERVIEW NOTES:
 * 
 * 1. PREREQUISITES:
 *    - Array MUST be sorted
 *    - Random access required (arrays, not linked lists)
 * 
 * 2. TIME COMPLEXITY: O(log n)
 *    - Each iteration cuts search space in half
 *    - log₂(1000000) ≈ 20 comparisons
 * 
 * 3. SPACE COMPLEXITY:
 *    - Iterative: O(1)
 *    - Recursive: O(log n) due to call stack
 * 
 * 4. COMMON MISTAKES:
 *    - mid = (left + right) / 2 → Can overflow!
 *    - Use: mid = left + (right - left) / 2
 *    - Condition: while (left <= right) not (left < right)
 *    - Update: left = mid + 1, right = mid - 1
 * 
 * 5. VARIATIONS:
 *    - First/Last occurrence (duplicates)
 *    - Floor/Ceiling (closest values)
 *    - Rotated sorted array
 *    - Peak element
 *    - Search in 2D matrix
 *    - Find minimum in rotated array
 * 
 * 6. WHEN TO USE BINARY SEARCH:
 *    - "Find in sorted array"
 *    - "Find minimum/maximum satisfying condition"
 *    - "Search space can be divided"
 *    - Answer space problems (sqrt, allocate pages)
 * 
 * 7. TEMPLATE:
 *    while (left <= right) {
 *        mid = left + (right - left) / 2;
 *        if (condition) return mid;
 *        else if (go_right) left = mid + 1;
 *        else right = mid - 1;
 *    }
 * 
 * 8. INTERVIEW TIPS:
 *    - Always mention O(log n) complexity
 *    - Discuss overflow prevention
 *    - Handle edge cases (empty, single element)
 *    - Prefer iterative over recursive (space)
 */
