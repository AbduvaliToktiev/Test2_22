package politeh.thirdcourse.eighth;

class ArrayBoundsException extends Exception {
    public ArrayBoundsException(String message) {
        super(message);
    }
}

class SafeArray {
    private int[] arr;
    private int size;
    
    public SafeArray(int size) {
        this.size = size;
        arr = new int[size];
    }
    
    public void putel(int index, int value) throws ArrayBoundsException {
        if (index < 0 || index >= size) {
            throw new ArrayBoundsException(
                String.format("Индекс %d выходит за пределы массива [0, %d]", index, size-1)
            );
        }
        arr[index] = value;
        System.out.printf("Элемент arr[%d] установлен в %d\n", index, value);
    }
    
    public int getel(int index) throws ArrayBoundsException {
        if (index < 0 || index >= size) {
            throw new ArrayBoundsException(
                String.format("Индекс %d выходит за пределы массива [0, %d]", index, size-1)
            );
        }
        return arr[index];
    }
    
    public int getSize() {
        return size;
    }
}

public class ArrayWithExceptions {
    
    public static void demonstrateArrayExceptions() {
        System.out.println("=== Демонстрация обработки исключений в массиве ===\n");
        
        SafeArray array = new SafeArray(5);
        
        try {
            array.putel(0, 10);
            array.putel(1, 20);
            array.putel(2, 30);
            
            System.out.println("arr[1] = " + array.getel(1));
            System.out.println("arr[2] = " + array.getel(2));
            
            System.out.println("\nПопытка получить элемент с индексом 10:");
            System.out.println("arr[10] = " + array.getel(10));
            
        } catch (ArrayBoundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }
        
        try {
            System.out.println("\nПопытка установить элемент с индексом -1:");
            array.putel(-1, 100);
            
        } catch (ArrayBoundsException e) {
            System.out.println("ОШИБКА: " + e.getMessage());
        }
        
        System.out.println("\nМножественные операции в одном блоке try:");
        try {
            array.putel(3, 40);
            array.putel(4, 50);
            array.putel(5, 60);
            array.putel(6, 70);
            
        } catch (ArrayBoundsException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
            System.out.println("Выполнение продолжается после обработки исключения...");
        }
        
        System.out.println("\nДемонстрация блока finally:");
        try {
            System.out.println("Попытка получить элемент с индексом 100:");
            int value = array.getel(100);
            System.out.println("Значение: " + value);
        } catch (ArrayBoundsException e) {
            System.out.println("Исключение: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполняется всегда!");
        }
    }
}