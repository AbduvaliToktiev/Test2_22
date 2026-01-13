package politeh.thirdcourse.sixth;

public class VirtualMethods {
    public static void main(String[] args) {
        System.out.println("Часть 1: Виртуальные методы сложения массивов\n");
        
        Array arr1 = new BoundedArray(5, 40);
        Array arr2 = new BoundedArray(5, 70);
        Array arr3 = new ModularArray(5, 30);
        Array arr4 = new ModularArray(5, 40);
        
        System.out.println("Исходные массивы:");
        arr1.print();
        arr2.print();
        arr3.print();
        arr4.print();
        
        System.out.println("\nРезультаты сложения:");
        System.out.println("BoundedArray + BoundedArray:");
        Array sum1 = arr1.add(arr2);
        sum1.print();
        
        System.out.println("\nModularArray + ModularArray:");
        Array sum2 = arr3.add(arr4);
        sum2.print();
        
        // Демонстрация полиморфизма через массив базового класса
        System.out.println("\nДемонстрация полиморфизма:");
        Array[] arrays = {arr1, arr2, arr3, arr4};
        for (Array arr : arrays) {
            System.out.println("Тип массива: " + arr.getClass().getSimpleName());
            arr.print();
        }
        
        System.out.println("\n\nЧасть 2: Геометрические фигуры\n");
        
        // Создаем массив фигур
        Figure[] figures = new Figure[3];
        figures[0] = new Rectangle(5.0, 10.0);
        figures[1] = new Circle(7.0);
        figures[2] = new Trapezium(3.0, 7.0, 4.0, 5.0, 5.0);
        
        // Вызываем виртуальные методы через базовый класс
        for (Figure figure : figures) {
            figure.displayInfo();
        }
        
        System.out.println("\n\nЧасть 3: Валюты\n");
        
        // Создаем массив валют
        Currency[] currencies = new Currency[2];
        currencies[0] = new Dollar(100.0);
        currencies[1] = new Euro(100.0);
        
        // Вызываем виртуальные методы
        for (Currency currency : currencies) {
            currency.display();
        }
        
        // Демонстрация дополнительных операций
        System.out.println("\nДополнительные операции:");
        Currency dollar = new Dollar(50.0);
        Currency euro = new Euro(50.0);
        
        System.out.printf("50 долларов = %.2f рублей\n", dollar.convertToRubles());
        System.out.printf("50 евро = %.2f рублей\n", euro.convertToRubles());
        
        double totalInRubles = dollar.convertToRubles() + euro.convertToRubles();
        System.out.printf("Общая сумма в рублях: %.2f\n", totalInRubles);
    }
}