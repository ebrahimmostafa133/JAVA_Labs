import java.util.function.Predicate;

class StringChecker {
    
    public static boolean isAlphabetic(String word, Predicate<String> predicate) {
        return predicate.test(word);
    }
    
    public static void main(String[] args) {
        Predicate<String> alphabeticCheck = (s) -> {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        };
        
        // Test strings
        String word1 = "Hello";
        String word2 = "Hello123";
        String word3 = "HelloWorld";
        String word4 = "Hello World";
        String word5 = "12345";
        
        System.out.println("Testing strings:\n");
        
        System.out.println("\"" + word1 + "\" is alphabetic? " + isAlphabetic(word1, alphabeticCheck));
        System.out.println("\"" + word2 + "\" is alphabetic? " + isAlphabetic(word2, alphabeticCheck));
        System.out.println("\"" + word3 + "\" is alphabetic? " + isAlphabetic(word3, alphabeticCheck));
        System.out.println("\"" + word4 + "\" is alphabetic? " + isAlphabetic(word4, alphabeticCheck));
        System.out.println("\"" + word5 + "\" is alphabetic? " + isAlphabetic(word5, alphabeticCheck));
    }
}
