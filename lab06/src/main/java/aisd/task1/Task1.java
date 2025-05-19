package aisd.task1;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {2, 0, 1, 2, 1, 0};
        sort(arr);
        printArray(arr);
    }

    public static void sort(int[] arr) {
        int low = 0, mid = 0, rigth = arr.length - 1;

        while (mid <= rigth) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, rigth);
                rigth--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
    }
}