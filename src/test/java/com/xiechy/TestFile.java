package com.xiechy;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xiechy
 * @create 2018-10-31
 * @Descrption 测试生成文件
 **/
public class TestFile {


    @Test
    public void writer(){
        String[] contents ={"0.01","0.02","0.03","0.04","0.05","0.06"};
        File file = new File("data.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0 ; i<contents.length;i++){
                bw.write("精度:"+contents[i]);
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {

        }
    }
}




    
        