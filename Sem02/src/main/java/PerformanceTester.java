import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class PerformanceTester {
    public static void testAndSaveResults() {
        try (PrintWriter writer = new PrintWriter(new File("performance.csv"))) {
            writer.println("Size,Insert,Search,Delete");

            Random random = new Random();
            for (int size = 100; size <= 10000; size += 200) {
                int[] data = generateTestData(size, random);

                TwoThreeTree tree = new TwoThreeTree();
                long[] times = testOperations(tree, data);

                writer.printf("%d,%d,%d,%d\n",
                        size, times[0], times[1], times[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] generateTestData(int size, Random random) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(1000000);
        }
        return data;
    }

    private static long[] testOperations(TwoThreeTree tree, int[] data) {
        long[] times = new long[3];

        long start = System.nanoTime();
        for (int key : data) tree.insert(key);
        times[0] = System.nanoTime() - start;

        start = System.nanoTime();
        for (int key : data) tree.contains(key);
        times[1] = System.nanoTime() - start;

        start = System.nanoTime();
        for (int key : data) tree.remove(key);
        times[2] = System.nanoTime() - start;

        return times;
    }
}