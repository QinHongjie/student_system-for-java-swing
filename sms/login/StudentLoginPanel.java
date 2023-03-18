package sms.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sms.register.RegisterGUI;
import sms.utils.BackgroundPanel;
import sms.utils.MyFocusListener;
import sms.utils.Student;
/**
 * ѧ����¼������
 */
public class StudentLoginPanel extends BackgroundPanel{
	
	private JLabel lab1 = new JLabel("�� ����");	//������ǩ
	private JLabel lab2 = new JLabel("�� �룺");
	
	private JTextField text1 = new JTextField();//�����ı���
	private JPasswordField text2 = new JPasswordField();
	
	private JButton but1 = new JButton("��¼");//������ť
	private JButton but2 = new JButton("ע��");

	static String name,pass;//�������ڴ洢�û���������Ŀռ�

	//���ø��๹�췽��Ϊ�������ñ���
	protected StudentLoginPanel() {
		super("images/stu_login.png");
	}
	
	//��������
	public JPanel panel(JFrame frame) {
		panel.setLayout(null);	//ȡ��Ĭ�ϲ�����
		
		panel.add(userLabel());	//����������ӱ�ǩ���
		panel.add(passLabel());
		
		panel.add(userText());//������������ı������
		panel.add(passText());
		
		panel.add(userButton());//����������Ӱ�ť���
		panel.add(passButton());
		
		but1Click(frame);//��ӵ�¼����¼�
		but2Click(frame);
		
		text1.addFocusListener(new MyFocusListener("����������", text1));
		
		return panel;
	}
	
	//�û�����ǩ���
	private JLabel userLabel() {
		lab1.setForeground(Color.WHITE);
		lab1.setFont(font);
		lab1.setBounds(105, 125, 120, 30);
		return lab1;
	}
	//�����ǩ���
	private JLabel passLabel() {
		lab2.setForeground(Color.WHITE);
		lab2.setFont(font);
		lab2.setBounds(105, 175, 120, 30);
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
	private JButton userButton() {
		but1.setBounds(130, 300, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//ע�ᰴť���
	private JButton passButton() {
		but2.setBounds(280, 300, 100, 40);
		but2.setFont(font);
		return but2;
	}
	//��¼��ť-����¼�
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student stu = new Student();
				stu.setStuName(text1.getText());
				stu.setStuPass(String.valueOf(text2.getPassword()));
				new StuLoginCheck(frame, stu);//������֤����֤��Ϣ
				//����û�/�����Ϊ�գ���ȫ�ÿ�
				if(stu.getStuName().length()!=0 && stu.getStuPass().length()!=0) {
					text1.setText("");
					text2.setText("");
				}else {
					if(stu.getStuName().length() == 0) {
						text2.setText("");
					}
				}
			}
		});
	}
	//ע�ᰴť-����¼�
	public void but2Click(JFrame frame) {
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterGUI().run();//����ע�����
			}
		});
	}
}
