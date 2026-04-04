import com.codegym.Circle;
import com.codegym.Rectangle;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();

        circle = new Circle(3.5);
        System.out.println(circle);

        circle.reSize(1.2);
        System.out.println(circle);


        Rectangle rectangle = new Rectangle();

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle.reSize(1.5);
        System.out.println(rectangle);
    }
}