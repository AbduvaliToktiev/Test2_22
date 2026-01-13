package politeh.thirdcourse.fourth;

import java.util.Scanner;

class Fraction {
    private double numerator;
    private double denominator;
    
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }
    
    public Fraction(double value) {
        this.numerator = value;
        this.denominator = 1;
    }
    
    public Fraction(double numerator, double denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }
    
    public Fraction(String fractionStr) {
        if (fractionStr.contains("/")) {
            String[] parts = fractionStr.split("/");
            this.numerator = Double.parseDouble(parts[0]);
            this.denominator = Double.parseDouble(parts[1]);
            
            if (this.denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть нулем!");
            }
        } else {
            this.numerator = Double.parseDouble(fractionStr);
            this.denominator = 1;
        }
        simplify();
    }
    
    private void simplify() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        
        double gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }
    
    private double gcd(double a, double b) {
        while (Math.abs(b) > 0.0001) {
            double temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public double getNumerator() { return numerator; }
    public double getDenominator() { return denominator; }
    public double getValue() { return numerator / denominator; }

    public Fraction add(Fraction other) {
        double newNumerator = this.numerator * other.denominator + 
                             other.numerator * this.denominator;
        double newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    
    public Fraction add(double number) {
        return add(new Fraction(number));
    }
    
    public Fraction subtract(Fraction other) {
        double newNumerator = this.numerator * other.denominator - 
                             other.numerator * this.denominator;
        double newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    
    public Fraction subtract(double number) {
        return subtract(new Fraction(number));
    }
    
    public Fraction multiply(Fraction other) {
        double newNumerator = this.numerator * other.numerator;
        double newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
    
    public Fraction multiply(double number) {
        return multiply(new Fraction(number));
    }
    
    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        double newNumerator = this.numerator * other.denominator;
        double newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    
    public Fraction divide(double number) {
        return divide(new Fraction(number));
    }
    
    public Fraction prefixIncrement() {
        this.numerator += this.denominator;
        simplify();
        return this;
    }
    
    public Fraction postfixIncrement() {
        Fraction temp = new Fraction(this.numerator, this.denominator);
        this.numerator += this.denominator;
        simplify();
        return temp;
    }
    
    public Fraction prefixDecrement() {
        this.numerator -= this.denominator;
        simplify();
        return this;
    }
    
    public Fraction postfixDecrement() {
        Fraction temp = new Fraction(this.numerator, this.denominator);
        this.numerator -= this.denominator;
        simplify();
        return temp;
    }
    
    public void display() {
        if (Math.abs(denominator - 1) < 0.0001) {
            System.out.printf("%.2f", numerator);
        } else {
            System.out.printf("%.2f/%.2f", numerator, denominator);
        }
    }
    
    @Override
    public String toString() {
        if (Math.abs(denominator - 1) < 0.0001) {
            return String.format("%.2f", numerator);
        } else {
            return String.format("%.2f/%.2f", numerator, denominator);
        }
    }
    
    public String toDecimalString() {
        return String.format("%.4f", getValue());
    }
    
    public static Fraction add(Fraction a, Fraction b) {
        return a.add(b);
    }
    
    public static Fraction subtract(Fraction a, Fraction b) {
        return a.subtract(b);
    }
    
    public static Fraction multiply(Fraction a, Fraction b) {
        return a.multiply(b);
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
        return a.divide(b);
    }
}

public class FractionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== КЛАСС Fraction (ДРОБЬ) ===");
        System.out.println("Примеры использования:\n");
        
        // Пример 1: 3/4 + 2/5
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(2, 5);
        
        System.out.println("1. 3/4 + 2/5:");
        System.out.print("   ");
        f1.display();
        System.out.print(" + ");
        f2.display();
        System.out.print(" = ");
        Fraction sum1 = f1.add(f2);
        sum1.display();
        System.out.println(" ? " + sum1.toDecimalString());
        
        Fraction f3 = new Fraction(1, 2);
        
        System.out.println("\n2. 1/2 + 4:");
        System.out.print("   ");
        f3.display();
        System.out.print(" + 4 = ");
        Fraction sum2 = f3.add(4);
        sum2.display();
        System.out.println(" ? " + sum2.toDecimalString());
        
        Fraction f4 = new Fraction(5, 6);
        
        System.out.println("\n3. 2 * 5/6:");
        System.out.print("   2 * ");
        f4.display();
        System.out.print(" = ");
        Fraction product = f4.multiply(2);
        product.display();
        System.out.println(" ? " + product.toDecimalString());
        
        Fraction f5 = new Fraction(1, 3);
        
        System.out.println("\n4. Инкремент дроби 1/3:");
        System.out.print("   Исходная: ");
        f5.display();
        
        Fraction incPref = f5.prefixIncrement();
        System.out.print("\n   ++(1/3) = ");
        incPref.display();
        System.out.println(" (теперь f5 = " + f5 + ")");
        
        Fraction incPost = f5.postfixIncrement();
        System.out.print("   (1/3)++ = ");
        incPost.display();
        System.out.println(" (теперь f5 = " + f5 + ")");
        
        System.out.println("\n5. Комплексное выражение: (1/2 + 1/3) * (2 - 1/4)");
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 3);
        Fraction c = new Fraction(2);
        Fraction d = new Fraction(1, 4);
        
        Fraction result = a.add(b).multiply(c.subtract(d));
        System.out.print("   Результат: ");
        result.display();
        System.out.println(" ? " + result.toDecimalString());
        
        System.out.println("\n=== РУЧНОЙ ВВОД ===");
        System.out.print("Введите первую дробь (формат: a/b или число): ");
        String input1 = scanner.next();
        
        System.out.print("Введите вторую дробь (формат: a/b или число): ");
        String input2 = scanner.next();
        
        try {
            Fraction userF1 = new Fraction(input1);
            Fraction userF2 = new Fraction(input2);
            
            System.out.println("\nВаши дроби:");
            System.out.println("f1 = " + userF1 + " ? " + userF1.toDecimalString());
            System.out.println("f2 = " + userF2 + " ? " + userF2.toDecimalString());
            
            System.out.println("\nРезультаты операций:");
            System.out.println("f1 + f2 = " + userF1.add(userF2) + 
                             " ? " + userF1.add(userF2).toDecimalString());
            System.out.println("f1 - f2 = " + userF1.subtract(userF2) + 
                             " ? " + userF1.subtract(userF2).toDecimalString());
            System.out.println("f1 * f2 = " + userF1.multiply(userF2) + 
                             " ? " + userF1.multiply(userF2).toDecimalString());
            
            if (userF2.getValue() != 0) {
                System.out.println("f1 / f2 = " + userF1.divide(userF2) + 
                                 " ? " + userF1.divide(userF2).toDecimalString());
            } else {
                System.out.println("f1 / f2 = Деление на ноль!");
            }
            
            System.out.println("++f1 = " + userF1.prefixIncrement() + 
                             " (теперь f1 = " + userF1 + ")");
            
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        scanner.close();
    }
}