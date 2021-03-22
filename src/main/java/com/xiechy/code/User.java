package com.xiechy.code;

/**
 * @author xiechy
 * @create 2018-01-03
 * @Descrption
 **/
public class User {
    int id;
    String name;

    Double sarlay;

    public User(){
        super();
    }

    public User (int id, String name){
        this.id = id;
        this.name = name;
    }

    public Double getSarlay() {
        return sarlay;
    }

    public void setSarlay(Double sarlay) {
        this.sarlay = sarlay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sarlay=" + sarlay +
                '}';
    }
}




    
        