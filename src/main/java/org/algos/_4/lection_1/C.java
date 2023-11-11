package org.algos._4.lection_1;

import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = 0, m = 0;
        int[] A = null, B = null, C = null;
        StringTokenizer tokenizer;
        try {
            n = Integer.parseInt(reader.readLine());
            if (n != 0) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                int i = 0;
                A = new int[n];
                while (tokenizer.hasMoreTokens()) {
                    A[i] = Integer.parseInt(tokenizer.nextToken());
                    i++;
                }
            }
            else {
                reader.readLine();
                A = new int[]{};
            }
            m = Integer.parseInt(reader.readLine());
            if (m!=0) {
                tokenizer = new StringTokenizer(reader.readLine());
                int i = 0;
                B = new int[m];
                while (tokenizer.hasMoreTokens()) {
                    B[i] = Integer.parseInt(tokenizer.nextToken());
                    i++;
                }
            }
            else {
                reader.readLine();
                B = new int[]{};
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        if (n == 0) C = B;
        else if (m == 0) C = A;
        else C = merge(A, B);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (var el : C) {
            try {
                writer.write(el + " ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] merge(int[] A, int[] B){
        int[] C = new int[A.length + B.length];
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
        return C;
    }
}
