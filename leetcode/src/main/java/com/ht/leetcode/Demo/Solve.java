package com.ht.leetcode.Demo;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class Solve {

    public static String solve (String s, String t) {
        char[] a = s.toCharArray();
        char[] b=  t.toCharArray();
        char[] res = new char[Math.max(s.length(), t.length()) + 1];
        int i = a.length - 1, j = b.length - 1, k = res.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = a[i--] - '0' + b[j--] - '0' + carry;
            res[k--] = (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        while (i >= 0) {
            int sum = a[i--] - '0' + carry;
            res[k--] = (char)(sum % 10 + '0');
            carry = (sum + carry) / 10;
        }
        while (j >= 0) {
            int sum = b[j--] - '0' + carry;
            res[k--] = (char)(sum % 10 + '0');
            carry = (sum + carry) / 10;
        }
        if (carry > 0) {
            res[0] = '1';
            return String.valueOf(res);
        }
        return String.valueOf(res).substring(1);

    }

    public static void main(String[] args) {
        System.out.println(solve("129", "98"));
        System.out.println('9' - '0');
    }
}
