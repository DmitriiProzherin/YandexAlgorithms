package org.algos._1.lection_3;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class G {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(reader.readLine().trim());
            int a, b;
            String[] nums;
            Set<Integer> turtles = new HashSet<>();
            for (int i = 0; i < n; i++) {
                nums = reader.readLine().trim().split(" ");
                a = Integer.parseInt(nums[0]);
                b = Integer.parseInt(nums[1]);
                if (a >= 0 && b >= 0 && (a+b == n-1)) {
                    turtles.add(a);
                }
            }
            writer.write(""+turtles.size());
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
