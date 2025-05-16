public class TreeVisualizer {
    public static void print(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            System.out.println("  ".repeat(level) + node);
            printTree(node.middle, level + 1);
            printTree(node.left, level + 1);
        }
    }
}