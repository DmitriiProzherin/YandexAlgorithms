package org.algos._4.preliminary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class I {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(analyze(input));

    }

    static String analyze(String s) {
        Stack<Character> brackets = new Stack<>();

        for (char c : s.toCharArray()) {
            if (brackets.empty()) {
                if (c == '(' || c == '[' || c == '{') brackets.push(c);
                else return "no";
            }
            else {
                if (c == '(' || c == '[' || c == '{') brackets.push(c);
                else if (brackets.peek().equals(flip(c))) brackets.pop();
                else return "no";
            }
        }

        if (brackets.empty()) return "yes";
        else return "no";
    }

    private static Character flip(char c) {
        return switch (c) {
            case '(' -> ')';
            case ')' -> '(';
            case '[' -> ']';
            case ']' -> '[';
            case '{' -> '}';
            case '}' -> '{';
            default -> ' ';
        };
    }


}
