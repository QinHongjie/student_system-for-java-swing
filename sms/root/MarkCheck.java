package sms.root;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.login.LoginCheckNull;
import sms.utils.Student;
/**
 * 管理员设置学生分数验证类
 */
public class MarkCheck extends LoginCheckNull{

	Boolean flag = false;
	
	public MarkCheck(JFrame frame, String id, String mark) {
		super(frame, id, mark);
		super.name = "学号";
		super.pass = "分数";
		if(isNull(id, mark)) {
			dialog.setVisible(true);
		}else {
			if(isRightData(id, mark)) {
				new JDBC().setMark(id, Integer.parseInt(mark));
				flag = true;
			}else {
				dialog.setVisible(true);
			}
		}
	}
	
	//重写父类方法，判断 id/分数 是否为空
	public Boolean isNull(String id, String mark) {
		if(id.equals("(输入学号)")) {
			label.setText(name+"不能为空！");
			label.setForeground(Color.red);
			return true;
		}else {
			if(mark.equals("Max's 100")||mark.length()==0) {
				label.setText(pass+"不能为空！");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
	
	//判断信息正确性
	public Boolean isRightData(String id, String mark) {
		if(!isNumber(id)) {
			label.setText("请正确输入学号！");
			label.setForeground(Color.red);
			return false;
		}
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String oid = stu.getStuId();
			//判断姓名/密码正确性，并设置相应的弹窗信息
			if(oid.equals(id)) {
				if(isNumber(mark)) {
					int m = Integer.parseInt(mark);
					if(m >= 0 && m <= 100){
						return true;
					}else {
						label.setText("分数范围0~100！");
						label.setForeground(Color.red);
						return false;
					}
				}else {
					label.setText("分数为0~100的数字！");
					label.setForeground(Color.red);
					return false;
				}
			}else {
				label.setText("没有此学生，请先添加！");
				label.setForeground(Color.blue);
			}
		}
		return false;
	}
	
	//判断信息是否为数字
	public Boolean isNumber(String str) {
		boolean b = str.matches("[0-9]+");
		if(b == true) return true;
		return false;
	}
}
