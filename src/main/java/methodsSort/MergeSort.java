package methodsSort;

/**
 * Алгоритм сортировки слиянием на Java
 * Данный алгоритм разбивает список на две части, каждую из них он разбивает ещё на две и так далее,
 * пока не останутся единичные элементы. Массив из одного элемента считается упорядоченным.
 * Соседние элементы сравниваются и соединяются вместе. Так происходит до тех пор, пока все элементы не будут отсортированы.
 * Примечание По возможности используйте готовые алгоритмы для коллекций и методы из java.util.Arrays.
 *
 * Реализовать алгоритм сортировки слиянием на Java можно так:
 *
 * Объяснение:
 * Сортировка осуществляется путём сравнения наименьших элементов каждого подмассива.
 * Первые элементы каждого подмассива сравниваются первыми. Наименьший элемент перемещается в результирующий массив.
 * Счётчики результирующего массива и подмассива, откуда был взят элемент, увеличиваются на один.
 */

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        int[] result = Main.mergeSort(sortArr);
        System.out.println(Arrays.toString(result));
    }

    public static class Main {
        public static int[] mergeSort(int[] sortArr) {
            int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
            int[] buffer2 = new int[sortArr.length];
            int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
            return result;
        }

        public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
            if (startIndex >= endIndex - 1) {
                return buffer1;
            }

            //уже отсортирован
            int middle = startIndex + (endIndex - startIndex) / 2;
            int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
            int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

            //слияние
            int index1 = startIndex;
            int index2 = middle;
            int destIndex = startIndex;
            int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
            while (index1 < middle && index2 < endIndex) {
                result[destIndex++] = sorted1[index1] < sorted2[index2]
                        ? sorted1[index1++] : sorted2[index2++];
            }
            while (index1 < middle) {
                result[destIndex++] = sorted1[index1++];
            }
            while (index2 < endIndex) {
                result[destIndex++] = sorted2[index2++];
            }
            return result;
        }
    }
}
