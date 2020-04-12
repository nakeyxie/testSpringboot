package testzhuangshizhe;

public class Zhuang3 implements IZhuang {
	
IZhuang iz;
	
	public Zhuang3(IZhuang i){
		this.iz=i;
	}

	@Override
	public void work() {
		 System.out.println("这个是测试装饰者模式的第三个继承类");
		 System.out.println("记录日志！");
		 System.out.println("开始执行括号对象的work");
		   iz.work();
		   System.out.println("执行完毕!3");

	}

}
