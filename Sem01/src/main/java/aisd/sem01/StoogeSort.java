package aisd.sem01;

public class StoogeSort {
    private static long iterations = 0;

    public static void stoogeSort(int[] arr) {
        long startTime = System.nanoTime();
        iterations = 0;

        stoogeSort(arr, 0, arr.length - 1);

        System.out.println("Длина входных данных: " + arr.length +
                " Время (мс): " + (double)(System.nanoTime() - startTime) / 1000000 +
                " Количество итераций: " + iterations);
    }

    private static void stoogeSort(int[] arr, int l, int h) {
        iterations++;

        // если первый элемент больше последнего то меняем их местами
        if (arr[l] > arr[h]) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;
        }

        // если в массиве больше 2 элементов
        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;

            // рекурсивно сортируем первые 2/3
            stoogeSort(arr, l, h - t);

            // рекурсивно сортируем последние 2/3
            stoogeSort(arr, l + t, h);

            // снова сортируем первые 2/3
            stoogeSort(arr, l, h - t);
        }
    }
}