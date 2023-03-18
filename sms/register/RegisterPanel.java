package sms.register;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import sms.utils.BackgroundPanel;

/**
 * ע���������
 */
public class RegisterPanel extends BackgroundPanel{
	
	JLabel lab1 = new JLabel("ѧ ��:");	//������ǩ
	JLabel lab2 = new JLabel("�� ��:");
	JLabel lab3 = new JLabel("�� ��:");
	JLabel lab4 = new JLabel("�� ��:");
	JLabel lab5 = new JLabel("��������:");
	JLabel lab6 = new JLabel("ȷ������:");
	
	JTextField text1 = new JTextField();//�����ı���
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JPasswordField text4 = new JPasswordField();
	JPasswordField text5 = new JPasswordField();
	
	ButtonGroup group = new ButtonGroup();//������ѡ��������
	JRadioButton rb1 = new JRadioButton("��");//������ѡ��
	JRadioButton rb2 = new JRadioButton("Ů");
	
	JButton but1 = new JButton("ע��");//������ť
	JButton but2 = new JButton("����");
	
	String id,name,sex = "", age, pass1, pass2;//������Ϣ�洢�ռ�

	public RegisterPanel() {
		super("images/stu_register.jpg");
	}
	//��������
	public JPanel panel(JFrame frame) {		
		panel.add(idLabel());//����������ӱ�ǩ���
		panel.add(nameLabel());
		panel.add(sexLabel());
		panel.add(ageLabel());
		panel.add(pass1Label());
		panel.add(pass2Label());
		
		panel.add(idText());//������������ı������
		panel.add(nameText());
		panel.add(ageText());
		panel.add(pass1Text());
		panel.add(pass2Text());
		
		group.add(rb1);//�󶨵�ѡ��
		group.add(rb2);
		panel.add(boyRB());//����������ӵ�ѡ�����
		panel.add(girlRB());
		addJRadioButton();
		
		panel.add(userButton());//����������Ӱ�ť���
		panel.add(passButton());
		
		but1Click(frame);//��ӵ�¼����¼�
		but2Click(frame);
		
		return panel;
	}
	
	//ID��ǩ���
	private JLabel idLabel() {
		lab1.setFont(font);
		lab1.setBounds(50, 40, 120, 30);
		return lab1;
	}
	//������ǩ���
	private JLabel nameLabel() {
		lab2.setFont(font);
		lab2.setBounds(50, 100, 120, 30);
		return lab2;
	}
	//�Ա��ǩ���
	private JLabel sexLabel() {
		lab3.setFont(font);
		lab3.setBounds(50, 160, 120, 30);
		return lab3;
	}
	//�����ǩ���
	private JLabel ageLabel() {
		lab4.setFont(font);
		lab4.setBounds(50, 220, 120, 30);
		return lab4;
	}
	//���������ǩ���
	private JLabel pass1Label() {
		lab5.setFont(font);
		lab5.setBounds(50, 300, 120, 30);
		return lab5;
	}
	//ȷ�������ǩ���
	private JLabel pass2Label() {
		lab6.setFont(font);
		lab6.setBounds(50, 360, 120, 30);
		return lab6;
	}
	
	//ID�ı������
	private JTextField idText() {
		text1.setBounds(190, 37, 180, 35);
		text1.setFont(font);
		return text1;
	}
	//�����ı������
	private JTextField nameText() {
		text2.setBounds(190, 97, 180, 35);
		text2.setFont(font);
		return text2;
	}

	//�Ա�'��'��ѡ�����
	private JRadioButton boyRB() {
		rb1.setForeground(Color.blue);//��������Ϊ��ɫ
		rb1.setOpaque(false);//���ñ���͸��
		rb1.setBounds(190, 157, 90, 35);
		rb1.setFont(font);
		return rb1;
	}
	//�Ա�'Ů'��ѡ�����
	private JRadioButton girlRB() {
		rb2.setForeground(Color.blue);//��������Ϊ��ɫ
		rb2.setOpaque(false);//���ñ���͸��
		rb2.setBounds(280, 157, 90, 35);
		rb2.setFont(font);
		return rb2;
	}
	
	//�����ı������
	private JTextField ageText() {
		text3.setBounds(190, 217, 90, 35);
		text3.setFont(font);
		return text3;
	}
	
	//���������ı������
	private JTextField pass1Text() {
		text4.setBounds(190, 297, 180, 35);
		text4.setFont(font);
		return text4;
	}
	//ȷ�������ı������
	private JTextField pass2Text() {
		text5.setBounds(190, 347, 180, 35);
		text5.setFont(font);
		return text5;
	}
	
	//��¼��ť���
	private JButton userButton() {
		but1.setBounds(60, 450, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//ע�ᰴť���
	private JButton passButton() {
		but2.setBounds(250, 450, 100, 40);
		but2.setFont(font);
		return but2;
	}
	
	//��ȡ��ѡ����Ϣ
	private void addJRadioButton() {
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "��";
			}
		});
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "Ů";
			}
		});
	}
	
	//ע�ᰴť-����¼�
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = idText().getText();
				name = nameText().getText();
				age = ageText().getText();
				pass1 = String.valueOf(text4.getPassword());
				pass2 = String.valueOf(text5.getPassword());
				//����Ϣ����ע����Ϣ��֤����֤
				new RegisterCheck(frame, id, name, sex, age, pass1, pass2);
			}
		});
	}
	//���ð�ť-����¼�
	public void but2Click(JFrame frame) {
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				panel =new RegisterPanel().panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		});
	}
}
