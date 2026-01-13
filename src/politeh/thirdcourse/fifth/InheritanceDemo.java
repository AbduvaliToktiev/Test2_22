package politeh.thirdcourse.fifth;

import java.util.Scanner;

class Employee {
    protected String name;
    protected String position;
    protected double salary;
    
    public Employee() {
        this.name = "Неизвестно";
        this.position = "Не указана";
        this.salary = 0.0;
        System.out.println("Создан объект Employee (конструктор по умолчанию)");
    }
    
    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        System.out.println("Создан объект Employee: " + name);
    }
    
    public double calculateAnnualSalary() {
        return salary * 12;
    }
    
    public double calculateTotalAnnualIncome() {
        return calculateAnnualSalary();
    }
    
    public void displayInfo() {
        System.out.println("\n=== ИНФОРМАЦИЯ О СОТРУДНИКЕ ===");
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.printf("Зарплата в месяц: %.2f руб.\n", salary);
        System.out.printf("Зарплата в год: %.2f руб.\n", calculateAnnualSalary());
        System.out.println("================================");
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Объект Employee '" + name + "' удален");
        } finally {
            super.finalize();
        }
    }
}

class Manager extends Employee {
    private double annualBonus;      // ежегодный бонус
    private String companyCar;       // машина компании
    private int stockOptions;        // опционы на акции
    
    public Manager() {
        super(); // вызов конструктора родительского класса
        this.annualBonus = 0.0;
        this.companyCar = "Не предоставлена";
        this.stockOptions = 0;
        System.out.println("Создан объект Manager (конструктор по умолчанию)");
    }
    
    public Manager(String name, String position, double salary,
                   double annualBonus, String companyCar, int stockOptions) {
        super(name, position, salary); // вызов конструктора родительского класса
        this.annualBonus = annualBonus;
        this.companyCar = companyCar;
        this.stockOptions = stockOptions;
        System.out.println("Создан объект Manager: " + name);
    }
    
    @Override
    public double calculateTotalAnnualIncome() {
        double baseAnnualSalary = super.calculateAnnualSalary();
        return baseAnnualSalary + annualBonus + (stockOptions * 1000); // предположим, 1000 руб. за опцион
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // вызов метода родительского класса
        System.out.println("\n=== ДОПОЛНИТЕЛЬНАЯ ИНФОРМАЦИЯ О МЕНЕДЖЕРЕ ===");
        System.out.printf("Ежегодный бонус: %.2f руб.\n", annualBonus);
        System.out.println("Машина компании: " + companyCar);
        System.out.println("Опционы на акции: " + stockOptions + " шт.");
        System.out.printf("Общий годовой доход: %.2f руб.\n", calculateTotalAnnualIncome());
        System.out.println("==============================================");
    }
    
    public void conductMeeting() {
        System.out.println(name + " проводит собрание команды...");
    }
    
    public void approveProject() {
        System.out.println(name + " утверждает проект...");
    }
    
    public double getAnnualBonus() { return annualBonus; }
    public void setAnnualBonus(double annualBonus) { this.annualBonus = annualBonus; }
    
    public String getCompanyCar() { return companyCar; }
    public void setCompanyCar(String companyCar) { this.companyCar = companyCar; }
    
    public int getStockOptions() { return stockOptions; }
    public void setStockOptions(int stockOptions) { this.stockOptions = stockOptions; }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Объект Manager '" + name + "' удален");
        } finally {
            super.finalize();
        }
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ПРОСТОЕ НАСЛЕДОВАНИЕ: Employee -> Manager ===\n");
        
        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ КЛАССА Employee:");
        Employee emp1 = new Employee();
        emp1.setName("Иван Петров");
        emp1.setPosition("Инженер");
        emp1.setSalary(50000);
        emp1.displayInfo();
        
        Employee emp2 = new Employee("Анна Сидорова", "Бухгалтер", 45000);
        emp2.displayInfo();
        
        System.out.println("\n2. СОЗДАНИЕ ОБЪЕКТОВ КЛАССА Manager:");
        
        Manager mgr1 = new Manager();
        mgr1.setName("Сергей Иванов");
        mgr1.setPosition("Менеджер проекта");
        mgr1.setSalary(80000);
        mgr1.setAnnualBonus(120000);
        mgr1.setCompanyCar("Toyota Camry");
        mgr1.setStockOptions(50);
        mgr1.displayInfo();
        
        Manager mgr2 = new Manager("Ольга Николаева", "Директор отдела",
                                  120000, 200000, "Mercedes E-Class", 100);
        mgr2.displayInfo();
        
        System.out.println("\n3. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        
        Employee[] employees = new Employee[4];
        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = mgr1;
        employees[3] = mgr2;
        
        double totalAnnualPayroll = 0;
        System.out.println("\nРасчет годового фонда оплаты труда:");
        System.out.println("-------------------------------------");

        for (int i = 0; i < employees.length; i++) {
            double annualIncome = employees[i].calculateTotalAnnualIncome();
            totalAnnualPayroll += annualIncome;

            System.out.printf("%-20s: %,.2f руб.\n",
                employees[i].getName(), annualIncome);
        }
        
        System.out.println("-------------------------------------");
        System.out.printf("Итого: %,.2f руб.\n", totalAnnualPayroll);
        
        System.out.println("\n4. СПЕЦИФИЧНЫЕ МЕТОДЫ КЛАССА Manager:");
        mgr1.conductMeeting();
        mgr2.approveProject();
        
        System.out.println("\n5. ПРОВЕРКА НАСЛЕДОВАНИЯ:");
        
        System.out.println("Менеджер " + mgr1.getName() +
                         " имеет зарплату: " + mgr1.getSalary());
        
        System.out.println("Работник " + emp1.getName() +
                         " имеет доступ только к методам Employee");
        
        System.out.println("\n=== ИНТЕРАКТИВНЫЙ РЕЖИМ ===");
        System.out.print("Хотите создать нового сотрудника? (да/нет): ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("да")) {
            System.out.println("\nВыберите тип сотрудника:");
            System.out.println("1. Обычный сотрудник (Employee)");
            System.out.println("2. Менеджер (Manager)");
            System.out.print("Ваш выбор: ");
            
            int type = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            
            System.out.print("Введите должность: ");
            String position = scanner.nextLine();
            
            System.out.print("Введите месячную зарплату: ");
            double salary = scanner.nextDouble();
            
            if (type == 1) {
                Employee newEmp = new Employee(name, position, salary);
                newEmp.displayInfo();
            } else if (type == 2) {
                System.out.print("Введите ежегодный бонус: ");
                double bonus = scanner.nextDouble();
                scanner.nextLine(); // очистка буфера
                
                System.out.print("Введите машину компании: ");
                String car = scanner.nextLine();
                
                System.out.print("Введите количество опционов: ");
                int options = scanner.nextInt();
                
                Manager newMgr = new Manager(name, position, salary, bonus, car, options);
                newMgr.displayInfo();
            }
        }
        
        scanner.close();
        
        System.out.println("\n=== ОЧИСТКА ПАМЯТИ ===");
        emp1 = null;
        emp2 = null;
        mgr1 = null;
        mgr2 = null;
        
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nПрограмма завершена!");
    }
}