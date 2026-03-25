public class FunctionExample {

    // Function with no parameter
    static void greet() {
        System.out.println("Hello!");
    }

    // Function with single parameter
    static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Function with multiple parameters
    static int add(int a, int b) {
        return a + b;
    }

    // Function with return value
    static double multiply(double x, double y) {
        return x * y;
    }

    public static void main(String[] args) {
        greet();                          // No parameter
        greetUser("Alice");               // Single parameter
        System.out.println(add(3, 5));    // Multiple parameters → 8
        System.out.println(multiply(2.5, 4)); // Return value → 10.0
    }
}
