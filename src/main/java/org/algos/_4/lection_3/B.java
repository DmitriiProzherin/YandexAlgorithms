package org.algos._4.lection_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        int[] temp;
        final int N;
        final int S;
        final int F;
        final int[][] M;

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
        int[] verticesPaths = new int[N+1];

        // Initialize visited vertices array
        visitedArray[0] = true;
        visitedArray[S] = true;

        // Initialize distance array
        for (int i = 1; i < N+1; i++) {
            if (M[S][i] == -1) distanceArray[i] = 10001;
            else distanceArray[i] = M[S][i];
        }

        // Initialize vertices paths array
        verticesPaths[S] = S;

        int currentVertex = S;
        int counter = 0;
        do {
            // Saving previous vertex for pathing
            int previousVertex = currentVertex;

            // Finding the closest unvisited vertex
            int min = 10001;
            for (int i = 1; i < N+1; i++) {
                if (distanceArray[i] <= min && !visitedArray[i]) {
                    min = distanceArray[i];
                    currentVertex = i;
                }
            }
            if (previousVertex == S) verticesPaths[currentVertex] = previousVertex;

//            verticesPaths[currentVertex] = previousVertex;

            // Marking current vertex as a visited one
            visitedArray[currentVertex] = true;

            // Re-evaluate distances
            for (int i = 1; i < N + 1; i++) {
                if (M[currentVertex][i] != -1) {
                    if (distanceArray[currentVertex] + M[currentVertex][i] < distanceArray[i]) {
                        distanceArray[i] = distanceArray[currentVertex] + M[currentVertex][i];
                        verticesPaths[i] = currentVertex;
                    }
                }
            }
            counter++;
        } while (currentVertex != F && counter < N);

//        System.out.println(Arrays.toString(verticesPaths));

        if (distanceArray[F] == 10001) System.out.println(-1);
        else {
            int vertex = F;

            ArrayList<Integer> list = new ArrayList<>();
            list.add(F);
            while (verticesPaths[vertex] != S && verticesPaths[vertex] != 0) {
                list.add(verticesPaths[vertex]);
                vertex = verticesPaths[vertex];
            }
            if (S != F) list.add(S);

            Collections.reverse(list);
            String res = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(res);
        }
    }
}
