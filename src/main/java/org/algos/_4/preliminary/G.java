package org.algos._4.preliminary;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n, m;
        int[][] inputMatrix;
        try {
            String[] inputs = reader.readLine().split("\\D");
            n = Integer.parseInt(inputs[0]);
            m = Integer.parseInt(inputs[0]);

            inputMatrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                inputMatrix[i] = Arrays.stream(reader.readLine().split("\\D"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }
        catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(maxElementInMatrix(sidesMatrix(inputMatrix)));

    }

    static int[][] sidesMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] =
                            min(matrix[i-1][j-1],
                            matrix[i][j-1],
                            matrix[i-1][j])
                            +1;
                }
            }
        }

        return matrix;
    }

    static int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }

    static int maxElementInMatrix(int[][] matrix){
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, matrix[i][j]);
            }
        }
        return max;
    }
}
