package org.algos._4.contest;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.print(elementInC(x));
    }

    public static long elementInC(long x){
        int indexA = 1;
        int indexB = 1;
        int indexC = 1;

        while (indexC < x) {
            if (A(indexA) == B(indexB)) {
                indexA++;
                indexB++;
                indexC++;
            }
            else if (A(indexA) < B(indexB)){
                indexA++;
                indexC++;
            }
            else if (A(indexA) > B(indexB)){
                indexB++;
                indexC++;
            };
        }

        return (long) Math.min(Math.pow(indexA, 2), Math.pow(indexB, 3));
    }

    public static long A(long number){
        return number;
    }

    public static double B(long number){
        return Math.pow(number, 1.5);
    }
}
