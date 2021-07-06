package com.bruce.note;

import java.util.Arrays;

public class QuickSort2 {

    public static void quickSort(int[] arr, int left, int right) {

        if (left < right) {
            int middle = partition(arr, left, right);
            quickSort(arr, left, middle - 1);
            quickSort(arr, middle + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 1, 3, 6, 5, 7, 9, 4, 0};
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("------------");
        Arrays.stream(arr).forEach(it -> System.out.print(it + " "));

    }


    public static void quickSort2(int[] arr, int left, int right) {

        if (left < right) {
            int middle = partition2(arr, left, right);
            quickSort2(arr, left, middle - 1);
            quickSort2(arr, middle + 1, right);
        }
    }

    public static int partition2(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


}
