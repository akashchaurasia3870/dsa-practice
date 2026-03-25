public class Factorial_3 {
    public static long factorial(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // 120
        System.out.println(factorial(0));  // 1
        System.out.println(factorial(7));  // 5040
    }
}
