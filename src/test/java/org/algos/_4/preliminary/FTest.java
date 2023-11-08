package org.algos._4.preliminary;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FTest {

    @Test
    void solve() {
        int capacity = 1;
        int n = 10_000;
        long[] array = new long[n];
        Arrays.fill(array, 10_000);
        BigInteger priceSum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            priceSum = priceSum.add(new BigInteger(String.valueOf(2 * i * 10_000)));
        }
        assertEquals(priceSum, F.solve(array, capacity));
    }

}