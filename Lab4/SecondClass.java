class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

// Throw Exceptions
class FirstClass {
    
    public void method1() throws MyException {
        throw new MyException("Error from method1");
    }
    
    public void method2() throws MyException {
        throw new MyException("Error from method2");
    }
    
    public void method3() throws MyException {
        throw new MyException("Error from method3");
    }
}

class SecondClass {
    public static void main(String[] args) {
        FirstClass obj = new FirstClass();
        
        try {
            obj.method1();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
        
        System.out.println();
        
        try {
            obj.method2();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
        
        System.out.println();
        
        try {
            obj.method3();
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
