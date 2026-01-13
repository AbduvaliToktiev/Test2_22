package politeh.thirdcourse.second;

class Nomenclature {
    private String productName;
    private double wholesalePrice;
    private double retailMarkup; // в процентах
    private int quantityInStock;
    
    public Nomenclature() {
        this.productName = "Не указано";
        this.wholesalePrice = 0.0;
        this.retailMarkup = 0.0;
        this.quantityInStock = 0;
        System.out.println("Создан товар (конструктор по умолчанию)");
    }
    
    public Nomenclature(String name, double wholesale, double markup, int quantity) {
        this.productName = name;
        this.wholesalePrice = wholesale;
        this.retailMarkup = markup;
        this.quantityInStock = quantity;
        System.out.println("Создан товар: " + name);
    }
    
    public Nomenclature(Nomenclature other) {
        this.productName = other.productName;
        this.wholesalePrice = other.wholesalePrice;
        this.retailMarkup = other.retailMarkup;
        this.quantityInStock = other.quantityInStock;
        System.out.println("Создана копия товара: " + other.productName);
    }
    
    public double calculateNetIncome() {
        double retailPrice = wholesalePrice * (1 + retailMarkup / 100);
        double incomePerUnit = retailPrice - wholesalePrice;
        return incomePerUnit * quantityInStock;
    }
    
    public void displayProductInfo() {
        System.out.println("\n=== ИНФОРМАЦИЯ О ТОВАРЕ ===");
        System.out.println("Название: " + productName);
        System.out.printf("Оптовая цена: %.2f руб.\n", wholesalePrice);
        System.out.printf("Розничная наценка: %.1f%%\n", retailMarkup);
        System.out.println("Количество на складе: " + quantityInStock + " шт.");
        
        double retailPrice = wholesalePrice * (1 + retailMarkup / 100);
        System.out.printf("Розничная цена: %.2f руб.\n", retailPrice);
        System.out.printf("Возможный чистый доход: %.2f руб.\n", calculateNetIncome());
        System.out.println("===========================\n");
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String name) {
        this.productName = name;
    }
    
    public double getWholesalePrice() {
        return wholesalePrice;
    }
    
    public void setWholesalePrice(double price) {
        this.wholesalePrice = price;
    }
    
    public double getRetailMarkup() {
        return retailMarkup;
    }
    
    public void setRetailMarkup(double markup) {
        this.retailMarkup = markup;
    }
    
    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    public void setQuantityInStock(int quantity) {
        this.quantityInStock = quantity;
    }
    
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Товар '" + productName + "' удален со склада");
        } finally {
            super.finalize();
        }
    }
}

public class NomenclatureDemo {
    public static void main(String[] args) {
        System.out.println("=== УПРАВЛЕНИЕ СКЛАДОМ ТОВАРОВ ===\n");
        
        System.out.println("1. Создание товаров разными конструкторами:");
        
        Nomenclature product1 = new Nomenclature();
        product1.setProductName("Молоко");
        product1.setWholesalePrice(50.0);
        product1.setRetailMarkup(20.0);
        product1.setQuantityInStock(100);
        
        Nomenclature product2 = new Nomenclature("Хлеб", 30.0, 25.0, 200);
        
        Nomenclature product3 = new Nomenclature(product2);
        product3.setProductName("Хлеб ржаной");
        product3.setRetailMarkup(30.0);
        
        System.out.println("\n2. Информация о товарах:");
        product1.displayProductInfo();
        product2.displayProductInfo();
        product3.displayProductInfo();
        
        System.out.println("3. Расчет общего дохода со склада:");
        double totalIncome = product1.calculateNetIncome() + 
                            product2.calculateNetIncome() + 
                            product3.calculateNetIncome();
        System.out.printf("Общий возможный доход: %.2f руб.\n", totalIncome);
        
        System.out.println("\n4. Очистка объектов:");
        product1 = null;
        product2 = null;
        product3 = null;
        
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nПрограмма завершена!");
    }
}