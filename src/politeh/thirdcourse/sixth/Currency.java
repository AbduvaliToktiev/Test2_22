package politeh.thirdcourse.sixth;

abstract class Currency {
    protected double amount;
    
    public Currency(double amount) {
        this.amount = amount;
    }
    
    public abstract double convertToRubles();
    public abstract void display();
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class Dollar extends Currency {
    private static final double EXCHANGE_RATE = 75.50;
    
    public Dollar(double amount) {
        super(amount);
    }
    
    @Override
    public double convertToRubles() {
        return amount * EXCHANGE_RATE;
    }
    
    @Override
    public void display() {
        System.out.printf("Доллары: $%.2f = %.2f руб. (курс: %.2f)\n", 
                         amount, convertToRubles(), EXCHANGE_RATE);
    }
    
    public static double getExchangeRate() {
        return EXCHANGE_RATE;
    }
}

class Euro extends Currency {
    private static final double EXCHANGE_RATE = 85.30;
    
    public Euro(double amount) {
        super(amount);
    }
    
    @Override
    public double convertToRubles() {
        return amount * EXCHANGE_RATE;
    }
    
    @Override
    public void display() {
        System.out.printf("Евро: €%.2f = %.2f руб. (курс: %.2f)\n", 
                         amount, convertToRubles(), EXCHANGE_RATE);
    }
    
    public static double getExchangeRate() {
        return EXCHANGE_RATE;
    }
}