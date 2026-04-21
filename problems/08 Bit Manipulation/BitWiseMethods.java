public class BitWiseMethods {
    
    // GET ith BIT
    // Purpose: Check if bit at position i is 0 or 1
    // Method: 
    //   1. Create bit mask: 1 << i (shifts 1 to position i)
    //   2. AND with number: n & (1 << i)
    //   3. Right shift result: (n & (1 << i)) >> i OR check if != 0
    // 
    // Example: Get 2nd bit of 5 (binary: 0101)
    //   Step 1: 1 << 2 = 0100 (bit mask)
    //   Step 2: 0101 & 0100 = 0100
    //   Step 3: 0100 >> 2 = 0001 = 1
    //   Result: Bit at position 2 is 1
    public static int getBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    // Alternative: Direct approach
    public static int getBitDirect(int n, int i) {
        return (n >> i) & 1;
    }
    
    // SET ith BIT
    // Purpose: Set bit at position i to 1 (if it's 0, make it 1)
    // Method:
    //   1. Create bit mask: 1 << i
    //   2. OR with number: n | (1 << i)
    // 
    // Example: Set 1st bit of 5 (binary: 0101)
    //   Step 1: 1 << 1 = 0010 (bit mask)
    //   Step 2: 0101 | 0010 = 0111 = 7
    //   Result: 5 becomes 7
    // 
    // Why OR? Because:
    //   - If bit is 0: 0 | 1 = 1 (sets to 1)
    //   - If bit is 1: 1 | 1 = 1 (remains 1)
    public static int setBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }
    
    // CLEAR ith BIT
    // Purpose: Clear bit at position i to 0 (if it's 1, make it 0)
    // Method:
    //   1. Create bit mask: 1 << i
    //   2. Invert bit mask: ~(1 << i) - all bits 1 except position i
    //   3. AND with number: n & ~(1 << i)
    // 
    // Example: Clear 2nd bit of 5 (binary: 0101)
    //   Step 1: 1 << 2 = 0100 (bit mask)
    //   Step 2: ~0100 = 1011 (inverted mask)
    //   Step 3: 0101 & 1011 = 0001 = 1
    //   Result: 5 becomes 1
    // 
    // Why AND with inverted mask?
    //   - If bit is 1: 1 & 0 = 0 (clears to 0)
    //   - If bit is 0: 0 & 0 = 0 (remains 0)
    //   - Other bits: x & 1 = x (unchanged)
    public static int clearBit(int n, int i) {
        int bitMask = 1 << i;
        return n & (~bitMask);
    }
    
    // TOGGLE ith BIT
    // Purpose: Flip bit at position i (0→1 or 1→0)
    // Method:
    //   1. Create bit mask: 1 << i
    //   2. XOR with number: n ^ (1 << i)
    // 
    // Example: Toggle 1st bit of 5 (binary: 0101)
    //   Step 1: 1 << 1 = 0010
    //   Step 2: 0101 ^ 0010 = 0111 = 7
    public static int toggleBit(int n, int i) {
        int bitMask = 1 << i;
        return n ^ bitMask;
    }
    
    // UPDATE ith BIT
    // Purpose: Update bit at position i to specific value (0 or 1)
    // Method:
    //   1. Clear the bit first: n & ~(1 << i)
    //   2. Set to new value: result | (newBit << i)
    public static int updateBit(int n, int i, int newBit) {
        n = clearBit(n, i);  // Clear bit first
        int bitMask = newBit << i;
        return n | bitMask;  // Set to new value
    }
    
    // Helper: Print binary representation
    public static void printBinary(int n, String label) {
        System.out.println(label + n + " (binary: " + Integer.toBinaryString(n) + ")");
    }
    
    public static void main(String[] args) {
        int n = 5;  // Binary: 0101
        
        System.out.println("Original number: " + n + " (binary: 0101)\n");
        
        // GET ith BIT
        System.out.println("=== GET ith BIT ===");
        System.out.println("Get bit at position 0: " + getBit(n, 0));
        System.out.println("Get bit at position 1: " + getBit(n, 1));
        System.out.println("Get bit at position 2: " + getBit(n, 2));
        System.out.println("Get bit at position 3: " + getBit(n, 3));
        System.out.println("Binary: 0101 → positions [3][2][1][0]");
        
        // SET ith BIT
        System.out.println("\n=== SET ith BIT ===");
        printBinary(n, "Original: ");
        int afterSet = setBit(n, 1);
        printBinary(afterSet, "After setting bit 1: ");
        System.out.println("Explanation: 0101 | 0010 = 0111");
        
        // CLEAR ith BIT
        System.out.println("\n=== CLEAR ith BIT ===");
        printBinary(n, "Original: ");
        int afterClear = clearBit(n, 2);
        printBinary(afterClear, "After clearing bit 2: ");
        System.out.println("Explanation: 0101 & ~0100 = 0101 & 1011 = 0001");
        
        // TOGGLE ith BIT
        System.out.println("\n=== TOGGLE ith BIT ===");
        printBinary(n, "Original: ");
        int afterToggle = toggleBit(n, 1);
        printBinary(afterToggle, "After toggling bit 1: ");
        System.out.println("Explanation: 0101 ^ 0010 = 0111");
        
        // UPDATE ith BIT
        System.out.println("\n=== UPDATE ith BIT ===");
        printBinary(n, "Original: ");
        int afterUpdate = updateBit(n, 2, 0);
        printBinary(afterUpdate, "After updating bit 2 to 0: ");
        
        // Practical Example
        System.out.println("\n=== PRACTICAL EXAMPLE ===");
        int num = 10;  // 1010
        System.out.println("Number: " + num + " (binary: 1010)");
        System.out.println("Bit 0: " + getBit(num, 0) + " (rightmost)");
        System.out.println("Bit 1: " + getBit(num, 1));
        System.out.println("Bit 2: " + getBit(num, 2));
        System.out.println("Bit 3: " + getBit(num, 3) + " (leftmost)");
    }
}
