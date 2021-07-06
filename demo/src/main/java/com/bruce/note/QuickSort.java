package com.bruce.note;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int partitionIndex = partition(arr, 0, right);
            quickSort(arr, 0, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }

    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, pivot, index);
                index++;
            }
        }
        if (pivot != index - 1) {
            swap(arr, pivot, index - 1);
        }
        return index - 1;
    }


    public static void swap(int[] arr, int i, int j) {
        System.out.println("before:======  arr[" + i + "]=" + arr[i] + "    arr[" + j + "]=" + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("after:======  arr[" + i + "]=" + arr[i] + "     arr[" + j + "]=" + arr[j]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 1, 3, 6, 5, 7, 9, 4, 0};
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("------------");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));


    }

}
