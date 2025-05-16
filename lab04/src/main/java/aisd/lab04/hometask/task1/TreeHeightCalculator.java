package aisd.lab04.hometask.task1;

public class TreeHeightCalculator {

    public void calcHeights(TreeNode root) {
        calcSubtreeHeights(root);
    }

    private int calcSubtreeHeights(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = calcSubtreeHeights(node.getLeft());
        int rightHeight = calcSubtreeHeights(node.getRight());

        int currentHeight = 1 + Math.max(leftHeight, rightHeight);
        node.setHeight(currentHeight);

        return currentHeight;
    }
}