package org.algos._4.preliminary;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    @Test
    void directPrefixSumSimpleTest(){
        int[] testArray = {1, 2, 3};
        assertArrayEquals(new int[]{1, 3, 6}, E.directPrefixSum(testArray));
    }

    @Test
    void inversePrefixSumSimpleTest(){
        int[] testArray = {1, 2, 3};
        assertArrayEquals(new int[]{6, 5, 3}, E.inversePrefixSum(testArray));
    }

    @Test
    void  grudgeSimpleTest1(){
        int[] testArray = new int[] {1, 3, 4};
        assertArrayEquals(new int[] {5, 3, 4}, E.grudge(testArray));
    }

    @Test
    void  grudgeSimpleTest2(){
        int[] testArray = new int[] {3, 7, 8, 10, 15};
        assertArrayEquals(new int[] {28, 16, 15, 17, 32}, E.grudge(testArray));
    }

    @Test
    void  grudgeSimpleTest3(){
        int[] testArray = new int[] {3};
        assertArrayEquals(new int[] {0}, E.grudge(testArray));
    }

    @Test
    void  grudgeSimpleTest4(){
        int[] testArray = new int[] {0};
        assertArrayEquals(new int[] {0}, E.grudge(testArray));
    }


    @Test
    void grudgeMaxTest(){
        int[] array = new int[100_000];
        for (int i = 0; i < 50_000; i++) {
            array[i] = 0;
        }
        for (int i = 50_000; i < array.length; i++) {
            array[i] = 1;
        }

        int[] resultArray = new int[100_000];

        Arrays.fill(resultArray, 50_000);

        assertArrayEquals(resultArray, E.grudge(array));

    }
}