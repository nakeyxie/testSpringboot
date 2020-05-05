package com.xiechy.SuanFa;

/**
 * @Author: xcy
 * @Date: 2020/4/14 21:05
 * 功能描述: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 */
import java.util.*;
public class Solution {

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if(str.length()==0 ||str == null){
            return result;
        }
        PermutationHelper(str.toCharArray(),0,result);
        Collections.sort(result);
        return result;
    }
    private static void PermutationHelper(char[] chars,int i,ArrayList<String> result){
        //已经递归到了字符串最后一位，判断集合中有没有这个字符串，没有则加入
        if(i== chars.length-1){
            if(!result.contains(new String(chars))){
                result.add(new String(chars));
                return;
            }
        }else{
            //首次传进来的i为0，代表首位字符
            //依次处理i与i后面的每个字符(索引j)交换
            for(int j=i; j<chars.length; j++){
                swap(chars,i,j);//交换
                PermutationHelper(chars,i+1,result);//继续递归交换后的子串
                swap(chars,i,j);//还原
            }
        }
    }
    private static void swap(char[] chars,int i,int j){
        if(i != j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}
