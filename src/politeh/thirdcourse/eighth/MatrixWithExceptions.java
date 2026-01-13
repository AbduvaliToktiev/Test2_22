package politeh.thirdcourse.eighth;

class MatrixException extends Exception {
    public MatrixException(String message) {
        super(message);
    }
}

class InvalidMatrixSizeException extends MatrixException {
    public InvalidMatrixSizeException(String message) {
        super(message);
    }
}

class MatrixMultiplicationException extends MatrixException {
    public MatrixMultiplicationException(String message) {
        super(message);
    }
}

class Matrix {
    private int[][] data;
    private int rows;
    private int cols;
    
    public Matrix(int rows, int cols) throws InvalidMatrixSizeException {
        if (rows <= 0 || cols <= 0) {
            throw new InvalidMatrixSizeException(
                String.format("Некорректный размер матрицы: %d x %d", rows, cols)
            );
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }
    
    public void setElement(int row, int col, int value) throws MatrixException {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new MatrixException(
                String.format("Индекс [%d][%d] выходит за пределы матрицы %d x %d", 
                             row, col, rows, cols)
            );
        }
        data[row][col] = value;
    }
    
    public int getElement(int row, int col) throws MatrixException {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new MatrixException(
                String.format("Индекс [%d][%d] выходит за пределы матрицы %d x %d", 
                             row, col, rows, cols)
            );
        }
        return data[row][col];
    }
    
    public void fillRandom() {
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = rand.nextInt(10);
            }
        }
    }
    
    public void print() {
        System.out.println("Матрица " + rows + "x" + cols + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", data[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public Matrix multiply(Matrix other) throws MatrixMultiplicationException {
        if (this.cols != other.rows) {
            throw new MatrixMultiplicationException(
                String.format("Невозможно умножить матрицы: %dx%d и %dx%d", 
                             this.rows, this.cols, other.rows, other.cols)
            );
        }
        
        try {
            Matrix result = new Matrix(this.rows, other.cols);
            
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    int sum = 0;
                    for (int k = 0; k < this.cols; k++) {
                        sum += this.getElement(i, k) * other.getElement(k, j);
                    }
                    result.setElement(i, j, sum);
                }
            }
            
            return result;
            
        } catch (MatrixException e) {
            throw new MatrixMultiplicationException("Ошибка при умножении матриц: " + e.getMessage());
        }
    }
    
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}

public class MatrixWithExceptions {
    
    public static void demonstrateMatrixExceptions() {
        System.out.println("\n=== Демонстрация исключений при работе с матрицами ===\n");
        
        try {
            System.out.println("1. Создание матриц:");
            Matrix A = new Matrix(2, 3);
            Matrix B = new Matrix(3, 2);
            
            A.fillRandom();
            B.fillRandom();
            
            A.print();
            B.print();
            
            System.out.println("2. Умножение матриц:");
            Matrix C = A.multiply(B);
            C.print();
            
            System.out.println("3. Попытка некорректного умножения:");
            Matrix D = new Matrix(2, 2);
            D.fillRandom();
            D.print();
            
            Matrix E = A.multiply(D);
            
        } catch (InvalidMatrixSizeException e) {
            System.out.println("Ошибка размера матрицы: " + e.getMessage());
        } catch (MatrixMultiplicationException e) {
            System.out.println("Ошибка умножения матриц: " + e.getMessage());
        }

        System.out.println("\n4. Демонстрация разных сценариев:");
        
        try {
            System.out.println("а) Создание матрицы с некорректным размером:");
            Matrix badMatrix = new Matrix(-1, 5);
        } catch (InvalidMatrixSizeException e) {
            System.out.println("Перехвачено: " + e.getMessage());
        }
        
        try {
            System.out.println("\nб) Выход за границы матрицы:");
            Matrix smallMatrix = new Matrix(2, 2);
            smallMatrix.setElement(5, 5, 100);
        } catch (MatrixException e) {
            System.out.println("Перехвачено: " + e.getMessage());
        }
        
        System.out.println("\nв) Вложенные блоки try-catch:");
        try {
            Matrix m1 = new Matrix(3, 3);
            Matrix m2 = new Matrix(2, 3);
            
            try {
                Matrix result = m1.multiply(m2);
            } catch (MatrixMultiplicationException e) {
                System.out.println("Внутренний catch: " + e.getMessage());
            }
            
            System.out.println("Выполнение продолжается после обработки вложенного исключения");
            
        } catch (InvalidMatrixSizeException e) {
            System.out.println("Внешний catch: " + e.getMessage());
        }
        
        System.out.println("\n5. Обработка нескольких типов исключений:");
        try {
            Matrix m = new Matrix(0, 0);
            m.setElement(0, 0, 1);
            Matrix result = m.multiply(m); 
            
        } catch (InvalidMatrixSizeException e) {
            System.out.println("Обработано InvalidMatrixSizeException: " + e.getMessage());
        } catch (MatrixMultiplicationException e) {
            System.out.println("Обработано MatrixMultiplicationException: " + e.getMessage());
        } catch (MatrixException e) {
            System.out.println("Обработано общее MatrixException: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполнен!");
        }
    }
}