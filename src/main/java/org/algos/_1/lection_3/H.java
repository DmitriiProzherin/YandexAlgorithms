package org.algos._1.lection_3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class H {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(reader.readLine().trim());
            int a;
            String[] nums;
            Set<Integer> shots = new HashSet<>();
            for (int i = 0; i < n; i++) {
                nums = reader.readLine().trim().split(" ");
                a = Integer.parseInt(nums[0]);
                shots.add(a);
            }
            writer.write(""+shots.size());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }


}
