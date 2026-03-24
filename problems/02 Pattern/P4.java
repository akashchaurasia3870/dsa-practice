
public class P4 {
    public static void main(String[] args) {
        // char pattern
        int ch = 65;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print((char)(ch)+" ");
                ch++;
            }
            System.out.println();
        }
    }
}
