import java.util.function.BiPredicate;

class StringUtils {
    
    // Using BiPredicate (no need to create custom interface!)
    public static String betterString(String s1, String s2, BiPredicate<String, String> comparator) {
        if (comparator.test(s1, s2)) {
            return s1;  // return first if lambda returns true
        } else {
            return s2;  // return second if lambda returns false
        }
    }
    
    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "World!";
        
        // Test 1: Return the longer string
        String longer = betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longer);
        
        // Test 2: Return the first string (always true)
        String first = betterString(string1, string2, (s1, s2) -> true);
        System.out.println("First string: " + first);
      
    }
}
