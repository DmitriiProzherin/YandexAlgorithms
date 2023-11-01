package org.algos._4.preliminary;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short n = scanner.nextShort();
        short m = scanner.nextShort();

        short[] array = new short[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextShort();
        }

        short l = 0, r = 0;
        for (int i = 0; i < m; i++) {
            l = scanner.nextShort();
            r = scanner.nextShort();
            System.out.println(solve(array, l, r));
        }

    }

    static short minOnASegment(short[] array, short l, short r) {
        short min = array[l];
        for (int i = l+1; i <= r; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    static String solve(short[] array, short l, short r){
        short min = minOnASegment(array, l, r);
        for (int i = l; i <= r; i++) {
            if (array[i] != min) {
                return array[i] + "";
            }
        }
        return "NOT FOUND";
    }


}
