package sms.root;

import java.awt.Color;

import javax.swing.JFrame;

import sms.jdbc.JDBC;
import sms.register.RegisterCheckNull;
/**
 * ѧ������ϵͳ-��֤�����Ϣ
 */
public class RootCheck extends RegisterCheckNull{
	
	Boolean flag = false;//���ڱ�ʾ��Ϣ�Ƿ���ȷ
	
	//����ע���¼���֤
	public RootCheck(JFrame frame, String id, String name, 
			String sex, String age) {
		//���ø��๹�췽�����ر��跽��
		super(frame, id, name, sex, age);
		//��֤��
		if(isNull(id, name)) {	//�ж�id/name�Ƿ�Ϊ��
			dialog.setVisible(true);//��ʾ������Ϣ����
		}else {
			if(isNull2(sex, age)) {	//�ж�������Ϣ�Ƿ�Ϊ��
				dialog.setVisible(true);//��ʾ������Ϣ����
			}else {
				//�ж���Ϣ�Ƿ���ȷ
				if(!isRightData(id, name, sex, age)) {
					dialog.setVisible(true);//��ʾ������Ϣ����
				}else {
					flag = true;//��Ϣ��ȷ��־
				}
			}
		}
	}
	
	//��֤�����Ϣ�Ƿ���ȷ
	public Boolean isRightData(String id, String name, String sex, String age) {
		if (!isNumber(id) || id.length()<0 || id.length()>10 ) {
			label.setText("����ȷ����ѧ�ţ�");
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
				if(!sex.equals("��") && !sex.equals("Ů")) {
					label.setText("��������ȷ�Ա�");
					label.setForeground(Color.red);
					return false;
				}else {
					if(!isNumber(age)) {
						label.setText("����ӦΪ���֣�");
						label.setForeground(Color.red);
						return false;
					}else {
						int intage = Integer.parseInt(age);
						if(intage < 6 || intage > 25) {
							label.setText("��������ʵ���䣡");
							label.setForeground(Color.red);
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	//�ж���Ϣ�Ƿ�Ϊ����
	public Boolean isNumber(String str) {
		boolean b = str.matches("[0-9]+");
		if(b == true) return true;
		return false;
	}
	//�ж���Ϣ�Ƿ��ظ�
	public Boolean isSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(jdbc.ishavaId(id)) {
			label.setText("���и�ѧ��ѧ����Ϣ��");
			label.setForeground(Color.red);
			dialog.setVisible(true);
			flag = false;
			return true;
		}else {
			if(jdbc.ishavaName(name)) {
				label.setText("���и�����ѧ����Ϣ��");
				label.setForeground(Color.red);
				dialog.setVisible(true);
				flag = false;
				return true;
			}
		}
		return false;
	}
	//�ж���Ϣ�Ƿ��ظ�
	public Boolean alterIsSome(String id, String name) {
		JDBC jdbc = new JDBC();
		if(!jdbc.ishavaId(id)) {
			label.setText("û�и�ѧ�ţ�������ӣ�");
				label.setForeground(Color.red);
				dialog.setVisible(true);
				flag = false;
				return true;
		}else {
			if(jdbc.alterIshavaName(id, name)) {
				label.setText("���и�����ѧ����Ϣ��");
				label.setForeground(Color.red);
				dialog.setVisible(true);
				flag = false;
				return true;
			}
		}
		return false;
	}
	//��ȷִ����ʾ��
	public void right(JFrame frame, String say) {
		label.setText(say+"�ɹ�������Ϊѧ�ţ�");
		label.setForeground(Color.blue);
		dialog.setVisible(true);//��Ϣ��ȷ��ʾ
	}
}

