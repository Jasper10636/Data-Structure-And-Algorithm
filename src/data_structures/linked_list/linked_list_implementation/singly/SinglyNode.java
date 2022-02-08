package data_structures.linked_list.linked_list_implementation.singly;

public class SinglyNode {
    private int value;
    private SinglyNode next;

    public SinglyNode(int value) {
        this.value = value;
        this.next = null;
    }

    public SinglyNode(int value, SinglyNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyNode getNext() {
        return next;
    }

    public void setNext(SinglyNode next) {
        this.next = next;
    }
}
