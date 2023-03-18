package sms.login;

import sms.root.RootGUI;
import sms.utils.JDBCUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 管理员登录验证类
 */
public class RootLoginCheck extends LoginCheckNull {
	
	//构造方法验证信息正确性
	@SuppressWarnings("static-access")
	public RootLoginCheck(JFrame frame, String user, String password) {
		super(frame, user, password);
		//根据情况提示
		if(isNull(user,password)) {
			dialog.setVisible(true);
		}else {
			//若姓名/ID确认无误
			if(isRightData(user, password)) {
				frame.dispose();//关闭登录窗口
				new RootGUI().run();//打开管理主窗口
			}else {
				dialog.setVisible(true);
			}
		}
	}
	//验证 用户名/密码 输入是否正确
		public Boolean isRightData(String user, String password) {
			Map<String, String> dataList = new HashMap<String, String>();
			try {
				conn = JDBCUtils.getConnection();//调用数据库工具类，获取连接
				stmt = conn.createStatement();
				//4.使用Statement执行SQL语句
				String sql = "select * from teachers";
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					//获取数据库id字段信息，并转为整型
					String pass = rs.getString("password");
					//获取数据库name字段信息
					String name = rs.getString("user");
					//将id/name字段信息存入集合
					dataList.put(pass, name);
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCUtils.release(stmt, conn);//调用数据库工具类，释放资源
			}
			//foreach循环遍历dataList集合数据
			for (Entry<String, String> entry : dataList.entrySet()) {
				String name = entry.getValue();
				String pass = entry.getKey();
				//判断姓名/密码正确性，并设置相应的弹窗信息
				if(user.equals(name)) {
					if(password.equals(pass)){
						return true;
					}else {
						label.setText("密码输入错误！");
						label.setForeground(Color.red);
						return false;
					}
				}else {
					label.setText("此用户名还没获取权限！");
					label.setForeground(Color.blue);
				}
			}
			return false;
		}
	
}
