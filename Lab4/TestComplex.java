// Generic class for Complex Numbers
class ComplexNumber<T extends Number> {
    private T real;
    private T imaginary;
    
    public ComplexNumber(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    // Addition
    public ComplexNumber<Double> add(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() + other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() + other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    
    // Subtraction
    public ComplexNumber<Double> subtract(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() - other.real.doubleValue();
        double newImaginary = this.imaginary.doubleValue() - other.imaginary.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    
    // Multiplication
    public ComplexNumber<Double> multiply(ComplexNumber<T> other) {
        double newReal = this.real.doubleValue() * other.real.doubleValue() - 
                         this.imaginary.doubleValue() * other.imaginary.doubleValue();
        double newImaginary = this.real.doubleValue() * other.imaginary.doubleValue() + 
                              this.imaginary.doubleValue() * other.real.doubleValue();
        return new ComplexNumber<>(newReal, newImaginary);
    }
    
    // Display
    public void display() {
        System.out.println(real + " + " + imaginary + "i");
    }
}

// Test class
class TestComplex {
    public static void main(String[] args) {
        // Create two complex numbers
        ComplexNumber<Integer> c1 = new ComplexNumber<>(3, 2);
        ComplexNumber<Integer> c2 = new ComplexNumber<>(1, 4);
        
        System.out.println("Complex Number 1:");
        c1.display();
        
        System.out.println("\nComplex Number 2:");
        c2.display();
        
        // Addition
        System.out.println("\nAddition:");
        ComplexNumber<Double> sum = c1.add(c2);
        sum.display();
        
        // Subtraction
        System.out.println("\nSubtraction:");
        ComplexNumber<Double> diff = c1.subtract(c2);
        diff.display();
        
        // Multiplication
        System.out.println("\nMultiplication:");
        ComplexNumber<Double> product = c1.multiply(c2);
        product.display();
    }
}
