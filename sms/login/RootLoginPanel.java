package sms.login;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import sms.utils.BackgroundPanel;
import sms.utils.MyFocusListener;
/**
 * ����Ա��¼������
 */
public class RootLoginPanel extends BackgroundPanel{
	
	private JLabel lab1 = new JLabel("user��");	//������ǩ
	private JLabel lab2 = new JLabel("pass��");
	
	private JTextField text1 = new JTextField();//�����ı���
	private JPasswordField text2 = new JPasswordField();
	
	private JButton but1 = new JButton("��¼");//������ť
	private JButton but2 = new JButton("����");

	static String user,password;//�������ڴ洢�û���������Ŀռ�

	//���ø��๹�췽�����ñ���
	protected RootLoginPanel() {
		super("images/stu_login.png");
	}
	
	//��������
	public JPanel panel(JFrame frame) {
		panel.setLayout(null);	//ȡ��Ĭ�ϲ�����
		
		panel.add(userLabel());	//����������ӱ�ǩ���
		panel.add(passLabel());
		
		panel.add(userText());//������������ı������
		panel.add(passText());
		
		panel.add(button1());//����������Ӱ�ť���
		panel.add(button2());
		
		but1Click(frame);//��ӵ�¼����¼�
		but2Click(frame);
		
		text1.addFocusListener(new MyFocusListener("�������û���",text1));
		
		return panel;
	}
	
	//�û�����ǩ���
	private JLabel userLabel() {
		lab1.setForeground(Color.WHITE);
		lab1.setFont(font);
		lab1.setBounds(120, 125, 150, 30);
		return lab1;
	}
	//�����ǩ���
	private JLabel passLabel() {
		lab2.setForeground(Color.WHITE);
		lab2.setFont(font);
		lab2.setBounds(120, 175, 150, 30);
		return lab2;
	}
	//�û����ı������
	private JTextField userText() {
		text1.setBounds(210, 120, 190, 35);
		text1.setFont(font);
		return text1;
	}
	//�����ı������
	private JPasswordField passText() {
		text2.setBounds(210, 170, 190, 35);
		text2.setFont(font);
		return text2;
	}
	//��¼��ť���
	private JButton button1() {
		but1.setBounds(130, 300, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//���ð�ť���
	private JButton button2() {
		but2.setBounds(280, 300, 100, 40);
		but2.setFont(font);
		return but2;
	}
	//��¼��ť-����¼�
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = text1.getText();
				password = String.valueOf(text2.getPassword());
				new RootLoginCheck(frame, user, password);//������֤����֤��Ϣ
				//����û�/�����Ϊ�գ���ȫ�ÿ�
				if(user.length()!=0 && password.length()!=0) {
					text1.setText("");
					text2.setText("");
				}else {
					if(user.length() == 0) {
						text2.setText("");
					}
				}
			}
		});
	}
	//���ð�ť-����¼�
	public void but2Click(JFrame frame) {
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText("");
				text2.setText("");
			}
		});
	}
}
