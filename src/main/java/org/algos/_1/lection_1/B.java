package org.algos._1.lection_1;

import java.util.Scanner;

public class B{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a <= 0 || b <= 0 || c <= 0) System.out.println("NO");
        else if ( a+b<=c || a+c <= b || b+c <= a) System.out.println("NO");
        else System.out.println("YES");


    }
}