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
        int pElement;

        try {
            arrayLength = Integer.parseInt(reader.readLine().trim());
            if (arrayLength != 0) array = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            else {
                array = new int[] {};
                reader.readLine();
            }
            pElement = Integer.parseInt(reader.readLine().trim());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int pIndex = partitionLessThanP(pElement, array);
        System.out.println(pIndex + 1);
        System.out.println(arrayLength - pIndex - 1);
    }

    public static int partitionLessThanP(int p, int[] array){
        int l = 0;
        for (int j : array) {
            if (j < p) l++;
        }
        return l - 1;
    }
}
