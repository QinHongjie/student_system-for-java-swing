package sms.register;

import java.awt.Color;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.utils.FileUtil;
import sms.utils.Student;
/**
 * 学生管理系统-验证注册信息
 */
public class RegisterCheck extends RegisterCheckNull{

	static int intage = 0;//创建存储整型年龄的空间
	
	//构造注册事件验证
	public RegisterCheck(JFrame frame, String id, String name, 
			String sex, String age, String pass1, String pass2) {
		//调用父类构造方法加载必需方法
		super(frame, id, name, sex, age);
		//验证：
		if(isNull(id, name)) {	//判断基本信息是否为空
			dialog.setVisible(true);//显示错误信息弹窗
		}else {
			if(isNull2(sex, age)) {	//判断密码是否为空
				dialog.setVisible(true);//显示错误信息弹窗
			}else {
				//判断信息是否正确
				if(isRightData(id, name, sex, age, pass1, pass2)) {
					//将正确信息存入数据库
					if(isSome(id, name)) {
						dialog.setVisible(true);//显示错误信息弹窗
					}else {
						//将正确信息添加进数据库
						new JDBC().add(id, name, sex, intage, pass1);
						//记录增添信息
						Student stu = new Student();
						stu.setStuId(id);
						stu.setStuName(name);
						stu.setStuSex(sex);
						stu.setStuAge(intage);
						FileUtil.saveStudent(stu);
						right(frame);//信息正确提示弹窗
					}
				}else {
					dialog.setVisible(true);//显示错误信息弹窗
				}
			}
		}
	}
	
	//验证注册信息是否正确
	public Boolean isRightData(String id, String name, String sex, 
			String age, String pass1, String pass2) {
		intage = toInt(age);
		if (!isNumber(id) || id.length()<0 || id.length()>10 ) {
			label.setText("请正确输入ID！");
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
				if(!isNumber(age) || intage<6 || intage>25) {
					label.setText("请输入真实年龄！");
					label.setForeground(Color.red);
					return false;
				}else {
					if(pass1.length() == 0) {
						label.setText("请设置密码！");
						label.setForeground(Color.red);
						return false;
					}else {
						if(pass2.length() == 0) {
							label.setText("请确认密码！");
							label.setForeground(Color.red);
							return false;
						}else {
							if(!pass1.equals(pass2)) {
								label.setText("重输密码错误！");
								label.setForeground(Color.red);
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	//判断信息是否为数字
	public Boolean isNumber(String str) {
//		for(int i = str.length(); --i >= 0;) {
//			int chr = str.charAt(i);
//			if(chr < 48 || chr > 57)
//				return false;
//		}
		boolean b = str.matches("[0-9]+");
		if(b == true) return true;
		return false;
	}
	//将字符串转为整型数据
	public int toInt(String str) {
		int i = 0;
		if(isNumber(str)) {
			i = Integer.parseInt(str);
			return i;
		}
		return i;
	}
	//判断信息是否重复
	public Boolean isSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(jdbc.ishavaId(id) || jdbc.ishavaName(name)) {
			label.setText("已有该学生信息！");
			label.setForeground(Color.blue);
			return true;
		}
		return false;
	}
	//信息正确执行
	private void right(JFrame frame) {
		label.setText("注册成功，请牢记密码！");
		label.setForeground(Color.blue);
		frame.dispose();//关闭注册窗口
		dialog.setVisible(true);//信息正确提示
	}
}
