/**
 * @author xiechy
 * @create 2018-01-02
 * @Descrption
 **/
public class TestLoadOrad {
    public TestLoadOrad(){
        System.out.println("构造");
    }
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        TestLoadOrad  t = new sun();
        TestLoadOrad  t2 = new sun();
    }
}
class sun extends  TestLoadOrad {
    public sun(){
        System.out.println("sun 构造");
    }
    {
        System.out.println("sun 代码块");
    }
    static {
        System.out.println("sun  静态代码块");
    }
}



    
        