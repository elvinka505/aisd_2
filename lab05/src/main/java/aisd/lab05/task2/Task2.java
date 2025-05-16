/*
Задача 2.
s = aabaa
t = aaaab
Является ли s циклическим сдвигом от t и если да, то насколько
Сложность линейная О(|s| + |t|)
Ответ: да, 2
Сдвиг влево
Сложить строки и проверить на вхождение строки
Начало s стало концом t
s можно сконкатенировать с s

 */
package aisd.lab05.task2;

public class Task2 {
    public static void main(String[] args) {
        String s = "aabaa";
        String t = "aaaab";

        int shift = findCyclicShift(s, t);
        if (shift != -1) {
            System.out.println("Да, сдвиг влево на " + shift + " позиции");
        } else {
            System.out.println("Нет, это не циклический сдвиг");
        }
    }

    public static int findCyclicShift(String s, String t) {
        // Проверка на одинаковую длину
        if (s.length() != t.length()) {
            return -1;
        }

        // Проверка, является ли t подстрокой s + s
        String doubledS = s + s;
        int index = doubledS.indexOf(t);

        if (index == -1) {
            return -1; // t не является циклическим сдвигом s
        }

        // Вычисляем величину сдвига (влево)
        return (s.length() - index) % s.length();
    }
}