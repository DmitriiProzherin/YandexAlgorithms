package org.algos._4.lection_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class B {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] array;

        try {
            n = Integer.parseInt(reader.readLine().trim());
            array = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    public static int[] sort(int[] array){
        int l = 0;
        int index = new Random().nextInt(0, l);

        int pIndex = array[index];


        return null;
    }
    public static int partitionLessThanP(int p, int[] array){
        int l = 0;
        for (int j : array) {
            if (j < p) l++;
        }
        return l - 1;
    }
}