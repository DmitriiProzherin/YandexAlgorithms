package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        reader.close();

        List<Integer> results = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            results.add(Integer.parseInt(tokenizer.nextToken()));
        }
        System.out.println(maxPlace(results));
    }

    private static int maxPlace(List<Integer> results) {
        List<Integer> possibleResults = new ArrayList<>();
        int place = results.size();
        int winnerResult = Collections.max(results);
        int index = results.indexOf(winnerResult);

        for (int i = 0; i < results.size() - 1; i++) {
            if (results.get(i) % 10 == 5 && results.get(i+1) < results.get(i) && index < i) possibleResults.add(results.get(i));
        }

        if (possibleResults.isEmpty()) return 0;

        int bestResult = Collections.max(possibleResults);

        for (Integer result : results) {
            if (result <= bestResult) place--;
        }

        return place + 1;
    }


}
