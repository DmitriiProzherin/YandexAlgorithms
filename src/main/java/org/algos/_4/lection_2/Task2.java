package org.algos._4.lection_2;

public class Task2 {
    public static void main(String[] args) {
        String string = "aaagbb";
        String string2 = doubleMirroredString(string);
        System.out.println(string2);
        StringHashComparator comparator = new StringHashComparator(string2);

        System.out.println(isAPalindrome(comparator, 4, 5));

    }

    private static boolean isAPalindrome(StringHashComparator comparator, int indexStart, int indexEnd){
        int length = indexEnd - indexStart + 1;
        int index1 = indexStart+1;
        int index2 = comparator.getLength()-length-indexStart;

        return comparator.compareSubstrings(length, index1, index2, 1);
    }

    private static String doubleMirroredString(String string){
        return string + new StringBuilder(string).reverse();
    }

    static class StringHashComparator {

        private String string;
        private long[][] coeff;
        private long[][] hash;
        private long[][] pow;

        private static long[][] pxArray = {
                {1000000007L, 313}
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

        public int getLength() {
            return this.string.length();
        }
    }
}
