package SortingAndSearching;

import java.util.Arrays;

/**
 * Created by ashish on 15/06/21
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,15,3,83,17,68,29,40};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while((j>=0) && (arr[j] > key)){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
