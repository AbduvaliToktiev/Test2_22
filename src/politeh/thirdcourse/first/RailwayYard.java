package politeh.thirdcourse.first;

import java.util.*;

class Stack<T> {
    private List<T> items;
    
    public Stack() {
        items = new ArrayList<>();
    }
    
    public void push(T item) {
        items.add(item);
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public int getStackSize() {
        return items.size();
    }
    
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Стек пуст!");
            return;
        }
        
        System.out.println("Содержимое стека (вершина -> низ):");
        for (int i = items.size() - 1; i >= 0; i--) {
            System.out.println("  " + items.get(i));
        }
    }
}

class Wagon {
    private String type; // "A" или "B"
    private int number;
    
    public Wagon(String type, int number) {
        this.type = type;
        this.number = number;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Вагон " + type + "-" + number;
    }
}

public class RailwayYard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Wagon> inputStack = new Stack<>();
        Stack<Wagon> trackA = new Stack<>();
        Stack<Wagon> trackB = new Stack<>();
        
        System.out.println("=== Т-образный сортировочный узел ===");
        System.out.println("1. Заполнить состав из файла");
        System.out.println("2. Ввести состав вручную");
        System.out.println("3. Сортировать вагоны");
        System.out.println("4. Показать все стеки");
        System.out.println("0. Выход");
        
        while (true) {
            System.out.print("\nВыберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Введите имя файла: ");
                    String filename = scanner.nextLine();
                    // Здесь была бы реализация чтения из файла
                    System.out.println("Чтение из файла " + filename + " (заглушка)");
                    break;
                    
                case 2:
                    System.out.println("Введите вагоны (формат: тип(A/B) номер). Введите 'stop' для завершения:");
                    while (true) {
                        System.out.print("Вагон: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("stop")) break;
                        
                        try {
                            String[] parts = input.split(" ");
                            String type = parts[0].toUpperCase();
                            int number = Integer.parseInt(parts[1]);
                            
                            if (type.equals("A") || type.equals("B")) {
                                inputStack.push(new Wagon(type, number));
                                System.out.println("Добавлен: " + input);
                            } else {
                                System.out.println("Неверный тип! Используйте A или B");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка формата! Используйте: A 123");
                        }
                    }
                    System.out.println("Состав сформирован. Всего вагонов: " + inputStack.getStackSize());
                    break;
                    
                case 3:
                    System.out.println("Сортировка вагонов...");
                    int sortedCount = 0;
                    
                    while (!inputStack.isEmpty()) {
                        Wagon wagon = inputStack.pop();
                        if (wagon.getType().equals("A")) {
                            trackA.push(wagon);
                        } else {
                            trackB.push(wagon);
                        }
                        sortedCount++;
                    }
                    
                    System.out.println("Отсортировано " + sortedCount + " вагонов:");
                    System.out.println("Путь A: " + trackA.getStackSize() + " вагонов");
                    System.out.println("Путь B: " + trackB.getStackSize() + " вагонов");
                    break;
                    
                case 4:
                    System.out.println("\n=== ТЕКУЩЕЕ СОСТОЯНИЕ ===");
                    System.out.println("Входной стек:");
                    inputStack.printStack();
                    System.out.println("\nПуть А:");
                    trackA.printStack();
                    System.out.println("\nПуть В:");
                    trackB.printStack();
                    break;
                    
                case 0:
                    System.out.println("Выход из программы!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}