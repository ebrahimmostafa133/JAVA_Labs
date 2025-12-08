// Custom Exception Class
class OperationException extends Exception {
    public OperationException(String message) {
        super(message);
    }
}

// Class that throws exceptions
class OperationHandler {

    public void performAddition() throws OperationException {
        throw new OperationException("Error during addition operation");
    }

    public void performSubtraction() throws OperationException {
        throw new OperationException("Error during subtraction operation");
    }

    public void performMultiplication() throws OperationException {
        throw new OperationException("Error during multiplication operation");
    }
}

// Main Class
public class ApplicationMain {
    public static void main(String[] args) {

        OperationHandler handler = new OperationHandler();

        try {
            handler.performAddition();
        } catch (OperationException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        System.out.println();

        try {
            handler.performSubtraction();
        } catch (OperationException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }

        System.out.println();

        try {
            handler.performMultiplication();
        } catch (OperationException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
