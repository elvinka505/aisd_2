package aisd.lab03.task4;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        // Добавляем оставшиеся элементы
        while (!q1.isEmpty()) result.add(q1.poll());
        while (!q2.isEmpty()) result.add(q2.poll());

        return result;
    }

    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(3);
        q1.add(5);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(2);
        q2.add(4);
        q2.add(6);

        Queue<Integer> merged = merge(q1, q2);
        System.out.println(merged); // [1, 2, 3, 4, 5, 6]
    }
}