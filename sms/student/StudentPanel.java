package sms.student;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sms.utils.BackgroundPanel;
import sms.utils.Student;

public class StudentPanel extends BackgroundPanel{

	JLabel label1 = new JLabel("ѧ����Ϣ:");//'������Ϣ'��ǩ
	JLabel label2 = new JLabel("�ɼ���:");//'�ɼ���Ϣ��ǩ'
	
	JLabel lab1 = new JLabel();//����ѧ����Ϣ����
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	
	//���ø��๹�췽�����ñ���
	protected StudentPanel() {
		super("images/stu_xs.jpg");
		super.font = new Font("����", Font.BOLD, 30);
	}
	
	//��������
	public JPanel panel(JFrame frame, Student stu) {		
		panel.setLayout(null);	//ȡ��Ĭ�ϲ�����
		
		panel.add(label1());//��ӱ����ǩ���
		panel.add(label2());
		
		panel.add(idLabel(stu.getStuId()));//��������ӱ�ǩ���
		panel.add(nameLabel(stu.getStuName()));
		panel.add(sexLabel(stu.getStuSex()));
		panel.add(ageLabel(stu.getStuAge()));
		panel.add(markLabel(stu.getStuMark()));
		
		return panel;
	}
	
	//'ѧ����Ϣ'��ǩ���
	private JLabel label1() {
		label1.setForeground(Color.blue);
		label1.setFont(font);
		label1.setBounds(50, 40, 220, 30);
		return label1;
	}
	//ID��ǩ���
	private JLabel idLabel(String id) {
		lab1.setForeground(Color.white);
		lab1.setText("ѧ ��: "+id);
		lab1.setFont(font);
		lab1.setBounds(100, 100, 220, 30);
		return lab1;
	}
	//������ǩ���
	private JLabel nameLabel(String name) {
		lab2.setForeground(Color.white);
		lab2.setText("����: "+name);
		lab2.setFont(font);
		lab2.setBounds(100, 160, 220, 30);
		return lab2;
	}
	//�Ա��ǩ���
	private JLabel sexLabel(String sex) {
		lab3.setForeground(Color.white);
		lab3.setText("�Ա�: "+sex);
		lab3.setFont(font);
		lab3.setBounds(100, 220, 220, 30);
		return lab3;
	}
	//�����ǩ���
	private JLabel ageLabel(int age) {
		lab4.setForeground(Color.white);
		lab4.setText("����: "+age);
		lab4.setFont(font);
		lab4.setBounds(100, 280, 220, 30);
		return lab4;
	}
	
	//'�ɼ���'��ǩ���
	private JLabel label2() {
		label2.setForeground(Color.blue);
		label2.setFont(font);
		label2.setBounds(50, 360, 220, 30);
		return label2;
	}
	//�ɼ���ǩ���
	private JLabel markLabel(int mark) {
		if(mark == -1) {
			lab5.setText("��δ�гɼ���");
		}else {
			lab5.setText("�ɼ�: "+mark);
		}
		lab5.setForeground(Color.white);
		lab5.setFont(font);
		lab5.setBounds(100, 420, 220, 30);
		return lab5;
	}
}
