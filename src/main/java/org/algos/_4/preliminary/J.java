package org.algos._4.preliminary;

import java.util.Arrays;
import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine().trim());

        int n, a, b;

        String[] resultArray = new String[t];
        String[] sArr;

        for (int i = 0; i < t; i++) {
            sArr = scanner.nextLine().trim().split("\\D");
            n = Integer.parseInt(sArr[0]);
            a = Integer.parseInt(sArr[1]);
            b = Integer.parseInt(sArr[2]);

            resultArray[i] = solve(n, a, b);
            }

        Arrays.stream(resultArray).forEach(System.out::println);
    }

    static String solve(int n, int a, int b){
        int l = n % b == 0 ? n / b : n / b + 1;
        int r = n / a;
        return l > r ? "NO" : "YES";
    }

}
