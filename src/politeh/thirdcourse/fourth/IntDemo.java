package politeh.thirdcourse.fourth;

import java.util.Scanner;

class Int {
    private int value;
    
    public Int() {
        this.value = 0;
    }
    
    public Int(int value) {
        this.value = value;
    }
    
    public Int(long value) {
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            throw new ArithmeticException("Переполнение при создании Int!");
        }
        this.value = (int) value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    

    public Int add(Int other) {
        long result = (long) this.value + (long) other.value;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int add(int num) {
        long result = (long) this.value + (long) num;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int subtract(Int other) {
        long result = (long) this.value - (long) other.value;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int subtract(int num) {
        long result = (long) this.value - (long) num;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int multiply(Int other) {
        long result = (long) this.value * (long) other.value;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int multiply(int num) {
        long result = (long) this.value * (long) num;
        checkOverflow(result);
        return new Int((int) result);
    }
    
    public Int divide(Int other) {
        if (other.value == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Int(this.value / other.value);
    }
    
    public Int divide(int num) {
        if (num == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        return new Int(this.value / num);
    }
    
    public Int prefixIncrement() {
        long result = this.value + 1L;
        checkOverflow(result);
        this.value = (int) result;
        return this;
    }
    
    public Int postfixIncrement() {
        Int temp = new Int(this.value);
        long result = this.value + 1L;
        checkOverflow(result);
        this.value = (int) result;
        return temp;
    }
    
    public Int prefixDecrement() {
        long result = this.value - 1L;
        checkOverflow(result);
        this.value = (int) result;
        return this;
    }
    
    public Int postfixDecrement() {
        Int temp = new Int(this.value);
        long result = this.value - 1L;
        checkOverflow(result);
        this.value = (int) result;
        return temp;
    }
    
    private void checkOverflow(long result) {
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Арифметическое переполнение! Результат: " + result + 
                                        " выходит за пределы int [" + Integer.MIN_VALUE + 
                                        ", " + Integer.MAX_VALUE + "]");
        }
    }
    
    public static Int add(Int a, Int b) {
        return a.add(b);
    }
    
    public static Int subtract(Int a, Int b) {
        return a.subtract(b);
    }
    
    public static Int multiply(Int a, Int b) {
        return a.multiply(b);
    }
    
    public static Int divide(Int a, Int b) {
        return a.divide(b);
    }
    
    public void display() {
        System.out.println("Int value: " + value);
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    
    public static void demoOperations() {
        System.out.println("\n=== ДЕМОНСТРАЦИЯ КЛАССА Int ===");
        
        try {
            Int a = new Int(1000);
            Int b = new Int(2000);
            
            System.out.println("a = " + a + ", b = " + b);
            
            Int sum = a.add(b);
            System.out.println("a + b = " + sum);
            
            Int diff = a.subtract(b);
            System.out.println("a - b = " + diff);
            
            Int product = a.multiply(b);
            System.out.println("a * b = " + product);
            
            Int quotient = a.divide(new Int(2));
            System.out.println("a / 2 = " + quotient);
            
            System.out.println("\nИнкремент:");
            System.out.println("Исходное a = " + a);
            Int prefixResult = a.prefixIncrement();
            System.out.println("++a = " + prefixResult + " (теперь a = " + a + ")");
            
            Int postfixResult = a.postfixIncrement();
            System.out.println("a++ = " + postfixResult + " (теперь a = " + a + ")");
            
            System.out.println("\nТест переполнения:");
            Int maxInt = new Int(Integer.MAX_VALUE);
            System.out.println("MAX_INT = " + maxInt);
            
            try {
                Int overflow = maxInt.add(1);
                System.out.println("MAX_INT + 1 = " + overflow);
            } catch (ArithmeticException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
            }
            
            try {
                Int minInt = new Int(Integer.MIN_VALUE);
                Int underflow = minInt.subtract(1);
                System.out.println("MIN_INT - 1 = " + underflow);
            } catch (ArithmeticException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
            }
            
            System.out.println("\nОперации с большими числами:");
            Int big1 = new Int(2000000000);
            Int big2 = new Int(2000000000);
            
            try {
                Int bigSum = big1.add(big2);
                System.out.println("2000000000 + 2000000000 = " + bigSum);
            } catch (ArithmeticException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
            }
            
            Int big3 = new Int(100000);
            Int bigProduct = big1.multiply(big3);
            System.out.println("2000000000 * 100000 = " + bigProduct);
            
        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка: " + e.getMessage());
        }
    }
}

public class IntDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== КЛАСС Int С ПРОВЕРКОЙ ПЕРЕПОЛНЕНИЯ ===");
        System.out.println("1. Автоматическая демонстрация");
        System.out.println("2. Ручной ввод");
        System.out.print("Выберите вариант: ");
        
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            Int.demoOperations();
        } else {
            System.out.print("Введите первое число: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Введите второе число: ");
            int num2 = scanner.nextInt();
            
            Int a = new Int(num1);
            Int b = new Int(num2);
            
            System.out.println("\nРезультаты операций:");
            System.out.println("a = " + a + ", b = " + b);
            
            try {
                System.out.println("a + b = " + a.add(b));
                System.out.println("a - b = " + a.subtract(b));
                System.out.println("a * b = " + a.multiply(b));
                
                if (b.getValue() != 0) {
                    System.out.println("a / b = " + a.divide(b));
                } else {
                    System.out.println("a / b = Деление на ноль!");
                }
                
                System.out.println("++a = " + a.prefixIncrement());
                System.out.println("b++ = " + b.postfixIncrement());
                System.out.println("После b++: b = " + b);
                
            } catch (ArithmeticException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
}