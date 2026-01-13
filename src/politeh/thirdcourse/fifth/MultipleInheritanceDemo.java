package politeh.thirdcourse.fifth;

import java.util.Scanner;

interface IDisplay {
    void displayInfo();
    String getType();
    long getColors();
    int getXResolution();
    int getYResolution();
}

interface IMotherBoard {
    void motherboardInfo();
    String getProcessor();
    int getSpeed();
    int getRAM();
}

class Display implements IDisplay {
    private String type;
    private long colors;
    private int xResolution;
    private int yResolution;
    
    public Display(String type, long colors, int xResolution, int yResolution) {
        this.type = type;
        this.colors = colors;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n=== ХАРАКТЕРИСТИКИ ДИСПЛЕЯ ===");
        System.out.println("Тип: " + type);
        System.out.println("Количество цветов: " + colors);
        System.out.println("Разрешение: " + xResolution + "x" + yResolution);
        System.out.println("==============================");
    }
    
    @Override
    public String getType() { return type; }
    
    @Override
    public long getColors() { return colors; }
    
    @Override
    public int getXResolution() { return xResolution; }
    
    @Override
    public int getYResolution() { return yResolution; }
}

class MotherBoard implements IMotherBoard {
    private String processor;
    private int speed; // в MHz
    private int RAM;   // в GB
    
    public MotherBoard(String processor, int speed, int RAM) {
        this.processor = processor;
        this.speed = speed;
        this.RAM = RAM;
    }
    
    @Override
    public void motherboardInfo() {
        System.out.println("\n=== ХАРАКТЕРИСТИКИ МАТЕРИНСКОЙ ПЛАТЫ ===");
        System.out.println("Процессор: " + processor);
        System.out.println("Скорость: " + speed + " MHz");
        System.out.println("Оперативная память: " + RAM + " GB");
        System.out.println("========================================");
    }
    
    @Override
    public String getProcessor() { return processor; }
    
    @Override
    public int getSpeed() { return speed; }
    
    @Override
    public int getRAM() { return RAM; }
}

class Computer implements IDisplay, IMotherBoard {
    private String name;
    private int hardDisk;
    private Display display;
    private MotherBoard motherboard;
    
    public Computer(String name, int hardDisk,
                   Display display, MotherBoard motherboard) {
        this.name = name;
        this.hardDisk = hardDisk;
        this.display = display;
        this.motherboard = motherboard;
    }
    
    public void show() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("          ХАРАКТЕРИСТИКИ КОМПЬЮТЕРА");
        System.out.println("═".repeat(50));
        System.out.println("Марка: " + name);
        System.out.println("Жесткий диск: " + hardDisk + " GB");
        System.out.println("═".repeat(50));
        
        display.displayInfo();
        
        motherboard.motherboardInfo();
        
        System.out.println("=== СВОДНАЯ ИНФОРМАЦИЯ ===");
        System.out.println("Общий объем памяти: " + 
                          (hardDisk + motherboard.getRAM()) + " GB (HDD + RAM)");
        System.out.println("Разрешение экрана: " + 
                          display.getXResolution() + "x" + display.getYResolution());
        System.out.println("Процессорная мощность: " + 
                          motherboard.getProcessor() + " @ " + motherboard.getSpeed() + "MHz");
        System.out.println("═".repeat(50));
    }
    
    @Override
    public void displayInfo() {
        display.displayInfo();
    }
    
    @Override
    public String getType() {
        return display.getType();
    }
    
    @Override
    public long getColors() {
        return display.getColors();
    }
    
    @Override
    public int getXResolution() {
        return display.getXResolution();
    }
    
    @Override
    public int getYResolution() {
        return display.getYResolution();
    }
    
    @Override
    public void motherboardInfo() {
        motherboard.motherboardInfo();
    }
    
    @Override
    public String getProcessor() {
        return motherboard.getProcessor();
    }
    
    @Override
    public int getSpeed() {
        return motherboard.getSpeed();
    }
    
    @Override
    public int getRAM() {
        return motherboard.getRAM();
    }
    
    public String getName() { return name; }
    public int getHardDisk() { return hardDisk; }
    public Display getDisplay() { return display; }
    public MotherBoard getMotherBoard() { return motherboard; }
}

class Computer2 extends Display {
    private String name;
    private int hardDisk;
    private MotherBoard motherboard;
    
    public Computer2(String name, int hardDisk,
                    String displayType, long colors, int xRes, int yRes,
                    String processor, int speed, int RAM) {
        super(displayType, colors, xRes, yRes);
        
        this.name = name;
        this.hardDisk = hardDisk;
        this.motherboard = new MotherBoard(processor, speed, RAM);
    }
    
    public void show() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          КОМПЬЮТЕР (Computer2)          ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ Марка: " + String.format("%-32s", name) + "║");
        System.out.println("║ HDD: " + String.format("%-35s", hardDisk + " GB") + "║");
        System.out.println("╠══════════════════════════════════════════╣");
        
        System.out.println("║ ДИСПЛЕЙ (наследование):                 ║");
        System.out.println("║ Тип: " + String.format("%-34s", getType()) + "║");
        System.out.println("║ Разрешение: " + 
                         String.format("%-28s", getXResolution() + "x" + getYResolution()) + "║");
        
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║ МАТЕРИНСКАЯ ПЛАТА (композиция):         ║");
        System.out.println("║ Процессор: " + 
                         String.format("%-29s", motherboard.getProcessor()) + "║");
        System.out.println("║ Частота: " + 
                         String.format("%-31s", motherboard.getSpeed() + " MHz") + "║");
        System.out.println("║ RAM: " + 
                         String.format("%-35s", motherboard.getRAM() + " GB") + "║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}

public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== МНОЖЕСТВЕННОЕ НАСЛЕДОВАНИЕ (эмуляция) ===");
        System.out.println("Display + MotherBoard → Computer\n");
        
        System.out.println("1. СОЗДАНИЕ КОМПОНЕНТОВ:");
        
        Display display1 = new Display("IPS LCD", 16777216L, 1920, 1080);
        display1.displayInfo();
        
        MotherBoard mb1 = new MotherBoard("Intel Core i7", 3600, 16);
        mb1.motherboardInfo();
        
        Display display2 = new Display("OLED", 16777216L, 3840, 2160);
        MotherBoard mb2 = new MotherBoard("AMD Ryzen 9", 4200, 32);
        
        System.out.println("\n2. СОЗДАНИЕ КОМПЬЮТЕРОВ:");
        
        Computer comp1 = new Computer("Dell XPS 15", 1000, display1, mb1);
        comp1.show();
        
        Computer comp2 = new Computer("Apple MacBook Pro", 2000, display2, mb2);
        comp2.show();
        
        System.out.println("\n3. АЛЬТЕРНАТИВНАЯ РЕАЛИЗАЦИЯ (Computer2):");
        Computer2 comp3 = new Computer2("HP Pavilion", 500, 
                                       "LED", 16777216L, 1366, 768,
                                       "Intel Core i5", 2400, 8);
        comp3.show();
        
        System.out.println("\n4. ПОЛИМОРФИЗМ С ИНТЕРФЕЙСАМИ:");
        
        System.out.println("Массив IDisplay:");
        IDisplay[] displays = new IDisplay[3];
        displays[0] = display1;
        displays[1] = comp1;
        displays[2] = comp2;
        
        for (IDisplay disp : displays) {
            System.out.println("Тип дисплея: " + disp.getType() + 
                             ", Разрешение: " + disp.getXResolution() + "x" + disp.getYResolution());
        }
        
        System.out.println("\nМассив IMotherBoard:");
        IMotherBoard[] motherboards = new IMotherBoard[3];
        motherboards[0] = mb1;
        motherboards[1] = comp1;
        motherboards[2] = comp2;
        
        for (IMotherBoard mb : motherboards) {
            System.out.println("Процессор: " + mb.getProcessor() + 
                             ", RAM: " + mb.getRAM() + "GB");
        }
        
        System.out.println("\n=== ИНТЕРАКТИВНЫЙ РЕЖИМ ===");
        System.out.print("Хотите создать свой компьютер? (да/нет): ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("да")) {
            System.out.println("\nВведите характеристики дисплея:");
            System.out.print("Тип дисплея: ");
            String dispType = scanner.nextLine();
            
            System.out.print("Количество цветов: ");
            long colors = scanner.nextLong();
            
            System.out.print("Разрешение по X: ");
            int xRes = scanner.nextInt();
            
            System.out.print("Разрешение по Y: ");
            int yRes = scanner.nextInt();
            
            System.out.println("\nВведите характеристики материнской платы:");
            scanner.nextLine(); // очистка буфера
            System.out.print("Процессор: ");
            String processor = scanner.nextLine();
            
            System.out.print("Скорость (MHz): ");
            int speed = scanner.nextInt();
            
            System.out.print("RAM (GB): ");
            int ram = scanner.nextInt();
            
            System.out.println("\nВведите общие характеристики компьютера:");
            scanner.nextLine(); // очистка буфера
            System.out.print("Марка компьютера: ");
            String compName = scanner.nextLine();
            
            System.out.print("Объем жесткого диска (GB): ");
            int hdd = scanner.nextInt();
            
            Display userDisplay = new Display(dispType, colors, xRes, yRes);
            MotherBoard userMB = new MotherBoard(processor, speed, ram);
            Computer userComp = new Computer(compName, hdd, userDisplay, userMB);
            
            System.out.println("\n" + "=".repeat(50));
            System.out.println("ВЫ СОЗДАЛИ КОМПЬЮТЕР!");
            userComp.show();
        }
        
        scanner.close();
        
        System.out.println("\nПрограмма завершена!");
    }
}