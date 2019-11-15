//package util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBUtil {
//	
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC";	
//	private static final String USER = "root";
//	private static final String PASSWORD = "1234";
//
//	static {
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(URL, USER, PASSWORD);
//	}
//	
//	public static void close(ResultSet rs) {
//		if(rs != null)
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
//	public static void close(Statement stmt) {
//		if(stmt != null)
//			try {
//				stmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
//	public static void close(Connection conn) {
//		if(conn != null)
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
//	
//	
//	
//	
//	
//	
//}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static DataSource ds;
	static {
		//1.InitailContext 생성
		//2.lookup 으로 DataSource를 찾아온다...Naming Service
		try {
			InitialContext ic = new InitialContext();	//1
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql"); //2
			System.out.println("DataSource Lookup...Success");
		}catch(NamingException e) {
			System.out.println("DataSource Lookup...Fail");
		}
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection(); // 하나씩 커넥션을 빌려온다.
	}
	
	public static void close(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt) {
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void close(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	
	
	
}






