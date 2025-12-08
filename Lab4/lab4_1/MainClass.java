public class MainClass {
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
