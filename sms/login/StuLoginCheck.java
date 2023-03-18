package sms.login;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.student.StudentGUI;
/**
 * ѧ����¼��Ϣ��֤
 */
import sms.utils.Student;
public class StuLoginCheck extends LoginCheckNull{
	
	Student student;
	
	public StuLoginCheck(JFrame frame, Student stu) {
		super(frame, stu.getStuName(), stu.getStuId());
		//��֤�����������ʾ����������´���
		if(isNull(stu.getStuName(),stu.getStuPass())) {
			dialog.setVisible(true);
		}else {
			//������/IDȷ������
			if(isRightData(stu.getStuName(), stu.getStuPass())) {
				new StudentGUI(student).run();//��ѧ��������Ϣ����
			}else {
				dialog.setVisible(true);
			}
		}
	}
	//��֤ �û���/���� �����Ƿ���ȷ
	public Boolean isRightData(String user, String password) {
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String name = stu.getStuName();
			String pass = stu.getStuPass();
			//�ж�����/������ȷ�ԣ���������Ӧ�ĵ�����Ϣ
			if(user.equals(name)) {
				if(password.equals(pass)){
					student = stu;
					return true;
				}else {
					label.setText("�����������");
					label.setForeground(Color.red);
					return false;
				}
			}else {
				label.setText("û�д�ѧ��������ע�ᣡ");
				label.setForeground(Color.blue);
			}
		}
		return false;
	}
}
