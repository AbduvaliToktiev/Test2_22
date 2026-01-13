package politeh.thirdcourse.nineth;

import java.util.Random;

class AntiAircraftGun {
    private static int totalShotsFired = 0;
    private static int totalPlanesShotDown = 0;
    private static int totalSimulations = 0;
    private double hitProbability;
    
    public AntiAircraftGun(double hitProbability) {
        if (hitProbability < 0 || hitProbability > 1) {
            throw new IllegalArgumentException("Вероятность должна быть в диапазоне [0, 1]");
        }
        this.hitProbability = hitProbability;
    }
    
    public int simulateShooting(int maxShots) {
        if (maxShots <= 0) {
            throw new IllegalArgumentException("Количество выстрелов должно быть > 0");
        }
        
        Random random = new Random();
        
        totalSimulations++;
        
        for (int shot = 1; shot <= maxShots; shot++) {
            totalShotsFired++;
            
            if (random.nextDouble() < hitProbability) {
                totalPlanesShotDown++;
                return 1;
            }
        }
        
        return 0;
    }
    
    public static double calculateTheoreticalProbability(double p, int n) {
        if (p < 0 || p > 1) {
            throw new IllegalArgumentException("Вероятность должна быть в диапазоне [0, 1]");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Количество выстрелов должно быть > 0");
        }
        
        return 1 - Math.pow(1 - p, n);
    }
    
    public static double calculateExperimentalProbability() {
        if (totalSimulations == 0) {
            return 0.0;
        }
        return (double) totalPlanesShotDown / totalSimulations;
    }
    
    public static double getAverageEfficiency() {
        if (totalShotsFired == 0) {
            return 0.0;
        }
        return (double) totalPlanesShotDown / totalShotsFired;
    }
    
    public static void resetStatistics() {
        totalShotsFired = 0;
        totalPlanesShotDown = 0;
        totalSimulations = 0;
    }
    
    public static void printStatistics() {
        System.out.println("\n=== Статистика стрельбы ===");
        System.out.printf("Всего симуляций: %d\n", totalSimulations);
        System.out.printf("Всего выстрелов: %d\n", totalShotsFired);
        System.out.printf("Сбито самолетов: %d\n", totalPlanesShotDown);
        System.out.printf("Экспериментальная вероятность поражения: %.4f\n", 
                         calculateExperimentalProbability());
        System.out.printf("Средняя эффективность стрельбы: %.4f\n", 
                         getAverageEfficiency());
    }
    
    public double getHitProbability() {
        return hitProbability;
    }
    
    public final String getGunInfo() {
        return String.format("Зенитное орудие с вероятностью попащения: %.3f", hitProbability);
    }
}

class StaticDemo {
    private static int instanceCount = 0;
    
    public static final double PI = 3.14159;
    
    private int id;
    
    public StaticDemo() {
        instanceCount++;
        this.id = instanceCount;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
    
    public static void showStaticInfo() {
        System.out.println("Статическая информация:");
        System.out.println("Создано объектов: " + instanceCount);
        System.out.println("Значение PI: " + PI);
    }
    
    public void showInstanceInfo() {
        System.out.println("Информация об объекте:");
        System.out.println("ID: " + id);
        System.out.println("Всего объектов: " + instanceCount);
        System.out.println("PI: " + PI);
    }
    
    public final String getDescription() {
        return String.format("Объект StaticDemo #%d", id);
    }
}

public class StaticMethods {
    
    public static void main(String[] args) {
        System.out.println("Тема: Статические поля и методы класса\n");
        
        System.out.println("=== Часть 1: Стрельба по самолету ===\n");
        
        double probability = 0.3;
        int maxShots = 5;
        
        AntiAircraftGun gun = new AntiAircraftGun(probability);
        
        System.out.println(gun.getGunInfo());
        System.out.printf("Максимальное количество выстрелов: %d\n", maxShots);
        System.out.printf("Теоретическая вероятность поражения: %.4f\n", 
                         AntiAircraftGun.calculateTheoreticalProbability(probability, maxShots));
        
        System.out.println("\nПроводим 10 симуляций стрельбы:");
        for (int i = 1; i <= 10; i++) {
            int result = gun.simulateShooting(maxShots);
            String outcome = result == 1 ? "Сбит ?" : "Уцелел ?";
            System.out.printf("Симуляция %2d: Результат: %s\n", i, outcome);
        }
        
        AntiAircraftGun.printStatistics();
        
        System.out.println("\n--- Еще 5 симуляций с другим орудием ---");
        AntiAircraftGun gun2 = new AntiAircraftGun(0.5);
        for (int i = 1; i <= 5; i++) {
            gun2.simulateShooting(3);
        }
        
        AntiAircraftGun.printStatistics();
        
        System.out.println("\n--- Сброс статистики ---");
        AntiAircraftGun.resetStatistics();
        AntiAircraftGun.printStatistics();
        
        System.out.println("\n=== Часть 2: Демонстрация статических полей и методов ===\n");
        
        System.out.println("Вызов статических методов класса StaticDemo:");
        StaticDemo.showStaticInfo();
        System.out.println("Константа PI: " + StaticDemo.PI);
        
        System.out.println("\nСоздание объектов класса StaticDemo:");
        StaticDemo obj1 = new StaticDemo();
        StaticDemo obj2 = new StaticDemo();
        StaticDemo obj3 = new StaticDemo();
        
        obj1.showInstanceInfo();
        System.out.println();
        obj2.showInstanceInfo();
        System.out.println();
        obj3.showInstanceInfo();
        
        System.out.println("\nДоступ к статическим членам через объект:");
        System.out.println("obj1.getInstanceCount(): " + obj1.getInstanceCount());
        System.out.println("obj2.getInstanceCount(): " + obj2.getInstanceCount());
        System.out.println("obj3.getInstanceCount(): " + obj3.getInstanceCount());

        System.out.println("\nИспользование константных методов:");
        System.out.println("obj1: " + obj1.getDescription());
        System.out.println("obj2: " + obj2.getDescription());
        
        System.out.println("\n=== Практическое сравнение статических и автоматических полей ===\n");
        
        System.out.println("1. Статические поля - общие для всех объектов:");
        System.out.println("   Изменение через один объект влияет на все остальные");
        
        System.out.println("\n2. Автоматические поля - уникальные для каждого объекта:");
        System.out.println("   Изменение в одном объекте не влияет на другие");
        
        System.out.println("\n=== Дополнительно: Статические методы для математических вычислений ===\n");
        
        System.out.println("Сравнение теоретических вероятностей для разного p:");
        System.out.println("n\\p    0.1     0.3     0.5     0.7     0.9");
        System.out.println("---------------------------------------------");
        
        for (int n = 1; n <= 5; n++) {
            System.out.printf("%d  ", n);
            for (double p = 0.1; p <= 0.9; p += 0.2) {
                double prob = AntiAircraftGun.calculateTheoreticalProbability(p, n);
                System.out.printf("  %.3f", prob);
            }
            System.out.println();
        }
        
        System.out.println("\nЭкспериментальная проверка для p=0.3, n=5:");
        
        AntiAircraftGun.resetStatistics();
        
        AntiAircraftGun testGun = new AntiAircraftGun(0.3);
        for (int i = 0; i < 10000; i++) {
            testGun.simulateShooting(5);
        }
        
        double theoretical = AntiAircraftGun.calculateTheoreticalProbability(0.3, 5);
        double experimental = AntiAircraftGun.calculateExperimentalProbability();
        
        System.out.printf("Теоретическая вероятность: %.4f\n", theoretical);
        System.out.printf("Экспериментальная вероятность: %.4f\n", experimental);
        System.out.printf("Отклонение: %.4f (%.2f%%)\n", 
                         Math.abs(theoretical - experimental),
                         Math.abs(theoretical - experimental) / theoretical * 100);
    }
}