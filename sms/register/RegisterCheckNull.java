package sms.register;

import java.awt.Color;

import javax.swing.JFrame;

import sms.login.LoginCheckNull;
/**
 * ��֤ע����Ϣ�Ƿ�Ϊ��
 */
public class RegisterCheckNull extends LoginCheckNull{
	
	public RegisterCheckNull(JFrame frame, String id, String name,String sex,String age) {
		super(frame, name, id);
		super.name = "ID";
		super.pass = "����";
	}
	//�ж� �Ա�/���� �Ƿ�Ϊ��
	public Boolean isNull2(String sex, String age) {
		if(sex.length() == 0) {
			label.setText("��ѡ���Ա�");
			label.setForeground(Color.red);
			return true;
		}else {
			if(age.length() == 0) {
				label.setText("���䲻��Ϊ�գ�");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
}


