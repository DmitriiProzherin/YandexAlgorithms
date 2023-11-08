package org.algos._4.preliminary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        long[] floorsArray = new long[n];

        for (int i = 0; i < n; i++) {
            floorsArray[i]  = scanner.nextInt();
        }

        System.out.println(solve(floorsArray, k));
    }

    static BigInteger solve(long[] arrayOfFloors, int capacity){
        long freeSpace = 0;
        BigInteger priceSum = BigInteger.ZERO;
        long price;
        long peopleLeft;
        long freeRiders;
        long ridesAmount;

        for (int i = arrayOfFloors.length - 1; i >= 0 ; i--) {
            if (arrayOfFloors[i] == 0) continue;
            if (arrayOfFloors[i] <= freeSpace) {
                freeRiders = arrayOfFloors[i];
                freeSpace -= freeRiders;
            }
            else {
             freeRiders = freeSpace;
             arrayOfFloors[i] -= freeRiders;
             price = 2L * (i+1);

             if (capacity >= arrayOfFloors[i]) {
                 priceSum = priceSum.add(new BigInteger(String.valueOf(price)));
                 freeSpace = capacity - arrayOfFloors[i];
             }
             else {
                 peopleLeft = arrayOfFloors[i] % capacity;
                 if (peopleLeft == 0) {
                     ridesAmount = arrayOfFloors[i] / capacity;
                     priceSum = priceSum.add(new BigInteger(String.valueOf(ridesAmount * price)));
                     freeSpace = 0;
                 }
                 else {
                     ridesAmount = arrayOfFloors[i] / capacity + 1;
                     priceSum = priceSum.add(new BigInteger(String.valueOf(ridesAmount * price)));
                     freeSpace = capacity - peopleLeft;
                 }
             }
            }
        }
        return priceSum;
    }
}
