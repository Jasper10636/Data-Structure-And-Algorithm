package data_structures.linked_list.linked_list_implementation.doubly;

public class DoublyNode {

    private int value;
    private DoublyNode previous;
    private DoublyNode next;

    public DoublyNode(int value) {
        this.value = value;
        this.next = null;
    }

    public DoublyNode(int value, DoublyNode previous, DoublyNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyNode previous) {
        this.previous = previous;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }
}
