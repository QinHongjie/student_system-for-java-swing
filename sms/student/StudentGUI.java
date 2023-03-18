package sms.student;

import java.awt.event.*;
import javax.swing.*;
import sms.utils.*;
/**
 * ѧ��������Ϣ����
 */
public class StudentGUI{
	
	JFrame frame = new JFrame();
	JPanel panel;
	
	JMenuBar menuBar = new JMenuBar();//�����˵���
	JMenu menu = new JMenu("ѡ�����");//�����˵�
	
	JMenuItem item1 = new JMenuItem("������Ϣ"),
			  item2 = new JMenuItem("�޸�����");//����һ���˵���
	
	Student stu;
	String name = "", password;
	
	//���췽�����ô������
	public StudentGUI(Student stu) {
		this.stu = stu;
		this.name = stu.getStuName();
		this.password = stu.getStuPass();
	}
	//�򿪴˴��ڷ���
	public void run() {
		frame.setTitle(stu.getStuName()+"ѧ��������Ϣ");
		frame.setSize(425, 665);
		frame.setResizable(false);//���ô���ߴ粻�ɸı�
		
		frame.setJMenuBar(menuBar());	//���˵�����ӵ�����
		i1Click();	//Ϊ�����ص�¼���˵�����ӵ���¼�
		i2Click();
		
		panel = new StudentPanel().panel(frame, stu);
		frame.add(panel);	//�������
		GUITool.center(frame);//������ʾ
		frame.setVisible(true);
	}
	
	//���ò˵���
	protected JMenuBar menuBar() {
		menuBar.add(menu);	//���˵���ӵ��˵���
		
		menu.add(item1);	//���'�޸�����'�˵���
		menu.addSeparator();//���һ���ָ���
		menu.add(item2);	//���'ѧ��'�˵���
		
		return menuBar;
	}
	//Ϊ'������Ϣ'-�˵�������¼�������
	private void i1Click() {
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				panel = new StudentPanel().panel(frame, stu);
				frame.add(panel);
				panel.updateUI();
			}
		});
	}
	//Ϊ'�޸�����'-�˵�������¼�������
	private void i2Click() {
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);
				panel = new ChangePassPanel(name, password).panel(frame);
				frame.add(panel);
				panel.updateUI();
			}
		});
	}
	
//	public static void main(String[] args) {
//		Student stu = new Student();
//		stu.setStuId("1001");
//		stu.setStuName("�غ��");
//		stu.setStuSex("��");
//		stu.setStuAge(19);
//		stu.setStuMark(100);
//		stu.setStuPass("123");
//		new StudentGUI(stu).run();
//	}

}
