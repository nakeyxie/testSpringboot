package com.xiechy.testjdbc;

import com.xiechy.testjdbc.DBUtil2;
import com.xiechy.testjdbc.StringHandle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * statement 代理类，可以在这个类增加点新功能
 * @author Administrator
 *
 */
public class Statementdaili {
	
	public Object executeQuery(String sql, StringHandle result) throws SQLException{
		 Connection  conn = DBUtil2.getConnection();
		  Statement  state =conn.createStatement();
		 ResultSet  rs = state.executeQuery("SELECT * FROM bd_corp");
		 int pk_corp=(Integer) result.handleRult(rs);
		 return pk_corp;
	}

}
