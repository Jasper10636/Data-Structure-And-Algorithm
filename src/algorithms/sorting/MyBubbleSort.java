package algorithms.sorting;

import java.util.Arrays;

public class MyBubbleSort {

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length;i++){
            for(int j = i+1; j < array.length;j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,5,3,8,6,2,9};
        int[] arr2 = {100,542,123,245,648,10,20,1,9,54,60,789};
        bubbleSort(arr1);
        bubbleSort(arr2);
//        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
