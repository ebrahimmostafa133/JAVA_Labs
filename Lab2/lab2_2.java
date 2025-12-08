import java.util.StringTokenizer;

public class lab2_2 {
    public static void main(String[] args) {

        String str = "ITI develops people and ITI house of developers and ITI for people";

        String delimiter = "ITI";
  
        if (str != null && delimiter != null) {
          StringTokenizer tokenizer = new StringTokenizer(str, delimiter);
          while (tokenizer.hasMoreTokens()) {
              System.out.println(tokenizer.nextToken().trim());
          }
      } else {
          System.out.println("String or delimiter is null");
      }

    }
}
