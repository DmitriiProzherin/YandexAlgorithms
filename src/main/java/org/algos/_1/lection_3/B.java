package org.algos._1.lection_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    public static void main(String[] args) throws IOException {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        while (tokenizer.hasMoreTokens()) {
            set1.add(Integer.valueOf(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        while (tokenizer.hasMoreTokens()) {
            set2.add(Integer.valueOf(tokenizer.nextToken()));
        }

        set2.retainAll(set1);

        List<Integer> res = new ArrayList<>(set2);
        Collections.sort(res);

        for (var el : res) System.out.print(el + " ");
    }
}
