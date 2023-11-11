package org.algos._4.lection_1;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.random.RandomGenerator;

public class B {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int[] array;

        try {
            n = Integer.parseInt(reader.readLine().trim());
            if (n != 0) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
                array = new int[n];
                int  i = 0;
                while (tokenizer.hasMoreTokens()) {
                    array[i] = Integer.parseInt(tokenizer.nextToken());
                    i++;
                }
            }
            else array = new int[] {};

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quickSort(array, 0, array.length);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (var el : array) {
            try {
                writer.write(el + " ");
            }
            catch (IOException e) {
                throw new RuntimeException();
            }
        }

        try {
            reader.close();
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }


    public static void quickSort(int[] array, int left, int right) {
        if (right - left > 1)
        {
            Random random = new Random();
            int pivot = array[random.nextInt(left, right)];
            System.out.println(pivot);

            int[] indexes = partition(pivot, array, left, right);

            quickSort(array, left, indexes[0]);
            quickSort(array, indexes[1], right);
        }
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