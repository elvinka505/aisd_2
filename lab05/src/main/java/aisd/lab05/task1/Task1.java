/*
Задача поиска
1) arr[n], a[i] <= a[i+1
   input -> a
   i, j => a[i] = min = a
   a[i] = max = a

   arr[1, 2, 2, 2, 4, 5]
   a = 2;
   1, 3
2) на вход 2 параметра - массив и искомое число, надо найти
минимальный и максимальный индексы искомого числа
 */
package aisd.lab05.task1;
public class Task1 {
    public static void main(String[] args) {
        int[] answer = bs(new int[] {0, 1, 2, 2, 2, 2, 2, 3, 4, 5}, 2);
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] bs(int[] x, int y) {
        int[] answer = new int[2];
        int l = 0;
        int r = x.length - 1;
        int m;

        while(l <= r) {
            m = (l+r)/2;
            if (x[m] < y) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        answer[0] = l;

        l = 0;
        r = x.length - 1;
        while(l <= r) {
            m = (l+r)/2;
            if (x[m] <= y) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        answer[1] = l - 1;
        return answer;
    }

}
