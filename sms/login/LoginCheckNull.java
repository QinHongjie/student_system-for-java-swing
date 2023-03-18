package sms.login;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import sms.utils.GUITool;
/**
 * ��֤��¼��Ϣ�Ƿ�Ϊ��
 */
public abstract class LoginCheckNull {
	
	protected Font font = new Font("����", Font.BOLD, 25);//��������
	protected static JDialog dialog;//����������ʾ������
	protected JLabel label = new JLabel();//������ǩ
	protected JButton button = new JButton("ȷ��");//������ť
	
	static Connection conn = null;	//����mysql���Ӷ���
	static Statement stmt = null;	//����ִ��mysql�������
	static ResultSet rs = null;	//����mysql���ؽ��������
	
	protected String name = "����",pass = "����";
	
	//����ע���¼���֤
	public LoginCheckNull(JFrame frame, String user, String password) {
		dialog = new JDialog(frame,"��ʾ",true);//����������ӵ���
		dialog().add(label());	//�򵯴������ʾ��ǩ
		dialog().add(button());	//�򵯴����ȷ�ϰ�ť
		buttonClick();//��Ӱ�ť����¼�
	}
	//�ж� �û���/���� �Ƿ�Ϊ��
	public Boolean isNull(String user, String password) {
		if(user.length() == 0 || user.startsWith("������")) {
			label.setText(name+"����Ϊ�գ�");
			label.setForeground(Color.red);
			return true;
		}else {
			if(password.length() == 0) {
				label.setText(pass+"����Ϊ�գ�");
				label.setForeground(Color.red);
				return true;
			}
		}
		return false;
	}
	//�������������
	private JDialog dialog() {
		dialog.setLayout(new FlowLayout(FlowLayout.CENTER,30,40));
		dialog.setResizable(false);//���ô���ߴ粻�ɸı�
		dialog.setSize(300, 250);
		GUITool.center(dialog);	//���õ�������Ļ�о�����ʾ
		return dialog;
	}
	//��ǩ��ʾ��Ϣ���
	private JLabel label() {
		label.setSize(180, 35);		//���ñ�ǩ��Ϣ��С
		label.setFont(font);		//�������
		return label;
	}
	//'ȷ��'��ť���
	private JButton button() {	
		button.setSize(180, 50);	//��ť��С
		button.setFont(font);		//���������ʽ
		return button;
	}
	//ȷ�ϰ�ť-����¼�
	private void buttonClick() {
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();//�رյ�ǰ����
			}
		});
	}
}
