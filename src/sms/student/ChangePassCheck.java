package sms.student;

import sms.jdbc.JDBC;
import sms.login.LoginCheckNull;
import sms.utils.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * 修改学生登录密码验证
 */
public class ChangePassCheck extends LoginCheckNull{

	public ChangePassCheck(JFrame frame,String password, String pass,
						   String pass1, String pass2, String name) {
		super(frame, pass, pass1);
		super.name = "原密码";
		super.pass = "新密码";
		if(isNull(pass, pass1)) {
			dialog.setVisible(true);
		}else {
			if(isPassNull(pass2)) {
				dialog.setVisible(true);
			}else {
				if(!isPass1(pass)) {
					dialog.setVisible(true);
				}else {
					if(!isPass2(pass1, pass2)) {
						dialog.setVisible(true);
					}else {
						new JDBC().alterPass(name, pass2);
						label.setText("密码修改成功！");
						label.setForeground(Color.blue);
						dialog.setVisible(true);
					}
				}
			}
		}
	}

	//验证'确认密码'文本框是否为空
	Boolean isPassNull(String pass) {
		if(pass.length() == 0) {
			label.setText("请确认密码！");
			label.setForeground(Color.red);
			return true;
		}
		return false;
	}

	//验证原密码正确性
//	Boolean isPass1(String password,String pass) {
//		if(!password.equals(pass)) {
//			label.setText("原密码错误！");
//			label.setForeground(Color.red);
//			return false;
//		}
//		return true;
//	}

	//验证'确认密码'是否正确
	Boolean isPass2(String pass1, String pass2) {
		if(!pass1.equals(pass2)) {
			label.setText("重输密码错误！");
			label.setForeground(Color.red);
			return false;
		}
		return true;
	}

	//验证 密码 输入是否正确
	public Boolean isPass1(String pass) {
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String password = stu.getStuPass();
			//判断密码正确性，并设置相应的弹窗信息
			if(password.equals(pass)){
				return true;
			}
		}
		return false;
	}
}
