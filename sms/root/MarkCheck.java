package sms.root;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.login.LoginCheckNull;
import sms.utils.Student;
/**
 * ����Ա����ѧ��������֤��
 */
public class MarkCheck extends LoginCheckNull{

	Boolean flag = false;
	
	public MarkCheck(JFrame frame, String id, String mark) {
		super(frame, id, mark);
		super.name = "ѧ��";
		super.pass = "����";
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
	
	//��д���෽�����ж� id/���� �Ƿ�Ϊ��
	public Boolean isNull(String id, String mark) {
		if(id.equals("(����ѧ��)")) {
			label.setText(name+"����Ϊ�գ�");
			label.setForeground(Color.red);
			return true;
		}else {
			if(mark.equals("Max's 100")||mark.length()==0) {
				label.setText(pass+"����Ϊ�գ�");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
	
	//�ж���Ϣ��ȷ��
	public Boolean isRightData(String id, String mark) {
		if(!isNumber(id)) {
			label.setText("����ȷ����ѧ�ţ�");
			label.setForeground(Color.red);
			return false;
		}
		ArrayList<Student> stuList = new JDBC().select();
		for(Student stu : stuList) {
			String oid = stu.getStuId();
			//�ж�����/������ȷ�ԣ���������Ӧ�ĵ�����Ϣ
			if(oid.equals(id)) {
				if(isNumber(mark)) {
					int m = Integer.parseInt(mark);
					if(m >= 0 && m <= 100){
						return true;
					}else {
						label.setText("������Χ0~100��");
						label.setForeground(Color.red);
						return false;
					}
				}else {
					label.setText("����Ϊ0~100�����֣�");
					label.setForeground(Color.red);
					return false;
				}
			}else {
				label.setText("û�д�ѧ����������ӣ�");
				label.setForeground(Color.blue);
			}
		}
		return false;
	}
	
	//�ж���Ϣ�Ƿ�Ϊ����
	public Boolean isNumber(String str) {
		boolean b = str.matches("[0-9]+");
		if(b == true) return true;
		return false;
	}
}
