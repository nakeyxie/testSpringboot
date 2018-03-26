package TestConectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author xiechy
 * @create 2018-01-03
 * @Descrption
 **/
public class TestQuery {
    public static void main(String[] args) {
        try {
            Connection   con = DBUtil.getConnection();
            PreparedStatement  statement = con.prepareStatement("select * from t_user");
            ResultSet set =statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                System.out.println("id:"+id+",name:"+name);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}




    
        