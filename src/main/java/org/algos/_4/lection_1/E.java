package org.algos._4.lection_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class E {
    static int radix;
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n;
        String[] array;

        try {
            n = Integer.parseInt(reader.readLine());
            array = new String[n];
                String line = reader.readLine();
                radix = line.length();
                array[0] = line;
            for (int i = 1; i < n; i++) {
                array[i] = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Initial array:");
        System.out.println(String.join(", ", array));

        sort(array);

        System.out.println("**********");
        System.out.println("Sorted array:");
        System.out.println(String.join(", ", array));

    }

    static void sort(String[] array){
        ArrayList<ArrayList<String>> map = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) map.add(new ArrayList<>());

        for (int k = 0; k < radix; k++) {

            map.forEach(ArrayList::clear);

            for (var line : array) {
                char c = line.charAt(line.length() - k - 1);
                switch (c) {
                    case '0' -> map.get(0).add(line);
                    case '1' -> map.get(1).add(line);
                    case '2' -> map.get(2).add(line);
                    case '3' -> map.get(3).add(line);
                    case '4' -> map.get(4).add(line);
                    case '5' -> map.get(5).add(line);
                    case '6' -> map.get(6).add(line);
                    case '7' -> map.get(7).add(line);
                    case '8' -> map.get(8).add(line);
                    case '9' -> map.get(9).add(line);
                }
            }

            System.out.println("**********");
            System.out.println("Phase " + (k+1));
            for (int i = 0; i < 10; i++) {
                String res = String.join(", ", map.get(i));
                if (res.isEmpty()) res = "empty";
                System.out.println("Bucket " + i  + ": " +  res);
            }

            int i = 0;
            for (var arr : map) {
                for (var el : arr) {
                    array[i] = el;
                    i++;
                }
            }
        }
    }
}
