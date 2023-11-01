package org.algos._4.preliminary;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JTest {

    @Test
    @RepeatedTest(100)
    void solveTest1() {
        int a = 1;
        int b  = 1_000_000_000;
        int n = 999999937;

        assertEquals("YES", J.solve(n, a, b));
    }
}