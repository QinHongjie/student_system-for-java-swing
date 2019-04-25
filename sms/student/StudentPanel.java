package sms.student;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sms.utils.BackgroundPanel;
import sms.utils.Student;

public class StudentPanel extends BackgroundPanel{

	JLabel label1 = new JLabel("学生信息:");//'基本信息'标签
	JLabel label2 = new JLabel("成绩单:");//'成绩信息标签'
	
	JLabel lab1 = new JLabel();//创建学生信息容器
	JLabel lab2 = new JLabel();
	JLabel lab3 = new JLabel();
	JLabel lab4 = new JLabel();
	JLabel lab5 = new JLabel();
	
	//利用父类构造方法设置背景
	protected StudentPanel() {
		super("images/stu_xs.jpg");
		super.font = new Font("宋体", Font.BOLD, 30);
	}
	
	//设置容器
	public JPanel panel(JFrame frame, Student stu) {		
		panel.setLayout(null);	//取消默认布局流
		
		panel.add(label1());//添加标题标签组件
		panel.add(label2());
		
		panel.add(idLabel(stu.getStuId()));//向容器添加标签组件
		panel.add(nameLabel(stu.getStuName()));
		panel.add(sexLabel(stu.getStuSex()));
		panel.add(ageLabel(stu.getStuAge()));
		panel.add(markLabel(stu.getStuMark()));
		
		return panel;
	}
	
	//'学生信息'标签组件
	private JLabel label1() {
		label1.setForeground(Color.blue);
		label1.setFont(font);
		label1.setBounds(50, 40, 220, 30);
		return label1;
	}
	//ID标签组件
	private JLabel idLabel(String id) {
		lab1.setForeground(Color.white);
		lab1.setText("学 号: "+id);
		lab1.setFont(font);
		lab1.setBounds(100, 100, 220, 30);
		return lab1;
	}
	//姓名标签组件
	private JLabel nameLabel(String name) {
		lab2.setForeground(Color.white);
		lab2.setText("姓名: "+name);
		lab2.setFont(font);
		lab2.setBounds(100, 160, 220, 30);
		return lab2;
	}
	//性别标签组件
	private JLabel sexLabel(String sex) {
		lab3.setForeground(Color.white);
		lab3.setText("性别: "+sex);
		lab3.setFont(font);
		lab3.setBounds(100, 220, 220, 30);
		return lab3;
	}
	//年龄标签组件
	private JLabel ageLabel(int age) {
		lab4.setForeground(Color.white);
		lab4.setText("年龄: "+age);
		lab4.setFont(font);
		lab4.setBounds(100, 280, 220, 30);
		return lab4;
	}
	
	//'成绩单'标签组件
	private JLabel label2() {
		label2.setForeground(Color.blue);
		label2.setFont(font);
		label2.setBounds(50, 360, 220, 30);
		return label2;
	}
	//成绩标签组件
	private JLabel markLabel(int mark) {
		if(mark == -1) {
			lab5.setText("（未有成绩）");
		}else {
			lab5.setText("成绩: "+mark);
		}
		lab5.setForeground(Color.white);
		lab5.setFont(font);
		lab5.setBounds(100, 420, 220, 30);
		return lab5;
	}
}
