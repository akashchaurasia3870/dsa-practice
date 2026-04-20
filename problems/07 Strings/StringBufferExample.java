public class StringBufferExample {
    
    public static void main(String[] args) {
        // Creating StringBuffer
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Initial: " + sb);
        
        // append() - Add to end (thread-safe)
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
        
        // Thread-safety demonstration
        System.out.println("\n--- Thread-Safety Test ---");
        threadSafetyTest();
    }
    
    // Demonstrate thread-safety of StringBuffer
    public static void threadSafetyTest() {
        StringBuffer sb = new StringBuffer();
        
        // Create multiple threads appending to same StringBuffer
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("A");
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                sb.append("B");
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final length: " + sb.length());
        System.out.println("Expected: 2000, Actual: " + sb.length());
        System.out.println("Thread-safe: " + (sb.length() == 2000));
    }
}
