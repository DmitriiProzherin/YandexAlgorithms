package org.algos._4.lection_3;

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] temp;
        int N, S, F;
        int[][] M;

        try {
            temp = Arrays.stream(reader.readLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            N = temp[0];
            S = temp[1];
            F = temp[2];

            M = new int[N+1][N+1];
            for (int i = 1; i <= N; i++) {
                temp = Arrays.stream(reader.readLine().trim().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                System.arraycopy(temp, 0, M[i],1,  N);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Arrays for storing visited vertices and distances
        boolean[] visitedArray = new boolean[N+1];
        int[] distanceArray = new int[N+1];

        // Initialize visited vertices array
        visitedArray[0] = true;
        visitedArray[S] = true;

        // Initialize distance array
        for (int i = 1; i < N+1; i++) {
            if (M[S][i] == -1) distanceArray[i] = 10001;
            else distanceArray[i] = M[S][i];
        }

        int currentVertex = S;
        int counter = 0;
        do {
            // Finding the closest unvisited vertex
            int min = 10001;
            for (int i = 1; i < N+1; i++) {
                if (distanceArray[i] <= min && !visitedArray[i]) {
                    min = distanceArray[i];
                    currentVertex = i;
                }
            }

            // Marking current vertex as a visited one
            visitedArray[currentVertex] = true;

            // Re-evaluate distances
            for (int i = 1; i < N + 1; i++) {
                if (M[currentVertex][i] != -1) {
                    distanceArray[i] = Math.min(
                      distanceArray[i],
                      distanceArray[currentVertex] + M[currentVertex][i]
                    );
                }
            }
            counter++;
        } while (currentVertex != F && counter < N);
        System.out.println(distanceArray[F] == 10001 ? -1 : distanceArray[F]);
    }
}
