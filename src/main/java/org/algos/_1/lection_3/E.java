package org.algos._1.lection_3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class E {
    public static void main(String[] args) {
        try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] nums = reader.readLine().trim().split(" ");
            Set<Integer> xyz = Arrays.stream(nums).map(Integer::parseInt).collect(Collectors.toSet());
            Set<Integer> number = new HashSet<>();
            int num = Integer.parseInt(reader.readLine().trim());

            do {
                number.add(num % 10);
                num /= 10;
            } while (num != 0);

            number.removeAll(xyz);

            writer.write(""+number.size());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
