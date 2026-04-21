public class BitWiseOperator {
    
    // 1. AND Operator (&)
    // Returns 1 if both bits are 1, otherwise 0
    // Example: 5 & 3 = 0101 & 0011 = 0001 = 1
    // Trick: Check if number is even/odd -> (n & 1) == 0 means even
    // Trick: Clear specific bit -> n & ~(1 << i)
    public static void andOperator() {
        System.out.println("=== AND Operator (&) ===");
        int a = 5, b = 3;  // 0101 & 0011
        System.out.println(a + " & " + b + " = " + (a & b));
        System.out.println("Binary: 0101 & 0011 = 0001");
        
        // Trick: Check even/odd
        System.out.println("5 is even? " + ((5 & 1) == 0));
        System.out.println("4 is even? " + ((4 & 1) == 0));
    }
    
    // 2. OR Operator (|)
    // Returns 1 if at least one bit is 1, otherwise 0
    // Example: 5 | 3 = 0101 | 0011 = 0111 = 7
    // Trick: Set specific bit -> n | (1 << i)
    // Trick: Combine flags/permissions
    public static void orOperator() {
        System.out.println("\n=== OR Operator (|) ===");
        int a = 5, b = 3;  // 0101 | 0011
        System.out.println(a + " | " + b + " = " + (a | b));
        System.out.println("Binary: 0101 | 0011 = 0111");
        
        // Trick: Set bit at position 1
        int n = 5;  // 0101
        int result = n | (1 << 1);  // Set bit at position 1
        System.out.println("Set bit 1 in 5: " + result + " (binary: 0111)");
    }
    
    // 3. XOR Operator (^)
    // Returns 1 if bits are different, 0 if same
    // Example: 5 ^ 3 = 0101 ^ 0011 = 0110 = 6
    // Trick: Swap without temp -> a^=b; b^=a; a^=b;
    // Trick: Find unique element -> XOR all elements
    // Trick: Toggle bit -> n ^ (1 << i)
    // Property: a ^ a = 0, a ^ 0 = a
    public static void xorOperator() {
        System.out.println("\n=== XOR Operator (^) ===");
        int a = 5, b = 3;  // 0101 ^ 0011
        System.out.println(a + " ^ " + b + " = " + (a ^ b));
        System.out.println("Binary: 0101 ^ 0011 = 0110");
        
        // Trick: Swap without temp
        int x = 10, y = 20;
        System.out.println("\nBefore swap: x=" + x + ", y=" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("After swap: x=" + x + ", y=" + y);
        
        // Trick: Find unique element
        int[] arr = {2, 3, 4, 2, 3};
        int unique = 0;
        for (int num : arr) unique ^= num;
        System.out.println("Unique element: " + unique);
    }
    
    // 4. NOT Operator (~)
    // Inverts all bits (1's complement)
    // Example: ~5 = ~0101 = 1010 (in 32-bit: -6)
    // Trick: ~n = -(n+1)
    // Trick: Clear bit -> n & ~(1 << i)
    public static void notOperator() {
        System.out.println("\n=== NOT Operator (~) ===");
        int a = 5;  // 0101
        System.out.println("~" + a + " = " + (~a));
        System.out.println("Binary: ~0101 = 1010 (2's complement: -6)");
        System.out.println("Formula: ~n = -(n+1)");
    }
    
    // 5. Left Shift (<<)
    // Shifts bits to left, fills with 0 from right
    // Example: 5 << 2 = 0101 << 2 = 10100 = 20
    // Trick: n << k = n * 2^k (multiply by power of 2)
    // Trick: Fast multiplication by 2, 4, 8, etc.
    public static void leftShiftOperator() {
        System.out.println("\n=== Left Shift (<<) ===");
        int a = 5;  // 0101
        System.out.println(a + " << 1 = " + (a << 1) + " (multiply by 2)");
        System.out.println(a + " << 2 = " + (a << 2) + " (multiply by 4)");
        System.out.println(a + " << 3 = " + (a << 3) + " (multiply by 8)");
        System.out.println("Binary: 0101 << 2 = 10100");
        System.out.println("Formula: n << k = n * 2^k");
    }
    
    // 6. Right Shift (>>)
    // Shifts bits to right, fills with sign bit from left
    // Example: 20 >> 2 = 10100 >> 2 = 00101 = 5
    // Trick: n >> k = n / 2^k (divide by power of 2)
    // Trick: Fast division by 2, 4, 8, etc.
    public static void rightShiftOperator() {
        System.out.println("\n=== Right Shift (>>) ===");
        int a = 20;  // 10100
        System.out.println(a + " >> 1 = " + (a >> 1) + " (divide by 2)");
        System.out.println(a + " >> 2 = " + (a >> 2) + " (divide by 4)");
        System.out.println("Binary: 10100 >> 2 = 00101");
        System.out.println("Formula: n >> k = n / 2^k");
        
        // Negative number
        int neg = -8;
        System.out.println("\n" + neg + " >> 1 = " + (neg >> 1) + " (sign preserved)");
    }
    
    // 7. Unsigned Right Shift (>>>)
    // Shifts bits to right, fills with 0 from left (ignores sign)
    // Example: -8 >>> 1 fills with 0, not sign bit
    // Trick: Used for logical shift (no sign extension)
    public static void unsignedRightShiftOperator() {
        System.out.println("\n=== Unsigned Right Shift (>>>) ===");
        int a = -8;
        System.out.println(a + " >> 1 = " + (a >> 1) + " (signed)");
        System.out.println(a + " >>> 1 = " + (a >>> 1) + " (unsigned)");
        System.out.println("Difference: >>> fills with 0, >> fills with sign bit");
    }
    
    // Common Bit Manipulation Tricks
    public static void commonTricks() {
        System.out.println("\n=== Common Bit Tricks ===");
        
        int n = 12;  // 1100
        
        // Check if power of 2
        boolean isPowerOf2 = (n & (n - 1)) == 0 && n != 0;
        System.out.println(n + " is power of 2? " + isPowerOf2);
        
        // Count set bits (1s)
        int count = 0, temp = n;
        while (temp > 0) {
            count += temp & 1;
            temp >>= 1;
        }
        System.out.println("Set bits in " + n + ": " + count);
        
        // Get ith bit
        int i = 2;
        int bit = (n >> i) & 1;
        System.out.println("Bit at position " + i + ": " + bit);
        
        // Set ith bit
        int setBit = n | (1 << i);
        System.out.println("Set bit at position " + i + ": " + setBit);
        
        // Clear ith bit
        int clearBit = n & ~(1 << i);
        System.out.println("Clear bit at position " + i + ": " + clearBit);
        
        // Toggle ith bit
        int toggleBit = n ^ (1 << i);
        System.out.println("Toggle bit at position " + i + ": " + toggleBit);
        
        // Remove last set bit
        int removeLast = n & (n - 1);
        System.out.println("Remove last set bit: " + removeLast);
        
        // Get last set bit
        int lastSet = n & (-n);
        System.out.println("Get last set bit: " + lastSet);
    }
    
    public static void main(String[] args) {
        andOperator();
        orOperator();
        xorOperator();
        notOperator();
        leftShiftOperator();
        rightShiftOperator();
        unsignedRightShiftOperator();
        commonTricks();
    }
}
