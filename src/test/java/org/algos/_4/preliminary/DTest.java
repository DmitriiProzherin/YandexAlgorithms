package org.algos._4.preliminary;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class DTest {

    @Test
    void testEqualStrings(){
        String s1 = "dsfdsfd";
        String s2 = "dsfdsfd";
        assertEquals("YES", D.solve(s1, s2));
    }

    @Test
    void testEmptyStrings(){
        assertEquals("YES", D.solve("", ""));
    }

    @Test
    void testDifferentStrings(){
        String s1 = "wqrwed";
        String s2 = "wqrwedw";
        assertEquals("NO", D.solve(s1, s2));
    }

    @Test
    void testMaxLengthEqualStrings(){
        Random random = new Random();
        StringBuilder s1Builder = new StringBuilder();
        StringBuilder s2Builder = new StringBuilder();

        char c;
        for (int i = 0; i < 100000; i++) {
            c = (char)(random.nextInt(26) + 'a');
            s1Builder.append(c);
            c = (char)(random.nextInt(26) + 'a');
            s2Builder.append(c);
        }
        
        String s1 = s1Builder.toString();
        String s2 = s1;
        assertEquals("YES", D.solve(s1, s2));
    }

    @Test
    void testMaxLengthNonEqualStrings(){
        Random random = new Random();
        StringBuilder s1Builder = new StringBuilder();
        StringBuilder s2Builder = new StringBuilder();

        char c;
        for (int i = 0; i < 100000; i++) {
            c = (char)(random.nextInt(26) + 'a');
            s1Builder.append(c);
            c = (char)(random.nextInt(26) + 'a');
            s2Builder.append(c);
        }

        String s1 = s1Builder.toString();
        String s2 = s2Builder.toString();
        assertEquals("NO", D.solve(s1, s2));
    }

    @Test
    void testMaxLengthNonEqual1SymbolStrings(){
        Random random = new Random();
        StringBuilder s1Builder = new StringBuilder();
        StringBuilder s2Builder = new StringBuilder();

        char c;
        for (int i = 0; i < 100000; i++) {
            c = (char)(random.nextInt(26) + 'a');
            s1Builder.append(c);
            c = (char)(random.nextInt(26) + 'a');
            s2Builder.append(c);
        }

        String s1 = s1Builder.toString();
        String s2 = "g".equals(s1Builder.substring(s1Builder.length() - 1)) ?
                s1Builder.replace(s1Builder.length() - 1, s1Builder.length(), "r").toString() :
                s1Builder.replace(s1Builder.length() - 1, s1Builder.length(), "g").toString();
        assertEquals("NO", D.solve(s1, s2));
    }
}