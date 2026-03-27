
public class Array1 {
    public static void main(String[] args) {
        // 1. BYTE ARRAY (8-bit, -128 to 127)
        byte[] byteArr = {1, 2, 3, 127, -128};
        byte[] byteArr2 = new byte[5]; // default: 0
        
        // 2. SHORT ARRAY (16-bit, -32768 to 32767)
        short[] shortArr = {100, 200, 32767};
        
        // 3. INT ARRAY (32-bit, most common)
        int[] intArr = {1, 2, 3, 4, 5};
        int[] intArr2 = new int[10]; // default: 0
        
        // 4. LONG ARRAY (64-bit)
        long[] longArr = {1000000L, 2000000L};
        
        // 5. FLOAT ARRAY (32-bit decimal)
        float[] floatArr = {1.5f, 2.5f, 3.14f};
        
        // 6. DOUBLE ARRAY (64-bit decimal)
        double[] doubleArr = {1.5, 2.5, 3.14159};
        
        // 7. CHAR ARRAY (16-bit Unicode)
        char[] charArr = {'a', 'b', 'c'};
        char[] charArr2 = "hello".toCharArray();
        
        // 8. BOOLEAN ARRAY
        boolean[] boolArr = {true, false, true};
        boolean[] boolArr2 = new boolean[3]; // default: false
        
        // INTERVIEW TRICKS
        demonstrateTricks();
    }
    
    static void demonstrateTricks() {
        // TRICK 1: Array length is fixed
        int[] arr = new int[5];
        System.out.println("Length: " + arr.length); // property, not method
        
        // TRICK 2: ArrayIndexOutOfBoundsException
        // arr[5] = 10; // Runtime error!
        
        // TRICK 3: Arrays are objects, stored in heap
        int[] a = {1, 2, 3};
        int[] b = a; // Both reference same array
        b[0] = 99;
        System.out.println(a[0]); // 99 (shallow copy)
        
        // TRICK 4: Anonymous array
        printArray(new int[]{1, 2, 3});
        
        // TRICK 5: Default values
        // int: 0, boolean: false, char: '\u0000', object: null
        
        // TRICK 6: 2D array (jagged allowed)
        int[][] matrix = new int[3][];
        matrix[0] = new int[2];
        matrix[1] = new int[3];
        
        // TRICK 7: Clone creates shallow copy
        int[] original = {1, 2, 3};
        int[] cloned = original.clone();
        cloned[0] = 99;
        System.out.println(original[0]); // Still 1
        
        // TRICK 8: Array covariance (be careful!)
        Object[] objArr = new String[3];
        // objArr[0] = 10; // Compiles but throws ArrayStoreException
    }
    
    static void printArray(int[] arr) {
        for (int val : arr) System.out.print(val + " ");
        System.out.println();
    }
}

/*
 * INTERVIEW NOTES:
 * 
 * 1. MEMORY: Arrays stored in heap, reference in stack
 * 2. SIZE: Fixed at creation, cannot be resized
 * 3. INDEX: 0-based, length-1 is last index
 * 4. TIME COMPLEXITY:
 *    - Access: O(1)
 *    - Search: O(n) unsorted, O(log n) sorted
 *    - Insert/Delete: O(n) (shifting required)
 * 
 * 5. COMMON PITFALLS:
 *    - arr.length (property) vs str.length() (method)
 *    - Null array vs empty array: null vs new int[0]
 *    - Array vs ArrayList: fixed vs dynamic size
 *    - Primitive arrays can't use generics
 * 
 * 6. COMPARISON:
 *    - Use Arrays.equals(arr1, arr2) for content comparison
 *    - == compares references, not content
 * 
 * 7. MULTIDIMENSIONAL:
 *    - int[][] arr = new int[3][4]; // 3 rows, 4 cols
 *    - Java allows jagged arrays (rows with different lengths)
 * 
 * 8. USEFUL METHODS (java.util.Arrays):
 *    - Arrays.sort(arr)
 *    - Arrays.binarySearch(arr, key)
 *    - Arrays.fill(arr, value)
 *    - Arrays.copyOf(arr, newLength)
 *    - Arrays.toString(arr)
 *    - Arrays.equals(arr1, arr2)
 */
