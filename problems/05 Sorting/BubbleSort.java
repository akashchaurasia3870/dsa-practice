public class BubbleSort {
    
    // Basic Bubble Sort - O(n²)
    // Repeatedly swap adjacent elements if they are in wrong order
    public static void bubbleSortBasic(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Optimized Bubble Sort - O(n²) worst case, O(n) best case
    // Stop early if array becomes sorted
    public static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }
    
    public static void main(String[] args) {
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original Array: " + java.util.Arrays.toString(arr1));
        
        bubbleSortBasic(arr1);
        System.out.println("After Basic Bubble Sort: " + java.util.Arrays.toString(arr1));
        
        bubbleSortOptimized(arr2);
        System.out.println("After Optimized Bubble Sort: " + java.util.Arrays.toString(arr2));
    }
}
