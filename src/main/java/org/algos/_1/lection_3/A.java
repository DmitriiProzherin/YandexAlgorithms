package org.algos._1.lection_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(Integer.valueOf(tokenizer.nextToken()));
        }
        System.out.print(differentNumbersAmount(list));
    }

    public static int differentNumbersAmount(List<Integer> list){
        return new HashSet<>(list).size();
    }

}
