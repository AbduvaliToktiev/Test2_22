package methodsSort;

/**
 * Алгоритм сортировки выбором на Java
 * Идея алгоритма:
 * Разбиваем массив на отсортированную и неотсортированную части.
 * Находим в неотсортированной части минимальный элемент.
 * Меняем его местами с тем элементом, который находится на нулевой позиции —
 * в конец отсортированного массива.
 * Далее находим следующий по величине элемент и меняем его с элементом на первой позиции, etc.,
 * пока не закончатся неотсортированные значения.
 *
 * Реализация сортировки выбором на языке программирования Java:
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        selectionSort(sortArr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void selectionSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            //меняем местами наименьший с sortArr[i]
            sortArr[i] = min;
        }
    }

}
