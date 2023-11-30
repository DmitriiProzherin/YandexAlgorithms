package org.algos._1.lection_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String line;
        while (!"-2000000000".equals(line = reader.readLine())){
            list.add(Integer.parseInt(line));
        }
        System.out.println(typeofList(list));
    }

    private static String typeofList(List<Integer> list) {
        if (list.size() == 1) return "RANDOM";

        ListTypes type = ListTypes.RANDOM;
        int prev = list.get(0);
        int next = list.get(1);

        if (prev == next) type = ListTypes.CONSTANT;
        if (prev < next) type = ListTypes.ASCENDING;
        if (prev > next) type = ListTypes.DESCENDING;

        for (int i = 1; i < list.size() - 1; i++) {
            prev = next;
            next = list.get(i + 1);

            if (prev == next) {
                type = switch (type) {
                    case ASCENDING -> ListTypes.WEAKLY_ASCENDING;
                    case DESCENDING -> ListTypes.WEAKLY_DESCENDING;
                    default -> type;
                };
            } else if (prev < next) {
                type = switch (type) {
                    case DESCENDING, WEAKLY_DESCENDING -> ListTypes.RANDOM;
                    case CONSTANT -> ListTypes.WEAKLY_ASCENDING;
                    default -> type;
                };
            } else {
                type = switch (type) {
                    case ASCENDING, WEAKLY_ASCENDING -> ListTypes.RANDOM;
                    case CONSTANT -> ListTypes.WEAKLY_DESCENDING;
                    default -> type;
                };
            }
        }

        return switch (type) {
            case CONSTANT -> ListTypes.CONSTANT.name();
            case ASCENDING -> ListTypes.ASCENDING.name();
            case WEAKLY_ASCENDING -> "WEAKLY ASCENDING";
            case DESCENDING -> ListTypes.DESCENDING.name();
            case WEAKLY_DESCENDING -> "WEAKLY DESCENDING";
            default -> ListTypes.RANDOM.name();
        };
    }

    private static enum ListTypes{
        CONSTANT,
        ASCENDING,
        WEAKLY_ASCENDING,
        DESCENDING,
        WEAKLY_DESCENDING,
        RANDOM
    }
}
