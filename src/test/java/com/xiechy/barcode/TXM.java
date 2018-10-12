package com.xiechy.barcode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * 生成条形码图片
 */
public class TXM {


public static void main(String[] args) {
String msg = "CI-20180720-02";
String path = "C:/Users/lenovo/Pictures/Saved Pictures/666.png";
int height = 160;
double width = UnitConv.in2mm(1.0f / height);
File file = new File(path);
OutputStream out;
try {
out = new FileOutputStream(file);
} catch (FileNotFoundException e) {
throw new RuntimeException(e);
}
Code39Bean c39 = new Code39Bean();
// 设置属性
c39.setModuleWidth(width);
c39.setWideFactor(2);
String format = "image/png";
BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, format, height, BufferedImage.TYPE_BYTE_BINARY,
false, 0);


// 生成图片
c39.generateBarcode(canvas, msg);
try {
// 关闭流
canvas.finish();
System.out.println("ok...");
} catch (IOException e) {
throw new RuntimeException(e);
}
}
}