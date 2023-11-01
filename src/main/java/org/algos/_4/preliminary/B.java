package org.algos._4.preliminary;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short a = scanner.nextShort();
        short b = scanner.nextShort();
        short c = scanner.nextShort();
        short d = scanner.nextShort();

        short[] first = reduceFraction(a, b);
        short[] second = reduceFraction(c, d);
        short[] result = addFractions(first, second);

        System.out.println(result[0] + " " + result[1]);
    }

    static short[] reduceFraction(short a, short b) {
        short n = nod(a, b);
        while (n != 1) {
            a/=n;
            b/=n;
            n = nod(a, b);
        }
        return new short[]{a, b};
    }

    static short nod(short a, short b) {
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }

    static short[] addFractions(short[] first, short[] second){
        return reduceFraction((short) (first[0]*second[1] + second[0]*first[1]), (short) (first[1]*second[1]));
    }
}

