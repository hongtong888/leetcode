package com.ht.leetcode.Demo;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * 对于这种对称的  考虑用栈
 */
public class IsValid {

    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack();
        //遍历字符串，判断字符串，判断前半部分对称的就放入后半部分，后半部分判断的时候在pop跟自己判断
        for(char c : s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else if(stack.empty() || stack.pop()!=c)return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        isValid(s);
    }
}
