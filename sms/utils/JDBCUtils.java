package sms.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * jdbc������
 */
public class JDBCUtils {
	//�������������������ݿ�����
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/student_jdbc";
			String user = "root";
			String password = "root";
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			return conn;
	}
	//�ر����ݿ����ӣ��ͷ���Դ
	public static void release(java.sql.Statement stmt,java.sql.Connection conn) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
