package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine().trim(), " ");
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(Integer.parseInt(tokenizer.nextToken()));
        }

        System.out.println(listIsInc(list));
    }

    private static String listIsInc(List<Integer> list) {
        if (list == null) return "NO";
        if (list.size() == 1) return "YES";

        for (int i = 0; i < list.size() - 1; i++) {
            int current = list.get(i);
            int next = list.get(i+1);
            if (current >= next) return "NO";
        }

        return "YES";
    }
}
