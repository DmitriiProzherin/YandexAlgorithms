package org.algos._1.lection_7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            nums = reader.readLine().split(" ");
            list.add(new Pair(Integer.parseInt(nums[0]), -1));
            list.add(new Pair(Integer.parseInt(nums[1]), 1));
        }
        list.sort(Comparator.comparingInt(Pair::getFirst));

        Collections.sort(list);

        int currentOnline = 0;
        int cheaters = 0;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getSecond() == -1) {
                if (currentOnline == 0) {
                    if (i != 0)
                        cheaters+=(list.get(i).getFirst() - list.get(i-1).getFirst() - 1);
                    else cheaters+=list.get(i).getFirst() - 1;
                }
                currentOnline++;
            }
            else if (list.get(i).getSecond() == 1){
                currentOnline--;
            }

        }

        cheaters += n - list.get(list.size() - 1).getFirst();

        writer.write(String.valueOf(cheaters));

        reader.close();
        writer.close();
    }

    private static class Pair implements Comparable<Pair>{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }


        @Override
        public int compareTo(Pair o) {
            if (this.first < o.first) return -1;
            else if (this.first > o.first) return 1;
            else {
                return Integer.compare(this.second, o.second);
            }
        }

        @Override
        public String toString(){
            return this.first + " " + this.second;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }


}
