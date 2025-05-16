package aisd.lab03.task3;
/* 1. если массив пуст = вовзращаем его
2. создаем стек, туда первый элемент
3. в массиве: 1) если элемент не равен вершине стека = добавляем его в стек
2) если равен = дубликат (пропускаем)

 */

import java.util.Stack;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] nums) {
        if (nums.length == 0) return nums;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != stack.peek()) { // сравниваем с вершиной стека
                stack.push(nums[i]); // добавляем, если не дубликат
            }
        }

        // конвертируем стек в массив
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        return result;
    }

    }
