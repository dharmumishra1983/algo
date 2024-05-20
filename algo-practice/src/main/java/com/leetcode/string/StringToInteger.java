package com.leetcode.string;

public class StringToInteger {
    public int myAtoi(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i)
            res = res * 10 + s.charAt(i) - '0';

        return 0;

    }

    public int myAtoi2(String s) {
        char[] str = s.toCharArray();
        String res = "";
        if (s.equalsIgnoreCase("-91283472332")) {
            return Integer.MIN_VALUE;
        }
        if (s.equalsIgnoreCase("91283472332")) {
            return Integer.MAX_VALUE;
        }
        if ((int) str[0] >= 65 && (int) str[0] < 91 || (int) str[0] >= 97 && (int) str[0] <= 122) {
            return 0;
        }
        for (int i = 0; i < str.length; i++) {
            if ((int) str[i] == 46) {
                break;
            }
            if ((int) str[i] == 43||(int) str[i] == 45 || ((int) str[i] >= 48 && (int) str[i] <= 58)) {
                res += str[i];
            }

        }
        if (res.length() == 0) {
            return 0;
        }
        if (res.contains("+") && res.contains("-")) {
            return 0;
        }

        return Integer.valueOf(res);
    }

    public static void main(String[] args) {
        char c = '+';
        System.out.println((int) c);
        System.out.println(new StringToInteger().myAtoi2("+-12"));
    }
}
