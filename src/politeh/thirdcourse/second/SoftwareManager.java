package politeh.thirdcourse.second;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Soft {
    private String programName;
    private String developer;
    private double diskSpace;
    private LocalDate licenseExpiryDate;
    
    public Soft() {
        this.programName = "Не указано";
        this.developer = "Не указан";
        this.diskSpace = 0.0;
        this.licenseExpiryDate = LocalDate.now().plusYears(1);
    }
    
    public Soft(String name, String dev, double space, String expiryDate) {
        this.programName = name;
        this.developer = dev;
        this.diskSpace = space;
        this.licenseExpiryDate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
    public Soft(String name, String dev, double space, LocalDate expiryDate) {
        this.programName = name;
        this.developer = dev;
        this.diskSpace = space;
        this.licenseExpiryDate = expiryDate;
    }
    
    public long daysUntilLicenseExpiry() {
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(today, licenseExpiryDate);
    }
    
    public void displaySoftwareInfo() {
        System.out.println("\n?????????????????????????????????????????????");
        System.out.println("?        ИНФОРМАЦИЯ О ПРОГРАММЕ            ?");
        System.out.println("?????????????????????????????????????????????");
        System.out.println("? Название: " + String.format("%-30s", programName) + "?");
        System.out.println("? Разработчик: " + String.format("%-27s", developer) + "?");
        System.out.printf("? Занимаемый объем: %-7.1f МБ %17s?\n", diskSpace, "");
        System.out.println("? Дата окончания лицензии: " + 
                         String.format("%-17s", licenseExpiryDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))) + "?");
        
        long daysLeft = daysUntilLicenseExpiry();
        if (daysLeft > 0) {
            System.out.printf("? Осталось дней лицензии: %-17d?\n", daysLeft);
        } else if (daysLeft == 0) {
            System.out.println("? ?  Лицензия истекает СЕГОДНЯ!          ?");
        } else {
            System.out.println("? ?  Лицензия ПРОСРОЧЕНА!              ?");
        }
        System.out.println("?????????????????????????????????????????????");
    }
    
    public String getLicenseStatus() {
        long daysLeft = daysUntilLicenseExpiry();
        if (daysLeft > 30) {
            return "АКТИВНА";
        } else if (daysLeft > 0) {
            return "ИСТЕКАЕТ";
        } else {
            return "ПРОСРОЧЕНА";
        }
    }
    
    public String getProgramName() {
        return programName;
    }
    
    public void setProgramName(String name) {
        this.programName = name;
    }
    
    public String getDeveloper() {
        return developer;
    }
    
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    
    public double getDiskSpace() {
        return diskSpace;
    }
    
    public void setDiskSpace(double space) {
        this.diskSpace = space;
    }
    
    public LocalDate getLicenseExpiryDate() {
        return licenseExpiryDate;
    }
    
    public void setLicenseExpiryDate(LocalDate date) {
        this.licenseExpiryDate = date;
    }
    
    public void setLicenseExpiryDate(String dateStr) {
        this.licenseExpiryDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Программа '" + programName + "' удалена из системы");
        } finally {
            super.finalize();
        }
    }
}

public class SoftwareManager {
    public static void main(String[] args) {
        System.out.println("=== МЕНЕДЖЕР ПРОГРАММНОГО ОБЕСПЕЧЕНИЯ ===\n");
        
        // Создание объектов ПО разными конструкторами
        System.out.println("1. Установка программного обеспечения:");
        
        Soft program1 = new Soft();
        program1.setProgramName("Microsoft Office");
        program1.setDeveloper("Microsoft Corporation");
        program1.setDiskSpace(2500.5);
        program1.setLicenseExpiryDate(LocalDate.now().plusMonths(45));
        
        Soft program2 = new Soft("Adobe Photoshop", "Adobe Inc.", 3500.0, "31.12.2024");
        
        Soft program3 = new Soft("IntelliJ IDEA", "JetBrains", 1200.0, 
                                LocalDate.now().plusDays(15));
        
        Soft program4 = new Soft("Windows 11", "Microsoft", 20000.0, 
                                LocalDate.now().minusDays(30)); // Просроченная
        
        System.out.println("\n2. Информация об установленном ПО:");
        program1.displaySoftwareInfo();
        program2.displaySoftwareInfo();
        program3.displaySoftwareInfo();
        program4.displaySoftwareInfo();
        
        System.out.println("\n3. Анализ состояния лицензий:");
        System.out.println("================================");
        Soft[] programs = {program1, program2, program3, program4};
        
        for (Soft program : programs) {
            long daysLeft = program.daysUntilLicenseExpiry();
            String status = program.getLicenseStatus();
            
            System.out.printf("%-20s: %-12s (дней: %+d)\n", 
                program.getProgramName(), status, daysLeft);
        }
        
        System.out.println("\n4. Статистика:");
        double totalSpace = 0;
        for (Soft program : programs) {
            totalSpace += program.getDiskSpace();
        }
        System.out.printf("Общий занимаемый объем: %.1f МБ (%.2f ГБ)\n", 
                         totalSpace, totalSpace / 1024);
        
        System.out.println("\n5. Очистка данных:");
        program1 = null;
        program2 = null;
        program3 = null;
        program4 = null;
        
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nРабота программы завершена!");
    }
}