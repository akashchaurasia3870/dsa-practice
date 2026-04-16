public class Example2D {
    
    // Print 2D array
    public static void print2D(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Search element in 2D array
    public static boolean search(int[][] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == key) {
                    System.out.print("\bFound at (" + i + ", " + j + ")\n");
                    return true;
                }
            }
        }
        return false;
    }
    
    // Find largest element
    public static int findMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }
    
    // Find smallest element
    public static int findMin(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                min = Math.min(min, arr[i][j]);
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 10}
        };
        
        System.out.println("2D Array:");
        print2D(matrix);
        
        System.out.println("\nSearch 5: " + search(matrix, 5));
        System.out.println("Search 10: " + search(matrix, 10));
        
        System.out.println("\nMax: " + findMax(matrix));
        System.out.println("Min: " + findMin(matrix));
    }
}
