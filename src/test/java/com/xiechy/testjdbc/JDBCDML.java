package com.xiechy.testjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.dbcp.BasicDataSource;


/**
 * ʹ��satementִ��DML����
 * @author soft01
 *
 */
public class JDBCDML {
   public static void main(String[]args){
	   try {
		   BasicDataSource basic=new BasicDataSource();
		   System.out.println(basic);
		   Connection  conn = DBUtil2.getConnection();
		   Statement  state =conn.createStatement();
		   //INSERT  INTO  T_EMP_XCY(empno,ename,job,sal,deptno)
		   // VALUES(8000,'jjack','MANAGER',5000,30)
		  /* String  sql="select * from bd_corp";
		   int flag=-1;
		   flag=state.executeUpdate(sql);
		   if(flag==1){
			   System.out.println("����ɹ�");
		   }*/
		   
		   /*此处用封装的过的代理类来处理结果集*/
		    //ResultSet  rs = state.executeQuery("SELECT * FROM bd_corp");
		   String sql="SELECT * FROM bd_corp";
		    Statementdaili daili = new Statementdaili();
		    Object a = daili.executeQuery(sql, new StringHandle());
		    System.out.println(a);
		    
		  /* while(rs.next()){
			   System.out.println(""+rs.getInt("pk_corp")+","+rs.getString("unitcode")+","+rs.getString("unitname")+"");
		   }*/
		   
		   state.close();
		  
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}finally{
		 DBUtil2.closeConnection();
	}
   }
}
