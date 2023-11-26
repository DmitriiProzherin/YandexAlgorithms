package org.algos._1.lection_1;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (c < 0) System.out.println("NO SOLUTION");
        else {
            if (a == 0) {
                if (b < 0) System.out.println("NO SOLUTION");
                else {
                    int left = c*c - b;
                    if (left == 0) System.out.println("MANY SOLUTIONS");
                    else System.out.println("NO SOLUTION");
                }
            }
            else {
                int left = c*c - b;
                if (left % a != 0) System.out.println("NO SOLUTION");
                else System.out.println(left/a);
            }
        }
    }

}
