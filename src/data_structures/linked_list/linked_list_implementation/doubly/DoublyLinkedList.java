package data_structures.linked_list.linked_list_implementation.doubly;

import java.util.ArrayList;
import java.util.List;
// Pro & Cons for Singly & Doubly
// Pros for Singly => Fairly Simple Implementation
// Cons Cannot traverse from back to front
public class DoublyLinkedList {

    private int length;
    private DoublyNode head;
    private DoublyNode tail;

    public DoublyLinkedList(int value) {
        head = new DoublyNode(value);
        tail = head;
        length = 1;
    }

    public void prepend(int value){
        DoublyNode newNode = new DoublyNode(value, null, head);
        head.setPrevious(newNode);
        head = newNode;
        length++;
    }

    public void append(int value){
        DoublyNode newNode = new DoublyNode(value, tail, null);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void insert(int index, int value){
        index = wrapIndex(index);
        if(index == 0){
            prepend(value);
            return;
        }

        if(index == length-1){
            append(value);
            return;
        }

        DoublyNode leader = traverseToIndex(index-1);
        DoublyNode nextNode = leader.getNext();

        DoublyNode newNode = new DoublyNode(value,leader,nextNode);
        leader.setNext(newNode);
        nextNode.setPrevious(newNode);
        length++;
    }

    public void remove(int index){
        index = wrapIndex(index);
        if(index == 0){
            head = head.getNext();
            return;
        }

        DoublyNode leader = traverseToIndex(index-1);
        DoublyNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrevious(leader);

        length--;
    }

    public void printList(){
        DoublyNode currentNode = head;
        List<Integer> list = new ArrayList<>();
        while(currentNode != null){
            list.add(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(list.toString());
    }

    public DoublyNode traverseToIndex(int index){
        index = wrapIndex(index);
        DoublyNode currentNode = head;
        for(int i = 0; i < index;i++){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public int wrapIndex(int index){
        return Math.max(Math.min(index, length-1),0);
    }

    public int getLength() {
        return length;
    }

    public DoublyNode getHead() {
        return head;
    }

    public DoublyNode getTail() {
        return tail;
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList(5);
        linkedList.prepend(10);
        linkedList.append(54);
        linkedList.append(40);
        linkedList.insert(2,88);
        linkedList.insert(0,99);
        linkedList.insert(6,77);
        linkedList.printList();
    }
}
