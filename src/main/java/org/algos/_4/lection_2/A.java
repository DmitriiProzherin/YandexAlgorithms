package org.algos._4.lection_2;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        StringInfo stringInfo = new StringInfo(s);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int length = scanner.nextInt();
            int pos1 = scanner.nextInt();
            int pos2 = scanner.nextInt();

            System.out.println(stringInfo.compareSubstrings(length, pos1 + 1, pos2 +1) ? "yes" : "no");

        }

    }


    static class StringInfo{

        private String string;
        private static long p = 1000000007L;
        private long x = 313;
        private long[] coeff;
        private long[] hash;
        private long[] pow;

        StringInfo(String string){

            this.string = " " + string;

            coeff = new long[this.string.length()];
            hash = new long[this.string.length()];
            pow = new long[this.string.length()];

            int k = 0;
            for (var c : this.string.getBytes()) {
                this.coeff[k] = c;
                k++;
            }

            hash[0] = 0;
            pow[0] = 1;
            for (int i = 1; i < this.string.length(); i++) {
                hash[i] = (hash[i-1] * x + coeff[i]) % p;
                pow[i] = pow[i - 1] * this.x % p;
            }
        }

        public boolean compareSubstrings(int length, int pos1, int pos2){
            return (hash[pos1 + length - 1] + hash[pos2 - 1] * pow[length]) % p == (hash[pos2 + length - 1] + hash[pos1 - 1] * pow[length]) % p;
        }
    }

}
