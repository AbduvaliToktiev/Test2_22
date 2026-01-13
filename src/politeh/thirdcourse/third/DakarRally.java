package politeh.thirdcourse.third;

import java.util.*;

class Kamaz {
    private String name;
    private double plainSpeed;
    private double mountainSpeed;
    private double desertSpeed;
    
    public Kamaz(String name, double plain, double mountain, double desert) {
        this.name = name;
        this.plainSpeed = plain;
        this.mountainSpeed = mountain;
        this.desertSpeed = desert;
    }
    
    public String getName() { return name; }
    public double getPlainSpeed() { return plainSpeed; }
    public double getMountainSpeed() { return mountainSpeed; }
    public double getDesertSpeed() { return desertSpeed; }
    
    public void displayInfo() {
        System.out.println("Грузовик: " + name);
        System.out.printf("  Равнина: %.1f км/ч\n", plainSpeed);
        System.out.printf("  Горы:    %.1f км/ч\n", mountainSpeed);
        System.out.printf("  Пустыня: %.1f км/ч\n", desertSpeed);
    }
    

    public double calculateAverageSpeed() {
        return (plainSpeed + mountainSpeed + desertSpeed) / 3.0;
    }
}

class Tatra {
    private String name;
    private double plainSpeed;
    private double mountainSpeed;
    private double desertSpeed;
    
    public Tatra(String name, double plain, double mountain, double desert) {
        this.name = name;
        this.plainSpeed = plain;
        this.mountainSpeed = mountain;
        this.desertSpeed = desert;
    }
    
    public String getName() { return name; }
    public double getPlainSpeed() { return plainSpeed; }
    public double getMountainSpeed() { return mountainSpeed; }
    public double getDesertSpeed() { return desertSpeed; }
    
    public void displayInfo() {
        System.out.println("Грузовик: " + name);
        System.out.printf("  Равнина: %.1f км/ч\n", plainSpeed);
        System.out.printf("  Горы:    %.1f км/ч\n", mountainSpeed);
        System.out.printf("  Пустыня: %.1f км/ч\n", desertSpeed);
    }
    
    public double calculateAverageSpeed() {
        return (plainSpeed + mountainSpeed + desertSpeed) / 3.0;
    }
}

class RallyUtils {
    public static int frCreater(Kamaz kamaz, Tatra tatra) {
        double kamazAvg = kamaz.calculateAverageSpeed();
        double tatraAvg = tatra.calculateAverageSpeed();
        
        if (Math.abs(kamazAvg - tatraAvg) < 0.01) {
            return 0;
        } else if (kamazAvg > tatraAvg) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static int compareByTerrain(Kamaz kamaz, Tatra tatra, String terrain) {
        double kamazSpeed, tatraSpeed;
        
        switch (terrain.toLowerCase()) {
            case "равнина":
                kamazSpeed = kamaz.getPlainSpeed();
                tatraSpeed = tatra.getPlainSpeed();
                break;
            case "горы":
                kamazSpeed = kamaz.getMountainSpeed();
                tatraSpeed = tatra.getMountainSpeed();
                break;
            case "пустыня":
                kamazSpeed = kamaz.getDesertSpeed();
                tatraSpeed = tatra.getDesertSpeed();
                break;
            default:
                return frCreater(kamaz, tatra); // по умолчанию средняя
        }
        
        if (Math.abs(kamazSpeed - tatraSpeed) < 0.01) {
            return 0;
        } else if (kamazSpeed > tatraSpeed) {
            return 1;
        } else {
            return -1;
        }
    }
    
    public static void createResultsTable(Kamaz kamaz, Tatra tatra) {
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("        РЕЗУЛЬТАТЫ РАЛЛИ-МАРАФОНА «ДАКАР»");
        System.out.println("═══════════════════════════════════════════════════════");
        
        System.out.printf("%-15s %-15s %-15s %-15s\n", 
            "УЧАСТОК", "КАМАЗ", "TATRA", "ЛИДЕР");
        System.out.println("───────────────────────────────────────────────────────");
        
        String[] terrains = {"РАВНИНА", "ГОРЫ", "ПУСТЫНЯ", "СРЕДНЯЯ"};
        
        for (int i = 0; i < terrains.length; i++) {
            String terrain = terrains[i];
            String kamazValue, tatraValue, leader;
            
            if (i < 3) {
                kamazValue = String.format("%.1f км/ч",
                    getSpeedByTerrain(kamaz, terrain));
                tatraValue = String.format("%.1f км/ч", 
                    getSpeedByTerrain(tatra, terrain));
                int result = compareByTerrain(kamaz, tatra, terrain);
                leader = getLeaderName(result, kamaz.getName(), tatra.getName());
            } else {
                kamazValue = String.format("%.1f км/ч", kamaz.calculateAverageSpeed());
                tatraValue = String.format("%.1f км/ч", tatra.calculateAverageSpeed());
                int result = frCreater(kamaz, tatra);
                leader = getLeaderName(result, kamaz.getName(), tatra.getName());
            }
            
            System.out.printf("%-15s %-15s %-15s %-15s\n", 
                terrain, kamazValue, tatraValue, leader);
        }
        
        System.out.println("═══════════════════════════════════════════════════════");
        
        int finalResult = frCreater(kamaz, tatra);
        if (finalResult == 1) {
            System.out.println("\n🎉 ПОБЕДИТЕЛЬ: " + kamaz.getName() + "!");
        } else if (finalResult == -1) {
            System.out.println("\n🎉 ПОБЕДИТЕЛЬ: " + tatra.getName() + "!");
        } else {
            System.out.println("\n🤝 НИЧЬЯ! Оба грузовика показали одинаковый результат!");
        }
    }
    
    // Вспомогательные методы
    private static double getSpeedByTerrain(Kamaz kamaz, String terrain) {
        return switch (terrain) {
            case "РАВНИНА" -> kamaz.getPlainSpeed();
            case "ГОРЫ" -> kamaz.getMountainSpeed();
            case "ПУСТЫНЯ" -> kamaz.getDesertSpeed();
            default -> kamaz.calculateAverageSpeed();
        };
    }
    
    private static double getSpeedByTerrain(Tatra tatra, String terrain) {
        return switch (terrain) {
            case "РАВНИНА" -> tatra.getPlainSpeed();
            case "ГОРЫ" -> tatra.getMountainSpeed();
            case "ПУСТЫНЯ" -> tatra.getDesertSpeed();
            default -> tatra.calculateAverageSpeed();
        };
    }
    
    private static String getLeaderName(int result, String kamazName, String tatraName) {
        if (result == 1) return kamazName;
        if (result == -1) return tatraName;
        return "НИЧЬЯ";
    }
}

class TatraFriend {
    public static void analyzeKamazPerformance(Kamaz kamaz) {
        System.out.println("\n[Анализ от дружественного класса TatraFriend]:");
        System.out.println("Анализируем производительность " + kamaz.getName());
        System.out.printf("Общая оценка: %.1f/100\n", 
            (kamaz.calculateAverageSpeed() * 100 / 120));
        
        // "Доступ" к "приватным" данным через геттеры
        double plain = kamaz.getPlainSpeed();
        double mountain = kamaz.getMountainSpeed();
        double desert = kamaz.getDesertSpeed();
        
        System.out.println("Рекомендации для Tatra:");
        System.out.println("1. На равнине Kamaz сильнее на " + 
            String.format("%.1f", plain - 80) + " км/ч");
        System.out.println("2. В горах нужно улучшить проходимость");
        System.out.println("3. В пустыне конкуренция равная");
    }
}

public class DakarRally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== РАЛЛИ-МАРАФОН «ДАКАР» ===");
        System.out.println("Расчет результатов соревнования грузовиков\n");
        
        Kamaz kamaz = new Kamaz("КАМАЗ-мастер", 110.0, 75.0, 95.0);
        Tatra tatra = new Tatra("Tatra Phoenix", 105.0, 85.0, 90.0);
        
        System.out.println("Хотите ввести данные вручную? (да/нет): ");
        String choice = scanner.nextLine();
        
        if (choice.equalsIgnoreCase("да")) {
            System.out.println("\n=== ВВОД ДАННЫХ ДЛЯ КАМАЗ ===");
            System.out.print("Название: ");
            String kamazName = scanner.nextLine();
            System.out.print("Скорость по равнине (км/ч): ");
            double kamazPlain = scanner.nextDouble();
            System.out.print("Скорость в горах (км/ч): ");
            double kamazMountain = scanner.nextDouble();
            System.out.print("Скорость в пустыне (км/ч): ");
            double kamazDesert = scanner.nextDouble();
            scanner.nextLine(); // очистка буфера
            
            kamaz = new Kamaz(kamazName, kamazPlain, kamazMountain, kamazDesert);
            
            System.out.println("\n=== ВВОД ДАННЫХ ДЛЯ TATRA ===");
            System.out.print("Название: ");
            String tatraName = scanner.nextLine();
            System.out.print("Скорость по равнине (км/ч): ");
            double tatraPlain = scanner.nextDouble();
            System.out.print("Скорость в горах (км/ч): ");
            double tatraMountain = scanner.nextDouble();
            System.out.print("Скорость в пустыне (км/ч): ");
            double tatraDesert = scanner.nextDouble();
            
            tatra = new Tatra(tatraName, tatraPlain, tatraMountain, tatraDesert);
        }
        
        System.out.println("\n=== ХАРАКТЕРИСТИКИ УЧАСТНИКОВ ===");
        kamaz.displayInfo();
        System.out.printf("Средняя скорость: %.1f км/ч\n\n", kamaz.calculateAverageSpeed());
        
        tatra.displayInfo();
        System.out.printf("Средняя скорость: %.1f км/ч\n", tatra.calculateAverageSpeed());
        
        System.out.println("\n=== СРАВНЕНИЕ СКОРОСТЕЙ (функция FrCreater) ===");
        int comparisonResult = RallyUtils.frCreater(kamaz, tatra);
        
        System.out.print("Результат сравнения: ");
        switch (comparisonResult) {
            case 1:
                System.out.println("КАМАЗ быстрее Tatra (+1)");
                break;
            case 0:
                System.out.println("Скорости одинаковы (0)");
                break;
            case -1:
                System.out.println("КАМАЗ медленнее Tatra (-1)");
                break;
        }
        
        System.out.println("\n=== СРАВНЕНИЕ ПО УЧАСТКАМ ===");
        String[] terrains = {"равнина", "горы", "пустыня"};
        
        for (String terrain : terrains) {
            int terrainResult = RallyUtils.compareByTerrain(kamaz, tatra, terrain);
            System.out.printf("%-10s: ", terrain.toUpperCase());
            
            switch (terrainResult) {
                case 1:
                    System.out.println("КАМАЗ лидирует");
                    break;
                case 0:
                    System.out.println("Равные скорости");
                    break;
                case -1:
                    System.out.println("Tatra лидирует");
                    break;
            }
        }
        
        RallyUtils.createResultsTable(kamaz, tatra);
        
        TatraFriend.analyzeKamazPerformance(kamaz);
        
        System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЙ АНАЛИЗ ===");
        System.out.println("Преимущества КАМАЗ:");
        System.out.println("- Лучшая скорость на равнине: " + 
            String.format("%.1f", kamaz.getPlainSpeed() - tatra.getPlainSpeed()) + " км/ч");
        System.out.println("- Сильнее в пустыне: " + 
            String.format("%.1f", kamaz.getDesertSpeed() - tatra.getDesertSpeed()) + " км/ч");
        
        System.out.println("\nПреимущества Tatra:");
        System.out.println("- Лучшая проходимость в горах: " + 
            String.format("%.1f", tatra.getMountainSpeed() - kamaz.getMountainSpeed()) + " км/ч");

        scanner.close();

        System.out.println("\n=== ГОНКА ЗАВЕРШЕНА! ===");
    }
}