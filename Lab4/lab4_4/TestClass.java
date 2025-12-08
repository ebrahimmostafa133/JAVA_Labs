import java.util.ArrayList;

// 1. Base class with abstract method
abstract class Shape {
    abstract void draw();
}

// 2. First concrete class
class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// 3. Second concrete class
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

// 4. Test class with generic method
class TestClass {
    
    // Generic method that accepts only child classes of Shape
    public static <T extends Shape> void drawShapes(ArrayList<T> shapes) {
        for (T shape : shapes) {
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
