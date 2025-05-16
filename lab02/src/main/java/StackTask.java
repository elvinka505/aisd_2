/* неверное: (], ([)], { (когда не хватает закрывающей скобки)
используем стек как: последнюю положенную - берем первую
1. открывающую скобку сразу кладем в стек
2. а закрывающую проверяем: если стек пустили последняя открывающая
не совпадает с текущей закрывающей = ошибка
3. в самом конце все скобки закрыты должны быть = стек пуст
 */
import java.util.Stack;

public class StackTask {
    public static boolean isRigth(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char lastOpen = stack.pop();
                if (!isMatching(lastOpen, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }


    public static void main(String[] args) {
        System.out.println(isRigth("()[]{}"));
        System.out.println(isRigth("(]([)]{"));
    }
}
