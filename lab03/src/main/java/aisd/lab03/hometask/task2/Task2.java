/*
Задача 2
Дан массив целых чисел и число k. Определить, есть ли
в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
Пример:
[1, 2, 3, 1, 5], k = 3
Вывод: true (индекс 0 и 3, расстояние 3)
 */
package aisd.lab03.hometask.task2;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static boolean nearlyDublicates(int[] nums, int k) {
        //1) храним индекс каждого числа здесь:
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //2) если наше число уже встречалось и разница индексов <= k
            if (lastIndexMap.containsKey(num) && i - lastIndexMap.get(num) <= k) {
                return true;
            }
            //3) обновляем последний инлекс для числа
            lastIndexMap.put(num, i);
        }
        return false;
    }
        public static void main(String[] args) {
            int[] nums = {1, 2, 3, 1, 4}; // индекс 1 =0, индекс второй 1 = 4, 4-0= 4 =k
            int k = 4;

            System.out.println(nearlyDublicates(nums, k));

        }
    }
