package sms.root;

import sms.utils.BackgroundPanel;
import sms.utils.MyFocusListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 创建管理主窗口必需组件类
 */
public abstract class AbstractRootPanel extends BackgroundPanel{

	//学生信息表要用到的组件
	protected JTable table = new JTable();	//学生列表
	protected JScrollPane tablePane = new JScrollPane();//滚动视窗

	private JLabel tableLabel = new JLabel("学生信息表");//学生表标题
	private JLabel idLabel = new JLabel("学号");//ID标题
	private JLabel nameLabel = new JLabel("姓名");//姓名标题
	private JLabel sexLabel = new JLabel("性别");//性别标题
	private JLabel ageLabel = new JLabel("年龄");//年龄标题
	//添加功能组件
	protected JTextField addIdText = new JTextField();//添加id文本框
	protected JTextField addNameText = new JTextField();//添加名字文本框
	protected JTextField addSexText = new JTextField();//添加性别文本框
	protected JTextField addAgeText = new JTextField();//添加年龄文本框
	private JButton addButton = new JButton("添加信息");//添加按钮
	//修改功能组件
	protected JTextField updateIdText = new JTextField();//修改id文本框
	protected JTextField updateNameText = new JTextField();//修改名字文本框
	protected JTextField updateSexText = new JTextField();//修改性别文本框
	protected JTextField updateAgeText = new JTextField();//修改年龄文本框
	private JButton updateButton = new JButton("修改信息");//删除按钮
	//删除功能组件
	protected JTextField delIdText = new JTextField();//添加id文本
	private JButton delBtu = new JButton("删除信息");//删除按钮
	//设置成绩功能组件
	private JLabel markLabel = new JLabel("*为学生打分*");//设置成绩标题
	protected JTextField markIdText = new JTextField();//要设置分数的id文本框
	protected JTextField markText = new JTextField();//修改分数文本框
	protected JButton markBut = new JButton("设置分数");//打分按钮

	//继承自背景容器类构造方法，但是在此类先不实现
	protected AbstractRootPanel(JFrame frame) {
		super("images/stu_root.jpg");
		addComponent();//添加组件
		addListener(frame);//添加按钮监听
		setFont();//设置字体样式
	}

	//添加组件
	private void addComponent() {
		//表格标题
		tableLabel.setBounds(380, 20, 140, 30);
		panel.add(tableLabel);
		//表格
		table.getTableHeader().setReorderingAllowed(false);//列不能移动
		table.getTableHeader().setReorderingAllowed(false);//不可拉动表格
		table.setEnabled(false);//不可更改数据
		table.getTableHeader().setPreferredSize(new Dimension(1, 25));//设置表头高度
		table.getTableHeader().setFont(font);//设置表头字体
		table.setRowHeight(30);//设置表格每行字段高度
		table.setFont(font);
		table.setForeground(Color.WHITE);
		//用于装表格的视图
		tablePane.setBounds(50, 60, 800, 300);
		tablePane.setViewportView(table);//视口装入表格
		tablePane.setOpaque(false);	//设置装表格的视图透明
		tablePane.getViewport().setOpaque(false);//视图透明
		panel.add(tablePane);
		//字段标题
		idLabel.setBounds(100, 385, 70, 25);
		nameLabel.setBounds(260, 385, 70, 25);
		sexLabel.setBounds(410, 385, 70, 25);
		ageLabel.setBounds(570, 385, 70, 25);
		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(sexLabel);
		panel.add(ageLabel);
		//增加组件
		addIdText.setBounds(50, 440, 150, 30);
		addNameText.setBounds(240, 440, 100, 30);
		addSexText.setBounds(390, 440, 100, 30);
		addSexText.addFocusListener(new MyFocusListener("男/女",addSexText));
		addAgeText.setBounds(550, 440, 100, 30);
		panel.add(addIdText);
		panel.add(addNameText);
		panel.add(addSexText);
		panel.add(addAgeText);
		addButton.setBounds(700, 440, 140, 35);
		panel.add(addButton);
		//修改组件
		updateIdText.setBounds(50, 500, 150, 30);
		updateNameText.setBounds(240, 500, 100, 30);
		updateSexText.setBounds(390, 500, 100, 30);
		updateSexText.addFocusListener(new MyFocusListener("男/女",updateSexText));
		updateAgeText.setBounds(550, 500, 100, 30);
		panel.add(updateIdText);
		panel.add(updateNameText);
		panel.add(updateSexText);
		panel.add(updateAgeText);
		updateButton.setBounds(700, 500, 140, 35);
		panel.add(updateButton);
		//删除组件
		delIdText.setBounds(50, 560, 150, 30);
		panel.add(delIdText);
		delBtu.setBounds(700, 560, 140, 35);
		panel.add(delBtu);
		//分数组件
		markLabel.setBounds(888, 60, 200, 30);
		markIdText.setBounds(888, 120, 150, 30);
		markIdText.addFocusListener(new MyFocusListener("(输入学号)",markIdText));
		markText.setBounds(888, 180, 150, 30);
		markText.addFocusListener(new MyFocusListener("Max's 100",markText));
		markBut.setBounds(888, 240, 140, 40);
		panel.add(markLabel);
		panel.add(markIdText);
		panel.add(markText);
		panel.add(markBut);
	}

	//添加监听器
	private void addListener(JFrame frame) {
		//添加按钮监听
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用添加方法
				addStudent(frame);
			}
		});
		//修改按钮监听
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用修改方法
				updateStudent(frame);
			}
		});
		//删除按钮监听
		delBtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用删除方法
				delStudent(frame);
			}
		});
		//评分按钮监听
		markBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//调用删除方法
				setMark(frame);
			}
		});
	}
	//为容器中所有元素设置字体样式
	private void setFont() {
		//为所有组件设置字体样式
		Component[] com = panel.getComponents();
		for(int i = 0; i < com.length; i++) {
			com[i].setFont(font);
		}
		//为所有标签组件设置字体为白色
		tableLabel.setForeground(Color.WHITE);
		idLabel.setForeground(Color.WHITE);
		nameLabel.setForeground(Color.WHITE);
		sexLabel.setForeground(Color.WHITE);
		ageLabel.setForeground(Color.WHITE);
		markLabel.setForeground(Color.WHITE);
		//为按钮设置字体为蓝色
		addButton.setForeground(Color.blue);
		updateButton.setForeground(Color.blue);
		delBtu.setForeground(Color.blue);
		markBut.setForeground(Color.blue);
	}
	//查询数据并添加进表方法
	public abstract String[][] tbody();
	//添加方法
	public abstract void addStudent(JFrame frame);
	//修改方法
	public abstract void updateStudent(JFrame frame);
	//删除方法
	public abstract void delStudent(JFrame frame);
	//评分方法
	public abstract void setMark(JFrame frame);
}
