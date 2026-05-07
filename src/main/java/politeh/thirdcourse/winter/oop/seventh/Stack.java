package politeh.thirdcourse.winter.oop.seventh;

import java.util.EmptyStackException;

class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;
    
    public Stack() {
        this(DEFAULT_CAPACITY);
    }
    
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть > 0");
        }
        elements = new Object[capacity];
        top = -1;
    }
    
    public void push(T element) {
        if (top == elements.length - 1) {
            expandCapacity();
        }
        elements[++top] = element;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = (T) elements[top];
        elements[top--] = null;
        return element;
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    private void expandCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
    
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            return;
        }
        
        System.out.print("Стек (сверху вниз): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}

class StackProblemSolver {
    
    public static boolean checkBracketBalance(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }
    
    public static void demonstrateStack() {
        System.out.println("\n=== Демонстрация шаблонного класса Stack ===\n");
        
        System.out.println("1. Стек с Integer:");
        Stack<Integer> intStack = new Stack<>(5);
        
        System.out.println("Добавляем элементы: 10, 20, 30");
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.printStack();
        
        System.out.println("Верхний элемент: " + intStack.peek());
        System.out.println("Извлекаем элемент: " + intStack.pop());
        intStack.printStack();
        
        System.out.println("Размер стека: " + intStack.size());
        
        System.out.println("\n2. Стек с String:");
        Stack<String> stringStack = new Stack<>();
        
        System.out.println("Добавляем элементы: 'Java', 'Python', 'C++'");
        stringStack.push("Java");
        stringStack.push("Python");
        stringStack.push("C++");
        stringStack.printStack();
        
        System.out.println("Извлекаем два элемента:");
        System.out.println("Первый: " + stringStack.pop());
        System.out.println("Второй: " + stringStack.pop());
        stringStack.printStack();
        
        System.out.println("\n3. Решение задачи проверки баланса скобок:");
        
        String[] expressions = {
            "(a + b) * (c - d)",
            "{(a + b) * [c - d]}",
            "((a + b)",
            "a + b)",
            "({[()]})",
            "({[(])})"
        };
        
        for (String expr : expressions) {
            boolean isBalanced = checkBracketBalance(expr);
            System.out.printf("Выражение: %-20s Баланс: %s%n", 
                expr, "?");
        }
        
        System.out.println("\n4. Обратный вывод строки с использованием стека:");
        String text = "Hello, World!";
        Stack<Character> charStack = new Stack<>();
        
        for (char ch : text.toCharArray()) {
            charStack.push(ch);
        }
        
        System.out.print("Оригинал: " + text + "\nОбратный порядок: ");
        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop());
        }
        System.out.println();
    }
}