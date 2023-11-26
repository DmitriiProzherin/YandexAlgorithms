package org.algos._4.lection_3;

import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(19);
        set.add(1);
        set.add(9);
        set.add(199);
        set.add(5);
        System.out.println(set.first());
        System.out.println(set.last());
        set.remove(1);
        System.out.println(set.first());
    }

}
