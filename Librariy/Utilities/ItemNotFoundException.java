package Utilities;

// Requirement 2: Custom Exception
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}