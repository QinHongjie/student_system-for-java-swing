package sms.jdbc;

import com.mysql.jdbc.Connection;
import sms.utils.JDBCUtils;
import sms.utils.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * 向数据库学生表添加数据
 */
public class JDBC implements JdbcConnector{
	
	JDBCUtils jdbc = new JDBCUtils();
	static Connection conn = null;	//创建mysql连接对象
	static Statement stmt = null;	//创建执行mysql命令对象
	static ResultSet rs = null;	//创建mysql返回结果集对象
	
	//实现 添加基本学生信息记录方法 完成
	public void add(String id, String name, String sex, int age, String password) {
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//4.使用Statement执行SQL语句
			String sql = "insert into students values('"+id+"','"+name+"','"+sex+"',"+age+",null,'"+password+"')";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
	}
	//实现 添加学生分数方法 完成
	public void setMark(String id, int mark) {
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//修改数据库表中字段为id的mark字段记录
			String sql = "update students set mark = '"+mark+"' where id = '"+id+"'";
			//4.使用Statement执行SQL语句
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
	}
	
	//实现 删除学生信息记录方法 完成
	public void delete(String id) {
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//4.使用Statement执行SQL语句
			String sql = "delete from students where id = '"+id+"'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
	}
	
	//实现 修改学生数据信息记录 完成
	public void alter(String id, String name, String sex, int age) {
		//先删除该ID学生信息
		delete(id);
		//最后调用添加学生信息方法
		add(id, name, sex, age, id);
	}

	//实现 修改学生登录密码方法 完成
	public void alterPass(String name, String pass) {
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//查询学生数据表所有信息语句
			String sql = "update students set password='"+pass+"' where name='"+name+"'";
			//使用Statement执行SQL语句
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
	}
	
	//实现 查看学生信息记录，并以集合方式返回 完成
	public ArrayList<Student> select() {
		ArrayList<Student> stuList = new ArrayList<Student>();
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			//通过Connection对象获取Statement对象
			stmt = conn.createStatement();
			//查询学生数据表所有信息语句
			String sql = "select * from students order by id";
			//使用Statement执行SQL语句
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student stu = new Student();//创建临时学生信息对象
				stu.setStuId(rs.getString("id"));
				stu.setStuName(rs.getString("name"));
				stu.setStuSex(rs.getString("sex"));
				stu.setStuAge(rs.getInt("age"));
				if(rs.getString("mark") != null) {
					stu.setStuMark(Integer.parseInt(rs.getString("mark")));
				}
				stu.setStuPass(rs.getString("password"));
				stuList.add(stu);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
		return stuList;
	}
	
	//实现 判断学生姓名是否已有记录方法 完成
	public Boolean ishavaName(String name) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			stmt = conn.createStatement();
			//4.使用Statement执行SQL语句
			String sql = "select name from students";
			rs = stmt.executeQuery(sql);
			//遍历查询结果
			while(rs.next()) {
				//获取数据库name字段信息，并转为整型
				String jname = rs.getString("name");
				if(name.equals(jname)) {
					flag = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
		return flag;
	}
	
	//实现 判断学生ID在数据库中是否已有方法
	public Boolean ishavaId(String id) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			stmt = conn.createStatement();
			//4.使用Statement执行SQL语句
			String sql = "select id from students";
			rs = stmt.executeQuery(sql);
			//遍历查询结果
			while(rs.next()) {
				//获取数据库id字段信息，并转为整型
				String jid = rs.getString("id");
				if(id.equals(jid)) {
					flag = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
		return flag;
	}
	
	//实现 判断学生姓名，除直接以外，在数据库中是否已有方法
	public Boolean alterIshavaName(String id,String name) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
			stmt = conn.createStatement();
			//4.使用Statement执行SQL语句
			String sql = "select * from students";
			rs = stmt.executeQuery(sql);
			//遍历查询结果
			while(rs.next()) {
				//获取数据库name字段信息，并转为整型
				String jid = rs.getString("id");
				String jname = rs.getString("name");
				if(id.equals(jid)) {
					continue;
				}
				if(name.equals(jname)) {
					flag = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//		ArrayList<Student> stuList = new JDBC().select();
//		System.out.println("[id	|name	|sex	|age	|mark	]");
//		for (Student stu : stuList) {
//			String id = stu.getStuId();
//			String name = stu.getStuName();
//			String sex = stu.getStuSex();
//			int age = stu.getStuAge();
//			int mark = stu.getStuMark();
//			System.out.println("["+id+"	|"+name+"	|"+sex+"	|"+age+"	|"+mark+"	]");
//		}
//	}
}