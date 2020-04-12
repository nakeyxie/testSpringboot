package com.xiechy.testjdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;



import org.apache.commons.dbcp.BasicDataSource;

/**
 * ʹ�����ӳؼ���������ݿ�����
 * 
 * @author soft01
 * 
 */
public class DBUtil2 {
	// ��ݿ����ӳ�
	private static BasicDataSource ds;
	// Ϊ��ͬ�̹߳�������
	private static ThreadLocal<Connection> tl;

	static { // static������ʼ�����
		try {
         
			Properties  prop = new Properties();
			
			//������Ϣ
			InputStream  is =DBUtil2.class.getClassLoader().getResourceAsStream("" +
					"com/xiechy/testjdbc/config.properties");
			
			prop.load(is);
			
			is.close();
			
			
			// ��ʼ�����ӳ�
			ds=new BasicDataSource();
			//������
			ds.setDriverClassName(prop.getProperty("driver").trim());
			//����URL
			ds.setUrl(prop.getProperty("url").trim());
			//������ݿ��û�������
			ds.setUsername(prop.getProperty("user").trim());
			ds.setPassword(prop.getProperty("pwd").trim());
			
			
			String in=prop.getProperty("initsize");
			String maxactive=prop.getProperty("maxactive");
			String minidle=prop.getProperty("minidle");
			String maxidle=prop.getProperty("maxidle");
			String maxwait=prop.getProperty("maxwait");
			
			System.out.println(in+","+maxactive+","+minidle+","+maxidle+","+maxwait);
			
			//��ʼ��������
			ds.setInitialSize(Integer.parseInt(in));
			//���������
			ds.setMaxActive(Integer.parseInt(maxactive));
			//������С������
			ds.setMinIdle(Integer.parseInt(minidle));
			//������������
			ds.setMaxIdle(Integer.parseInt(maxidle));
            //�������ȴ�ʱ��			
			ds.setMaxWait(Integer.parseInt(maxwait));
			
			//��ʼ�������߳�
			tl=new ThreadLocal<Connection>();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
  public static Connection getConnection() throws SQLException{
	  /*
	   * ͨ�����ӳػ�ȡһ����������
	   */
	  Connection conn;
		conn = ds.getConnection();
		
		 tl.set(conn);
		 
	
	 return  conn;
	  
  }
	
	public static void closeConnection(){
		try {
			Connection conn = tl.get();
			if (conn !=null) {
				conn.close();//�����ӻ������ӳ����������Ĺ���
				
				tl.remove();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}
