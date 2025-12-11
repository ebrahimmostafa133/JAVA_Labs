package utilities;

// Implements requirement 2
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
    
    // Helper method to trigger the exception/print the error
    public void trigger() throws ItemNotFoundException {
        throw this;
    }
}