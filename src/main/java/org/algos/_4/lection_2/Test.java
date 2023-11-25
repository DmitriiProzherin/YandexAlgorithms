package org.algos._4.lection_2;

public class Test {
    public static void main(String[] args) {
        int a = -16;
        int b = a >> 1;
        int c = a >>> 1;
        System.out.println(a + " " + Integer.toBinaryString(a));
        System.out.println(b + " " + Integer.toBinaryString(b).length());
        System.out.println(c + " " + Integer.toBinaryString(c).length());
//        System.out.println((-16)>>>2);
    }
}
