package org.algos._1.lection_7;

import java.io.*;
import java.util.*;


public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().split(" ");

        String res = calcResult(nums, reader);

        writer.write(res);

        reader.close();
        writer.close();
    }

    public static String calcResult(String[] nums, BufferedReader reader) throws IOException{
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums = reader.readLine().split(" ");
            list.add(new Pair(Integer.parseInt(nums[0]), -1));
            list.add(new Pair(Integer.parseInt(nums[1]), 1));
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        Map<Integer, Integer> map = new LinkedHashMap<>();


        int value = 0;
        while (tokenizer.hasMoreTokens()) {
            value = Integer.parseInt(tokenizer.nextToken());
            list.add(new Pair(value, 0));
            map.put(value, 0);
        }

        Collections.sort(list);

        int currentCounter = 0;
        StringBuilder builder = new StringBuilder();

        for (Pair pair : list) {
            if (pair.getSecond() == -1) {
                currentCounter++;
            } else if (pair.getSecond() == 1) {
                currentCounter--;
            } else if (pair.getSecond() == 0) {
                map.put(pair.getFirst(), currentCounter);
            }

        }

        map.forEach((key, value1) -> builder.append(value1).append(" "));

        return builder.toString().trim();
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
