package sms.student;

import java.awt.event.*;
import javax.swing.*;
import sms.utils.*;
/**
 * 学生个人信息界面
 */
public class StudentGUI{
	
	JFrame frame = new JFrame();
	JPanel panel;
	
	JMenuBar menuBar = new JMenuBar();//创建菜单栏
	JMenu menu = new JMenu("选择操作");//创建菜单
	
	JMenuItem item1 = new JMenuItem("个人信息"),
			  item2 = new JMenuItem("修改密码");//创建一个菜单项
	
	Student stu;
	String name = "", password;
	
	//构造方法设置窗体标题
	public StudentGUI(Student stu) {
		this.stu = stu;
		this.name = stu.getStuName();
		this.password = stu.getStuPass();
	}
	//打开此窗口方法
	public void run() {
		frame.setTitle(stu.getStuName()+"学生个人信息");
		frame.setSize(425, 665);
		frame.setResizable(false);//设置窗体尺寸不可改变
		
		frame.setJMenuBar(menuBar());	//将菜单栏添加到窗口
		i1Click();	//为‘返回登录’菜单项添加点击事件
		i2Click();
		
		panel = new StudentPanel().panel(frame, stu);
		frame.add(panel);	//添加容器
		GUITool.center(frame);//居中显示
		frame.setVisible(true);
	}
	
	//设置菜单栏
	protected JMenuBar menuBar() {
		menuBar.add(menu);	//将菜单添加到菜单栏
		
		menu.add(item1);	//添加'修改密码'菜单项
		menu.addSeparator();//添加一个分隔符
		menu.add(item2);	//添加'学生'菜单项
		
		return menuBar;
	}
	//为'个人信息'-菜单项添加事件监听器
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
	//为'修改密码'-菜单项添加事件监听器
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
//		stu.setStuName("秦洪杰");
//		stu.setStuSex("男");
//		stu.setStuAge(19);
//		stu.setStuMark(100);
//		stu.setStuPass("123");
//		new StudentGUI(stu).run();
//	}

}
