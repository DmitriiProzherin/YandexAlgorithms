package org.algos._1.lection_3;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class I {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();

            int n = Integer.parseInt(reader.readLine().trim());
            int number;
            String lang;

            for (int i = 0; i < n; i++) {
                number = Integer.parseInt(reader.readLine().trim());
                for (int j = 0; j < number; j++) {
                    lang = reader.readLine().trim();
                    map.put(lang, map.getOrDefault(lang, 0) + 1);
                    if (map.get(lang) == n) set.add(lang);
                }
            }

            writer.write(set.size()+"\n");
            set.forEach(e -> {
                try {
                    writer.write(e+"\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            writer.write(map.size()+"\n");
            map.forEach((key, value) -> {
                try {
                    writer.write(key + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
