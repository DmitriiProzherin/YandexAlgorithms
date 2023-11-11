package org.algos._4.lection_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arrayLength;
        int[] array;
        int pivot;

        try {
            arrayLength = Integer.parseInt(reader.readLine().trim());
            if (arrayLength != 0) array = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            else {
                array = new int[] {};
                reader.readLine();
            }
            pivot = Integer.parseInt(reader.readLine().trim());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] equalsAndGreaterIndexes = partition(pivot, array, 0, arrayLength);

        int equalsIndex = equalsAndGreaterIndexes[0];
        int greaterIndex = equalsAndGreaterIndexes[1];

        if (equalsIndex == greaterIndex) {
            System.out.println(greaterIndex);
            System.out.println(arrayLength - greaterIndex);
        } else if (equalsIndex < greaterIndex) {
            System.out.println(equalsIndex);
            System.out.println(arrayLength - equalsIndex);
        }

        System.out.println(Arrays.toString(array));

    }

    public static int[] partition(int pivot, int[] array, int startIndex, int endIndex){
        int equals = startIndex, greater = startIndex, now = startIndex;

        int temp;
        while (now < endIndex) {
            if (array[now] > pivot) now++;
            else if (array[now] == pivot) {
                temp = array[now];
                array[now] = array[greater];
                array[greater] = temp;
                now++;
                greater++;
            }
            else if (array[now] < pivot) {
                temp = array[greater];
                array[greater] = array[now];
                array[now] = temp;

                temp = array[equals];
                array[equals] = array[greater];
                array[greater] = temp;

                now++;
                greater++;
                equals++;
            }
        }

        return new int[] {equals, greater};
    }
}
