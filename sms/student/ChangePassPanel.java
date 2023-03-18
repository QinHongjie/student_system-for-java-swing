package sms.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sms.utils.BackgroundPanel;

/**
 * ѧ���޸��������
 */
public class ChangePassPanel extends BackgroundPanel{
	
	JLabel lab1 = new JLabel("ԭ����:");
	JLabel lab2 = new JLabel("������:");
	JLabel lab3 = new JLabel("ȷ������:");
	
	JTextField pass = new JTextField();
	JPasswordField pass1 = new JPasswordField();
	JPasswordField pass2 = new JPasswordField();
	
	JButton but1 = new JButton("�޸�");//������ť
	JButton but2 = new JButton("����");
	
	String p, p1, p2;//��������洢�ռ�
	
	String name,password;
	
	//���ø��๹�췽�����ñ���
	ChangePassPanel(String name, String password){
		super("images/stu_xs.jpg");
		super.font = new Font("����", Font.BOLD, 30);
		this.name = name;
		this.password = password;
	}
	
	//��������
	public JPanel panel(JFrame frame) {		
		panel.setLayout(null);	//ȡ��Ĭ�ϲ�����
		
		panel.add(label1());//��ӱ����ǩ���
		panel.add(label2());
		panel.add(label3());
		
		panel.add(pass());//����ı������
		panel.add(pass1());
		panel.add(pass2());
		
		panel.add(But1());//����������Ӱ�ť���
		panel.add(But2());
		
		but1Click(frame);//��Ӱ�ť����¼�
		but2Click(frame);
		
		return panel;
	}
	
	//����'ԭ����'��ǩ���
	private JLabel label1() {
		lab1.setForeground(Color.WHITE);
		lab1.setFont(font);
		lab1.setBounds(40, 70, 150, 30);
		return lab1;
	}
	//����'������'��ǩ���
	private JLabel label2() {
		lab2.setForeground(Color.BLUE);
		lab2.setFont(font);
		lab2.setBounds(40, 170, 150, 30);
		return lab2;
	}
	//����'ȷ������'��ǩ���
	private JLabel label3() {
		lab3.setForeground(Color.BLUE);
		lab3.setFont(font);
		lab3.setBounds(30, 270, 150, 30);
		return lab3;
	}
	
	//����'ԭ����'�ı������
	private JTextField pass() {
		pass.setFont(font);
		pass.setBounds(200, 70, 170, 30);
		return pass;
	}
	//����'������'�ı������
	private JPasswordField pass1() {
		pass1.setFont(font);
		pass1.setBounds(200, 170, 170, 30);
		return pass1;
	}
	//����'ȷ������'�ı������
	private JPasswordField pass2() {
		pass2.setFont(font);
		pass2.setBounds(200, 270, 170, 30);
		return pass2;
	}
	
	//��¼��ť���
	private JButton But1() {
		but1.setBounds(60, 450, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//ע�ᰴť���
	private JButton But2() {
		but2.setBounds(250, 450, 100, 40);
		but2.setFont(font);
		return but2;
	}
	
	//�޸İ�ť-����¼�
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = pass.getText();
				p1 = String.valueOf(pass1.getPassword());
				p2 = String.valueOf(pass2.getPassword());
				new ChangePassCheck(frame, password, p, p1, p2, name);
			}
		});
	}
	//���ð�ť-����¼�
	public void but2Click(JFrame frame) {
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pass.setText("");
				pass1.setText("");
				pass2.setText("");
			}
		});
	}
}
