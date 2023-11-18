package org.algos._4.lection_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String line = inputStreamReader.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);

        line = inputStreamReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        int[] array = new int[2 * N];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
            array[array.length - 1 - i] = array[i];
            i++;
        }

        ArrayHashComparator comparator = new ArrayHashComparator(array);

        boolean equals;

        StringBuilder builder = new StringBuilder();

        for (int j = N/2; j >= 1; j--) {
            equals = comparator.compareSubarrays(j, array.length-j+1, j+1, 2);
            if (equals) builder.append(N-j).append(" ");
        }
        builder.append(N);

        System.out.println(builder);
        inputStreamReader.close();
    }

    static class ArrayHashComparator {

        private int[] array;
        private long[][] coeff;
        private long[][] hash;
        private long[][] pow;

        private static long[][] pxArray = {
                {1000000007L, 313},
                {1000000007L, 277},
//                {1000000007L, 515},
//                {1000000007L, 733},
//                {1000000007L, 311},
//                {1000000007L, 259},
//                {1000000007L, 291},
//                {1000000007L, 409},
//                {1000000007L, 913},
//                {1000000007L, 301},
        };

        ArrayHashComparator(int[] array){

            this.array = new int[array.length+1];
            System.arraycopy(array, 0, this.array, 1, array.length);

            coeff = new long[pxArray.length][this.array.length];
            hash = new long[pxArray.length][this.array.length];
            pow = new long[pxArray.length][this.array.length];

            for (int i = 0; i < pxArray.length; i++) {
                int k = 0;
                for (var c : this.array) {
                    this.coeff[i][k] = c;
                    k++;
                }
            }

            int d = 0;

            for (int j = 0; j < pxArray.length; j++) {
                hash[j][0] = 0;
                pow[j][0] = 1;
                for (int i = 1; i < this.array.length; i++) {
                    hash[j][i] = (hash[j][i-1] * pxArray[j][1] + coeff[j][i]) % pxArray[j][0];
                    pow[j][i] = pow[j][i - 1] * pxArray[j][1] % pxArray[j][0];
                }
            }
        }

        public boolean compareSubarrays(int length, int pos1, int pos2, int depth){
            assert depth <= 10;
            boolean res = true;

            for (int d = 0; d < depth; d++) {
                res = (hash[d][pos1 + length - 1] + hash[d][pos2 - 1] * pow[d][length]) % pxArray[d][0] == (hash[d][pos2 + length - 1] + hash[d][pos1 - 1] * pow[d][length]) % pxArray[d][0];
            }

            return res;
        }
    }

}
