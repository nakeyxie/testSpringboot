package com.xiechy.testFile;

import java.io.File;

/**
 * 文件扫描器
 * @author Administrator
 *
 */

public class testSeeAllFile {
public static void main(String[] args) {
        //扫描c盘里面所有文件
        String str = "C:\\";
        File f = new File(str);
        fun(f);
    }
    
    //要不断列出，因为给出的File类对象可能是一个目录
    public static void fun(File f){
        //判断给定的路径是否是目录，如果是目录在列出
        if(f.isDirectory()){
            File[] file = f.listFiles();
            //再依次循环进行判断
            try{
                for(int i = 0;i < file.length;i++){
                    //继续把内容传入到fun方法之中进行验证
                    fun(file[i]);
                }
            }catch(Exception e){}
        }
        else{
            System.out.println(f);
        }
    }


}
