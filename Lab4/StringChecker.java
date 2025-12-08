import java.util.function.Predicate;

class StringChecker {
    
    // Method that checks if string contains only alphabets using lambda
    public static boolean containsOnlyAlphabets(String str, Predicate<String> checker) {
        return checker.test(str);
    }
    
    public static void main(String[] args) {
        // Lambda that checks if all characters are letters
        Predicate<String> isAllLetters = (s) -> {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        };
        
        // Test cases
        String test1 = "Hello";
        String test2 = "Hello123";
        String test3 = "HelloWorld";
        String test4 = "Hello World";
        String test5 = "12345";
        
        System.out.println("Testing strings:\n");
        
        System.out.println("\"" + test1 + "\" contains only alphabets? " + 
                          containsOnlyAlphabets(test1, isAllLetters));
        
        System.out.println("\"" + test2 + "\" contains only alphabets? " + 
                          containsOnlyAlphabets(test2, isAllLetters));
        
        System.out.println("\"" + test3 + "\" contains only alphabets? " + 
                          containsOnlyAlphabets(test3, isAllLetters));
        
        System.out.println("\"" + test4 + "\" contains only alphabets? " + 
                          containsOnlyAlphabets(test4, isAllLetters));
        
        System.out.println("\"" + test5 + "\" contains only alphabets? " + 
                          containsOnlyAlphabets(test5, isAllLetters));
    }
}
