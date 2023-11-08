package org.algos._4.preliminary;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        int xa, ya, xb, yb;
        Scanner scanner = new Scanner(System.in);
        xa = scanner.nextInt();
        ya = scanner.nextInt();
        xb = scanner.nextInt();
        yb = scanner.nextInt();

        System.out.println(solve(xa, ya, xb, yb));
    }

    private static double solve(long xa, long ya, long xb, long yb) {
        double absVecOA = Math.sqrt(xa*xa + ya*ya);
        double absVecOB = Math.sqrt(xb*xb + yb*yb);
        double angleVecOA = Math.atan2(ya, xa);
        double angleVecOB = Math.atan2(yb, xb);

        double arcLength = Math.min(absVecOA, absVecOB) * Math.abs(angleVecOA - angleVecOB);
        double delta = Math.abs(absVecOB - absVecOA);

        double arcPath = arcLength + delta;
        double vecPath = absVecOA + absVecOB;

        return Math.min(arcPath, vecPath);
    }
}
