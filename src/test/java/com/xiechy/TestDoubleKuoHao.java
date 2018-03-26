/**
 * @author xiechy
 * @create 2018-01-02
 * @Descrption
 **/
public class TestDoubleKuoHao {
    private  Object o;
    public void addObject(Object o){
        System.out.println("addObject");
        this.o =o;
    }
    public TestDoubleKuoHao(){
        System.out.println("TestDoubleKuoHao");
    }

    public static void main(String[] args) {
        TestDoubleKuoHao t  = new TestDoubleKuoHao(){{
            this.addObject(new Object(){{
                System.out.println("code:"+this.hashCode());
            }
            });
        }};
    }
}




    
        