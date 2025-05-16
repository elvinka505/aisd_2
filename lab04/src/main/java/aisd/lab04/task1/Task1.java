/*
## Задача 1
Вычисление log(N!)
Реализовать рекурсивную процедуру вычисления логарифма факториала.
по свойству логарифмов:
log(ab) = log(a) + log(b)
значит:
log(N!) = log(1 × 2 × 3 × ... × N) = log(1) + log(2) + log(3) + ... + log(N)
 */
package aisd.lab04.task1;

public class Task1 {
    public static void main(String[] args) {
        int n = 10;
        double result = logFactorial(n);
        System.out.println("log(" + n + "!) = " + result);
    }
        public static double logFactorial(int n) {
            if (n <= 0) { //1) log(0!) = log(1) = 0
                return 0.0;
            }


            //2) рекурсивный метод
            return Math.log(n) + logFactorial(n - 1);
        }
    }
