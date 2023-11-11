package org.algos._4.lection_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n;
        int[] array;
        StringTokenizer tokenizer;

        try {
            n = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int i = 0;
            array = new int[n];
            while (tokenizer.hasMoreTokens()) {
                array[i] = Integer.parseInt(tokenizer.nextToken());
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(24 / 2);
        System.out.println(25 / 2);
        System.out.println(24 % 2);
        System.out.println(12 % 13);
    }

    static void sort(int[] array){

    }
}
