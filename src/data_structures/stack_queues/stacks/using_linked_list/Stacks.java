package data_structures.stack_queues.stacks.using_linked_list;

import java.util.EmptyStackException;

public class Stacks {

    private SinglyNode top;
    private SinglyNode bottom;
    private int length;

    public Stacks() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public int peak(){
        if(length == 0){
            throw new EmptyStackException();
        }

        return top.getValue();
    }

    public int pop(){
        if(length == 0){
            throw new EmptyStackException();
        }
        SinglyNode tempTop = top;
        top = top.getNext();
        length--;
        if(length == 0){
            bottom = null;
        }
        return tempTop.getValue();
    }

    public void push(int value){
        top = new SinglyNode(value, top);
        if(length == 0){
            bottom = top;
        }
        length++;
    }

    public void printStacks(){
        if(top == null){
            return ;
        }
        SinglyNode currentNode = top;
        System.out.println(currentNode.getValue());
        currentNode = currentNode.getNext();
        while(currentNode != null){
            System.out.println("==> " + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stacks stack = new Stacks();
        stack.push(3);
        stack.printStacks();
        stack.push(5);
        stack.printStacks();
        stack.push(7);
        stack.printStacks();
        stack.pop();
        stack.printStacks();
        stack.pop();
        stack.printStacks();
    }
}
