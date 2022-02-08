package data_structures.linked_list.linked_list_implementation.singly;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {

    private SinglyNode head;
    private SinglyNode tail;
    private int length;

    public SinglyLinkedList(int value) {
        head = new SinglyNode(value);
        tail = head;
        length = 1;
    }

    public void append(int value){
        SinglyNode newNode = new SinglyNode(value);
        tail.setNext(newNode); // point to newNode (Origin is null)
        tail = newNode;
        length++;
    }

    public void prepend(int value){
//        SinglyNode newNode = new SinglyNode(value);
//        newNode.setNext(head);
//        head = newNode;
        head = new SinglyNode(value, head);
        length++;
    }

    public void insert(int index,int value){
        index = wrapIndex(index);
        if(index == 0){
            prepend(value);
            return;
        }

        if(index == length-1){
            append(value);
            return;
        }

        SinglyNode leader = traverseToindex(index-1);
        SinglyNode nextNode = leader.getNext();
        SinglyNode newNode = new SinglyNode(value, nextNode);

        leader.setNext(newNode);
        length++;
//        leader.setNext(newNode);
    }

    public void delete(int index){
        index = wrapIndex(index);
        if(index == 0){
            head = head.getNext();
            return;
        }

        SinglyNode leader = traverseToindex(index-1);
        SinglyNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        length--;
    }

    public void printList(){
        List<Integer> list = new ArrayList<>();
        if(head == null) return;

        SinglyNode currentNode = head;
        while(currentNode != null){
            list.add(currentNode.getValue());
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println(list.toString());
//        if(head == null){
//            return;
//        }
//        SinglyNode currentNode = head;
//        System.out.println(currentNode.getValue());
//        currentNode = currentNode.getNext();
//        while(currentNode != null){
//            System.out.println("--> "+currentNode.getValue());
//            currentNode = currentNode.getNext();
//        }
    }

    public SinglyNode traverseToindex(int index){
        index = wrapIndex(index);
        SinglyNode currentNode = head;
        for(int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public void reverse(){
        SinglyNode first = head;
        tail = head;
        SinglyNode second = first.getNext();
        for(int i = 0; i < length-1;i++){
            SinglyNode tmp = second.getNext();
            second.setNext(first);
            first = second;
            second = tmp;
        }
        head.setNext(null);
        head = first;
    }

    public int wrapIndex(int index){
        return Math.max(Math.min(index,length-1),0);
    }

    public SinglyNode getHead() {
        return head;
    }

    public SinglyNode getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(10);
        list.append(5);
        list.append(45);
        list.prepend(94);
        list.insert(2,65);
        list.insert(0,70);
        list.delete(10);
        list.printList();
//        list.reverse();
//        list.printList();
        System.out.println(list.getTail().getValue());
        System.out.println("Length of the LinkedList: " + list.getLength());
    }
}
