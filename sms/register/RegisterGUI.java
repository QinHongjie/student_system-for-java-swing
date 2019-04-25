package sms.register;

import javax.swing.*;

import sms.utils.GUITool;

/**
 * 注册主界面
 */
public class RegisterGUI {
	
	static JFrame frame = new JFrame("学生管理系统-注册");
	JPanel panel = new JPanel();//创建容器
	
	RegisterPanel registerPanel = new RegisterPanel();//创建注册界面对象
	
	//运行此窗口方法
	public void run() {
		frame.setSize(425, 605);
		frame.setResizable(false);//设置窗体尺寸不可改变
		
		frame.add(registerPanel.panel(frame));//向窗口添加界面

		GUITool.center(frame);	//设置窗口在屏幕中居中显示
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new RegisterGUI().run();
	}
}