package com.xiechy.test;

/**
 * @Description 编码测试  （中文乱码的产生原因）https://blog.csdn.net/java_gchsh/article/details/74173498
 * @Author xcy
 * @Date  2021/4/13 17:40
 * @param null
 * @return
*/
public class testUnicode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {//a=97='\u0041'
		char[]  a = new char[]{(char) -128+1,127+1,'\u0041'+1,99,100,110,'\u0043'-1,65};
		//澶у啓A=65锛屽皬鍐?a=97,ASCii鐮佽寖鍥达細0~127锛宑har鐨勮〃绀鸿寖鍥达細-128~127
		//大写A=65，小写a=97,ASCii码范围：0~127，char的范围：-128~127
		//char可以存一个字符，2个字节
		//char 在java中是2个字节。java采用unicode，2个字节（16位）来表示一个字符。
		char b = 127+1;
		char c=(char) -128;
		System.out.println("b:"+b+",c:"+c);//GBK环境下，b=c;utf-8环境下，b和c表示的不是同一个字符！
		System.out.println(a);


		String regex = "(wqnmlgb|cnm|sb|jb|nmb|db|2b)";

		String message = "wqnmlgb,你怎么这么sb,你个db！，怎么回事nmb";
		/*全部替换，如果有字符都替换*/
		message = message.replaceAll(regex, "*****");
		//替换字符：*****,你怎么这么*****,你个*****！，怎么回事*****
		System.out.println("替换字符："+message);

		StringBuffer  stringbuffer = new StringBuffer();
		stringbuffer.append("start,");
		System.out.println(stringbuffer.delete(stringbuffer.length()-1, stringbuffer.length()));
		//3  一个汉字=一个字符=3个字节（UTF-8），一个字母也是一个字符
		byte[] bytes = "谢".getBytes();
		char a2 ='谢';
		System.out.println("a2:"+a2);
		System.out.println(bytes.length);
		System.out.println("say方法前");
		//抛出异常后不会执行后面的语句了！
		say();
		System.out.println("say方法后");



	}

	public static void say(){
		System.out.println("say()方法");
		for(int i=0;i<15;i++){
			if(i==10){
				throw new NullPointerException();
			}
		}

	}

}
