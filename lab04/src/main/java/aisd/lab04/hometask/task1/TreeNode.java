/*
## Задача 1
**Высота поддерева**
Для каждого узла двоичного дерева найти высоту поддерева, с корнем в заданном узле.

**Требования:**
- Реализовать рекурсивное решение
- Сложность: O(n
 */
package aisd.lab04.hometask.task1;

public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}