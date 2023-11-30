package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            list.add(Integer.parseInt(tokenizer.nextToken()));
        }
        int number = Integer.parseInt(reader.readLine());

        System.out.print(closestElementToANumber(list, number));
    }


    public static int closestElementToANumber(List<Integer> list, int number) {
        int index = 0;
        int delta = Math.abs(number - list.get(index));

        for (int i = 1; i < list.size(); i++) {
            if (Math.abs(list.get(i) - number) < delta) {
                index = i;
                delta = Math.abs(list.get(i) - number);
            }
        }

        return list.get(index);
    }
}
