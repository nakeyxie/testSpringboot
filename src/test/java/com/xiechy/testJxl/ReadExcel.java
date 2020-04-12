package testJxl;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *  读取excel文件内容
 * @author Administrator
 *
 */
public class ReadExcel {
  public static void main(String[] args) {
	try {
		//如果存在了，不会创建一个新的file
		Workbook book = Workbook.getWorkbook(new File("test.xls"));
		//获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		//获得第一行第一列单元格
		Cell cell1=sheet.getCell(0,0);
		//获取单元格内容
		String result = cell1.getContents();
		System.out.println(result);
		
		//关闭
		book.close();
		
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block 
		e.printStackTrace();
	}
}
}
