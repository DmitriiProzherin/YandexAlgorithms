package org.algos._1.lection_1;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        solve(a11, a12, a21, a22, b1, b2);
    }

    private static void solve(double a11, double a12, double a21, double a22, double b1, double b2) {
        double D = a11*a22 - a12*a21;
        double Dx = b1*a22 - b2*a21;
        double Dy = a11*b2 - a12*b1;

        // Главный определитель != 0 => ровно 1 решение
        if (D != 0) {
            double x = Dx/D;
            double y = Dy/D;
            System.out.printf("2 %.5f %.5f", x, y);
        }
        else {
            if (a11 == 0 && a12 == 0 & a21 ==0 && a22 == 0){
                if (b1 == 0 && b2 == 0) System.out.print(5);
                else System.out.print(0);
            }
            else {
                
            }
        }
    }
}
