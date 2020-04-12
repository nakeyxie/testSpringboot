package com.xiechy.testjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StringHandle implements DealReult {



	@Override
	public Object handleRult(ResultSet rs) throws SQLException {
		int pk_corp=0;
		while(rs.next()){
			   System.out.println(""+rs.getInt("pk_corp")+","+rs.getString("unitcode")+","+rs.getString("unitname")+"");
			   if(pk_corp==0){
				   pk_corp=rs.getInt("pk_corp");
			   }
		   }
		return pk_corp;
	}

}
