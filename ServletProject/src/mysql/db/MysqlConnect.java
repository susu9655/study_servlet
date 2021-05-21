package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnect {
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/bit501";
	String user="root";
	String pass="1234";
	
	public MysqlConnect() {
		// TODO Auto-generated constructor stub
		try {
			getClass().forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 드라이버 오류:"+e.getMessage()); 
		}
		
	}
	
	public Connection getConnction() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 서버 연결 실패"+e.getMessage());
		}
		return conn;
	}
	
	public void dbClose(PreparedStatement pstmt,Connection conn) {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void dbClose(ResultSet rs, PreparedStatement pstmt,Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
