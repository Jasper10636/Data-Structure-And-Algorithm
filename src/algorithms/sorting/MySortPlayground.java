package algorithms.sorting;

import java.util.Arrays;

public class MySortPlayground {

    public static void sortPractice(int[] array){
        int index = 0;
        for(int i = 0; i < array.length-1;i++){
            int temp = 0;
            if (array[i] > array[i+1]){
                temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,9,2};
//        sort(arr1);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

}
