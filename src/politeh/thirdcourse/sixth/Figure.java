package politeh.thirdcourse.sixth;

abstract class Figure {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    public void displayInfo() {
        System.out.println(getClass().getSimpleName() + ":");
        System.out.printf("  Площадь: %.2f\n", calculateArea());
        System.out.printf("  Периметр: %.2f\n", calculatePerimeter());
        System.out.println();
    }
}

class Rectangle extends Figure {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }
}

class Circle extends Figure {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public double getRadius() { return radius; }
}

class Trapezium extends Figure {
    private double base1;
    private double base2;
    private double height;
    private double side1;
    private double side2;
    
    public Trapezium(double base1, double base2, double height, double side1, double side2) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }
    
    @Override
    public double calculateArea() {
        return (base1 + base2) * height / 2;
    }
    
    @Override
    public double calculatePerimeter() {
        return base1 + base2 + side1 + side2;
    }

    public double getBase1() { return base1; }
    public double getBase2() { return base2; }
    public double getHeight() { return height; }
}