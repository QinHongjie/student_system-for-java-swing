package sms.student;

import sms.utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 学生修改密码界面
 */
public class ChangePassPanel extends BackgroundPanel{

	JLabel lab1 = new JLabel("原密码:");
	JLabel lab2 = new JLabel("新密码:");
	JLabel lab3 = new JLabel("确认密码:");

	JTextField pass = new JTextField();
	JPasswordField pass1 = new JPasswordField();
	JPasswordField pass2 = new JPasswordField();

	JButton but1 = new JButton("修改");//创建按钮
	JButton but2 = new JButton("重置");

	String p, p1, p2;//创建密码存储空间

	String name,password;

	//利用父类构造方法设置背景
	ChangePassPanel(String name, String password){
		super("images/stu_xs.jpg");
		super.font = new Font("宋体", Font.BOLD, 30);
		this.name = name;
		this.password = password;
	}

	//设置容器
	public JPanel panel(JFrame frame) {
		panel.setLayout(null);	//取消默认布局流

		panel.add(label1());//添加标题标签组件
		panel.add(label2());
		panel.add(label3());

		panel.add(pass());//添加文本框组件
		panel.add(pass1());
		panel.add(pass2());

		panel.add(But1());//向容器中添加按钮组件
		panel.add(But2());

		but1Click(frame);//添加按钮点击事件
		but2Click(frame);

		return panel;
	}

	//设置'原密码'标签组件
	private JLabel label1() {
		lab1.setForeground(Color.WHITE);
		lab1.setFont(font);
		lab1.setBounds(40, 70, 150, 30);
		return lab1;
	}
	//设置'新密码'标签组件
	private JLabel label2() {
		lab2.setForeground(Color.BLUE);
		lab2.setFont(font);
		lab2.setBounds(40, 170, 150, 30);
		return lab2;
	}
	//设置'确认密码'标签组件
	private JLabel label3() {
		lab3.setForeground(Color.BLUE);
		lab3.setFont(font);
		lab3.setBounds(30, 270, 150, 30);
		return lab3;
	}

	//设置'原密码'文本框组件
	private JTextField pass() {
		pass.setFont(font);
		pass.setBounds(200, 70, 170, 30);
		return pass;
	}
	//设置'新密码'文本框组件
	private JPasswordField pass1() {
		pass1.setFont(font);
		pass1.setBounds(200, 170, 170, 30);
		return pass1;
	}
	//设置'确认密码'文本框组件
	private JPasswordField pass2() {
		pass2.setFont(font);
		pass2.setBounds(200, 270, 170, 30);
		return pass2;
	}

	//登录按钮组件
	private JButton But1() {
		but1.setBounds(60, 450, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//注册按钮组件
	private JButton But2() {
		but2.setBounds(250, 450, 100, 40);
		but2.setFont(font);
		return but2;
	}

	//修改按钮-点击事件
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
	//重置按钮-点击事件
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
