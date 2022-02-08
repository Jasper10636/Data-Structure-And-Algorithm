package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMergeSort {

    public static Integer[] mergeSortInt(Integer[] array){
        return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
    }

    public static List<Integer> mergeSort(List<Integer> array){
        if(array.size() == 1 ){
            return array;
        }

        List<Integer> left = array.subList(0, array.size()/2);
        List<Integer> right = array.subList(array.size()/2, array.size());
        return merge(mergeSort(left),mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.size() && rightIndex < right.size()){
            if(left.get(leftIndex) <= right.get(rightIndex)){
                merged.add(left.get(leftIndex));
                leftIndex++;
            }else if(left.get(leftIndex) >= right.get(rightIndex)){
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex,right.size()));

        return merged;
    }

    public static void main(String[] args) {
        Integer[] arr1= {100,542,123,245,648,10,20,1,9,54,60,789};
        Arrays.stream(mergeSortInt(arr1)).forEach(System.out::println);
    }

}
