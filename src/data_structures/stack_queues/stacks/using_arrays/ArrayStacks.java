package data_structures.stack_queues.stacks.using_arrays;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayStacks {

    private List<Integer> list = new ArrayList<>();

    public ArrayStacks() {
    }

    public int peak(){
        if(list.size() == 0){
            throw new EmptyStackException();
        }
        return list.get(this.list.size()-1);
    }

    public int pop(){
        if(list.size() == 0){
            throw new EmptyStackException();
        }
        return list.remove(this.list.size()-1);
    }

    public void push(int value){
        list.add(value);
    }

    public void printStacks(){
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        ArrayStacks stack = new ArrayStacks();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack peak: "+stack.peak());
        stack.printStacks();
        stack.pop();
        stack.printStacks();

    }
}
