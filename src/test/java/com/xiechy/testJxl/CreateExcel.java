package testJxl;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
/**
 * 导出excel
 * @author Administrator
 *
 */

public class CreateExcel {
	public static void main(String[] args) {
		try {
			// 打开文件
			WritableWorkbook book = Workbook
					.createWorkbook(new File("test.xls"));
			//  生成名为“第一页”的工作表，参数0表示这是第一页 
			WritableSheet sheet = book.createSheet("第一页", 0);
			//  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
			//   以及单元格内容为test 
			Label label = new Label(0, 0, "test");
			// 奖定义好的单据格添加到工作表中
			sheet.addCell(label);
			
			//生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			jxl.write.Number  number = new jxl.write.Number(1,1,789.123);
			sheet.addCell(number);
			
			//写入数据并关闭文件
			book.write();
			book.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

}
