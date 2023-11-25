package org.algos._4.lection_2;

import java.io.IOException;
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        StringHashComparator stringHashComparator = new StringHashComparator(s);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int length = scanner.nextInt();
            int pos1 = scanner.nextInt();
            int pos2 = scanner.nextInt();

            System.out.println(stringHashComparator.compareSubstrings(length, pos1 + 1, pos2 +1, 1) ? "yes" : "no");

        }

    }


    static class StringHashComparator {

        private String string;
        private long[][] coeff;
        private long[][] hash;
        private long[][] pow;

        private static long[][] pxArray = {
                {1000000007L, 313},
                {1000000007L, 277},
                {1000000007L, 515},
                {1000000007L, 733},
                {1000000007L, 311},
                {1000000007L, 259},
                {1000000007L, 291},
                {1000000007L, 409},
                {1000000007L, 913},
                {1000000007L, 301},
        };

        StringHashComparator(String string){

            this.string = " " + string;

            coeff = new long[pxArray.length][this.string.length()];
            hash = new long[pxArray.length][this.string.length()];
            pow = new long[pxArray.length][this.string.length()];

            for (int i = 0; i < pxArray.length; i++) {
                int k = 0;
                for (var c : this.string.getBytes()) {
                    this.coeff[i][k] = c;
                    k++;
                }
            }

            int d = 0;

            for (int j = 0; j < pxArray.length; j++) {
                hash[j][0] = 0;
                pow[j][0] = 1;
                for (int i = 1; i < this.string.length(); i++) {
                    hash[j][i] = (hash[j][i-1] * pxArray[j][1] + coeff[j][i]) % pxArray[j][0];
                    pow[j][i] = pow[j][i - 1] * pxArray[j][1] % pxArray[j][0];
                }
            }
        }

        public boolean compareSubstrings(int length, int pos1, int pos2, int depth){
            assert depth <= 10;
            boolean res = true;

            for (int d = 0; d < depth; d++) {
                res = (hash[d][pos1 + length - 1] + hash[d][pos2 - 1] * pow[d][length]) % pxArray[d][0] == (hash[d][pos2 + length - 1] + hash[d][pos1 - 1] * pow[d][length]) % pxArray[d][0];
            }

            return res;
        }
    }

}
