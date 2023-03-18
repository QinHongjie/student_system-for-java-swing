package sms.register;

import sms.utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 注册界面容器
 */
public class RegisterPanel extends BackgroundPanel{

	JLabel lab1 = new JLabel("学 号:");	//创建标签
	JLabel lab2 = new JLabel("姓 名:");
	JLabel lab3 = new JLabel("性 别:");
	JLabel lab4 = new JLabel("年 龄:");
	JLabel lab5 = new JLabel("设置密码:");
	JLabel lab6 = new JLabel("确认密码:");

	JTextField text1 = new JTextField();//创建文本框
	JTextField text2 = new JTextField();
	JTextField text3 = new JTextField();
	JPasswordField text4 = new JPasswordField();
	JPasswordField text5 = new JPasswordField();

	ButtonGroup group = new ButtonGroup();//创建单选框管理对象
	JRadioButton rb1 = new JRadioButton("男");//创建单选框
	JRadioButton rb2 = new JRadioButton("女");

	JButton but1 = new JButton("注册");//创建按钮
	JButton but2 = new JButton("重置");

	String id,name,sex = "", age, pass1, pass2;//创建信息存储空间

	public RegisterPanel() {
		super("images/stu_register.jpg");
	}
	//设置容器
	public JPanel panel(JFrame frame) {
		panel.add(idLabel());//向容器中添加标签组件
		panel.add(nameLabel());
		panel.add(sexLabel());
		panel.add(ageLabel());
		panel.add(pass1Label());
		panel.add(pass2Label());

		panel.add(idText());//向容器中添加文本框组件
		panel.add(nameText());
		panel.add(ageText());
		panel.add(pass1Text());
		panel.add(pass2Text());

		group.add(rb1);//绑定单选框
		group.add(rb2);
		panel.add(boyRB());//向容器中添加单选框组件
		panel.add(girlRB());
		addJRadioButton();

		panel.add(userButton());//向容器中添加按钮组件
		panel.add(passButton());

		but1Click(frame);//添加登录点击事件
		but2Click(frame);

		return panel;
	}

	//ID标签组件
	private JLabel idLabel() {
		lab1.setFont(font);
		lab1.setBounds(50, 40, 120, 30);
		return lab1;
	}
	//姓名标签组件
	private JLabel nameLabel() {
		lab2.setFont(font);
		lab2.setBounds(50, 100, 120, 30);
		return lab2;
	}
	//性别标签组件
	private JLabel sexLabel() {
		lab3.setFont(font);
		lab3.setBounds(50, 160, 120, 30);
		return lab3;
	}
	//年龄标签组件
	private JLabel ageLabel() {
		lab4.setFont(font);
		lab4.setBounds(50, 220, 120, 30);
		return lab4;
	}
	//设置密码标签组件
	private JLabel pass1Label() {
		lab5.setFont(font);
		lab5.setBounds(50, 300, 120, 30);
		return lab5;
	}
	//确认密码标签组件
	private JLabel pass2Label() {
		lab6.setFont(font);
		lab6.setBounds(50, 360, 120, 30);
		return lab6;
	}

	//ID文本框组件
	private JTextField idText() {
		text1.setBounds(190, 37, 180, 35);
		text1.setFont(font);
		return text1;
	}
	//姓名文本框组件
	private JTextField nameText() {
		text2.setBounds(190, 97, 180, 35);
		text2.setFont(font);
		return text2;
	}

	//性别'男'单选框组件
	private JRadioButton boyRB() {
		rb1.setForeground(Color.blue);//设置字体为蓝色
		rb1.setOpaque(false);//设置背景透明
		rb1.setBounds(190, 157, 90, 35);
		rb1.setFont(font);
		return rb1;
	}
	//性别'女'单选框组件
	private JRadioButton girlRB() {
		rb2.setForeground(Color.blue);//设置字体为蓝色
		rb2.setOpaque(false);//设置背景透明
		rb2.setBounds(280, 157, 90, 35);
		rb2.setFont(font);
		return rb2;
	}

	//年龄文本框组件
	private JTextField ageText() {
		text3.setBounds(190, 217, 90, 35);
		text3.setFont(font);
		return text3;
	}

	//设置密码文本框组件
	private JTextField pass1Text() {
		text4.setBounds(190, 297, 180, 35);
		text4.setFont(font);
		return text4;
	}
	//确认密码文本框组件
	private JTextField pass2Text() {
		text5.setBounds(190, 347, 180, 35);
		text5.setFont(font);
		return text5;
	}

	//登录按钮组件
	private JButton userButton() {
		but1.setBounds(60, 450, 100, 40);
		but1.setFont(font);
		return but1;
	}
	//注册按钮组件
	private JButton passButton() {
		but2.setBounds(250, 450, 100, 40);
		but2.setFont(font);
		return but2;
	}

	//获取单选框信息
	private void addJRadioButton() {
		rb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "男";
			}
		});
		rb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sex = "女";
			}
		});
	}

	//注册按钮-点击事件
	public void but1Click(JFrame frame) {
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = idText().getText();
				name = nameText().getText();
				age = ageText().getText();
				pass1 = String.valueOf(text4.getPassword());
				pass2 = String.valueOf(text5.getPassword());
				//将信息传给注册信息验证类验证
				new RegisterCheck(frame, id, name, sex, age, pass1, pass2);
			}
		});
	}
	//重置按钮-点击事件
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
