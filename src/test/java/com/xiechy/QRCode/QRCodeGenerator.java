package com.xiechy.QRCode;

/**
 * @Author: xiechengyu
 * @Description: 实现生成二维码
 * @Date: 2019/7/31 0031 17:31
 * @Param: 
 */

import com.beust.jcommander.internal.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

public class QRCodeGenerator {

	public static final String QR_CODE_IMAGE_PATH = "QRCode.png";

	/**
	 * @Author: xiechengyu
	 * @Description: 英文
	 * @Date: 2019/7/31 0031 18:16
	 * @Param: [text, width, height, filePath]
	 */
	private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {

		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		
		Path path = FileSystems.getDefault().getPath(filePath);
		
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
		
	}

	/**
	 * @Author: xiechengyu
	 * @Description: 解决中文
	 * @Date: 2019/7/31 0031 18:16
	 * @Param: []
	 */
	private static void generateQRCodeImageChinese(String text, int width, int height, String filePath) throws WriterException, IOException {
		Map<EncodeHintType, String> hints = Maps.newHashMap();
		//内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE,
				width, height, hints);

		Path path = FileSystems.getDefault().getPath(filePath);

		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}




	/**
	 * @Author: xiechengyu
	 * @Description: 生成二维码图片到指定路径下
	 * @Date: 2019/7/31 0031 17:40
	 * @Param: [text, width, height, filePath]
	 */
	public static void generateQRCodeImage(String text, int width, int height) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		File file =new File(getFileUrl());
		if(!file.exists()){
			file.createNewFile();
		}
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
		Path path = FileSystems.getDefault().getPath(getFileUrl());
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	/**
	 * @Author: xiechengyu
	 * @Description: 获取二维码生成路径 （本地：C:\Users\XIECHE~1\AppData\Local\Temp\）
	 * @Date: 2019/8/8 0008 14:58
	 * @Param: []
	 */
	public static String getFileUrl(){

		//jvm 在不同的系统允许会是不同的路径或者是不同的分隔符
		//System.getProperty("java.io.tmpdir");   jvm 允许空间暂时的目录
		String home = System.getProperty("java.io.tmpdir");
		//System.getProperty("file.separator") 获取系统分隔符
		String fileName = home + System.getProperty("file.separator") +"QRCode.png";
		return fileName;
	}

	public static void main(String[] args) {
		try {
			//generateQRCodeImage("fuck you !", 400, 400, QR_CODE_IMAGE_PATH);
			generateQRCodeImageChinese("345", 400, 400, QR_CODE_IMAGE_PATH);

			/*//系统获取属性
			Properties properties = System.getProperties();
			properties.entrySet().forEach( entry ->{
				System.out.println(entry.getKey()+":"+entry.getValue());
			});
*/
		} catch (Exception e) {
			System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
		}

	}
}
