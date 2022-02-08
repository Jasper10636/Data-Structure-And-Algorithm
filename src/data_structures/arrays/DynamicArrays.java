package data_structures.arrays;

import java.util.Arrays;

public class DynamicArrays {

    private int length;
    private Object[] data;
    private int capacity;

    public DynamicArrays() {
        data = new Object[1];
        length = 0;
        capacity = 1;
    }

    public Object get (int index){
        return this.data[index];
    }

    public void push(Object obj){
        if(capacity == length){
            data = Arrays.copyOf(data, capacity * 2);
            capacity *=2;
        }
        data[length] = obj;
        length++;
    }

    public static void main(String[] args) {
        DynamicArrays arrays = new DynamicArrays();
        System.out.println(arrays.capacity);
    }

}
