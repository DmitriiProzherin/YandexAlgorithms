package org.algos._4.contest;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        int M = scanner.nextInt();

        long[] array = new long[M];

        for (int i = 0; i < M; i++) {
            array[i] = scanner.nextLong();
        }

        System.out.println(calc(N, array));
    }

    public static String calc(long N, long[] array){
        long k = 2*Arrays.stream(array).sum();
        if (k < N) return "-1";
        else {
            return "" + CoinChangeLimitedExample.countWays(array, N, 2);
        }
    }

    public static class CoinChangeLimitedExample {
        public static int countWays(long[] coins, long S, long limit) {
            long[] dp = new long[ (int) S + 1];
            dp[0] = 1;

            for (long coin : coins) {
                for (long i = S; i >= coin; i--) {
                    for (long j = 1; j <= limit; j++) {
                        if (i - j * coin >= 0) {
                            dp[ (int) i] += dp[(int) (i - j * coin)];
                        }
                    }
                }
            }

            return (int) dp[(int) S];
        }
    }

}
