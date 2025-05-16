import java.util.Arrays;

public class TwoThreeTree {
    private static class TreeNode {
        int key1, key2;
        TreeNode left, middle, right;
        boolean isTwoNode;

        TreeNode(int key, TreeNode treeNode, TreeNode node) {
            this.key1 = key;
            this.isTwoNode = true;
        }

        TreeNode(int key1, int key2) {
            this.key1 = Math.min(key1, key2);
            this.key2 = Math.max(key1, key2);
            this.isTwoNode = false;
        }

        boolean isLeaf() {
            return left == null && middle == null && right == null;
        }
    }

    private TreeNode root;
    private int size;

    // Основной API
    public boolean insert(int key) {
        if (root == null) {
            root = new TreeNode(key, new TreeNode(keys[0]), new TreeNode(keys[2]));
            size++;
            return true;
        }

        InsertResult result = insert(root, key);
        if (result.newNode != null) {
            root = result.newNode;
        }
        if (result.inserted) size++;
        return result.inserted;
    }

    public boolean contains(int key) {
        return search(root, key);
    }

    public boolean remove(int key) {
        if (root == null) return false;

        boolean[] removed = new boolean[1];
        root = remove(root, key, removed);
        if (root != null && root.isTwoNode && root.left == null && root.right == null) {
            root = null;
        }
        if (removed[0]) size--;
        return removed[0];
    }

    public int size() {
        return size;
    }

    // Внутренние методы
    private static class InsertResult {
        TreeNode newNode;
        boolean inserted;
        InsertResult(TreeNode newNode, boolean inserted) {
            this.newNode = newNode;
            this.inserted = inserted;
        }
    }

    private boolean search(TreeNode node, int key) {
        if (node == null) return false;

        if (node.isTwoNode) {
            if (key == node.key1) return true;
            return key < node.key1 ? search(node.left, key) : search(node.right, key);
        } else {
            if (key == node.key1 || key == node.key2) return true;
            if (key < node.key1) return search(node.left, key);
            return key < node.key2 ? search(node.middle, key) : search(node.right, key);
        }
    }

    private InsertResult insert(TreeNode node, int key) {
        if (!node.isTwoNode) {
            // Логика для 3-узла
            if (key == node.key1 || key == node.key2) {
                return new InsertResult(null, false);
            }

            if (node.isLeaf()) {
                return new InsertResult(splitLeaf(node, key), true);
            }

            InsertResult result;
            if (key < node.key1) {
                result = insert(node.left, key);
                return processChildResult(node, result, 0);
            } else if (key < node.key2) {
                result = insert(node.middle, key);
                return processChildResult(node, result, 1);
            } else {
                result = insert(node.right, key);
                return processChildResult(node, result, 2);
            }
        } else {
            // Логика для 2-узла
            if (key == node.key1) {
                return new InsertResult(null, false);
            }

            if (node.isLeaf()) {
                if (key < node.key1) {
                    node.key2 = node.key1;
                    node.key1 = key;
                } else {
                    node.key2 = key;
                }
                node.isTwoNode = false;
                return new InsertResult(null, true);
            }

            InsertResult result;
            if (key < node.key1) {
                result = insert(node.left, key);
                if (result.newNode != null) {
                    node.key2 = node.key1;
                    node.key1 = result.newNode.key1;
                    node.isTwoNode = false;
                    node.left = result.newNode.left;
                    node.middle = result.newNode.right;
                }
                return new InsertResult(null, result.inserted);
            } else {
                result = insert(node.right, key);
                if (result.newNode != null) {
                    node.key2 = result.newNode.key1;
                    node.isTwoNode = false;
                    node.middle = result.newNode.left;
                    node.right = result.newNode.right;
                }
                return new InsertResult(null, result.inserted);
            }
        }
    }

    private TreeNode splitLeaf(TreeNode node, int key) {
        int[] keys = {node.key1, node.key2, key};
        Arrays.sort(keys);
        return new TreeNode(keys[1], new TreeNode(keys[0], new TreeNode(keys[0]), new TreeNode(keys[2])), new TreeNode(keys[2], new TreeNode(keys[0]), new TreeNode(keys[2])));
    }

    private InsertResult processChildResult(TreeNode node, InsertResult result, int childPos) {
        if (result.newNode == null) return result;

        if (node.isTwoNode) {
            if (childPos == 0) {
                node.key2 = node.key1;
                node.key1 = result.newNode.key1;
            } else {
                node.key2 = result.newNode.key1;
            }
            node.isTwoNode = false;
            if (childPos == 0) {
                node.left = result.newNode.left;
                node.middle = result.newNode.right;
            } else {
                node.middle = result.newNode.left;
                node.right = result.newNode.right;
            }
            return new InsertResult(null, result.inserted);
        } else {
            if (childPos == 0) {
                TreeNode newLeft = new TreeNode(result.newNode.key1, node.left, result.newNode.left);
                TreeNode newRight = new TreeNode(node.key2, result.newNode.right, node.right);
                return new InsertResult(new TreeNode(node.key1, newLeft, newRight), result.inserted);
            } else if (childPos == 1) {
                TreeNode newLeft = new TreeNode(node.key1, node.left, result.newNode.left);
                TreeNode newRight = new TreeNode(node.key2, result.newNode.right, node.right);
                return new InsertResult(new TreeNode(result.newNode.key1, newLeft, newRight), result.inserted);
            } else {
                TreeNode newLeft = new TreeNode(node.key1, node.left, node.middle);
                TreeNode newRight = new TreeNode(result.newNode.key1, node.right, result.newNode.left);
                return new InsertResult(new TreeNode(node.key2, newLeft, newRight), result.inserted);
            }
        }
    }

    private TreeNode remove(TreeNode node, int key, boolean[] removed) {
        if (node == null) return null;

        if (node.isTwoNode) {
            return handleTwoNodeRemove(node, key, removed);
        } else {
            return handleThreeNodeRemove(node, key, removed);
        }
    }

    private TreeNode handleTwoNodeRemove(TreeNode node, int key, boolean[] removed) {
        if (key == node.key1) {
            removed[0] = true;
            return node.isLeaf() ? null : deleteInternal(node, key);
        }

        if (key < node.key1) {
            node.left = remove(node.left, key, removed);
        } else {
            node.right = remove(node.right, key, removed);
        }
        return fixTwoNode(node);
    }

    private TreeNode handleThreeNodeRemove(TreeNode node, int key, boolean[] removed) {
        if (key == node.key1 || key == node.key2) {
            removed[0] = true;
            if (node.isLeaf()) {
                if (key == node.key1) node.key1 = node.key2;
                node.isTwoNode = true;
                return node;
            }
            return deleteInternal(node, key);
        }

        if (key < node.key1) {
            node.left = remove(node.left, key, removed);
        } else if (key < node.key2) {
            node.middle = remove(node.middle, key, removed);
        } else {
            node.right = remove(node.right, key, removed);
        }
        return fixThreeNode(node);
    }

    private TreeNode deleteInternal(TreeNode node, int key) {
        if (key == node.key1) {
            TreeNode predecessor = findMax(node.left);
            int predKey = predecessor.isTwoNode ? predecessor.key1 : predecessor.key2;
            node.key1 = predKey;
            boolean[] dummy = new boolean[1];
            node.left = remove(node.left, predKey, dummy);
            return node.isTwoNode ? fixTwoNode(node) : fixThreeNode(node);
        } else if (!node.isTwoNode && key == node.key2) {
            TreeNode successor = findMin(node.right);
            node.key2 = successor.key1;
            boolean[] dummy = new boolean[1];
            node.right = remove(node.right, node.key2, dummy);
            return fixThreeNode(node);
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private TreeNode findMax(TreeNode node) {
        while (node.right != null) node = node.right;
        return node;
    }

    private TreeNode fixTwoNode(TreeNode node) {
        //
        return node;
    }

    private TreeNode fixThreeNode(TreeNode node) {
        //
        return node;
    }
}