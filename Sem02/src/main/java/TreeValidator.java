public class TreeValidator {
    public static boolean isValid(TreeNode root) {
        return checkValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkValid(TreeNode node, int min, int max) {
        if (node == null) return true;

        if (node.isTwoNode) {
            if (node.key1 <= min || node.key1 >= max) return false;
            return checkValid(node.left, min, node.key1) &&
                    checkValid(node.right, node.key1, max);
        } else {
            if (node.key1 <= min || node.key2 >= max || node.key1 >= node.key2) return false;
            return checkValid(node.left, min, node.key1) &&
                    checkValid(node.middle, node.key1, node.key2) &&
                    checkValid(node.right, node.key2, max);
        }
    }
}