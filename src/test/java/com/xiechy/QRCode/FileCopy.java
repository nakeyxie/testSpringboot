package com.xiechy.QRCode;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author xiechy
 * @create 2019-07-31
 * @Descrption 实现文件复制
 **/
public class FileCopy {


    public static void main(String[] args) {
        String url = null;
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            //.../coach-euas/target/classes/com/icarbonx/coach/euas/service/
            String path = FileCopy.class.getResource(".").getPath();
            String prefix =path.replace("target","8").split("8")[0];
            String filePath = prefix +QRCodeGenerator.QR_CODE_IMAGE_PATH;
            inputChannel = new FileInputStream(new File(filePath)).getChannel();
            outputChannel = new FileOutputStream(new File(prefix+"src/QRCode/test.png")).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            //log.error("getUniqueCodeUrl error:"+e.getMessage(),e);
        }finally {
            IOUtils.closeQuietly(inputChannel);
            IOUtils.closeQuietly(outputChannel);
        }
    }
}




    
        