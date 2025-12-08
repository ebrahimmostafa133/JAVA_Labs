// Generic class for Complex Numbers
public class GenericComplex<T extends Number> {

    private T realPart;
    private T imaginaryPart;

    public GenericComplex(T realPart, T imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    // Addition Method
    public GenericComplex<Double> addComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue()
                          + otherNumber.realPart.doubleValue();

        double resultImaginary = this.imaginaryPart.doubleValue()
                               + otherNumber.imaginaryPart.doubleValue();

        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Subtraction Method
    public GenericComplex<Double> subtractComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue()
                          - otherNumber.realPart.doubleValue();

        double resultImaginary = this.imaginaryPart.doubleValue()
                               - otherNumber.imaginaryPart.doubleValue();

        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Multiplication Method
    public GenericComplex<Double> multiplyComplex(GenericComplex<T> otherNumber) {
        double resultReal = this.realPart.doubleValue()
                          * otherNumber.realPart.doubleValue()
                          - this.imaginaryPart.doubleValue()
                          * otherNumber.imaginaryPart.doubleValue();

        double resultImaginary = this.realPart.doubleValue()
                               * otherNumber.imaginaryPart.doubleValue()
                               + this.imaginaryPart.doubleValue()
                               * otherNumber.realPart.doubleValue();

        return new GenericComplex<>(resultReal, resultImaginary);
    }

    // Display Method
    public void printComplexNumber() {
        System.out.println(realPart + " + " + imaginaryPart + "i");
    }
}
