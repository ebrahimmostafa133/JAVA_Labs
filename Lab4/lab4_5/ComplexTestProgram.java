// Generic class for Complex Numbers
class GenericComplex<T extends Number> {

    private T realPart;
    private T imaginaryPart;

    public GenericComplex(T realPart, T imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Addition Method
    public GenericComplex<Double> addComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue() + otherNumber.realPart.doubleValue();
        double resultImaginary = this.imaginaryPart.doubleValue() + otherNumber.imaginaryPart.doubleValue();
        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Subtraction Method
    public GenericComplex<Double> subtractComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue() - otherNumber.realPart.doubleValue();
        double resultImaginary = this.imaginaryPart.doubleValue() - otherNumber.imaginaryPart.doubleValue();
        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Multiplication Method
    public GenericComplex<Double> multiplyComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue() * otherNumber.realPart.doubleValue()
                          - this.imaginaryPart.doubleValue() * otherNumber.imaginaryPart.doubleValue();

        double resultImaginary = this.realPart.doubleValue() * otherNumber.imaginaryPart.doubleValue()
                               + this.imaginaryPart.doubleValue() * otherNumber.realPart.doubleValue();

        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Display Method
    public void printComplexNumber() {
        System.out.println(realPart + " + " + imaginaryPart + "i");
    }
}

// Test Class
public class ComplexTestProgram {
    public static void main(String[] args) {

        GenericComplex<Integer> firstComplex = new GenericComplex<>(3, 2);
        GenericComplex<Integer> secondComplex = new GenericComplex<>(1, 4);

        System.out.println("First Complex Number:");
        firstComplex.printComplexNumber();

        System.out.println("\nSecond Complex Number:");
        secondComplex.printComplexNumber();

        // Addition
        System.out.println("\nAddition Result:");
        GenericComplex<Double> sumResult = firstComplex.addComplex(secondComplex);
        sumResult.printComplexNumber();

        // Subtraction
        System.out.println("\nSubtraction Result:");
        GenericComplex<Double> subtractionResult = firstComplex.subtractComplex(secondComplex);
        subtractionResult.printComplexNumber();

        // Multiplication
        System.out.println("\nMultiplication Result:");
        GenericComplex<Double> multiplicationResult = firstComplex.multiplyComplex(secondComplex);
        multiplicationResult.printComplexNumber();
    }
}
