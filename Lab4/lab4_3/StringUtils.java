import java.util.function.BiPredicate;

class StringUtils {
    
    public static String selectString(String str1, String str2, BiPredicate<String, String> condition) {
        if (condition.test(str1, str2)) {
            return str1;  
        } else {
            return str2;  
        }
    }
    
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World!";
        
        String longerString = selectString(str1, str2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longerString);
        
        String firstString = selectString(str1, str2, (s1, s2) -> true);
        System.out.println("First string: " + firstString);
    }
}
