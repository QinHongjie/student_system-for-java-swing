package sms.login;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import sms.utils.BackgroundPanel;
import sms.utils.MyFocusListener;
/**
 * 管理员登录界面类
 */
public class RootLoginPanel extends BackgroundPanel{
	
	private JLabel lab1 = new JLabel("user：");	//创建标签
	private JLabel lab2 = new JLabel("pass：");
	
	private JTextField text1 = new JTextField();//创建文本框
	private JPasswordField text2 = new JPasswordField();
	
	private JButton but1 = new JButton("登录");//创建按钮
	private JButton but2 = new JButton("重置");

	static String user,password;//创建用于存储用户名和密码的空间

	//利用父类构造方法设置背景
	protected RootLoginPanel() {
		super("images/stu_login.png");
	}
	
	//设置容器
	public JPanel panel(JFrame frame) {
		panel.setLayout(null);	//取消默认布局流
		
		panel.add(userLabel());	//向容器中添加标签组件
		panel.add(passLabel());
		
		panel.add(userText());//向容器中添加文本框组件
		panel.add(passText());
		
		panel.add(button1());//向容器中添加按钮组件
		panel.add(button2());
		
		but1Click(frame);//添加登录点击事件
		but2Click(frame);
		
		text1.addFocusListener(new MyFocusListener("请输入用户名",text1));
		
		return panel;
	}
	
	//用户名标签组件
	private JLabel userLabel() {
		lab1.setForeground(Color.WHITE);
		lab1.setFont(font);
		lab1.setBounds(120, 125, 150, 30);
		return lab1;
	}
	//密码标签组件
	private JLabel passLabel() {
		lab2.setForeground(Color.WHITE);
		lab2.setFont(font);
		lab2.setBounds(120, 175, 150, 30);
		return lab2;
	}
	//用户名文本框组件
	private JTextField userText() {
		text1.setBounds(210, 120, 190, 35);
		text1.setFont(font);
		return text1;
	}
	//密码文本框组件
	private JPasswordField passText() {
		text2.setBounds(210, 170, 190, 35);
		text2.setFont(font);
		return text2;
	}
	//登录按钮组件
	private JButton button1() {
		but1.setBounds(130, 300, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//重置按钮组件
	private JButton button2() {
		but2.setBounds(280, 300, 100, 40);
		but2.setFont(font);
		return but2;
	}
	//登录按钮-点击事件
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user = text1.getText();
				password = String.valueOf(text2.getPassword());
				new RootLoginCheck(frame, user, password);//利用验证类验证信息
				//如果用户/密码框为空，则全置空
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
	//重置按钮-点击事件
	public void but2Click(JFrame frame) {
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1.setText("");
				text2.setText("");
			}
		});
	}
}
