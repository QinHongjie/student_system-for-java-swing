package sms.welcome;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sms.login.LoginGUI;
import sms.utils.BackgroundPanel;
import sms.utils.GUITool;
/**
 * @学生管理系统
 * @ 欢迎界面-主窗口类
 */
public class WelcomeGUI extends BackgroundPanel{	//继承有背景窗体
	
	private static JFrame frame = new JFrame("学生管理系统-欢迎您！");
	
	private JButton but = new JButton("进入系统");	//创建按钮

	//利用父类构造方法为界面容器设置背景
	protected WelcomeGUI() {
		super("images/stu_welcome.jpg");
		super.font = new Font("宋体", Font.ITALIC, 30);
	}
	
	void run() {
		frame.setSize(900, 580);
		
		frame.add(fristPanel());	//添加容器
		buttonClick();
		
		GUITool.setAll(frame);	//通过工具类设置窗口必需性
		frame.setVisible(true);
	}
	//设置容器
	private JPanel fristPanel() {
		panel.setLayout(null);		//取消默认布局流
		panel.setOpaque(false);		//设置容器透明，以看到下层图片
		panel.add(button());		//向容器中添加按钮组件
		return panel;
	}
	//'进入系统'-按钮组件
	private JButton button() {	
		but.setBounds(500, 160, 180, 50);	//按钮定位·大小
		but.setFont(font);					//添加字体样式
		return but;
	}
	//设置按钮点击事件
	private void buttonClick() {
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginGUI().run();
			}
		});
	}
	
	public static void main(String[] asd) {
		new WelcomeGUI().run();
	}
}