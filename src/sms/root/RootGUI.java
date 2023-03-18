package sms.root;

import sms.login.LoginGUI;
import sms.utils.GUITool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 学生管理系统-管理主界面
 */
public class RootGUI {

	static JFrame frame = new JFrame("学生管理系统-管理主界面");
	LoginGUI loginGUI = new LoginGUI();

	JMenuBar menuBar = new JMenuBar();//创建菜单栏
	JMenu menu = new JMenu("操作");//创建菜单

	JMenuItem item1 = new JMenuItem("返回登录"),
			item2 = new JMenuItem("退出系统");//创建两个菜单项

	//运行此窗口方法
	public void run() {
		frame.setSize(1200, 700);
		frame.add(new RootPanel(frame).panel(frame));

		frame.setJMenuBar(menuBar());	//将菜单栏添加到窗口
		i1Click();	//为‘返回登录’菜单项添加点击事件
		i2Click();	//为‘退出系统’菜单项添加点击事件

		GUITool.setAll(frame);	//最后设置窗口通用性质
		frame.setVisible(true);
	}

	//设置菜单栏
	protected JMenuBar menuBar() {
		menuBar.add(menu);	//将菜单添加到菜单栏

		menu.setSize(100, 20);
		menu.add(item1);	//添加'管理员'菜单项
		menu.addSeparator();//添加一个分隔符
		menu.add(item2);	//添加'学生'菜单项

		return menuBar;
	}
	//为'返回登录'-菜单项添加事件监听器
	private void i1Click() {
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();//关闭当前窗口
				loginGUI.run();//打开登录窗口
			}
		});
	}
	//为'退出系统'-菜单项添加事件监听器
	private void i2Click() {
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//退出程序
			}
		});
	}
	//测试方法
	public static void main(String[] args) {
		new RootGUI().run();
	}
}