/*
Задача 2.
Есть строка. Нужно развернуть строку так, чтобы каждое
из слов осталось в естественном порядке. Например.
Input 1: A = "the sky is blue" Output 1: "blue is sky the"
Input 2: A = "this is ib"    Output 2: "ib is this".
Сложность линейная, с О(1) дополнительной памяти.
 */
package aisd.hometask.task2;

public class Task2 {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "the sky is blue";
        System.out.println(reverseWords(input1)); // blue is sky the

        String input2 = "this is ib";
        System.out.println(reverseWords(input2)); // ib is this
    }
}