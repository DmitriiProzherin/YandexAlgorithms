package org.algos._4.preliminary;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(solve(a, b, n));
    }

    static String solve(int a, int b, int n){
        int maxGroupA = a;
        int r = b % n;
        int minGroupB;
        if (r == 0) minGroupB = b / n;
        else minGroupB = b / n + 1;
        return maxGroupA > minGroupB ? "Yes" : "No";
    }


}
