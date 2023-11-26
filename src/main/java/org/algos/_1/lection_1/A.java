package org.algos._1.lection_1;

import java.util.Scanner;

class A{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String t[] = sc.nextLine().trim().split(" ");

        int t_room = Integer.parseInt(t[0]);
        int t_cond = Integer.parseInt(t[1]);

        String mode = sc.nextLine();


        int result = switch (mode.trim()) {
            case "freeze" -> Math.min(t_room, t_cond);
            case "heat" -> Math.max(t_room, t_cond);
            case "auto" -> t_cond;
            default -> t_room;
        };

        System.out.println(result);

    }

}