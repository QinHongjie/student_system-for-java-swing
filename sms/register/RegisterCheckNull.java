package sms.register;

import java.awt.Color;

import javax.swing.JFrame;

import sms.login.LoginCheckNull;
/**
 * 验证注册信息是否为空
 */
public class RegisterCheckNull extends LoginCheckNull{
	
	public RegisterCheckNull(JFrame frame, String id, String name,String sex,String age) {
		super(frame, name, id);
		super.name = "ID";
		super.pass = "姓名";
	}
	//判断 性别/年龄 是否为空
	public Boolean isNull2(String sex, String age) {
		if(sex.length() == 0) {
			label.setText("请选择性别！");
			label.setForeground(Color.red);
			return true;
		}else {
			if(age.length() == 0) {
				label.setText("年龄不能为空！");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
}


