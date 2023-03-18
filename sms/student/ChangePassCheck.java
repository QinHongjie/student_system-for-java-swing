package sms.student;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.login.LoginCheckNull;
import sms.utils.Student;
/**
 * �޸�ѧ����¼������֤
 */
public class ChangePassCheck extends LoginCheckNull{

	public ChangePassCheck(JFrame frame,String password, String pass, 
			String pass1, String pass2, String name) {
		super(frame, pass, pass1);
		super.name = "ԭ����";
		super.pass = "������";
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
						label.setText("�����޸ĳɹ���");
						label.setForeground(Color.blue);
						dialog.setVisible(true);
					}
				}
			}
		}
	}

	//��֤'ȷ������'�ı����Ƿ�Ϊ��
	Boolean isPassNull(String pass) {
		if(pass.length() == 0) {
			label.setText("��ȷ�����룡");
			label.setForeground(Color.red);
			return true;
		}
		return false;
	}
	
	//��֤ԭ������ȷ��
//	Boolean isPass1(String password,String pass) {
//		if(!password.equals(pass)) {
//			label.setText("ԭ�������");
//			label.setForeground(Color.red);
//			return false;
//		}
//		return true;
//	}
	
	//��֤'ȷ������'�Ƿ���ȷ
	Boolean isPass2(String pass1, String pass2) {
		if(!pass1.equals(pass2)) {
			label.setText("�����������");
			label.setForeground(Color.red);
			return false;
		}
		return true;
	}
	
	//��֤ ���� �����Ƿ���ȷ
	public Boolean isPass1(String pass) {
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String password = stu.getStuPass();
			//�ж�������ȷ�ԣ���������Ӧ�ĵ�����Ϣ
			if(password.equals(pass)){
				return true;
			}
		}
		return false;
	}
}
