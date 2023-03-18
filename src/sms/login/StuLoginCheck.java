package sms.login;

import sms.jdbc.JDBC;
import sms.student.StudentGUI;
import sms.utils.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * 学生登录信息验证
 */
public class StuLoginCheck extends LoginCheckNull{
	
	Student student;
	
	public StuLoginCheck(JFrame frame, Student stu) {
		super(frame, stu.getStuName(), stu.getStuId());
		//验证：根据情况显示弹窗；或打开新窗口
		if(isNull(stu.getStuName(),stu.getStuPass())) {
			dialog.setVisible(true);
		}else {
			//若姓名/ID确认无误
			if(isRightData(stu.getStuName(), stu.getStuPass())) {
				new StudentGUI(student).run();//打开学生个人信息窗口
			}else {
				dialog.setVisible(true);
			}
		}
	}
	//验证 用户名/密码 输入是否正确
	public Boolean isRightData(String user, String password) {
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String name = stu.getStuName();
			String pass = stu.getStuPass();
			//判断姓名/密码正确性，并设置相应的弹窗信息
			if(user.equals(name)) {
				if(password.equals(pass)){
					student = stu;
					return true;
				}else {
					label.setText("密码输入错误！");
					label.setForeground(Color.red);
					return false;
				}
			}else {
				label.setText("没有此学生，请先注册！");
				label.setForeground(Color.blue);
			}
		}
		return false;
	}
}
