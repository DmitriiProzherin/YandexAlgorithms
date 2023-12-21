package org.algos._1.lection_4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/_1/lection_4/B/input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/_1/lection_4/B/output.txt"));
        ) {
            Map<String, Integer> map = new HashMap<>();
            StringBuilder word = new StringBuilder();
            Integer count;
            int c;
            while ((c = reader.read()) > -1)
            {
                if (c == ' ' && !word.isEmpty()) {
                    count = map.get(word.toString());
                    if (count == null) {
                        writer.write("0 ");
                        count = 0;
                    }
                    else {
                        writer.write(count + " ");
                    }
                    map.put(word.toString(), ++count);
                    word.setLength(0);
                }
                else if (c == '\n') {
                    if (!word.isEmpty()){
                        count = map.get(word.toString());
                        if (count == null) {
                            writer.write("0 ");
                            count = 0;
                        }
                        else {
                            writer.write(count + " ");
                        }
                        map.put(word.toString(), ++count);
                        word.setLength(0);
                    }
                }
                else {
                    word.append((char) c);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
