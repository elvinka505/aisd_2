public class Main {
    public static void main(String[] args) {
        // Пример использования
        TwoThreeTree tree = new TwoThreeTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);

        System.out.println("Содержит 10: " + tree.contains(10));
        TreeVisualizer.print(tree.getRoot());

        // Тест производительности
        PerformanceTester.testAndSaveResults();
    }
}