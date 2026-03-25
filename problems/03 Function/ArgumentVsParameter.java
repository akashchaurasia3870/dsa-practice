public class ArgumentVsParameter {

    //  'a' and 'b' are PARAMETERS (variables in function definition)
    static int add(int a, int b) {
        return a + b;
    }

    //  'name' is a PARAMETER
    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {

        // 10 and 20 are ARGUMENTS (actual values passed during function call)
        int result = add(10, 20);
        System.out.println("Sum: " + result);

        // "Alice" is an ARGUMENT
        greet("Alice");
    }
}

/*
    PARAMETER → Variable in the function definition  → placeholder (formal parameters)
    ARGUMENT  → Actual value passed during function call → real value (actual parameters)

    add(int a, int b)  → a, b are PARAMETERS
    add(10, 20)        → 10, 20 are ARGUMENTS
*/
