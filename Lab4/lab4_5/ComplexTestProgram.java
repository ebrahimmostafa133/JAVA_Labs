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
