package sms.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sms.utils.JDBCUtils;
import sms.utils.Student;
/**
 * �����ݿ�ѧ�����������
 */
public class JDBC implements JdbcConnector{
	
	JDBCUtils jdbc = new JDBCUtils();
	static Connection conn = null;	//����mysql���Ӷ���
	static Statement stmt = null;	//����ִ��mysql�������
	static ResultSet rs = null;	//����mysql���ؽ��������
	
	//ʵ�� ��ӻ���ѧ����Ϣ��¼���� ���
	public void add(String id, String name, String sex, int age, String password) {
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			//ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "insert into students values('"+id+"','"+name
					+"','"+sex+"',"+age+",null,'"+password+"')";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
	}
	//ʵ�� ���ѧ���������� ���
	public void setMark(String id, int mark) {
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			//ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//�޸����ݿ�����ֶ�Ϊid��mark�ֶμ�¼
			String sql = "update students set mark = '"
						+mark+"' where id = '"+id+"'";
			//4.ʹ��Statementִ��SQL���
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
	}
	
	//ʵ�� ɾ��ѧ����Ϣ��¼���� ���
	public void delete(String id) {
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			//ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "delete from students where id = '"+id+"'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
	}
	
	//ʵ�� �޸�ѧ��������Ϣ��¼ ���
	public void alter(String id, String name, String sex, int age) {
		//��ɾ����IDѧ����Ϣ
		delete(id);
		//���������ѧ����Ϣ����
		add(id, name, sex, age, id);
	}

	//ʵ�� �޸�ѧ����¼���뷽�� ���
	public void alterPass(String name, String pass) {
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			//ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//��ѯѧ�����ݱ�������Ϣ���
			String sql = "update students set password='"+pass+"' where name='"+name+"'";
			//ʹ��Statementִ��SQL���
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
	}
	
	//ʵ�� �鿴ѧ����Ϣ��¼�����Լ��Ϸ�ʽ���� ���
	public ArrayList<Student> select() {
		ArrayList<Student> stuList = new ArrayList<Student>();
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			//ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//��ѯѧ�����ݱ�������Ϣ���
			String sql = "select * from students order by id";
			//ʹ��Statementִ��SQL���
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student stu = new Student();//������ʱѧ����Ϣ����
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
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
		return stuList;
	}
	
	//ʵ�� �ж�ѧ�������Ƿ����м�¼���� ���
	public Boolean ishavaName(String name) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "select name from students";
			rs = stmt.executeQuery(sql);
			//������ѯ���
			while(rs.next()) {
				//��ȡ���ݿ�name�ֶ���Ϣ����תΪ����
				String jname = rs.getString("name");
				if(name.equals(jname)) {
					flag = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
		return flag;
	}
	
	//ʵ�� �ж�ѧ��ID�����ݿ����Ƿ����з���
	public Boolean ishavaId(String id) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "select id from students";
			rs = stmt.executeQuery(sql);
			//������ѯ���
			while(rs.next()) {
				//��ȡ���ݿ�id�ֶ���Ϣ����תΪ����
				String jid = rs.getString("id");
				if(id.equals(jid)) {
					flag = true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
		}
		return flag;
	}
	
	//ʵ�� �ж�ѧ����������ֱ�����⣬�����ݿ����Ƿ����з���
	public Boolean alterIshavaName(String id,String name) {
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();//�������ݿ⹤���࣬��ȡ����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "select * from students";
			rs = stmt.executeQuery(sql);
			//������ѯ���
			while(rs.next()) {
				//��ȡ���ݿ�name�ֶ���Ϣ����תΪ����
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
			JDBCUtils.release(stmt, conn);//�������ݿ⹤���࣬�ͷ���Դ
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