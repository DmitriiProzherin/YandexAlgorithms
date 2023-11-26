package org.algos._4.lection_4;

import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        permutation(array, 0);
    }

    public static void permutation(int[] array, int index){
//        if (index == array.length - 1) System.out.println(Arrays.toString(array));
//
//        for (int i = index; i < array.length; i++) {
//            swap(array, index, i);
//            permutation(array, index+1);
//            swap(array, index, i);
//        }
        for (int i = 0; i < array.length; i++) {

        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
