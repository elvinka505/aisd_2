import java.util.Arrays;

public class Main {
    public static int[] findThreeNumbers(int[] arr, int target) {
        Arrays.sort(arr); // Сортируем массив для удобства
        int n = arr.length;
        int[] result = new int[3];
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                // Если нашли точную сумму — сразу возвращаем
                if (sum == target) {
                    return new int[]{arr[i], arr[left], arr[right]};
                }

                // Проверяем, ближе ли новая сумма к target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if (sum < target) {
                    left++; // Нужно увеличить сумму
                } else {
                    right--; // Нужно уменьшить сумму
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        int[] result = findThreeNumbers(nums, target);
        System.out.println("Ближайшая тройка: " + result[0] + ", " + result[1] + ", " + result[2]);
    }
}
