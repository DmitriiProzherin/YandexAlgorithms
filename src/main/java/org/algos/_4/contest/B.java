package org.algos._4.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        try {
            reader.readLine();
            string = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String zIndexes = mirrorZFunction(string);

        System.out.println(zIndexes);
    }

    public static String mirrorZFunction(String string){

        StringBuilder resultString = new StringBuilder();

        String doubleString = string + new StringBuilder(string).reverse();

        if (string.length() == 1) resultString.append("1");
        else if (string.length() > 1) {
            StringHashComparator comparator = new StringHashComparator(doubleString);
            int res;
            for (int i = 0; i <= string.length()-1; i++) {
                res = binarySearch(doubleString.length()-i-1, doubleString.length()+1, comparator);
                resultString.append(res).append(" ");
            }
        }
        return resultString.toString();
    }

    public static int binarySearch(int left, int right, StringHashComparator comparator){
        int mid;
        int length;
        int initialLeftPos = left;

        while (right - left > 1) {
            mid = (right + left) / 2;
            length = mid - initialLeftPos;
            boolean eq = comparator.compareSubstrings(length, 1, initialLeftPos + 1, 2);
            if (eq) {
                left = mid;
            }
            else right = mid;
        }
        return left-initialLeftPos;
    }

    public static class StringHashComparator {

        private String string;
        private long[][] coeff;
        private long[][] hash;
        private long[][] pow;

        private static long[][] pxArray = {
                {1000000007L, 313},
                {1000000007L, 277},
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