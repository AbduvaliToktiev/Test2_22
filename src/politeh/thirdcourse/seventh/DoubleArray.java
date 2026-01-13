package politeh.thirdcourse.seventh;

import java.util.Arrays;
import java.util.Random;

class DoubleArray<T extends Number> {
    private T[] array1;
    private T[] array2;
    private int size;
    private Random random;
    private Class<T> type;

    public DoubleArray(int size, Class<T> type) {
        this.size = size;
        this.random = new Random();
        this.type = type;

        array1 = (T[]) java.lang.reflect.Array.newInstance(type, size);
        array2 = (T[]) java.lang.reflect.Array.newInstance(type, size);

        fillArrays();
    }

    private void fillArrays() {
        for (int i = 0; i < size; i++) {
            if (type == Integer.class) {
                array1[i] = (T) Integer.valueOf(random.nextInt(100));
                array2[i] = (T) Integer.valueOf(random.nextInt(100));
            } else if (type == Double.class) {
                array1[i] = (T) Double.valueOf(random.nextDouble() * 100);
                array2[i] = (T) Double.valueOf(random.nextDouble() * 100);
            } else if (type == Float.class) {
                array1[i] = (T) Float.valueOf(random.nextFloat() * 100);
                array2[i] = (T) Float.valueOf(random.nextFloat() * 100);
            }
        }
    }

    public double sumArrays() {
        double sum = 0;

        for (int i = 0; i < size; i++) {
            sum += array1[i].doubleValue() + array2[i].doubleValue();
        }

        return sum;
    }

    public T[] elementwiseSum() {
        if (type == Integer.class) {
            Integer[] result = new Integer[size];
            for (int i = 0; i < size; i++) {
                result[i] = array1[i].intValue() + array2[i].intValue();
            }
            return (T[]) result;
        } else if (type == Double.class) {
            Double[] result = new Double[size];
            for (int i = 0; i < size; i++) {
                result[i] = array1[i].doubleValue() + array2[i].doubleValue();
            }
            return (T[]) result;
        } else if (type == Float.class) {
            Float[] result = new Float[size];
            for (int i = 0; i < size; i++) {
                result[i] = array1[i].floatValue() + array2[i].floatValue();
            }
            return (T[]) result;
        }
        return null;
    }

    public void printArrays() {
        System.out.println("Массив 1: " + Arrays.toString(array1));
        System.out.println("Массив 2: " + Arrays.toString(array2));
    }

    public T[] getArray1() { return array1; }
    public T[] getArray2() { return array2; }
    public int getSize() { return size; }
}

class DoubleArrayDemo {
    public static void demonstrate() {
        System.out.println("\n=== Демонстрация шаблонного класса DoubleArray ===\n");

        System.out.println("1. Работа с Integer:");
        DoubleArray<Integer> intArrays = new DoubleArray<>(5, Integer.class);
        intArrays.printArrays();
        System.out.println("Сумма всех элементов: " + intArrays.sumArrays());
        System.out.println("Поэлементная сумма: " + Arrays.toString(intArrays.elementwiseSum()));

        System.out.println("\n2. Работа с Double:");
        DoubleArray<Double> doubleArrays = new DoubleArray<>(5, Double.class);
        doubleArrays.printArrays();
        System.out.println("Сумма всех элементов: " + doubleArrays.sumArrays());
        System.out.println("Поэлементная сумма: " + Arrays.toString(doubleArrays.elementwiseSum()));

        System.out.println("\n3. Работа с Float:");
        DoubleArray<Float> floatArrays = new DoubleArray<>(5, Float.class);
        floatArrays.printArrays();
        System.out.println("Сумма всех элементов: " + floatArrays.sumArrays());
        System.out.println("Поэлементная сумма: " + Arrays.toString(floatArrays.elementwiseSum()));
    }
}