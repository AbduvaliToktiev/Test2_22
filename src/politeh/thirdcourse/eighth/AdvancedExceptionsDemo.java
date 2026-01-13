package politeh.thirdcourse.eighth;

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class FileReadException extends Exception {
    public FileReadException(String filename, String reason) {
        super(String.format("Ошибка чтения файла '%s': %s", filename, reason));
    }
}

class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Сумма для снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new Exception("Недостаточно средств на счете");
        }
        balance -= amount;
        System.out.printf("Снято %.2f. Остаток: %.2f\n", amount, balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

public class AdvancedExceptionsDemo {
    
    public static double divide(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Деление на ноль запрещено");
        }
        return a / b;
    }
    
    public static String readFile(String filename) throws FileReadException {
        if (filename == null || filename.isEmpty()) {
            throw new FileReadException(filename, "Имя файла не указано");
        }
        if (!filename.endsWith(".txt")) {
            throw new FileReadException(filename, "Неверный формат файла");
        }
        return "Содержимое файла " + filename;
    }
    
    public static void demonstrateAdvancedExceptions() {
        System.out.println("\n=== Дополнительные примеры исключений ===\n");
        
        System.out.println("1. Деление чисел с обработкой исключений:");
        try {
            System.out.println("10 / 2 = " + divide(10, 2));
            System.out.println("5 / 0 = " + divide(5, 0));
        } catch (DivisionByZeroException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        System.out.println("\n2. Работа с банковским счетом:");
        BankAccount account = new BankAccount(1000);
        
        try {
            account.withdraw(500);
            account.withdraw(600);
            account.withdraw(100);
        } catch (Exception e) {
            System.out.println("Банковская операция отклонена: " + e.getMessage());
        }
        
        System.out.println("\n3. Чтение файлов:");
        String[] files = {"data.txt", "document.pdf", "", null};
        
        for (String filename : files) {
            try {
                String content = readFile(filename);
                System.out.println("Успешно прочитано: " + content);
            } catch (FileReadException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("NullPointerException: имя файла равно null");
            }
        }
        
        System.out.println("\n4. Цепочка исключений:");
        try {
            try {
                int[] arr = new int[5];
                System.out.println(arr[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new Exception("Ошибка доступа к массиву", e);
            }
        } catch (Exception e) {
            System.out.println("Внешнее исключение: " + e.getMessage());
            System.out.println("Причина: " + e.getCause());
        }
        
        System.out.println("\n5. Использование try-with-resources:");
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Введите число: ");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            System.out.println("Вы ввели: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не число!");
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }
    }
}