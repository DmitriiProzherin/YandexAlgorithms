package org.algos._1.lection_3;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class D {
    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/algos/_1/lection_3/input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/org/algos/_1/lection_3/output.txt"))
        ) {
            Set<String> set = new HashSet<>();
            String line = reader.readLine();
            line = line.trim();
            while (!line.isBlank()) {
                set.addAll(Arrays.stream(line.trim().split(" +")).collect(Collectors.toSet()));
                line = reader.readLine();
                if (line == null) break;
                line = line.trim();
            }
            writer.write(""+set.size());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

    }
}

