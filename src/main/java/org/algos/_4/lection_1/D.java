package org.algos._4.lection_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n, i;
        int[] array;
        StringTokenizer tokenizer;

        try {
            n = Integer.parseInt(reader.readLine());
            if (n == 0) array = new int[]{};
            else {
                array = new int[n];
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                i = 0;
                while (tokenizer.hasMoreTokens()) {
                    array[i] = Integer.parseInt(tokenizer.nextToken());
                    i++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        mergeSort(array);

        StringBuilder builder = new StringBuilder();
        for (var el : array) builder.append(el).append(" ");
        System.out.println(builder);
    }

    static void mergeSort(int[] array) {
        if (array.length <= 1) return;

        int m = array.length / 2;
        int[] left = new int[m];
        int[] right = new int[array.length - m];
        System.arraycopy(array, 0, left, 0, m);
        System.arraycopy(array, m, right, 0, array.length - m);

        mergeSort(left);
        mergeSort(right);

        merge(left, right, array);
    }

    public static void merge(int[] A, int[] B, int[] C){
        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < A.length + B.length; i++) {
            if (indexA < A.length && indexB < B.length) {
                if (A[indexA] < B[indexB]) {
                    C[i] = A[indexA];
                    indexA++;
                }
                else {
                    C[i] = B[indexB];
                    indexB++;
                }
            }
            else {
                if (indexA == A.length) {
                    for (int j = indexB; j < B.length; j++) {
                        C[i] = B[j];
                        i++;
                    }
                }
                else if (indexB == B.length) {
                    for (int j = indexA; j < A.length; j++) {
                        C[i] = A[j];
                        i++;
                    }
                }
                break;
            }
        }
    }
}
