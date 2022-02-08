package algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;

public class MyInsertionSort {

    public static Integer[] insertionSort(Integer[] array){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(array));
        for(int i = 1; i < list.size();i++){
            if(list.get(i) <=list.get(0)){
                list.add(0, list.get(i));
                list.remove(i+1);
            }else{
                if(list.get(i) < list.get(i-1)){
                    for(int j = 1; j < i;j++){
                        if (list.get(i) >= list.get(j-1) && list.get(i) < list.get(j) ){
                            list.add(j, list.get(i));
                            list.remove(i+1);
                        }
                    }
                }
            }

        }
        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        Integer[] arr1= {100,542,123,245,648,10,20,1,9,54,60,789};
        Arrays.stream(insertionSort(arr1)).forEach(System.out::println);
    }


}
