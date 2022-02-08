package data_structures.arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] mergeSortArrays1(int[] array1, int[] array2){
        if(array1 == null || array1.length == 0){
            return array2;
        }
        if(array2 == null || array2.length == 0){
            return array1;
        }
        int[] result = Arrays.copyOf(array1, array1.length+array2.length);
        int index = 0;
        for(int i = array1.length; i < result.length;i++){
            result[i] = array2[index];
            index++;
        }

        Arrays.sort(result);

        return result;
    }

    public static int[] mergeSortArrays2(int[] array1,int[] array2){
        if(array1 == null || array1.length == 0){
            return array2;
        }
        if(array2 == null || array2.length == 0){
            return array1;
        }
        int[] result = new int[array1.length+ array2.length];

        int j = 0, k = 0;

        for(int i = 0; i < result.length;i++){
            if( j != array1.length && (k == array2.length || array1[j] < array2[k])){
                result[i] = array1[j];
                j++;
            }else{
                result[i] = array2[k];
                k++;
            }
        }

        return result;
    }

    public static int[] mergeSortArrays3(int[] array1,int[] array2){
        if(array1 == null || array1.length == 0){
            return array2;
        }
        if(array2 == null || array2.length == 0){
            return array1;
        }
        int i = 0, j = 0, k=0;

        int[] result = new int[array1.length+ array2.length];
        int resultLen = result.length;

        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                result[k] = array1[i];
                i++;
            }else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        System.out.println("i: " + i + " j: " + j + " k: "+ k);
        while (i < array1.length){
            result[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length){
            result[k] = array2[i];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] arr1 = {0,3,4,31};
        int[] arr1 = {0,3,4,31,50,70,90,100};
//        int[] arr2 = {4,6,30};
        int[] arr2 = {4,6,30,41,45,49};
//        int[] list1 = mergeSortArrays1(arr1,arr2);
        int[] list2 = mergeSortArrays2(arr1,arr2);
        int[] list3 = mergeSortArrays3(arr1,arr2);
//        for(int i = 0; i < list1.length;i++) {
//            System.out.println(list1[i]);
//        }
        for(int i = 0; i < list3.length;i++) {
            System.out.println(list3[i]);
        }


//        System.out.println(list[0]);
    }
}
