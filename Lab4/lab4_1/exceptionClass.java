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

