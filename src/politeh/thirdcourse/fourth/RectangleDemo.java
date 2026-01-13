package politeh.thirdcourse.fourth;

import java.util.Scanner;

class Rectangle {
    private double length;
    private double width;
    
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public Rectangle(double side) {
        this.length = side;
        this.width = side;
    }

    public double rect_area(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длины сторон должны быть положительными!");
        }
        return length * width;
    }
    
    public double rect_area(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной!");
        }
        return side * side;
    }
    
    public double rect_area() {
        if (length <= 0 || width <= 0) {
            throw new IllegalStateException("Сначала задайте размеры прямоугольника!");
        }
        return length * width;
    }
    
    public static double rect_area_static(double length, double width) {
        return length * width;
    }
    
    public static double rect_area_static(double side) {
        return side * side;
    }
    
    public void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public void setSquareSide(double side) {
        this.length = side;
        this.width = side;
    }
    
    public double getLength() { return length; }
    public double getWidth() { return width; }
    
    public boolean isSquare() {
        return Math.abs(length - width) < 0.0001;
    }
    
    public void displayInfo() {
        if (isSquare()) {
            System.out.printf("Квадрат со стороной: %.2f\n", length);
        } else {
            System.out.printf("Прямоугольник: %.2f x %.2f\n", length, width);
        }
        System.out.printf("Площадь: %.2f\n", rect_area());
    }
}

class ExtendedRectangle extends Rectangle {
    // Перегруженный метод с тремя параметрами (для параллелепипеда - площадь поверхности)
    public double rect_area(double length, double width, double height) {
        return 2 * (rect_area(length, width) + 
                   rect_area(length, height) + 
                   rect_area(width, height));
    }
    
    public double rect_perimeter() {
        return 2 * (getLength() + getWidth());
    }
    
    public double rect_perimeter(double length, double width) {
        return 2 * (length + width);
    }
    
    public double rect_perimeter(double side) {
        return 4 * side;
    }
}

public class RectangleDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ДЕМОНСТРАЦИЯ ПЕРЕГРУЗКИ МЕТОДОВ ===");
        System.out.println("Класс Rectangle с перегруженным методом rect_area()\n");
        
        Rectangle rect1 = new Rectangle(5, 3);
        Rectangle square1 = new Rectangle(4);
        Rectangle rect2 = new Rectangle();
        
        System.out.println("1. Использование разных версий rect_area():");
        
        System.out.println("   rect_area(5, 3) = " + rect1.rect_area(5, 3));
        
        System.out.println("   rect_area(4) = " + square1.rect_area(4));
        
        System.out.println("   rect1.rect_area() = " + rect1.rect_area());
        System.out.println("   square1.rect_area() = " + square1.rect_area());
        
        System.out.println("\n2. Статические методы:");
        System.out.println("   Rectangle.rect_area_static(6, 2) = " + 
                         Rectangle.rect_area_static(6, 2));
        System.out.println("   Rectangle.rect_area_static(5) = " + 
                         Rectangle.rect_area_static(5));
        
        System.out.println("\n3. Полиморфизм:");
        Rectangle[] shapes = new Rectangle[3];
        shapes[0] = new Rectangle(3, 4);
        shapes[1] = new Rectangle(5); // квадрат
        shapes[2] = new Rectangle(2.5, 6);
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("   Фигура %d: ", i+1);
            shapes[i].displayInfo();
        }
        
        System.out.println("\n4. Расширенный класс ExtendedRectangle:");
        ExtendedRectangle extRect = new ExtendedRectangle();
        extRect.setDimensions(3, 4);
        
        System.out.println("   Площадь: " + extRect.rect_area());
        System.out.println("   Периметр: " + extRect.rect_perimeter());
        System.out.println("   Площадь поверхности параллелепипеда 3x4x5: " + 
                         extRect.rect_area(3, 4, 5));
        
        System.out.println("\n=== ИНТЕРАКТИВНЫЙ РЕЖИМ ===");
        System.out.println("Выберите тип фигуры:");
        System.out.println("1. Прямоугольник");
        System.out.println("2. Квадрат");
        System.out.print("Ваш выбор: ");
        
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            System.out.print("Введите длину: ");
            double length = scanner.nextDouble();
            System.out.print("Введите ширину: ");
            double width = scanner.nextDouble();
            
            if (length <= 0 || width <= 0) {
                System.out.println("Ошибка: размеры должны быть положительными!");
            } else {
                Rectangle userRect = new Rectangle(length, width);
                System.out.printf("\nПрямоугольник %.2f x %.2f:\n", length, width);
                System.out.printf("Площадь: %.2f\n", userRect.rect_area());
                
                System.out.printf("Площадь (через метод с параметрами): %.2f\n",
                                userRect.rect_area(length, width));
            }
            
        } else if (choice == 2) {
            System.out.print("Введите длину стороны: ");
            double side = scanner.nextDouble();
            
            if (side <= 0) {
                System.out.println("Ошибка: длина стороны должна быть положительной!");
            } else {
                Rectangle userSquare = new Rectangle(side);
                System.out.printf("\nКвадрат со стороной %.2f:\n", side);
                System.out.printf("Площадь: %.2f\n", userSquare.rect_area());
                
                System.out.printf("Площадь (через метод с одним параметром): %.2f\n",
                                userSquare.rect_area(side));
                System.out.printf("Площадь (через метод с двумя параметрами): %.2f\n", 
                                userSquare.rect_area(side, side));
            }
        }
        
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");
        
        Rectangle multiPurpose = new Rectangle();
        
        System.out.println("Один объект, разные вызовы:");
        System.out.println("1. rect_area(7, 2) = " + multiPurpose.rect_area(7, 2));
        System.out.println("2. rect_area(6) = " + multiPurpose.rect_area(6));
        
        multiPurpose.setDimensions(8, 3);
        System.out.println("3. После setDimensions(8, 3):");
        System.out.println("   rect_area() = " + multiPurpose.rect_area());
        
        multiPurpose.setSquareSide(5);
        System.out.println("4. После setSquareSide(5):");
        System.out.println("   rect_area() = " + multiPurpose.rect_area());
        System.out.println("   Это квадрат? " + multiPurpose.isSquare());
        
        scanner.close();
    }
}