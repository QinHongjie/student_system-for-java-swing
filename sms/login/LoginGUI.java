package sms.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import sms.utils.GUITool;
/**
 * 登录界面
 */
//@SuppressWarnings("serial")
public class LoginGUI{
	
	public JFrame frame = new JFrame("学生管理系统-登录");
	public JPanel panel = new JPanel();//创建容器
	
	StudentLoginPanel studentLogin = new StudentLoginPanel();//创建学生登录界面对象
	RootLoginPanel rootLogin = new RootLoginPanel();//创建管理登录界面对象
	
	JMenuBar menuBar = new JMenuBar();//创建菜单栏
	JMenu menu = new JMenu("权限选择");//创建菜单
	
	JMenuItem item1 = new JMenuItem("管理员"),
			  item2 = new JMenuItem("学生");//创建两个菜单项
	//运行此窗口方法
	public void run() {
		frame.setSize(780, 560);

		frame.setJMenuBar(menuBar());	//将菜单栏添加到窗口
		i1Click();	//为‘管理员’菜单项添加点击事件
		i2Click();	//为‘学生’菜单项添加点击事件
		
		panel = studentLogin.panel(frame);//使容器为学生登录界面
		frame.add(panel);//向窗口添加界面
		
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
	//为'管理员'-菜单项添加事件监听器
	private void i1Click() {
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);//卸载当前界面
				panel = rootLogin.panel(frame);//使容器为管理登录界面
				frame.add(panel);//添加界面
				panel.updateUI();//使窗口强制刷新
			}
		});
	}
	//为'学生'-菜单项添加事件监听器
	private void i2Click() {
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(panel);//卸载当前界面
				panel = studentLogin.panel(frame);//学生登录界面
				frame.add(panel);//添加界面
				panel.updateUI();//强制刷新
			}
		});
	}
	//测试方法
	public static void main(String[] args) {
		new LoginGUI().run();
	}
}
