package org.algos._1.lection_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Set<Integer> anya = new TreeSet<>();
        Set<Integer> borya = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            anya.add(Integer.parseInt(reader.readLine()));

        }
        for (int i = 0; i < m; i++) {
            borya.add(Integer.parseInt(reader.readLine()));
        }

        // Пересечение
        Set<Integer> intersection = new TreeSet<>(anya);
        intersection.retainAll(borya);

        // Уникальные для Бори
        borya.removeAll(intersection);

        // Уникальные для Ани
        anya.removeAll(intersection);

        String anyaString = String.join(" ", anya.stream().map(String::valueOf).toArray(String[]::new));
        String boryaString = String.join(" ", borya.stream().map(String::valueOf).toArray(String[]::new));
        String intersectionString = String.join(" ", intersection.stream().map(String::valueOf).toArray(String[]::new));

        System.out.println(intersection.size());
        System.out.println(intersectionString);
        System.out.println(anya.size());
        System.out.println(anyaString);
        System.out.println(borya.size());
        System.out.println(boryaString);

        reader.close();
    }
}
