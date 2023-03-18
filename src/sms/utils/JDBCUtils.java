package sms.utils;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类
 */
public class JDBCUtils {

	//加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/student_jdbc";
		String user = "root";
		String password = "root";
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
		return conn;
	}

	//关闭数据库连接，释放资源
	public static void release(Statement stmt, Connection conn) {
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
