package org.algos._1.lection_4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        int n;
        String target;
        String[] pair;
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                pair = reader.readLine().split(" ");
                map.put(pair[1], pair[0]);
                map.put(pair[0], pair[1]);
            }
            target = reader.readLine();

            writer.write(map.get(target));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
