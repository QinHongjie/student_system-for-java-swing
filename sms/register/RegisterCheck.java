package sms.register;

import java.awt.Color;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.utils.FileUtil;
import sms.utils.Student;
/**
 * ѧ������ϵͳ-��֤ע����Ϣ
 */
public class RegisterCheck extends RegisterCheckNull{

	static int intage = 0;//�����洢��������Ŀռ�
	
	//����ע���¼���֤
	public RegisterCheck(JFrame frame, String id, String name, 
			String sex, String age, String pass1, String pass2) {
		//���ø��๹�췽�����ر��跽��
		super(frame, id, name, sex, age);
		//��֤��
		if(isNull(id, name)) {	//�жϻ�����Ϣ�Ƿ�Ϊ��
			dialog.setVisible(true);//��ʾ������Ϣ����
		}else {
			if(isNull2(sex, age)) {	//�ж������Ƿ�Ϊ��
				dialog.setVisible(true);//��ʾ������Ϣ����
			}else {
				//�ж���Ϣ�Ƿ���ȷ
				if(isRightData(id, name, sex, age, pass1, pass2)) {
					//����ȷ��Ϣ�������ݿ�
					if(isSome(id, name)) {
						dialog.setVisible(true);//��ʾ������Ϣ����
					}else {
						//����ȷ��Ϣ��ӽ����ݿ�
						new JDBC().add(id, name, sex, intage, pass1);
						//��¼������Ϣ
						Student stu = new Student();
						stu.setStuId(id);
						stu.setStuName(name);
						stu.setStuSex(sex);
						stu.setStuAge(intage);
						FileUtil.saveStudent(stu);
						right(frame);//��Ϣ��ȷ��ʾ����
					}
				}else {
					dialog.setVisible(true);//��ʾ������Ϣ����
				}
			}
		}
	}
	
	//��֤ע����Ϣ�Ƿ���ȷ
	public Boolean isRightData(String id, String name, String sex, 
			String age, String pass1, String pass2) {
		intage = toInt(age);
		if (!isNumber(id) || id.length()<0 || id.length()>10 ) {
			label.setText("����ȷ����ID��");
			label.setForeground(Color.red);
			return false;
		}else {
			if(isNumber(name)) {
				label.setText("���ֲ���Ϊ���֣�");
				label.setForeground(Color.red);
				return false;
			}
			if(name.length()>5) {
				label.setText("�������ֹ�����-����");
				label.setForeground(Color.red);
				return false;
			}else {
				if(!isNumber(age) || intage<6 || intage>25) {
					label.setText("��������ʵ���䣡");
					label.setForeground(Color.red);
					return false;
				}else {
					if(pass1.length() == 0) {
						label.setText("���������룡");
						label.setForeground(Color.red);
						return false;
					}else {
						if(pass2.length() == 0) {
							label.setText("��ȷ�����룡");
							label.setForeground(Color.red);
							return false;
						}else {
							if(!pass1.equals(pass2)) {
								label.setText("�����������");
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
	
	//�ж���Ϣ�Ƿ�Ϊ����
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
	//���ַ���תΪ��������
	public int toInt(String str) {
		int i = 0;
		if(isNumber(str)) {
			i = Integer.parseInt(str);
			return i;
		}
		return i;
	}
	//�ж���Ϣ�Ƿ��ظ�
	public Boolean isSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(jdbc.ishavaId(id) || jdbc.ishavaName(name)) {
			label.setText("���и�ѧ����Ϣ��");
			label.setForeground(Color.blue);
			return true;
		}
		return false;
	}
	//��Ϣ��ȷִ��
	private void right(JFrame frame) {
		label.setText("ע��ɹ������μ����룡");
		label.setForeground(Color.blue);
		frame.dispose();//�ر�ע�ᴰ��
		dialog.setVisible(true);//��Ϣ��ȷ��ʾ
	}
}
