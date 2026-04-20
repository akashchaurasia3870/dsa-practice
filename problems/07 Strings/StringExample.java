public class StringExample {
    
    // Check if string is palindrome
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Reverse a string
    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    
    // Count vowels
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
    
    // Check if two strings are anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
    
    // Demonstrate commonly used String functions
    public static void commonStringFunctions() {
        String str = "  Hello World  ";
        
        System.out.println("\n=== Common String Functions ===");
        System.out.println("Original: '" + str + "'");
        
        // length() - Get string length
        System.out.println("Length: " + str.length());
        
        // charAt() - Get character at index
        System.out.println("charAt(2): " + str.charAt(2));
        
        // substring() - Extract substring
        System.out.println("substring(2, 7): " + str.substring(2, 7));
        
        // trim() - Remove leading/trailing spaces
        System.out.println("trim(): '" + str.trim() + "'");
        
        // toLowerCase() / toUpperCase()
        System.out.println("toLowerCase(): " + str.toLowerCase());
        System.out.println("toUpperCase(): " + str.toUpperCase());
        
        // replace() - Replace characters/substring
        System.out.println("replace('o', 'X'): " + str.replace('o', 'X'));
        System.out.println("replace('World', 'Java'): " + str.replace("World", "Java"));
        
        // contains() - Check if contains substring
        System.out.println("contains('World'): " + str.contains("World"));
        
        // startsWith() / endsWith()
        System.out.println("startsWith('  He'): " + str.startsWith("  He"));
        System.out.println("endsWith('ld  '): " + str.endsWith("ld  "));
        
        // indexOf() / lastIndexOf() - Find position
        System.out.println("indexOf('o'): " + str.indexOf('o'));
        System.out.println("lastIndexOf('o'): " + str.lastIndexOf('o'));
        
        // split() - Split string into array
        String sentence = "Java,Python,C++,JavaScript";
        String[] languages = sentence.split(",");
        System.out.println("\nsplit(',') on '" + sentence + "':");
        for (String lang : languages) {
            System.out.println("  - " + lang);
        }
        
        // equals() / equalsIgnoreCase() - Compare strings
        String s1 = "Hello";
        String s2 = "hello";
        System.out.println("\n'Hello' equals 'hello': " + s1.equals(s2));
        System.out.println("'Hello' equalsIgnoreCase 'hello': " + s1.equalsIgnoreCase(s2));
        
        // compareTo() - Lexicographic comparison
        System.out.println("'Apple' compareTo 'Banana': " + "Apple".compareTo("Banana"));
        
        // isEmpty() / isBlank()
        System.out.println("\n''.isEmpty(): " + "".isEmpty());
        System.out.println("'   '.isBlank(): " + "   ".isBlank());
        
        // concat() - Concatenate strings
        System.out.println("\n'Hello'.concat(' World'): " + "Hello".concat(" World"));
        
        // valueOf() - Convert to String
        System.out.println("String.valueOf(123): " + String.valueOf(123));
        System.out.println("String.valueOf(true): " + String.valueOf(true));
        
        // toCharArray() - Convert to char array
        char[] chars = "Hello".toCharArray();
        System.out.println("\ntoCharArray():");
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        String str = "racecar";
        
        System.out.println("String: " + str);
        System.out.println("Is Palindrome: " + isPalindrome(str));
        System.out.println("Reversed: " + reverse(str));
        System.out.println("Vowel Count: " + countVowels(str));
        
        System.out.println("\nAnagram Check:");
        System.out.println("listen & silent: " + isAnagram("listen", "silent"));
        System.out.println("hello & world: " + isAnagram("hello", "world"));
        
        // Demonstrate common String functions
        commonStringFunctions();
    }
}
