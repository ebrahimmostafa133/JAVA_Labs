import java.util.function.Function;

public class lab3_1 {
    public static void main(String[] args) {

        Function<Double, Double> f = c -> (c * 9 / 5) + 32;
        //equal to double convert(double c) { return (c * 9 / 5) + 32; }
        System.out.println("Fahrenheit: " + f.apply(29.0));
    }
}

