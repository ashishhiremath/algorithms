package SortingAndSearching;

import java.util.Arrays;

/**
 * Created by ashish on 30/06/21
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 15, 3, 83, 17, 68, 29, 40};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
