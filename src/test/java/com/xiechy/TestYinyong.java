package com.xiechy;

/**
 * @author xiechy
 * @create 2018-04-02
 * @Descrption 测试引用关系
 **/
public class TestYinyong {

    public static void main(String[] args) {
        TestYinyong  t = new TestYinyong();
        User u = t.test(new User());
        System.out.println(u.toString());
    }

   public User test(User user){
        setId(user);
       System.out.println("中间");
         System.out.println(user.toString());
        setName(user);
       return user;
   }

    private void setName(User user) {
        user.setId(99);
    }

    private void setId(User user) {
        user.setName("test");
    }

}




    
        