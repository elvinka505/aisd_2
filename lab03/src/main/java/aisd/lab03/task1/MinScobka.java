package aisd.lab03.task1;
/* 1. проиницилизировать стек для отслеживания открывающих скобок
2. проходимся по стеку: если открывающая - в стек, если закрывающая -
1) если стек не пуст и на вершине открывающая скобка = забираем из стека
2) увеличиваем счетчик удалений
3. после прохождения убираем все ненужные(оставшиеся) скобки
 */
import java.util.Stack;

public class MinScobka {
    public static int MinScobka(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        int removals = 0;

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    removals++;
                } else {
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }

        // удаляем все скобки которые пометили выше в вайл
        return (int) sb.chars().filter(ch -> ch != '*').count();

    }

    public static void main(String[] args) {
        System.out.println(MinScobka(""));
        System.out.println(MinScobka("(((((((((((((("));
        System.out.println(MinScobka(")()()("));
    }
}
