package org.algos._4.preliminary;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        System.out.println(solve(a, b));
    }

    static Map<Character, Integer> mapString(String a){
        Map<Character, Integer> aMap = new HashMap<>();

        for (char c : a.toCharArray()) {
            if (!aMap.containsKey(c)) aMap.put(c, 1);
            else aMap.replace(c, aMap.get(c) + 1);
        }
        return aMap;
    }

    static String solve(String a, String b) {

        Map<Character, Integer> aMap = mapString(a);
        Map<Character, Integer> bMap = mapString(b);

        for (var e : aMap.entrySet()) {
            if (!bMap.containsKey(e.getKey()) || !Objects.equals(e.getValue(), bMap.get(e.getKey()))) return "NO";
        }
        return "YES";
    }

}
