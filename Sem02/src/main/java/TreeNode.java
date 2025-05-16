public class TreeNode {
    public int key1;
    public int key2;
    public TreeNode left;
    public TreeNode middle;
    public TreeNode right;
    public boolean isTwoNode;

    public TreeNode(int key) {
        this.key1 = key;
        this.isTwoNode = true;
    }

    public TreeNode(int key1, int key2) {
        this.key1 = Math.min(key1, key2);
        this.key2 = Math.max(key1, key2);
        this.isTwoNode = false;
    }

    public boolean isLeaf() {
        return left == null && middle == null && right == null;
    }

    @Override
    public String toString() {
        return isTwoNode ? "[" + key1 + "]" : "[" + key1 + "," + key2 + "]";
    }
}