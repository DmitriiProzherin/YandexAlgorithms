package org.algos._1.lection_4;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/_1/lection_4/C/input.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/_1/lection_4/C/output.txt"));
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
                        count = 0;
                    }
                    map.put(word.toString(), ++count);
                    word.setLength(0);
                }
                else if (c == '\n') {
                    if (!word.isEmpty()){
                        count = map.get(word.toString());
                        if (count == null) {
                            count = 0;
                        }
                        map.put(word.toString(), ++count);
                        word.setLength(0);
                    }
                }
                else {
                    word.append((char) c);
                }
            }

            if (map.isEmpty()) {
                writer.write("");
            }
            else {
                int max = 1;
                Optional<String> opt = map.keySet().stream().findAny();
                String res = opt.get();
                for (var e : map.entrySet()) {
                    if (e.getValue() == max) {
                        if (e.getKey().compareTo(res) < 0) res = e.getKey();
                    }
                    else if (e.getValue() > max) {
                        max = e.getValue();
                        res = e.getKey();
                    }
                }
                writer.write(res);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
