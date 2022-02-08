package data_structures.stack_queues.queues.using_linked_list;

import java.util.NoSuchElementException;

public class Queues {

    private SinglyNode first;
    private SinglyNode last;
    private int length;

    public Queues() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public int peek(){
        if (length == 0){
            throw new NoSuchElementException();
        }
        return first.getValue();
    }

    public void dequeue(){
        if(first == null){
            throw new NoSuchElementException();
        }
        first = first.getNext();
        length--;
        if(length == 0){
            last = null;
        }
    }

    public void enqueue(int value){
        SinglyNode newNode = new SinglyNode(value);
        if(length == 0){
            first = newNode;
        }else{
            last.setNext(newNode);
        }
        last = newNode;
        length++;
    }

    public void printQueues(){
        if(first == null){
            return;
        }
        SinglyNode currentNode = first;
        System.out.println(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null){
            System.out.println("==>"+currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println("==================");
    }

    public static void main(String[] args) {
        Queues queues = new Queues();
        queues.enqueue(10);
        queues.enqueue(20);
        queues.enqueue(30);
        queues.enqueue(40);
        queues.printQueues();
        queues.dequeue();
        queues.printQueues();
    }
}
