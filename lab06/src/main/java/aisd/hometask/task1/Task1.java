/*
Задача 1.
Дана последовательность различных чисел, в которой все числа
 до определенного индекса j отсортированы по убыванию,
 а после j по возрастанию. Найдите этот индекс j.  (Сложность O(log n).)
 */
package aisd.hometask.task1;

public class Task1 {
    public static int findIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left указывает на первый элемент возрастающей части, а точка перехода — предыдущий индекс
        return left > 0 ? left - 1 : 0;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 8, 7, 88, 99, 101, 122};
        System.out.println("Индекс перехода: " + findIndex(nums));
    }
}