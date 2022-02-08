package data_structures.hash_table;

import java.util.*;

public class FirstRecurringCharacter {
    // Method for ArrayList
    public static Integer FirstRecurChar(int[] array){
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for(int i = 0; i < array.length;i++){
            if(!list.contains(array[i])){
                list.add(array[i]);
            }else if(list.contains(array[i])){
                res = array[i];
                return res;
            }
        }
        return null;
    }

    //Method for HashMap
    public static Integer FirstRecurChar1(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i], i);
            }else if(map.containsKey(array[i])){
                res = array[i];
                return res;
            }
        }

        return null;
    }

    // Method for HashSet
    public static Object FirstRecurChar2(Object[] array){
        Set<Object> set = new HashSet<>();

        for(Object obj: array){
            if(set.contains(obj)){
                return obj;
            }else {
                set.add(obj);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] array = {2,5,1,2,3,5,1,2,4};
        int[] array2 = {2,3,4,5};
        int[] array3 = {2,1,1,2,3,5,1,2,4};

        Object[] arr = {2,5,1,2,3,5,1,2,4};
        Object[] arr2 = {2,3,4,5};
        Object[] arr3 = {2,1,1,2,3,5,1,2,4};

        System.out.println("First Recurring Character is: " + FirstRecurChar(array2));
        System.out.println("First Recurring Character is: " + FirstRecurChar2(arr3));

    }
}
