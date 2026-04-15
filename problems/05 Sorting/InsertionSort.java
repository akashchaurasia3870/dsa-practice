public class InsertionSort {
    
    // Insertion Sort - O(n²) worst case, O(n) best case
    // Build sorted array by inserting elements one at a time
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Shift elements greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        
        System.out.println("Original Array: " + java.util.Arrays.toString(arr));
        
        insertionSort(arr);
        
        System.out.println("After Insertion Sort: " + java.util.Arrays.toString(arr));
    }
}
