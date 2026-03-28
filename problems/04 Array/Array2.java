public class Array2 {
    private int[] data;
    private int size;
    private int capacity;
    
    // Constructor
    public Array2() {
        capacity = 10;
        data = new int[capacity];
        size = 0;
    }
    
    public Array2(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        size = 0;
    }
    
    // Add element at end - O(1) amortized
    public void add(int value) {
        if (size == capacity) resize();
        data[size++] = value;
    }
    
    // Insert at index - O(n)
    public void insert(int index, int value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == capacity) resize();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }
    
    // Remove by index - O(n)
    public int remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        int removed = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return removed;
    }
    
    // Get element - O(1)
    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return data[index];
    }
    
    // Set element - O(1)
    public void set(int index, int value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        data[index] = value;
    }
    
    // Search - O(n)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }
    
    // Contains - O(n)
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }
    
    // Resize array (double capacity)
    private void resize() {
        capacity *= 2;
        int[] newData = new int[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
    // Reverse array - O(n)
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = data[i];
            data[i] = data[size - 1 - i];
            data[size - 1 - i] = temp;
        }
    }
    
    // Get size
    public int size() {
        return size;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Clear array
    public void clear() {
        size = 0;
    }
    
    // Print array
    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Array2 arr = new Array2(5);
        
        // Add elements
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.print(); // [10, 20, 30, 40]
        
        // Insert
        arr.insert(2, 25);
        arr.print(); // [10, 20, 25, 30, 40]
        
        // Get
        System.out.println("Element at index 2: " + arr.get(2)); // 25
        
        // Set
        arr.set(0, 15);
        arr.print(); // [15, 20, 25, 30, 40]
        
        // Search
        System.out.println("Index of 30: " + arr.indexOf(30)); // 3
        System.out.println("Contains 50: " + arr.contains(50)); // false
        
        // Remove
        arr.remove(1);
        arr.print(); // [15, 25, 30, 40]
        
        // Reverse
        arr.reverse();
        arr.print(); // [40, 30, 25, 15]
        
        // Size
        System.out.println("Size: " + arr.size()); // 4
        
        // Test auto-resize
        Array2 arr2 = new Array2(2);
        for (int i = 1; i <= 5; i++) {
            arr2.add(i * 10);
        }
        arr2.print(); // [10, 20, 30, 40, 50]
    }
}

/*
 * CUSTOM ARRAY IMPLEMENTATION NOTES:
 * 
 * 1. DYNAMIC SIZING:
 *    - Starts with initial capacity
 *    - Doubles when full (amortized O(1) for add)
 * 
 * 2. TIME COMPLEXITIES:
 *    - add(): O(1) amortized
 *    - insert(): O(n)
 *    - remove(): O(n)
 *    - get/set(): O(1)
 *    - search: O(n)
 * 
 * 3. SPACE COMPLEXITY: O(n)
 * 
 * 4. INTERVIEW POINTS:
 *    - Why double capacity? Balance between memory and operations
 *    - Amortized analysis: occasional O(n) resize, but O(1) average
 *    - Trade-off: Array (fast access) vs LinkedList (fast insert/delete)
 * 
 * 5. IMPROVEMENTS POSSIBLE:
 *    - Generic type support: Array2<T>
 *    - Shrink capacity when size drops
 *    - Iterator implementation
 *    - More utility methods (sort, filter, map)
 */
