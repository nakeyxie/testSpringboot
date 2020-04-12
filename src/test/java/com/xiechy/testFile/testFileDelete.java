package testFile;

import java.io.File;

public class testFileDelete {
	public static boolean delAllFile(String path){
		boolean flag=false;
		File file = new File(path);
		if(!file.exists()){
			return flag;
		}
		if(!file.isDirectory()){
			return flag;
		}
		String[] tempArr =file.list();
		File temp=null;
		for(int i=0;i<tempArr.length;i++){
			if(path.endsWith(File.separator)){
				temp=new File(path+tempArr[i]);
			}else{
				temp=new File(path+file.separator+tempArr[i]);
			}
			if(temp.isDirectory()){
				delAllFile(path+"/"+tempArr[i]);//先删除文件夹里面的文件
				delFolder(path+"/"+tempArr[i]);//再删除文件夹
				flag=true;
			}
		}
		
		return flag;
	}

	private static void delFolder(String folderPath) {
		delAllFile(folderPath);//删除完里面所有的内容
		String filePath = folderPath;
		filePath=filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		//返回此抽象路径名的绝对路径名形式。等同于 new File(this.getAbsolutePath())。 
		myFilePath.getAbsoluteFile().delete();//删除空文件夹
		
	}
	

	
	
	
	
	

}
