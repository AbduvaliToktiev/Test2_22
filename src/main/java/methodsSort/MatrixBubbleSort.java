package methodsSort;

/**
 * А ниже представлен алгоритм сортировки двумерного массива Java пузырьком:
 */

public class MatrixBubbleSort {
    public static void main(String args[]) {
        int[][] sortMatrix = new int[][]{
                {8, 3, 5},
                {1, 4, 6},
                {9, 7, 2}
        };
        matrixBubbleSort(sortMatrix);
        //Вывод отсортированного двумерного массива:
        for (int i = 0; i < sortMatrix.length; i++) {
            for (int j = 0; j < sortMatrix[i].length; j++) {
                System.out.print(sortMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixBubbleSort(int[][] sortMatrix) {
        int swap;
        for (int i = 0; i < sortMatrix.length; i++) {
            for (int j = 0; j < sortMatrix[i].length; j++) {
                for (int k = 0; k < sortMatrix.length; k++) {
                    for (int l = 0; l < sortMatrix[k].length; l++) {
                        if (sortMatrix[i][j] <= sortMatrix[k][l]) {
                            swap = sortMatrix[i][j];
                            sortMatrix[i][j] = sortMatrix[k][l];
                            sortMatrix[k][l] = swap;
                        }
                    }
                }
            }
        }
        return sortMatrix;
    }

}
