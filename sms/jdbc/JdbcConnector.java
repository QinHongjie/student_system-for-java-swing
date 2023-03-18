package sms.jdbc;

import java.util.ArrayList;
/**
 * 数据库操作接口，创建必备方法
 */
public interface JdbcConnector {
	
	//添加基本学生信息记录方法
	void add(String id, String name, String sex, int age, String password);
	
	//添加学生分数方法
	void setMark(String id, int mark);
	
	//删除学生信息记录方法
	void delete(String id);
	
	//修改学生数据信息记录
	void alter(String id, String name, String sex, int age);
	
	//修改学生登录密码
	void alterPass(String name, String pass);
	
	//查看学生信息记录，并以集合方式返回
	@SuppressWarnings("rawtypes")
	ArrayList select();

	//判断学生姓名在数据库中是否已有
	Boolean ishavaName(String name);
	
	//判断学生ID在数据库中是否已有
	Boolean ishavaId(String id);
	
	//判断学生姓名，除直接以外，在数据库中是否已有
	Boolean alterIshavaName(String id, String name);
	
	//判断学生ID，除自己以外，在数据库中是否已有
//	Boolean alterIshavaId(String id);
}
