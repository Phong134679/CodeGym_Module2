import com.codegym.Circle;
import com.codegym.Rectangle;
import com.codegym.Shape;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(2, 3),
                new Circle(2, "red", false)
        };

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i]);
        }
    }
}