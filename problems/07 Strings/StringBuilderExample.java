public class StringBuilderExample {
    
    public static void main(String[] args) {
        // Creating StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Initial: " + sb);
        
        // append() - Add to end
        sb.append(" World");
        System.out.println("After append: " + sb);
        
        // insert() - Add at specific position
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);
        
        // replace() - Replace substring
        sb.replace(0, 5, "Hi");
        System.out.println("After replace: " + sb);
        
        // delete() - Remove substring
        sb.delete(2, 3);
        System.out.println("After delete: " + sb);
        
        // reverse() - Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // charAt() - Get character at index
        System.out.println("Char at 0: " + sb.charAt(0));
        
        // setCharAt() - Set character at index
        sb.setCharAt(0, 'W');
        System.out.println("After setCharAt: " + sb);
        
        // length() and capacity()
        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
        
        // Convert to String
        String result = sb.toString();
        System.out.println("Final String: " + result);
        
        // Performance comparison
        System.out.println("\n--- Performance Test ---");
        performanceTest();
    }
    
    // Demonstrate performance difference
    public static void performanceTest() {
        int n = 10000;
        
        // Using String (slow)
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("String concatenation: " + (end - start) + "ms");
        
        // Using StringBuilder (fast)
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder append: " + (end - start) + "ms");
    }
}
