import java.util.function.BiFunction;
import java.util.function.Function;

public class lab3_2 {

/*
  public class Discriminant {
    double a, b, c;

      public Discriminant(double a, double b, double c) {
          this.a = a;
          this.b = b;6
          
          this.c = c;
      }
  }

  public class RootInput {
      double a;
      double b;
      double discriminant;

      public RootInput(double a, double b, double discriminant) {
          this.a = a;
          this.b = b;
          this.discriminant = discriminant;
      }
  }
*/


    public static void main(String[] args) {

        double a = 1;
        double b = -3;
        double c = 2;

        // Function to compute the discriminant: b² - 4ac
        Function<double[], Double> discriminant =
                values ->  (values[1] * values[1]) - (4 * values[0] * values[2]);
        double d = discriminant.apply(new double[]{a, b, c});


      

        BiFunction<Double, Double, Double> root1 =
                (bb, aa) -> (-bb + Math.sqrt(d)) / (2 * aa);
        BiFunction<Double, Double, Double> root2 =
                (bb, aa) -> (-bb - Math.sqrt(d)) / (2 * aa);

        if (d < 0) {
            System.out.println("No real roots.");
        } else {
            double x1 = root1.apply(b, a);
            double x2 = root2.apply(b, a);

            System.out.println("Root 1 = " + x1);
            System.out.println("Root 2 = " + x2);
        }
    }
}

