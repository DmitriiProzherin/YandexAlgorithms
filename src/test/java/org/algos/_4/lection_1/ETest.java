package org.algos._4.lection_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ETest {

    @Test
    void main() {
        String out = "Initial array:\n" +
                "12, 32, 45, 67, 98, 29, 61, 35, 09\n" +
                "**********\n" +
                "Phase 1\n" +
                "Bucket 0: empty\n" +
                "Bucket 1: 61\n" +
                "Bucket 2: 12, 32\n" +
                "Bucket 3: empty\n" +
                "Bucket 4: empty\n" +
                "Bucket 5: 45, 35\n" +
                "Bucket 6: empty\n" +
                "Bucket 7: 67\n" +
                "Bucket 8: 98\n" +
                "Bucket 9: 29, 09\n" +
                "**********\n" +
                "Phase 2\n" +
                "Bucket 0: 09\n" +
                "Bucket 1: 12\n" +
                "Bucket 2: 29\n" +
                "Bucket 3: 32, 35\n" +
                "Bucket 4: 45\n" +
                "Bucket 5: empty\n" +
                "Bucket 6: 61, 67\n" +
                "Bucket 7: empty\n" +
                "Bucket 8: empty\n" +
                "Bucket 9: 98\n" +
                "**********\n" +
                "Sorted array:\n" +
                "09, 12, 29, 32, 35, 45, 61, 67, 98\n";

       // assertEquals();
    }
}