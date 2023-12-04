package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(Integer.valueOf(tokenizer.nextToken()));
        }
        System.out.println(countHills(list));
    }

    private static int countHills(List<Integer> list) {
        if (list.isEmpty() || list.size() == 1 || list.size() == 2) return 0;

        int i = 1;
        int counter = 0;
        while (i < list.size() - 1) {
            if (list.get(i-1) >= list.get(i)) i++;
            else {
                if (list.get(i) > list.get(i+1)) {
                    counter++;
                    i+=2;
                }
                else {
                    i++;
                }
            }
        }
        return counter;
    }
}
