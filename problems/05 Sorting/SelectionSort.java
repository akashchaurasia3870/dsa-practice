public class SelectionSort {
    
    // Selection Sort - O(n²)
    // Find minimum element and place it at the beginning
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap minimum element with first element of unsorted portion
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        
        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        
        selectionSort(arr);
        
        System.out.println("After Selection Sort: " + java.util.Arrays.toString(arr));
    }
}
