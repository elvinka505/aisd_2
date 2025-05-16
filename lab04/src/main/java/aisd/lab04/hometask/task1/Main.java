package aisd.lab04.hometask.task1;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));

        TreeHeightCalculator calculator = new TreeHeightCalculator();
        calculator.calcHeights(root);

        printHeights(root);
    }

    private static void printHeights(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println("Узел " + node.getValue() + ": высота = " + node.getHeight());
        printHeights(node.getLeft());
        printHeights(node.getRight());
    }
}
