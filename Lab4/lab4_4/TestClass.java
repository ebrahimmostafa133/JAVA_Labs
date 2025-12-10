import java.util.ArrayList;

public class TestClass {

    // Generic method that accepts only child classes of Shape
    public static void drawShapes(ArrayList <? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {

        // Test 1: ArrayList of Rectangles
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        System.out.println("Test 1: Drawing Rectangles");
        drawShapes(rectangles);

        System.out.println();

        // Test 2: ArrayList of Circles
        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());

        System.out.println("Test 2: Drawing Circles");
        drawShapes(circles);
    }
}
