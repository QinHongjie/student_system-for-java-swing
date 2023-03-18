package sms.root;

import sms.jdbc.JDBC;
import sms.register.RegisterCheckNull;

import javax.swing.*;
import java.awt.*;
/**
 * 学生管理系统-验证添加信息
 */
public class RootCheck extends RegisterCheckNull{

	Boolean flag = false;//用于表示信息是否正确

	//构造注册事件验证
	public RootCheck(JFrame frame, String id, String name,
					 String sex, String age) {
		//调用父类构造方法加载必需方法
		super(frame, id, name, sex, age);
		//验证：
		if(isNull(id, name)) {	//判断id/name是否为空
			dialog.setVisible(true);//显示错误信息弹窗
		}else {
			if(isNull2(sex, age)) {	//判断其他信息是否为空
				dialog.setVisible(true);//显示错误信息弹窗
			}else {
				//判断信息是否正确
				if(!isRightData(id, name, sex, age)) {
					dialog.setVisible(true);//显示错误信息弹窗
				}else {
					flag = true;//信息正确标志
				}
			}
		}
	}

	//验证添加信息是否正确
	public Boolean isRightData(String id, String name, String sex, String age) {
		if (!isNumber(id) || id.length()<0 || id.length()>10 ) {
			label.setText("请正确输入学号！");
			label.setForeground(Color.red);
			return false;
		}else {
			if(isNumber(name)) {
				label.setText("名字不能为数字！");
				label.setForeground(Color.red);
				return false;
			}
			if(name.length()>5) {
				label.setText("——名字过长！-——");
				label.setForeground(Color.red);
				return false;
			}else {
				if(!sex.equals("男") && !sex.equals("女")) {
					label.setText("请输入正确性别！");
					label.setForeground(Color.red);
					return false;
				}else {
					if(!isNumber(age)) {
						label.setText("年龄应为数字！");
						label.setForeground(Color.red);
						return false;
					}else {
						int intage = Integer.parseInt(age);
						if(intage < 6 || intage > 25) {
							label.setText("请输入真实年龄！");
							label.setForeground(Color.red);
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	//判断信息是否为数字
	public Boolean isNumber(String str) {
		boolean b = str.matches("[0-9]+");
		if(b == true) return true;
		return false;
	}
	//判断信息是否重复
	public Boolean isSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(jdbc.ishavaId(id)) {
			label.setText("已有该学号学生信息！");
			label.setForeground(Color.red);
			dialog.setVisible(true);
			flag = false;
			return true;
		}else {
			if(jdbc.ishavaName(name)) {
				label.setText("已有该姓名学生信息！");
				label.setForeground(Color.red);
				dialog.setVisible(true);
				flag = false;
				return true;
			}
		}
		return false;
	}
	//判断信息是否重复
	public Boolean alterIsSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(!jdbc.ishavaId(id)) {
			label.setText("没有该学号，请先添加！");
			label.setForeground(Color.red);
			dialog.setVisible(true);
			flag = false;
			return true;
		}else {
			if(jdbc.alterIshavaName(id, name)) {
				label.setText("已有该姓名学生信息！");
				label.setForeground(Color.red);
				dialog.setVisible(true);
				flag = false;
				return true;
			}
		}
		return false;
	}
	//正确执行提示窗
	public void right(JFrame frame, String say) {
		label.setText(say+"成功，密码为学号！");
		label.setForeground(Color.blue);
		dialog.setVisible(true);//信息正确提示
	}
}

