package com.xiechy.SuanFa;

import java.util.Stack;

/**
 * @Author xcy
 * @Date 2020/4/15 17:24
 * @Description 这是leetcode上的题。
 *
 * 给定一个字符串，只包含字符“（”、“””、“{”、“}”、“[”和“”），确定输入字符串是否有效。
 *
 * 括号必须以正确的顺序关闭，“（）”和“（）”{“}”都是有效的，但“（）和[（[ ] ] ] ]不是。
 *
 * 主要应用的是栈的知识点。开始的时候进行压栈，后期进行弹栈比较，这个思路很经典，个人觉得c语言实现更好理解一些
 * ————————————————
 * 版权声明：本文为CSDN博主「原点2333」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq297877375/article/details/79113056
 */
public class charStack {
    public static void main(String[] args) {
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String strt){
        Stack<Character> stack = new Stack<Character>();
        for(Character c: strt.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if( c=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
