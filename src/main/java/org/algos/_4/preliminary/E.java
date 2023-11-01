package org.algos._4.preliminary;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {

        int[] ratingsArray;
        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            reader.readLine();
            ratingsArray = Arrays.stream(reader.readLine().split("\\D"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int[] resultArr = grudge(ratingsArray);

        String res = Arrays.stream(resultArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(res);
    }
    
    static int[] directPrefixSum(int[] array){
        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixArray[i] = prefixArray[i-1] + array[i];
        }
        return prefixArray;
    }

    static int[] inversePrefixSum(int[] array) {
        int n = array.length;
        int[] prefixArray = new int[n];
        prefixArray[n-1] = array[n-1];
        for (int i = n-2; i >=0 ; i--) {
            prefixArray[i] = prefixArray[i+1] + array[i];
        }
        return prefixArray;
    }

    static int[] grudge(int[] array) {
        int n = array.length;

        int[] dPrefixSum = directPrefixSum(array);
        int[] iPrefixSum = inversePrefixSum(array);
        int[] grudgeArray = new int[n];

        for (int i = n - 1; i >=0 ; i--) {
            grudgeArray[i] = ((i+1) * array[i] - dPrefixSum[i]) + (iPrefixSum[i] - (n-i) * array[i]);
        }
        return grudgeArray;
    }

}
