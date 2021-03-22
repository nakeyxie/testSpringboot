package com.xiechy.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static List<User> getUser(){
        List<User> userList = new ArrayList<User>();
        try {
            Connection   con = DBUtil.getConnection();
            PreparedStatement  statement = con.prepareStatement("select * from t_user");
            ResultSet set =statement.executeQuery();
            User user =null;
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                user = new User(id,name);
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static void insertUser(User user){
        try {
            Connection   con = DBUtil.getConnection();
            PreparedStatement  statement = con.prepareStatement("insert into t_user values ("+user.getId()+",'"+user.getName()+"')");
            statement.execute();
        } catch (Exception e) {

        }

    }
}




    
        