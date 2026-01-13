package politeh.thirdcourse.sixth;

import java.util.Arrays;

abstract class Array {
    protected int[] data;
    protected int size;
    protected static final int MAX_SIZE = 100;
    
    public Array(int size, int defaultValue) {
        this.size = Math.min(size, MAX_SIZE);
        data = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            data[i] = defaultValue;
        }
    }
    
    public Array(int size) {
        this(size, 0);
    }
    
    public abstract Array add(Array other);
    
    public void print() {
        System.out.println("Массив: " + Arrays.toString(data));
    }
    
    public int getSize() {
        return size;
    }
    
    public int getElement(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        }
        return 0;
    }
    
    public void setElement(int index, int value) {
        if (index >= 0 && index < size) {
            data[index] = value;
        }
    }
}

class BoundedArray extends Array {
    private static final int MAX_VALUE = 100;
    
    public BoundedArray(int size, int defaultValue) {
        super(size, defaultValue);
    }
    
    public BoundedArray(int size) {
        super(size);
    }
    
    @Override
    public Array add(Array other) {
        if (this.size != other.getSize()) {
            throw new IllegalArgumentException("Массивы должны быть одного размера");
        }
        
        BoundedArray result = new BoundedArray(this.size);
        for (int i = 0; i < size; i++) {
            int sum = this.data[i] + other.getElement(i);
            result.setElement(i, Math.min(sum, MAX_VALUE));
        }
        return result;
    }
    
    @Override
    public void print() {
        System.out.print("BoundedArray (max=" + MAX_VALUE + "): ");
        super.print();
    }
}

class ModularArray extends Array {
    private static final int MODULUS = 50;
    
    public ModularArray(int size, int defaultValue) {
        super(size, defaultValue);
    }
    
    public ModularArray(int size) {
        super(size);
    }
    
    @Override
    public Array add(Array other) {
        if (this.size != other.getSize()) {
            throw new IllegalArgumentException("Массивы должны быть одного размера");
        }
        
        ModularArray result = new ModularArray(this.size);
        for (int i = 0; i < size; i++) {
            int sum = this.data[i] + other.getElement(i);
            result.setElement(i, sum % MODULUS);
        }
        return result;
    }
    
    @Override
    public void print() {
        System.out.print("ModularArray (mod=" + MODULUS + "): ");
        super.print();
    }
}