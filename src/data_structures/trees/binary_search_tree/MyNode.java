package data_structures.trees.binary_search_tree;

public class MyNode {

    private MyNode left;
    private MyNode right;
    private int value;

    public MyNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public MyNode(int value, MyNode left, MyNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
