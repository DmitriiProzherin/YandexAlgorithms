package org.algos._1.lection_3;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class F {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String string1 = reader.readLine().trim();
            String string2 = reader.readLine().trim();
            Map<String, Integer> str1Map = new HashMap<>();
            Set<String> str2Set = new HashSet<>();

            int res = 0;
            String pair;
            if (!string1.isEmpty() && !string2.isEmpty()) {
                for (int i = 1; i < string1.length(); i++) {
                    pair = string1.substring(i-1, i+1);
                    str1Map.put(pair, str1Map.getOrDefault(pair, 0) + 1);
                }

                for (int i = 1; i < string2.length(); i++) {
                    pair = string2.substring(i-1, i+1);
                    str2Set.add(pair);
                }
            }

            for (var e : str1Map.entrySet()) {
                if (str2Set.contains(e.getKey())) {
                    res += e.getValue();
                }
            }

            writer.write("" + res);

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
