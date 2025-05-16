package aisd.lab03.task2;
/* 1. разбиваем строчку на элементы по пробелам \\s+
2. создаем пустой стек для наших чисел
3. а для каждого элемента:
1) если число = кладем в стек
2) если это операция - 1) 2 последних числа из стека берем, 2) вып операцию 3) обратно кладем в стек
4. оставшийся элемент
 */

import java.util.Stack;

public class Calculator {
    public static int calculate(String exp) {
        Stack<Integer> stack = new Stack<>();
        String[] pieces = exp.split("\\s+");

        for (String piece : pieces) {
            if (piece.isEmpty()) continue;

            if (isNumber(piece)) {
                stack.push(Integer.parseInt(piece));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                int result = performOperation(a, b, piece);
                stack.push(result);
            }
        }
        return stack.pop();

    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new IllegalArgumentException("Неизвестная операция: " + op);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("3 4 +"));          // 7 (3 + 4)
        System.out.println(calculate("5 2 1 + *"));      // 15 (5 * (2 + 1))
        System.out.println(calculate("10 6 9 3 + - *")); // 60 (10 * (6 - (9 + 3)))
    }
    }
