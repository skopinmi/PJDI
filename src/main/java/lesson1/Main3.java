package lesson1;

//круг, квадрат, треугольник.

import java.awt.*;

public class Main3 {

    abstract class Shape {
        int height;
        int width;

        public double getArea() {
            return height * width;
        }
    }

    class Triangle extends Shape{

        @Override
        public double getArea() {
            return 0.5 * height * width;
        }
    }

    class Square  extends Shape{

    }

    class Circle  extends Shape{
        // in circle height = width
        @Override
        public double getArea() {
            return Math.PI * Math.sqrt(height) / 4;
        }
    }
}
