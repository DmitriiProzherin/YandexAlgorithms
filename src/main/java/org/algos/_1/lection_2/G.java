package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(Integer.valueOf(tokenizer.nextToken()));
        }
        long[] res = getMAxMultiplication(list);
        System.out.print(res[0] + " " + res[1]);
    }

    public static long[] getMAxMultiplication(List<Integer> list){
        long max, pmax, min, pmin;
        if (list.get(0) > list.get(1)) {
            max = list.get(0);
            pmax = list.get(1);
        }
        else {
            max = list.get(1);
            pmax = list.get(0);
        }
        min = pmax;
        pmin = max;

        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) == 0) continue;
            if (list.get(i) >= max) {
                pmax = max;
                max = list.get(i);
            }
            else if (list.get(i) > pmax) pmax = list.get(i);
            else if (list.get(i) <= min) {
                pmin = min;
                min = list.get(i);
            }
            else if (list.get(i) < pmin) pmin = list.get(i);
        }
        if (max*pmax >= min*pmin) return new long[] {pmax, max};
        else return new long[] {min, pmin};
    }
 }
