package algorithms.sorting;

import java.util.Arrays;

public class MySelectionSort {

    public static void selectionSort(int[] array){
        if(array == null || array.length == 0) return;

        for(int i = 0; i < array.length;i++){
            int minValue = array[i];
            int minIndex = i;
            for(int j = i+1; j < array.length;j++) {
                if(minValue > array[j]){
                    minValue = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = minValue;
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr2 = {100,542,123,245,648,10,20,1,9,54,60,789};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
