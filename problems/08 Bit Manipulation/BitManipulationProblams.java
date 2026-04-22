public class BitManipulationProblams {
    
    // 1. Check if number is odd or even
    // Logic: Last bit is 1 for odd, 0 for even
    public static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
    
    // 2. Check if number is power of 2
    // Logic: Power of 2 has only one set bit
    // Example: 8 = 1000, 8-1 = 0111, 1000 & 0111 = 0
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    // 3. Count set bits (number of 1s)
    // Method 1: Check each bit
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    
    // Method 2: Brian Kernighan's Algorithm (faster)
    // Logic: n & (n-1) removes rightmost set bit
    public static int countSetBitsFast(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
    // 4. Swap two numbers without temp variable
    public static void swap(int a, int b) {
        System.out.println("Before: a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After: a=" + a + ", b=" + b);
    }
    
    // 5. Find unique element (all others appear twice)
    // Logic: XOR of two same numbers is 0, XOR with 0 gives number itself
    public static int findUnique(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
    
    // 6. Find two unique elements (all others appear twice)
    // Logic: XOR all, find rightmost set bit, divide into two groups
    public static void findTwoUnique(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        
        // Find rightmost set bit
        int rightmostBit = xor & (-xor);
        
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & rightmostBit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        System.out.println("Two unique numbers: " + num1 + ", " + num2);
    }
    
    // 7. Reverse bits of a number
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
        }
        return result;
    }
    
    // 8. Find position of rightmost set bit
    // Logic: n & (-n) gives rightmost set bit
    public static int rightmostSetBit(int n) {
        if (n == 0) return -1;
        int pos = 1;
        int bit = n & (-n);
        while ((bit & 1) == 0) {
            bit >>= 1;
            pos++;
        }
        return pos;
    }
    
    // 9. Check if ith bit is set
    public static boolean isBitSet(int n, int i) {
        return (n & (1 << i)) != 0;
    }
    
    // 10. Toggle all bits (flip 0 to 1 and 1 to 0)
    public static int toggleAllBits(int n, int bits) {
        return n ^ ((1 << bits) - 1);
    }
    
    // 11. Clear all bits from MSB to ith bit (inclusive)
    public static int clearBitsMSBtoI(int n, int i) {
        int mask = (1 << i) - 1;
        return n & mask;
    }
    
    // 12. Clear all bits from ith bit to 0 (inclusive)
    public static int clearBitsIto0(int n, int i) {
        int mask = (~0) << (i + 1);
        return n & mask;
    }
    
    // 13. Find XOR from 1 to n (optimized)
    // Pattern: 1, 3, 0, 4, 1, 3, 0, 4...
    public static int xorFrom1ToN(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        return 0;
    }
    
    // 14. Find XOR in range [L, R]
    public static int xorInRange(int L, int R) {
        return xorFrom1ToN(L - 1) ^ xorFrom1ToN(R);
    }
    
    // 15. Multiply by 3.5 without using * or /
    public static int multiplyBy3Point5(int n) {
        return (n << 1) + n + (n >> 1);  // 2n + n + n/2 = 3.5n
    }
    
    // 16. Find missing number in array [0 to n]
    // Logic: XOR all numbers and array elements
    public static int findMissing(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        for (int num : arr) {
            xor ^= num;
        }
        return xor;
    }
    
    // 17. Generate all subsets using bit manipulation
    public static void generateSubsets(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n;  // 2^n
        
        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Bit Manipulation Problems ===\n");
        
        // 1. Odd/Even
        System.out.println("1. Is 5 odd? " + isOdd(5));
        System.out.println("   Is 4 odd? " + isOdd(4));
        
        // 2. Power of 2
        System.out.println("\n2. Is 8 power of 2? " + isPowerOfTwo(8));
        System.out.println("   Is 6 power of 2? " + isPowerOfTwo(6));
        
        // 3. Count set bits
        System.out.println("\n3. Set bits in 7 (0111): " + countSetBits(7));
        System.out.println("   Set bits in 15 (1111): " + countSetBitsFast(15));
        
        // 4. Swap
        System.out.println("\n4. Swap without temp:");
        swap(10, 20);
        
        // 5. Find unique
        System.out.println("\n5. Find unique in {2,3,4,2,3}:");
        System.out.println("   Unique: " + findUnique(new int[]{2, 3, 4, 2, 3}));
        
        // 6. Find two unique
        System.out.println("\n6. Find two unique in {2,3,4,5,2,3}:");
        findTwoUnique(new int[]{2, 3, 4, 5, 2, 3});
        
        // 7. Rightmost set bit
        System.out.println("\n7. Rightmost set bit position in 18 (10010): " + rightmostSetBit(18));
        
        // 8. Check if bit is set
        System.out.println("\n8. Is bit 2 set in 5 (0101)? " + isBitSet(5, 2));
        
        // 9. XOR from 1 to n
        System.out.println("\n9. XOR from 1 to 6: " + xorFrom1ToN(6));
        
        // 10. XOR in range
        System.out.println("\n10. XOR in range [3, 7]: " + xorInRange(3, 7));
        
        // 11. Multiply by 3.5
        System.out.println("\n11. 4 * 3.5 = " + multiplyBy3Point5(4));
        
        // 12. Find missing
        System.out.println("\n12. Missing number in {0,1,3,4}: " + findMissing(new int[]{0, 1, 3, 4}, 4));
        
        // 13. Generate subsets
        System.out.println("\n13. All subsets of {1, 2, 3}:");
        generateSubsets(new int[]{1, 2, 3});
    }
}
