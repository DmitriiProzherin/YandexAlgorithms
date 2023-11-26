package org.algos._1.lection_1;

import java.util.Scanner;

public class C{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        PhoneNumber[] numbers = new PhoneNumber[4];

        for (int i = 0; i < 4; i++) {
            String temp = "";
            for (char c: sc.nextLine().toCharArray()) {
                if (c >= '0' && c <= '9') temp = c + temp;
            }
            numbers[i] = new PhoneNumber(temp);
        }

        for (int i = 1; i < 4; i++) {
            if (numbers[i].equals(numbers[0])) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    static class PhoneNumber{
        private String prefix;
        private String code;
        private String number;
        PhoneNumber(String s){

            switch (s.length()) {
                case 7 -> {
                    number = new StringBuilder(s).reverse().toString();
                    code = "495";
                    prefix = "";
                }
                case 11 -> {
                    number = new StringBuilder(s.substring(0, 7)).reverse().toString();
                    code = new StringBuilder(s.substring(7, 10)).reverse().toString();
                    prefix = s.substring(10, 11);
                }
            }

        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PhoneNumber that = (PhoneNumber) o;

            if (!code.equals(that.code)) return false;
            return number.equals(that.number);
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + code.hashCode();
            result = 31 * result + number.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "prefix='" + prefix + '\'' +
                    ", code='" + code + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }

}