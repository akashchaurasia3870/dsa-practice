public class SpiralMatrix {
    
    // Print matrix in spiral order
    // Start from outer layer and move inward
    public static void printSpiral(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Print top row (left to right)
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            
            // Print right column (top to bottom)
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // Print bottom row (right to left)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            
            // Print left column (bottom to top)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        
        System.out.println("\nSpiral Order:");
        printSpiral(matrix);
    }
}
